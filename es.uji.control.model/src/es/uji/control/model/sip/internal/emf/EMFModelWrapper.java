package es.uji.control.model.sip.internal.emf;

import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import es.uji.control.domain.people.IAccreditation;
import es.uji.control.domain.people.IAccreditationInfo;
import es.uji.control.domain.people.ILinkage;
import es.uji.control.domain.people.IPerson;
import es.uji.control.domain.provider.service.connectionfactory.ControlConnectionException;
import es.uji.control.domain.provider.service.connectionfactory.IControlConnection;
import es.uji.control.domain.provider.service.connectionfactory.IControlConnectionFactory;
import es.uji.control.domain.provider.subsystem.people.IPersonService;
import es.uji.control.domain.provider.subsystem.people.IPersonStream;
import es.uji.control.model.sip.ModelLogEntry;
import es.uji.control.model.sip.ModelLogSource;
import es.uji.control.model.sip.ModelLogType;
import es.uji.control.sip.model.emf.sip.Accreditation;
import es.uji.control.sip.model.emf.sip.Linkage;
import es.uji.control.sip.model.emf.sip.Model;
import es.uji.control.sip.model.emf.sip.Person;
import es.uji.control.sip.model.emf.sip.SipFactory;
import es.uji.control.sip.model.emf.sip.impl.SipPackageImpl;

public class EMFModelWrapper extends ModelWrapperUtil {

	static final String EMF_CACHE_DIR = System.getProperty("user.home") + "\\Universitat Jaume I\\SIP\\cache\\cache.ecore";

	static public class ConnectionFactoryBuilder {

		final private IControlConnectionFactory controlConnectionFactory;
		final private Consumer<ModelLogEntry> consumer;

		public ConnectionFactoryBuilder(IControlConnectionFactory controlConnectionFactory, Consumer<ModelLogEntry> consumer) {
			this.controlConnectionFactory = controlConnectionFactory;
			this.consumer = consumer;
		}

		public EMFModelWrapper build() throws EMFModelWrapperException {
			try {
				return new EMFModelWrapper(controlConnectionFactory.createConnection(), consumer);
			} catch (ControlConnectionException e) {
				throw new EMFModelWrapperException("Imposible obtener una nueva conexion con el backend.", e);
			}
		}

	}

	static public ConnectionFactoryBuilder newConnectionFactoryBuilder(IControlConnectionFactory controlConnectionFactory, Consumer<ModelLogEntry> consumer) {
		return new ConnectionFactoryBuilder(controlConnectionFactory, consumer);
	}

	static public class FileBuilder {

		final private Consumer<ModelLogEntry> consumer;

		public FileBuilder(Consumer<ModelLogEntry> consumer) {
			this.consumer = consumer;
		}

		public EMFModelWrapper build() throws EMFModelWrapperException {
			return new EMFModelWrapper(EMF_CACHE_DIR, consumer);
		}

	}

	static public FileBuilder newFileBuilder(Consumer<ModelLogEntry> consumer) {
		return new FileBuilder(consumer);
	}

	final private Model model;
	final private Consumer<ModelLogEntry> consumer;

	private EMFModelWrapper(String cacheFilePath, Consumer<ModelLogEntry> consumer) throws EMFModelWrapperException {
		
		this.consumer = consumer;

		URI fileURI = URI.createFileURI(cacheFilePath);
		Resource resource = new XMIResourceFactoryImpl().createResource(fileURI);

		// Se carga el modelo desde la cache
		this.model = loadCache(resource);

	}

	private EMFModelWrapper(IControlConnection controlConnection, Consumer<ModelLogEntry> consumer) throws EMFModelWrapperException {

		this.consumer = consumer;
		
		try {

			// Se obtienen los servicios que se van a utilizar
			IPersonService personService = controlConnection.getPersonService();

			// Se carga el modelo
			this.model = instantiate(personService);

		} catch (ControlConnectionException e) {
			throw new EMFModelWrapperException("No se puede obtener el servicio para acceder al subsistema 'Person'", e);
		}

	}

	private Model loadCache(Resource resource) throws EMFModelWrapperException {

		// Inicializo el modelo EMF
		SipPackageImpl.init();

		Model tmpModel = SipFactory.eINSTANCE.createModel();

		try {
			resource.load(null);
		} catch (IOException ioEx) {
			throw new EMFModelWrapperException("No se ha podido leer el recurso desde el directorio especificado.");
		}

		// Se comprueba que el recurso no esta vacio.
		if (resource.getContents().size() == 0) {
			return null;
		}

		// Se obtiene un XmiResource
		XMIResource xmiResource = (XMIResource) resource;

		// Se obtiene el iterador para obtener los contenidos
		TreeIterator<EObject> contents = xmiResource.getAllContents();

		// Se empieza a construir el modelo respecto el recurso
		while (contents.hasNext()) {
			EObject object = contents.next();

			if (object instanceof Model) {
				tmpModel.setDate(((Model) object).getDate());
			} else {
				if (object instanceof Person) {

					TreeIterator<EObject> personsContents = object.eAllContents();

					Person personEMF = SipFactory.eINSTANCE.createPerson();
					personEMF.setId(((Person) object).getId());
					personEMF.setIdentification(((Person) object).getIdentification());
					personEMF.setName(((Person) object).getName());
					personEMF.setFirstLastName(((Person) object).getFirstLastName());
					personEMF.setSecondLastName(((Person) object).getSecondLastName());

					while (personsContents.hasNext()) {
						EObject personContent = personsContents.next();
						if (personContent instanceof Accreditation) {
							Accreditation accreditationEMF = SipFactory.eINSTANCE.createAccreditation();
							accreditationEMF.setType(((Accreditation) personContent).getType());
							accreditationEMF.setRaw(((Accreditation) personContent).getRaw());
							accreditationEMF.setPerson(((Accreditation) personContent).getPerson());
							personEMF.getAccreditationsList().add(accreditationEMF);
						}
						if (personContent instanceof Linkage) {
							Linkage linkageEMF = SipFactory.eINSTANCE.createLinkage();
							linkageEMF.setName(((Linkage) personContent).getName());
							personEMF.getLinkageList().add(linkageEMF);
						}
					}
					tmpModel.getModelPersonsList().add(personEMF);
				}
				if (object instanceof Accreditation) {
					Accreditation accreditationEMF = SipFactory.eINSTANCE.createAccreditation();
					accreditationEMF.setType(((Accreditation) object).getType());
					accreditationEMF.setRaw(((Accreditation) object).getRaw());
					accreditationEMF.setPerson(((Accreditation) object).getPerson());
					tmpModel.getModelCardsList().add(accreditationEMF);
				}

			}
		}
		return tmpModel;
	}

	private Model instantiate(IPersonService personService) throws EMFModelWrapperException {

		// Inicializo el modelo EMF
		SipPackageImpl.init();
		SipFactory factory = SipFactory.eINSTANCE;

		Model tmpModel = factory.createModel();
		
		// Se carga la lista de personas
		try {

			consumer.accept(new ModelLogEntry(Instant.now(), ModelLogSource.PERSONS, ModelLogType.INFO, "Comienza el proceso de carga de personas."));
			
			personService.getAllPersons(new IPersonStream() {
				
				int numPersons = 0;
								
				@Override
				public void onNext(List<IPerson> persons) {

					int size = persons.size();
					
					for (IPerson person : persons) {

						Person personEMF = domainToEMF(person);

						for (ILinkage linkage : person.getLinkages()) {
							Linkage linkageEMF = domainToEMF(linkage);
							personEMF.getLinkageList().add(linkageEMF);
						}

						for (IAccreditationInfo accreditationInfo : person.getAccreditationsInfo()) {
							Accreditation accreditationEMF = domainToEMF(accreditationInfo.getAccreditation());
							accreditationEMF.setPerson(personEMF);
							personEMF.getAccreditationsList().add(accreditationEMF);
							tmpModel.getModelCardsList().add(accreditationEMF);
						}

						tmpModel.getModelPersonsList().add(personEMF);
					}
					
					numPersons = numPersons + size;
					consumer.accept(new ModelLogEntry(Instant.now(), ModelLogSource.PERSONS, ModelLogType.INFO, String.format("%d Personas cargadas", numPersons)));
				}

				@Override
				public void onError(Throwable t) {
					consumer.accept(new ModelLogEntry(Instant.now(), ModelLogSource.PERSONS, ModelLogType.ERROR, String.format("Error duranle la carga (%s).", t.getMessage())));
				}

				@Override
				public void onCompleted() {
					tmpModel.setDate(new Date());
					consumer.accept(new ModelLogEntry(Instant.now(), ModelLogSource.PERSONS, ModelLogType.INFO, String.format("Modelo cargado correctamente %d Personas cargadas", numPersons)));
				}

			});

			return tmpModel;

		} catch (ControlConnectionException e) {
			throw new EMFModelWrapperException("Han surgido problemas con la conexion durante la carga del modelo.", e);
		}

	}

	public Date getModelDate() {
		return model.getDate();
	}

	public IPerson getPersonByAccreditation(IAccreditation accreditation) throws EMFModelWrapperException {
		throw new EMFModelWrapperException("No implementado.");
	}

}

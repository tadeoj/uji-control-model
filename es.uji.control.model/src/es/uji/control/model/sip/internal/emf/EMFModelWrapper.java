package es.uji.control.model.sip.internal.emf;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

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
import es.uji.control.domain.provider.service.connectionfactory.ControlNotImplementedException;
import es.uji.control.domain.provider.service.connectionfactory.IControlConnection;
import es.uji.control.domain.provider.service.connectionfactory.IControlConnectionFactory;
import es.uji.control.domain.provider.subsystem.people.IPersonService;
import es.uji.control.domain.provider.subsystem.people.IPersonStream;
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

		public ConnectionFactoryBuilder(IControlConnectionFactory controlConnectionFactory) {
			this.controlConnectionFactory = controlConnectionFactory;
		}

		public EMFModelWrapper build() throws EMFModelWrapperException {
			try {
				return new EMFModelWrapper(controlConnectionFactory.createConnection());
			} catch (ControlConnectionException e) {
				throw new EMFModelWrapperException("Imposible obtener una nueva conexion con el backend.", e);
			}
		}

	}

	static public ConnectionFactoryBuilder newBuilder(IControlConnectionFactory controlConnectionFactory) {
		return new ConnectionFactoryBuilder(controlConnectionFactory);
	}

	static public class FileBuilder {

		public FileBuilder() {
		}

		public EMFModelWrapper build() throws EMFModelWrapperException {
			return new EMFModelWrapper(EMF_CACHE_DIR);
		}

	}

	static public FileBuilder newBuilder() {
		return new FileBuilder();
	}

	private Model model;

	private EMFModelWrapper(String cacheFilePath) throws EMFModelWrapperException {

		URI fileURI = URI.createFileURI(cacheFilePath);
		Resource resource = new XMIResourceFactoryImpl().createResource(fileURI);

		// Se carga el modelo desde la cache
		this.model = loadCache(resource);

	}

	private EMFModelWrapper(IControlConnection controlConnection) throws EMFModelWrapperException {

		try {

			// Se obtienen los servicios que se van a utilizar
			IPersonService personService = controlConnection.getPersonService();

			// Se carga el modelo
			this.model = instantiate(personService);

		} catch (ControlNotImplementedException e) {
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
		AtomicBoolean finish = new AtomicBoolean(false);
		
		// Se carga la lista de personas
		try {

			personService.getAllPersons(new IPersonStream() {

				@Override
				public void onNext(List<IPerson> persons) {

					// Se procesa este bloque de personas
					for (IPerson person : persons) {

						// Se instancia la persona EMF
						Person personEMF = domainToEMF(person);

						// Se carga los linkages de la persona
						for (ILinkage linkage : person.getLinkages()) {
							Linkage linkageEMF = domainToEMF(linkage);
							personEMF.getLinkageList().add(linkageEMF);
						}

						// Se carga las acredtitaciones...
						for (IAccreditationInfo accreditationInfo : person.getAccreditationsInfo()) {
							Accreditation accreditationEMF = domainToEMF(accreditationInfo.getAccreditation());
							accreditationEMF.setPerson(personEMF);
							personEMF.getAccreditationsList().add(accreditationEMF);
						}

						// Se Se incorpora la persona en la lista del modelo EMF
						tmpModel.getModelPersonsList().add(personEMF);
					}

				}

				@Override
				public void onError(Throwable t) {
				}

				@Override
				public void onCompleted() {
					tmpModel.setDate(new Date());
					finish.set(true);
				}

			});

			return tmpModel;

		} catch (ControlConnectionException e) {
			throw new EMFModelWrapperException("Se han surgido problemas con la conexion duranta la carga del modelo.",	e);
		}

	}

	public Date getModelDate() {
		return model.getDate();
	}

	public IPerson getPersonByAccreditation(IAccreditation accreditation) throws EMFModelWrapperException {
		throw new EMFModelWrapperException("No implementado.");
	}

}

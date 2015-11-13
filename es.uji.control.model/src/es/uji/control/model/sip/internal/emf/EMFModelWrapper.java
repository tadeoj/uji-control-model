package es.uji.control.model.sip.internal.emf;

import java.util.Date;
import java.util.List;

import es.uji.control.domain.people.IAccreditation;
import es.uji.control.domain.people.ILinkage;
import es.uji.control.domain.people.IPerson;
import es.uji.control.domain.provider.service.connectionfactory.ControlConnectionException;
import es.uji.control.domain.provider.service.connectionfactory.ControlNotImplementedException;
import es.uji.control.domain.provider.service.connectionfactory.IControlConnection;
import es.uji.control.domain.provider.service.connectionfactory.IControlConnectionFactory;
import es.uji.control.domain.provider.subsystem.people.IPersonService;
import es.uji.control.domain.provider.subsystem.people.IPersonStream;
import es.uji.control.sip.model.emf.sip.Linkage;
import es.uji.control.sip.model.emf.sip.Model;
import es.uji.control.sip.model.emf.sip.Person;
import es.uji.control.sip.model.emf.sip.SipFactory;
import es.uji.control.sip.model.emf.sip.impl.SipPackageImpl;

public class EMFModelWrapper extends ModelWarapperUtil {
	
	static public class Builder {
		
		final private IControlConnectionFactory controlConnectionFactory;
		
		public Builder(IControlConnectionFactory controlConnectionFactory) {
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
	
	static public Builder newBuilder(IControlConnectionFactory controlConnectionFactory) {
		return new Builder(controlConnectionFactory); 
	}
	
	final private Model model;
	
	public EMFModelWrapper(IControlConnection controlConnection) throws EMFModelWrapperException {

		try {
			
			// Se obtienen los servicios que se van a utilizar
			IPersonService personService =  controlConnection.getPersonService();
			
			// Se carga el modelo
			this.model = instantiate(personService);
			
		} catch (ControlNotImplementedException e) {
			throw new EMFModelWrapperException("No se puede obtener el servicio para acceder al subsistema", e);
		}
		
	}
	
	private Model instantiate(IPersonService personService) throws EMFModelWrapperException {
		
		// Inicializo el modelo EMF
		SipPackageImpl.init();
		SipFactory factory = SipFactory.eINSTANCE;
		
		Model tmpModel = factory.createModel();
		
		// Se carga en la marca de tiempo del modelo 
		tmpModel.setDate(new Date());
		
		// Se carga la lista de personas
		try {
			
			personService.getAllPersons(new IPersonStream() {
				
				@Override
				public void onNext(List<IPerson> persons) {
					
					// Se procesa este bloque de personas
					for (IPerson person : persons) {
						
						// Se instancia la persona EMF
						Person personEMF = domainToEMF(person); 

						// Se carga los linakages de la persona
						for (ILinkage linkage : person.getLinkages()) {
							Linkage linkageEMF = factory.createLinkage();
							linkageEMF.setName(linkage.getName());
						}
						
						// Se carga las acredtitaciones...
						// TODO: implementar
						
						// Se Se incorpora la persona en la lista del modelo EMF
						tmpModel.getModelPersonsList().add(personEMF);
						
						
					}
					
				}
				
				@Override
				public void onError(Throwable t) {
				}
				
				@Override
				public void onCompleted() {
				}
				
			});
			
			return tmpModel;
			
		} catch (ControlConnectionException e) {
			throw new EMFModelWrapperException("Se han surgido problemas con la conexion duranta la carga del modelo.", e); 
		}
		
	}

	public Date getModelDate() {
		return model.getDate();
	}
	
	public IPerson getPersonByAccreditation(IAccreditation accreditation) throws EMFModelWrapperException {
		throw new EMFModelWrapperException("No implementado.");
	}
	
}

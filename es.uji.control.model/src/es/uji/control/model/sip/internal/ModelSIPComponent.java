/*******************************************************************************
 * Copyright © Universitat Jaume I de Castelló 2015.
 * Aquest programari es distribueix sota les condicions de llicència EUPL 
 * o de qualsevol altra que la substituisca en el futur.
 * La llicència completa es pot descarregar de 
 * https://joinup.ec.europa.eu/community/eupl/og_page/european-union-public-licence-eupl-v11
 *******************************************************************************/
package es.uji.control.model.sip.internal;

import java.util.Date;
import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;

import es.uji.control.domain.people.IAccreditation;
import es.uji.control.domain.people.IPerson;
import es.uji.control.domain.provider.service.connectionfactory.IControlConnectionFactory;
import es.uji.control.model.sip.IModelSIP;
import es.uji.control.model.sip.ModelSIPException;
import es.uji.control.model.sip.internal.emf.EMFModelWrapper;
import es.uji.control.model.sip.internal.emf.EMFModelWrapperException;

@Component(name = "model.sip.component", immediate = true)
public class ModelSIPComponent implements IModelSIP {

	private IControlConnectionFactory controlConnectionFactory;

	private EMFModelWrapper modelWrapper;
	
	@Activate
	public void activate() {
	}
	
	@Deactivate
	public void deactivate() {
	}
	
	@Reference(policy=ReferencePolicy.DYNAMIC, cardinality=ReferenceCardinality.OPTIONAL, name="controlConnectionFactory")
	public void bindConnectionFactorySPI(IControlConnectionFactory controlConnectionFactory, Map<String,?> properties) {
		synchronized (this) {
			this.controlConnectionFactory = controlConnectionFactory;
		}
	}
	
	public void unbindConnectionFactorySPI(IControlConnectionFactory controlConnectionFactory, Map<String,?> properties) {
		synchronized (this) {
			this.controlConnectionFactory = null;
		}
	}
	
	/////////////////////////////////////////////////////////////
	// Metodos que controlan el modelo
	/////////////////////////////////////////////////////////////
	
	@Override
	public void updateModelFromBackend() throws ModelSIPException {
		synchronized (this) {
			if (controlConnectionFactory != null) {
				modelWrapper = doUpdateModelFromBackend();
			} else {
				throw new ModelSIPException("No hay conexion con el backend en estos momentos");
			}
		}
	}
	
	private EMFModelWrapper doUpdateModelFromBackend() throws ModelSIPException {
		try {
			return EMFModelWrapper.newBuilder(controlConnectionFactory).build();
		} catch (EMFModelWrapperException e) {
			throw new ModelSIPException("No se ha podido cargar el modelo desde el backend", e);
		}
	}

	@Override
	public void updatePhotosFromBackend() throws ModelSIPException {
	}

	
	/////////////////////////////////////////////////////////////
	// Estado del modelo
	/////////////////////////////////////////////////////////////
	
	@Override
	public Date getModelDate() {
		synchronized (this) {
			return modelWrapper == null ? null : modelWrapper.getModelDate();
		}
	}

	
	/////////////////////////////////////////////////////////////
	// Acceso al modelo
	/////////////////////////////////////////////////////////////

	@Override
	public IPerson getPersonByAccreditation(IAccreditation accreditation) throws ModelSIPException {
		synchronized (this) {
			if (modelWrapper == null) {
				throw new ModelSIPException("No hay ningun modelo subyacente con informacion.");
			} else {
				try {
					return modelWrapper.getPersonByAccreditation(accreditation);
				} catch (EMFModelWrapperException e) {
					throw new ModelSIPException("Error al intentar obtener la persona desde una acreditacion.", e);
				}
			}
		}
	}
	
}

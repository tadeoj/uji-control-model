/*******************************************************************************
 * Copyright © Universitat Jaume I de Castelló 2015.
 * Aquest programari es distribueix sota les condicions de llicència EUPL 
 * o de qualsevol altra que la substituisca en el futur.
 * La llicència completa es pot descarregar de 
 * https://joinup.ec.europa.eu/community/eupl/og_page/european-union-public-licence-eupl-v11
 *******************************************************************************/
package es.uji.control.model.sip.internal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
import es.uji.control.model.sip.IModelListener;
import es.uji.control.model.sip.IModelSIP;
import es.uji.control.model.sip.ModelSIPException;
import es.uji.control.model.sip.internal.emf.EMFModelWrapper;
import es.uji.control.model.sip.internal.emf.EMFModelWrapperException;

@Component(name = "model.sip.component", immediate = true)
public class ModelSIPComponent implements IModelSIP {

	private IControlConnectionFactory controlConnectionFactory;

	private List<IModelListener> listeners = new ArrayList<IModelListener>();
	
	private EMFModelWrapper modelWrapper;
	
	@Activate
	public void activate() {
	}
	
	@Deactivate
	public void deactivate() {
		removeAllListeners();
	}
	
	@Reference(policy=ReferencePolicy.DYNAMIC, cardinality=ReferenceCardinality.OPTIONAL, name="controlConnectionFactory")
	public void bindConnectionFactorySPI(IControlConnectionFactory controlConnectionFactory, Map<String,?> properties) {
		synchronized (this) {
			this.controlConnectionFactory = controlConnectionFactory;
		}
	}
	
	public void unbindConnectionFactorySPI(IControlConnectionFactory controlConnectionFactory, Map<String,?> properties) {
		this.controlConnectionFactory = null;
	}
	
	/////////////////////////////////////////////////////////////
	// Metodos que controlan el modelo
	/////////////////////////////////////////////////////////////
	
	@Override
	public Date getModelDate() {
		synchronized (this) {
			return modelWrapper == null ? null : modelWrapper.getModelDate();
		}
	}

	@Override
	public void updateModelFromBackend() throws ModelSIPException {
		try {
			EMFModelWrapper tmpModel = EMFModelWrapper.newBuilder(controlConnectionFactory).build();
			synchronized (this) {
				this.modelWrapper = tmpModel;
			}
		} catch (EMFModelWrapperException e) {
			throw new ModelSIPException("No se ha podido cargar el modelo desde el backend", e);
		}
	}

	@Override
	public void updatePhotosFromBackend() throws ModelSIPException {
	}

	/////////////////////////////////////////////////////////////
	// Metodos del modelo
	/////////////////////////////////////////////////////////////

	@Override
	public IPerson getPersonByAccreditation(IAccreditation accreditation) throws ModelSIPException {
		synchronized (this) {
			if (modelWrapper == null) {
				throw new ModelSIPException("No ");
			} else {
				try {
					return modelWrapper.getPersonByAccreditation(accreditation);
				} catch (EMFModelWrapperException e) {
					throw new ModelSIPException("Error al intentar obtener la persona desde una acreditacion.", e);
				}
			}
		}
	}
	
	@Override
	public void addListener(final IModelListener listener) {
		synchronized (this) {
			listeners.add(listener);
		}
	}	

	@Override
	public void removeListener(IModelListener listener) {
		synchronized (this) {
			listeners.remove(listener);
		}
	}
	
	/////////////////////////////////////////////////////////////
	// Notificaciones del modelo
	/////////////////////////////////////////////////////////////
	// TODO: Listener o tracker ??
	private void fireModelUpdatedEvent() {
		synchronized (this) {
			for (IModelListener listener : listeners) {
				listener.modelUpdate(this);
			}
		}
	}
	
	private void removeAllListeners() {
		synchronized (this) {
			listeners.clear();
		}
	}

}

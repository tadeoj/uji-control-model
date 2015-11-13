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
import es.uji.control.domain.provider.service.connectionfactory.ControlConnectionException;
import es.uji.control.domain.provider.service.connectionfactory.IControlConnectionFactory;
import es.uji.control.model.sip.IModelListener;
import es.uji.control.model.sip.IModelSIP;
import es.uji.control.model.sip.QueryModelSIPException;
import es.uji.control.model.sip.domain.IModel;

@Component(name = "model.sip.component", immediate = true)
public class ModelSIPComponent implements IModelSIP {

	private Date date;
	private List<IModelListener> listeners;
	private Object lock;
	private IControlConnectionFactory connectionFactory;
	private List<IPerson> people;
	private List<IAccreditation> accreditation;
	
	@Activate
	public void startup() {
		lock = new Object();
		model = null;
		listeners = new ArrayList<IModelListener>(2);
	}
	
	@Deactivate
	public void shutdown() {
		removeAllListeners();
	}
	
	@Reference(policy=ReferencePolicy.DYNAMIC, cardinality=ReferenceCardinality.MANDATORY, name="controlConnectionFactory")
	public void bindConnectionFactorySPI(IControlConnectionFactory connectionFactory, Map<String,?> properties) {
		this.connectionFactory = connectionFactory;
	}
	
	public void unbindConnectionFactorySPI(IControlConnectionFactory connectionFactory, Map<String,?> properties) throws ControlConnectionException {
		this.connectionFactory = null;
		throw new ControlConnectionException("Se ha perdido la conexión.");
	}
	
	/////////////////////////////////////////////////////////////
	// Gestion del modelo
	/////////////////////////////////////////////////////////////
	
	@Override
	public Date getModelDate() {
		return this.date;
	}

	@Override
	public void updateModel() throws QueryModelSIPException {
		
	}

	@Override
	public void updatePhotos() throws QueryModelSIPException {
		// TODO Auto-generated method stub
		
	}

	/////////////////////////////////////////////////////////////
	// API de acceso al modelo
	/////////////////////////////////////////////////////////////

	@Override
	public IPerson getUserByRaw(long raw) {
//		List<Persons> personsList = model.getModelPersonsList();
//		Iterator<Persons> personsIterator = personsList.iterator();
//		Cards card = null;
//		
//		if (getCardByID(tagId) != null) {
//			card = getCardBySN(tagId);
//		} else {
//			return null;
//		}
//		
//		while (personsIterator.hasNext()) {
//			Persons person = personsIterator.next();
//			if(card.getPerId().equals(person.getId())) {
//				return person;
//			}
//		}
		return null;
	}
	
	/////////////////////////////////////////////////////////////
	// Notificaciones del modelo
	/////////////////////////////////////////////////////////////
	
	private void fireModelUpdatedEvent() {
		for (IModelListener listener : listeners) {
			fireModelUpdatedEvent(listener);
		}
	}
	
	private void fireModelUpdatedEvent(IModelListener listener) {
		listener.modelUpdate(this);
	}
	
	@Override
	public void addListener(final IModelListener listener) {
		synchronized (lock) {
			listeners.add(listener);
		}
	}	

	@Override
	public void removeListener(IModelListener listener) {
		synchronized (lock) {
			listeners.remove(listener);
		}
	}
	
	private void removeAllListeners() {
		synchronized (lock) {
			listeners.clear();
		}
	}

}

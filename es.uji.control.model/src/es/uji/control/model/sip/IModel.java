/*******************************************************************************
 * Copyright © Universitat Jaume I de Castelló 2015.
 * Aquest programari es distribueix sota les condicions de llicència EUPL 
 * o de qualsevol altra que la substituisca en el futur.
 * La llicència completa es pot descarregar de 
 * https://joinup.ec.europa.eu/community/eupl/og_page/european-union-public-licence-eupl-v11
 *******************************************************************************/
package es.uji.control.model.sip;

import java.util.Date;
import java.util.function.Consumer;

import es.uji.control.domain.people.IAccreditation;
import es.uji.control.domain.people.IPerson;

public interface IModel {
	
	/////////////////////////////////////////////////////////////
	// Control del modelo
	/////////////////////////////////////////////////////////////
	public void updateModelFromBackend();
	public void setUpdateModelStateListener(Consumer<Boolean> consumer);
	public void fireUpdateModelStateListener();
	
	/////////////////////////////////////////////////////////////
	// Control de la cache de fotografias
	/////////////////////////////////////////////////////////////
	public void updatePhotosFromBackend();
	
	/////////////////////////////////////////////////////////////
	// Estado del modelo
	/////////////////////////////////////////////////////////////
	public void setEventsConsumer(Consumer<ModelLogEntry> consumer);
	public Date getModelDate();
	
	/////////////////////////////////////////////////////////////
	// Acceso al modelo
	/////////////////////////////////////////////////////////////
	public IPerson getPersonByAccreditation(IAccreditation accreditation) throws ModelException;
		
}

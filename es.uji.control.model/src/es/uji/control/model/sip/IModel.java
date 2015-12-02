/*******************************************************************************
 * Copyright © Universitat Jaume I de Castelló 2015.
 * Aquest programari es distribueix sota les condicions de llicència EUPL 
 * o de qualsevol altra que la substituisca en el futur.
 * La llicència completa es pot descarregar de 
 * https://joinup.ec.europa.eu/community/eupl/og_page/european-union-public-licence-eupl-v11
 *******************************************************************************/
package es.uji.control.model.sip;

import java.util.Date;
import java.util.List;
import java.util.function.Consumer;

import es.uji.control.domain.people.IAccreditation;
import es.uji.control.domain.people.IPerson;

public interface IModel {
	
	/////////////////////////////////////////////////////////////
	// Log
	/////////////////////////////////////////////////////////////
	public void setLogger(Consumer<ModelLogEntry> logger);

	/////////////////////////////////////////////////////////////
	// Control del modelo
	/////////////////////////////////////////////////////////////
	public void updateModelFromBackend();
	public void setUpdateModelUpdatingTracker(Consumer<Boolean> consumer);
	
	/////////////////////////////////////////////////////////////
	// Control de la cache de fotografias
	/////////////////////////////////////////////////////////////
	public void updatePhotosFromBackend();
	
	/////////////////////////////////////////////////////////////
	// Estado del modelo
	/////////////////////////////////////////////////////////////
	public Date getModelDate();
	
	/////////////////////////////////////////////////////////////
	// Acceso al modelo
	/////////////////////////////////////////////////////////////
	public IPerson getPersonByAccreditation(IAccreditation accreditation) throws ModelException;
	public List<IPerson> getPersonsBySearch(IPerson person) throws ModelException;
		
}

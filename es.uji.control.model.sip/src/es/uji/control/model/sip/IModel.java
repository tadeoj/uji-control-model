/*******************************************************************************
 * Copyright © Universitat Jaume I de Castelló 2015.
 * Aquest programari es distribueix sota les condicions de llicència EUPL 
 * o de qualsevol altra que la substituisca en el futur.
 * La llicència completa es pot descarregar de 
 * https://joinup.ec.europa.eu/community/eupl/og_page/european-union-public-licence-eupl-v11
 *******************************************************************************/
package es.uji.control.model.sip;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

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
	public void setUpdatePhotosUpdatingTracker(Consumer<Boolean> consumer);

	/////////////////////////////////////////////////////////////
	// Estado del modelo
	/////////////////////////////////////////////////////////////
	public LocalDateTime getModelDate();
	public void setUpdateModelStateTracker(Consumer<LocalDateTime> state);
	
	/////////////////////////////////////////////////////////////
	// Acceso al modelo
	/////////////////////////////////////////////////////////////
	public IPerson getPersonByAccreditation(IAccreditation accreditation) throws ModelException;
	public List<IPerson> searchPerson(Predicate<IPerson> predicate) throws ModelException;
	
	/////////////////////////////////////////////////////////////
	// Acceso a la cache de fotografias
	/////////////////////////////////////////////////////////////
	
	
	
}

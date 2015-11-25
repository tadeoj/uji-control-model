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

public interface IModelSIP {
	
	/////////////////////////////////////////////////////////////
	// Metodos que controlan el modelo
	/////////////////////////////////////////////////////////////
	public void updateModelFromBackend(Consumer<AsyncModelSIPEvent> consumer);
	public void updatePhotosFromBackend(Consumer<AsyncModelSIPEvent> consumer);
	
	/////////////////////////////////////////////////////////////
	// Estado del modelo
	/////////////////////////////////////////////////////////////
	public Date getModelDate();
	
	/////////////////////////////////////////////////////////////
	// Acceso al modelo
	/////////////////////////////////////////////////////////////
	public IPerson getPersonByAccreditation(IAccreditation accreditation) throws ModelSIPException;
		
}

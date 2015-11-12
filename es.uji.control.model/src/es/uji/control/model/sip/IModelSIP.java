/*******************************************************************************
 * Copyright © Universitat Jaume I de Castelló 2015.
 * Aquest programari es distribueix sota les condicions de llicència EUPL 
 * o de qualsevol altra que la substituisca en el futur.
 * La llicència completa es pot descarregar de 
 * https://joinup.ec.europa.eu/community/eupl/og_page/european-union-public-licence-eupl-v11
 *******************************************************************************/
package es.uji.control.model.sip;

import java.util.Date;

import es.uji.control.domain.people.IPerson;

public interface IModelSIP {
	
	/////////////////////////////////////////////////////////////
	// Gestion del modelo
	/////////////////////////////////////////////////////////////
	public Date getModelDate();
	public void updateModel() throws QueryModelSIPException;
	public void updatePhotos() throws QueryModelSIPException;
	
	/////////////////////////////////////////////////////////////
	// API de acceso al modelo
	/////////////////////////////////////////////////////////////
	public IPerson getUserByRaw(long raw);
		
	public void addListener(IModelListener listener);
	public void removeListener(IModelListener listener);

}

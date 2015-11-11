/*******************************************************************************
 * Copyright © Universitat Jaume I de Castelló 2015.
 * Aquest programari es distribueix sota les condicions de llicència EUPL 
 * o de qualsevol altra que la substituisca en el futur.
 * La llicència completa es pot descarregar de 
 * https://joinup.ec.europa.eu/community/eupl/og_page/european-union-public-licence-eupl-v11
 *******************************************************************************/
package es.uji.control.model.factory;

import es.uji.control.model.emf.sip.Model;

public interface IModelFactory {
	
	// Consulta en la base de datos el modelo.
	public Model updateModel() throws QueryModelException;
	
	// Sincroniza las fotos del modelo persistente en disco
	public void syncronizePhotos() throws QueryModelException;
	
}

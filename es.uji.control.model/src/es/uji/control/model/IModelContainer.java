/*******************************************************************************
 * Copyright © Universitat Jaume I de Castelló 2015.
 * Aquest programari es distribueix sota les condicions de llicència EUPL 
 * o de qualsevol altra que la substituisca en el futur.
 * La llicència completa es pot descarregar de 
 * https://joinup.ec.europa.eu/community/eupl/og_page/european-union-public-licence-eupl-v11
 *******************************************************************************/
package es.uji.control.model;

import es.uji.control.controller.mifare.MifareTagId;
import es.uji.control.model.emf.sip.Model;
import es.uji.control.model.emf.sip.Persons;

public interface IModelContainer {
	
	public Model getCurrentModel();
	public void setCurrentModel(Model model);
	
	public Persons getUserByTagId(MifareTagId mifareTagId);
	public Persons getUserByTagId(long tagId);
		
	public void addListener(IModelListener listener);
	public void removeListener(IModelListener listener);

}

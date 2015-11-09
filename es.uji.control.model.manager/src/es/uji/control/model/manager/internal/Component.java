/*******************************************************************************
 * Copyright © Universitat Jaume I de Castelló 2015.
 * Aquest programari es distribueix sota les condicions de llicència EUPL 
 * o de qualsevol altra que la substituisca en el futur.
 * La llicència completa es pot descarregar de 
 * https://joinup.ec.europa.eu/community/eupl/og_page/european-union-public-licence-eupl-v11
 *******************************************************************************/
package es.uji.control.model.manager.internal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.uji.control.model.IModelContainer;
import es.uji.control.model.cache.IModelCache;
import es.uji.control.model.factory.IModelFactory;
import es.uji.control.model.manager.IModelManager;
import es.uji.control.model.manager.UpdateState;
import es.uji.control.model.manager.UpdateStateEnum;

public class Component implements IModelManager {

	static final Logger logger = LoggerFactory.getLogger(Component.class);
	
	private IModelContainer modelContainer;
	private IModelCache cache;
	private IModelFactory modelDAO;
	
	public void startup() {
		System.out.println("");
	}
	
	public void shutdown() {
		System.out.println("");
	}
	
	public void setModel(IModelContainer model) {
		this.modelContainer = model;
	}
	
	public void setCache(IModelCache cache) {
		this.cache = cache;
	}
	
	public void setModelDAO(IModelFactory modelDAO) {
		this.modelDAO = modelDAO;
	}
	
	//////////////////////////////////////////////////////////////////
	// Metodos encargados de la actualización del modelo.
	//////////////////////////////////////////////////////////////////
	
	@Override
	public UpdateState firstUpdate() {
		// Como acaba de iniciarse el sistema y no hay datos en el modelo
		// lo cargamos con lo que encontramos en la cache.
		modelContainer.setCurrentModel(cache.readModelFromCache());
		// Como ya proveemos de un modelo inicial, ya podemos intentar actualiza
		// los datos desde el servidor.
		return update();
	}

	@Override
	public UpdateState update() {
		// Se actualiza la cache y el modelo desde el servidor.
		try {
			cache.writeModelToCache(modelDAO.queryModel());
			modelContainer.setCurrentModel(cache.readModelFromCache());
			return new UpdateState(UpdateStateEnum.OK, null);
		} catch (Exception e) {
			return new UpdateState(UpdateStateEnum.UPDATE_ERROR, e);
		}
	}
}

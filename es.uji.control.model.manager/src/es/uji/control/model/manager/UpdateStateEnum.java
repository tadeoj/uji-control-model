/*******************************************************************************
 * Copyright © Universitat Jaume I de Castelló 2015.
 * Aquest programari es distribueix sota les condicions de llicència EUPL 
 * o de qualsevol altra que la substituisca en el futur.
 * La llicència completa es pot descarregar de 
 * https://joinup.ec.europa.eu/community/eupl/og_page/european-union-public-licence-eupl-v11
 *******************************************************************************/
package es.uji.control.model.manager;

public enum UpdateStateEnum {
	
	OK (0,"La actualización se ha realizado correctamente."),
	UPDATE_ERROR (1, "No se ha podido actualizar el modelo.");
	
	private int id;
	private String description;
	
	private UpdateStateEnum(int id, String description) {
		this.id = id;
		this.description = description;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return super.toString();
	}
	
	public String getDescription() {
		return description;
	}
	
	public static UpdateStateEnum getById(int id) {
		for (UpdateStateEnum updateState : UpdateStateEnum.values()) {
			if (id == updateState.getId())
				return updateState;
		}
		return null;
	}
}

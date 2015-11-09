/*******************************************************************************
 * Copyright © Universitat Jaume I de Castelló 2015.
 * Aquest programari es distribueix sota les condicions de llicència EUPL 
 * o de qualsevol altra que la substituisca en el futur.
 * La llicència completa es pot descarregar de 
 * https://joinup.ec.europa.eu/community/eupl/og_page/european-union-public-licence-eupl-v11
 *******************************************************************************/
package es.uji.control.model.manager;

public class UpdateState {
	
	private UpdateStateEnum updateStateEnum;
	private Throwable throwable;
	
	public UpdateState(UpdateStateEnum updateStateEnum, Throwable throwable) {
		this.updateStateEnum = updateStateEnum;
		this.throwable = throwable;
	}

	public UpdateStateEnum getUpdateStateEnum() {
		return updateStateEnum;
	}

	public Throwable getThrowable() {
		return throwable;
	}
	
}

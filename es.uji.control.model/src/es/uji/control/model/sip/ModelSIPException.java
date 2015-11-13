/*******************************************************************************
 * Copyright © Universitat Jaume I de Castelló 2015.
 * Aquest programari es distribueix sota les condicions de llicència EUPL 
 * o de qualsevol altra que la substituisca en el futur.
 * La llicència completa es pot descarregar de 
 * https://joinup.ec.europa.eu/community/eupl/og_page/european-union-public-licence-eupl-v11
 *******************************************************************************/
package es.uji.control.model.sip;

public class ModelSIPException extends Exception {

	private static final long serialVersionUID = -4995866451573580180L;

	public ModelSIPException(String message, Throwable cause) {
		super(message, cause);
	}

	public ModelSIPException(String message) {
		super(message);
	}

}

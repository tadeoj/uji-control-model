/*******************************************************************************
 * Copyright © Universitat Jaume I de Castelló 2015.
 * Aquest programari es distribueix sota les condicions de llicència EUPL 
 * o de qualsevol altra que la substituisca en el futur.
 * La llicència completa es pot descarregar de 
 * https://joinup.ec.europa.eu/community/eupl/og_page/european-union-public-licence-eupl-v11
 *******************************************************************************/
/**
 */
package es.uji.control.model.emf.sip;

import java.util.Date;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link es.uji.control.model.emf.sip.Model#getDate <em>Date</em>}</li>
 *   <li>{@link es.uji.control.model.emf.sip.Model#getModelPersonsList <em>Model Persons List</em>}</li>
 *   <li>{@link es.uji.control.model.emf.sip.Model#getModelCardsList <em>Model Cards List</em>}</li>
 *   <li>{@link es.uji.control.model.emf.sip.Model#getZoneId <em>Zone Id</em>}</li>
 *   <li>{@link es.uji.control.model.emf.sip.Model#getZoneName <em>Zone Name</em>}</li>
 * </ul>
 *
 * @see es.uji.control.model.emf.sip.SipPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject {
	/**
	 * Returns the value of the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date</em>' attribute.
	 * @see #setDate(Date)
	 * @see es.uji.control.model.emf.sip.SipPackage#getModel_Date()
	 * @model
	 * @generated
	 */
	Date getDate();

	/**
	 * Sets the value of the '{@link es.uji.control.model.emf.sip.Model#getDate <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date</em>' attribute.
	 * @see #getDate()
	 * @generated
	 */
	void setDate(Date value);

	/**
	 * Returns the value of the '<em><b>Model Persons List</b></em>' containment reference list.
	 * The list contents are of type {@link es.uji.control.model.emf.sip.Persons}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Persons List</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Persons List</em>' containment reference list.
	 * @see es.uji.control.model.emf.sip.SipPackage#getModel_ModelPersonsList()
	 * @model containment="true"
	 * @generated
	 */
	EList<Persons> getModelPersonsList();

	/**
	 * Returns the value of the '<em><b>Model Cards List</b></em>' containment reference list.
	 * The list contents are of type {@link es.uji.control.model.emf.sip.Cards}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Cards List</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Cards List</em>' containment reference list.
	 * @see es.uji.control.model.emf.sip.SipPackage#getModel_ModelCardsList()
	 * @model containment="true"
	 * @generated
	 */
	EList<Cards> getModelCardsList();

	/**
	 * Returns the value of the '<em><b>Zone Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Zone Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Zone Id</em>' attribute.
	 * @see #setZoneId(long)
	 * @see es.uji.control.model.emf.sip.SipPackage#getModel_ZoneId()
	 * @model
	 * @generated
	 */
	long getZoneId();

	/**
	 * Sets the value of the '{@link es.uji.control.model.emf.sip.Model#getZoneId <em>Zone Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Zone Id</em>' attribute.
	 * @see #getZoneId()
	 * @generated
	 */
	void setZoneId(long value);

	/**
	 * Returns the value of the '<em><b>Zone Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Zone Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Zone Name</em>' attribute.
	 * @see #setZoneName(String)
	 * @see es.uji.control.model.emf.sip.SipPackage#getModel_ZoneName()
	 * @model
	 * @generated
	 */
	String getZoneName();

	/**
	 * Sets the value of the '{@link es.uji.control.model.emf.sip.Model#getZoneName <em>Zone Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Zone Name</em>' attribute.
	 * @see #getZoneName()
	 * @generated
	 */
	void setZoneName(String value);

} // Model

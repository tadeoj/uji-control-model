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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Persons</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link es.uji.control.model.emf.sip.Persons#getId <em>Id</em>}</li>
 *   <li>{@link es.uji.control.model.emf.sip.Persons#getIdentification <em>Identification</em>}</li>
 *   <li>{@link es.uji.control.model.emf.sip.Persons#getName <em>Name</em>}</li>
 *   <li>{@link es.uji.control.model.emf.sip.Persons#getFirstName1 <em>First Name1</em>}</li>
 *   <li>{@link es.uji.control.model.emf.sip.Persons#getFirstName2 <em>First Name2</em>}</li>
 *   <li>{@link es.uji.control.model.emf.sip.Persons#getLink <em>Link</em>}</li>
 *   <li>{@link es.uji.control.model.emf.sip.Persons#getCardsList <em>Cards List</em>}</li>
 * </ul>
 *
 * @see es.uji.control.model.emf.sip.SipPackage#getPersons()
 * @model
 * @generated
 */
public interface Persons extends EObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(Long)
	 * @see es.uji.control.model.emf.sip.SipPackage#getPersons_Id()
	 * @model
	 * @generated
	 */
	Long getId();

	/**
	 * Sets the value of the '{@link es.uji.control.model.emf.sip.Persons#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(Long value);

	/**
	 * Returns the value of the '<em><b>Identification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identification</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identification</em>' attribute.
	 * @see #setIdentification(String)
	 * @see es.uji.control.model.emf.sip.SipPackage#getPersons_Identification()
	 * @model
	 * @generated
	 */
	String getIdentification();

	/**
	 * Sets the value of the '{@link es.uji.control.model.emf.sip.Persons#getIdentification <em>Identification</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identification</em>' attribute.
	 * @see #getIdentification()
	 * @generated
	 */
	void setIdentification(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see es.uji.control.model.emf.sip.SipPackage#getPersons_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link es.uji.control.model.emf.sip.Persons#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>First Name1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>First Name1</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First Name1</em>' attribute.
	 * @see #setFirstName1(String)
	 * @see es.uji.control.model.emf.sip.SipPackage#getPersons_FirstName1()
	 * @model
	 * @generated
	 */
	String getFirstName1();

	/**
	 * Sets the value of the '{@link es.uji.control.model.emf.sip.Persons#getFirstName1 <em>First Name1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First Name1</em>' attribute.
	 * @see #getFirstName1()
	 * @generated
	 */
	void setFirstName1(String value);

	/**
	 * Returns the value of the '<em><b>First Name2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>First Name2</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First Name2</em>' attribute.
	 * @see #setFirstName2(String)
	 * @see es.uji.control.model.emf.sip.SipPackage#getPersons_FirstName2()
	 * @model
	 * @generated
	 */
	String getFirstName2();

	/**
	 * Sets the value of the '{@link es.uji.control.model.emf.sip.Persons#getFirstName2 <em>First Name2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First Name2</em>' attribute.
	 * @see #getFirstName2()
	 * @generated
	 */
	void setFirstName2(String value);

	/**
	 * Returns the value of the '<em><b>Link</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Link</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link</em>' attribute.
	 * @see #setLink(EList)
	 * @see es.uji.control.model.emf.sip.SipPackage#getPersons_Link()
	 * @model many="false"
	 * @generated
	 */
	EList<?> getLink();

	/**
	 * Sets the value of the '{@link es.uji.control.model.emf.sip.Persons#getLink <em>Link</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link</em>' attribute.
	 * @see #getLink()
	 * @generated
	 */
	void setLink(EList<?> value);

	/**
	 * Returns the value of the '<em><b>Cards List</b></em>' containment reference list.
	 * The list contents are of type {@link es.uji.control.model.emf.sip.Cards}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cards List</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cards List</em>' containment reference list.
	 * @see es.uji.control.model.emf.sip.SipPackage#getPersons_CardsList()
	 * @model containment="true"
	 * @generated
	 */
	EList<Cards> getCardsList();

} // Persons

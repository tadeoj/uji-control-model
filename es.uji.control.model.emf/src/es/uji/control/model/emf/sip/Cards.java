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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cards</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link es.uji.control.model.emf.sip.Cards#getId <em>Id</em>}</li>
 *   <li>{@link es.uji.control.model.emf.sip.Cards#getPerId <em>Per Id</em>}</li>
 *   <li>{@link es.uji.control.model.emf.sip.Cards#getCreationDate <em>Creation Date</em>}</li>
 *   <li>{@link es.uji.control.model.emf.sip.Cards#getIssueDate <em>Issue Date</em>}</li>
 *   <li>{@link es.uji.control.model.emf.sip.Cards#getCancelationDate <em>Cancelation Date</em>}</li>
 *   <li>{@link es.uji.control.model.emf.sip.Cards#getDescription <em>Description</em>}</li>
 *   <li>{@link es.uji.control.model.emf.sip.Cards#getSerialNumber <em>Serial Number</em>}</li>
 * </ul>
 *
 * @see es.uji.control.model.emf.sip.SipPackage#getCards()
 * @model
 * @generated
 */
public interface Cards extends EObject {
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
	 * @see es.uji.control.model.emf.sip.SipPackage#getCards_Id()
	 * @model
	 * @generated
	 */
	Long getId();

	/**
	 * Sets the value of the '{@link es.uji.control.model.emf.sip.Cards#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(Long value);

	/**
	 * Returns the value of the '<em><b>Per Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Per Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Per Id</em>' attribute.
	 * @see #setPerId(Long)
	 * @see es.uji.control.model.emf.sip.SipPackage#getCards_PerId()
	 * @model
	 * @generated
	 */
	Long getPerId();

	/**
	 * Sets the value of the '{@link es.uji.control.model.emf.sip.Cards#getPerId <em>Per Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Per Id</em>' attribute.
	 * @see #getPerId()
	 * @generated
	 */
	void setPerId(Long value);

	/**
	 * Returns the value of the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Creation Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Creation Date</em>' attribute.
	 * @see #setCreationDate(Date)
	 * @see es.uji.control.model.emf.sip.SipPackage#getCards_CreationDate()
	 * @model
	 * @generated
	 */
	Date getCreationDate();

	/**
	 * Sets the value of the '{@link es.uji.control.model.emf.sip.Cards#getCreationDate <em>Creation Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Creation Date</em>' attribute.
	 * @see #getCreationDate()
	 * @generated
	 */
	void setCreationDate(Date value);

	/**
	 * Returns the value of the '<em><b>Issue Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Issue Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Issue Date</em>' attribute.
	 * @see #setIssueDate(Date)
	 * @see es.uji.control.model.emf.sip.SipPackage#getCards_IssueDate()
	 * @model
	 * @generated
	 */
	Date getIssueDate();

	/**
	 * Sets the value of the '{@link es.uji.control.model.emf.sip.Cards#getIssueDate <em>Issue Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Issue Date</em>' attribute.
	 * @see #getIssueDate()
	 * @generated
	 */
	void setIssueDate(Date value);

	/**
	 * Returns the value of the '<em><b>Cancelation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cancelation Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cancelation Date</em>' attribute.
	 * @see #setCancelationDate(Date)
	 * @see es.uji.control.model.emf.sip.SipPackage#getCards_CancelationDate()
	 * @model
	 * @generated
	 */
	Date getCancelationDate();

	/**
	 * Sets the value of the '{@link es.uji.control.model.emf.sip.Cards#getCancelationDate <em>Cancelation Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cancelation Date</em>' attribute.
	 * @see #getCancelationDate()
	 * @generated
	 */
	void setCancelationDate(Date value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see es.uji.control.model.emf.sip.SipPackage#getCards_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link es.uji.control.model.emf.sip.Cards#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Serial Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Serial Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Serial Number</em>' attribute.
	 * @see #setSerialNumber(Long)
	 * @see es.uji.control.model.emf.sip.SipPackage#getCards_SerialNumber()
	 * @model
	 * @generated
	 */
	Long getSerialNumber();

	/**
	 * Sets the value of the '{@link es.uji.control.model.emf.sip.Cards#getSerialNumber <em>Serial Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Serial Number</em>' attribute.
	 * @see #getSerialNumber()
	 * @generated
	 */
	void setSerialNumber(Long value);

} // Cards

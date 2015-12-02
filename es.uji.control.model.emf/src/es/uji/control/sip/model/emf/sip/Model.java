/**
 */
package es.uji.control.sip.model.emf.sip;

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
 *   <li>{@link es.uji.control.sip.model.emf.sip.Model#getDate <em>Date</em>}</li>
 *   <li>{@link es.uji.control.sip.model.emf.sip.Model#getSignature <em>Signature</em>}</li>
 *   <li>{@link es.uji.control.sip.model.emf.sip.Model#getModelPersonsList <em>Model Persons List</em>}</li>
 *   <li>{@link es.uji.control.sip.model.emf.sip.Model#getModelCardsList <em>Model Cards List</em>}</li>
 * </ul>
 *
 * @see es.uji.control.sip.model.emf.sip.SipPackage#getModel()
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
	 * @see es.uji.control.sip.model.emf.sip.SipPackage#getModel_Date()
	 * @model
	 * @generated
	 */
	Date getDate();

	/**
	 * Sets the value of the '{@link es.uji.control.sip.model.emf.sip.Model#getDate <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date</em>' attribute.
	 * @see #getDate()
	 * @generated
	 */
	void setDate(Date value);

	/**
	 * Returns the value of the '<em><b>Signature</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Signature</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Signature</em>' attribute.
	 * @see #setSignature(String)
	 * @see es.uji.control.sip.model.emf.sip.SipPackage#getModel_Signature()
	 * @model default=""
	 * @generated
	 */
	String getSignature();

	/**
	 * Sets the value of the '{@link es.uji.control.sip.model.emf.sip.Model#getSignature <em>Signature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Signature</em>' attribute.
	 * @see #getSignature()
	 * @generated
	 */
	void setSignature(String value);

	/**
	 * Returns the value of the '<em><b>Model Persons List</b></em>' containment reference list.
	 * The list contents are of type {@link es.uji.control.sip.model.emf.sip.Person}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Persons List</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Persons List</em>' containment reference list.
	 * @see es.uji.control.sip.model.emf.sip.SipPackage#getModel_ModelPersonsList()
	 * @model containment="true"
	 * @generated
	 */
	EList<Person> getModelPersonsList();

	/**
	 * Returns the value of the '<em><b>Model Cards List</b></em>' containment reference list.
	 * The list contents are of type {@link es.uji.control.sip.model.emf.sip.Accreditation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Cards List</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Cards List</em>' containment reference list.
	 * @see es.uji.control.sip.model.emf.sip.SipPackage#getModel_ModelCardsList()
	 * @model containment="true"
	 * @generated
	 */
	EList<Accreditation> getModelCardsList();

} // Model

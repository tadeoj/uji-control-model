/**
 */
package es.uji.control.sip.model.emf.sip;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Accreditation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link es.uji.control.sip.model.emf.sip.Accreditation#getId <em>Id</em>}</li>
 *   <li>{@link es.uji.control.sip.model.emf.sip.Accreditation#getRaw <em>Raw</em>}</li>
 *   <li>{@link es.uji.control.sip.model.emf.sip.Accreditation#getType <em>Type</em>}</li>
 *   <li>{@link es.uji.control.sip.model.emf.sip.Accreditation#getPerson <em>Person</em>}</li>
 * </ul>
 *
 * @see es.uji.control.sip.model.emf.sip.SipPackage#getAccreditation()
 * @model
 * @generated
 */
public interface Accreditation extends EObject {
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
	 * @see es.uji.control.sip.model.emf.sip.SipPackage#getAccreditation_Id()
	 * @model
	 * @generated
	 */
	Long getId();

	/**
	 * Sets the value of the '{@link es.uji.control.sip.model.emf.sip.Accreditation#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(Long value);

	/**
	 * Returns the value of the '<em><b>Raw</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Raw</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Raw</em>' attribute.
	 * @see #setRaw(Long)
	 * @see es.uji.control.sip.model.emf.sip.SipPackage#getAccreditation_Raw()
	 * @model
	 * @generated
	 */
	Long getRaw();

	/**
	 * Sets the value of the '{@link es.uji.control.sip.model.emf.sip.Accreditation#getRaw <em>Raw</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Raw</em>' attribute.
	 * @see #getRaw()
	 * @generated
	 */
	void setRaw(Long value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see es.uji.control.sip.model.emf.sip.SipPackage#getAccreditation_Type()
	 * @model
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link es.uji.control.sip.model.emf.sip.Accreditation#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Person</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link es.uji.control.sip.model.emf.sip.Person#getAccreditationsList <em>Accreditations List</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Person</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Person</em>' container reference.
	 * @see #setPerson(Person)
	 * @see es.uji.control.sip.model.emf.sip.SipPackage#getAccreditation_Person()
	 * @see es.uji.control.sip.model.emf.sip.Person#getAccreditationsList
	 * @model opposite="accreditationsList" transient="false"
	 * @generated
	 */
	Person getPerson();

	/**
	 * Sets the value of the '{@link es.uji.control.sip.model.emf.sip.Accreditation#getPerson <em>Person</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Person</em>' container reference.
	 * @see #getPerson()
	 * @generated
	 */
	void setPerson(Person value);

} // Accreditation

/**
 */
package es.uji.control.sip.model.emf.sip;

import java.util.Date;

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
 *   <li>{@link es.uji.control.sip.model.emf.sip.Accreditation#getIssueDate <em>Issue Date</em>}</li>
 *   <li>{@link es.uji.control.sip.model.emf.sip.Accreditation#getCancelationDate <em>Cancelation Date</em>}</li>
 *   <li>{@link es.uji.control.sip.model.emf.sip.Accreditation#getRaw <em>Raw</em>}</li>
 *   <li>{@link es.uji.control.sip.model.emf.sip.Accreditation#getPerson <em>Person</em>}</li>
 * </ul>
 *
 * @see es.uji.control.sip.model.emf.sip.SipPackage#getAccreditation()
 * @model
 * @generated
 */
public interface Accreditation extends EObject {
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
	 * @see es.uji.control.sip.model.emf.sip.SipPackage#getAccreditation_IssueDate()
	 * @model
	 * @generated
	 */
	Date getIssueDate();

	/**
	 * Sets the value of the '{@link es.uji.control.sip.model.emf.sip.Accreditation#getIssueDate <em>Issue Date</em>}' attribute.
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
	 * @see es.uji.control.sip.model.emf.sip.SipPackage#getAccreditation_CancelationDate()
	 * @model
	 * @generated
	 */
	Date getCancelationDate();

	/**
	 * Sets the value of the '{@link es.uji.control.sip.model.emf.sip.Accreditation#getCancelationDate <em>Cancelation Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cancelation Date</em>' attribute.
	 * @see #getCancelationDate()
	 * @generated
	 */
	void setCancelationDate(Date value);

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

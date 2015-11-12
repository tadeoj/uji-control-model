/**
 */
package es.uji.control.sip.model.emf.sip;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Person</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link es.uji.control.sip.model.emf.sip.Person#getId <em>Id</em>}</li>
 *   <li>{@link es.uji.control.sip.model.emf.sip.Person#getIdentification <em>Identification</em>}</li>
 *   <li>{@link es.uji.control.sip.model.emf.sip.Person#getName <em>Name</em>}</li>
 *   <li>{@link es.uji.control.sip.model.emf.sip.Person#getFirstName1 <em>First Name1</em>}</li>
 *   <li>{@link es.uji.control.sip.model.emf.sip.Person#getFirstName2 <em>First Name2</em>}</li>
 *   <li>{@link es.uji.control.sip.model.emf.sip.Person#getAccreditationsList <em>Accreditations List</em>}</li>
 *   <li>{@link es.uji.control.sip.model.emf.sip.Person#getLinkages <em>Linkages</em>}</li>
 * </ul>
 *
 * @see es.uji.control.sip.model.emf.sip.SipPackage#getPerson()
 * @model
 * @generated
 */
public interface Person extends EObject {
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
	 * @see es.uji.control.sip.model.emf.sip.SipPackage#getPerson_Id()
	 * @model
	 * @generated
	 */
	Long getId();

	/**
	 * Sets the value of the '{@link es.uji.control.sip.model.emf.sip.Person#getId <em>Id</em>}' attribute.
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
	 * @see es.uji.control.sip.model.emf.sip.SipPackage#getPerson_Identification()
	 * @model
	 * @generated
	 */
	String getIdentification();

	/**
	 * Sets the value of the '{@link es.uji.control.sip.model.emf.sip.Person#getIdentification <em>Identification</em>}' attribute.
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
	 * @see es.uji.control.sip.model.emf.sip.SipPackage#getPerson_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link es.uji.control.sip.model.emf.sip.Person#getName <em>Name</em>}' attribute.
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
	 * @see es.uji.control.sip.model.emf.sip.SipPackage#getPerson_FirstName1()
	 * @model
	 * @generated
	 */
	String getFirstName1();

	/**
	 * Sets the value of the '{@link es.uji.control.sip.model.emf.sip.Person#getFirstName1 <em>First Name1</em>}' attribute.
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
	 * @see es.uji.control.sip.model.emf.sip.SipPackage#getPerson_FirstName2()
	 * @model
	 * @generated
	 */
	String getFirstName2();

	/**
	 * Sets the value of the '{@link es.uji.control.sip.model.emf.sip.Person#getFirstName2 <em>First Name2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First Name2</em>' attribute.
	 * @see #getFirstName2()
	 * @generated
	 */
	void setFirstName2(String value);

	/**
	 * Returns the value of the '<em><b>Accreditations List</b></em>' containment reference list.
	 * The list contents are of type {@link es.uji.control.sip.model.emf.sip.Accreditation}.
	 * It is bidirectional and its opposite is '{@link es.uji.control.sip.model.emf.sip.Accreditation#getPerson <em>Person</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Accreditations List</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Accreditations List</em>' containment reference list.
	 * @see es.uji.control.sip.model.emf.sip.SipPackage#getPerson_AccreditationsList()
	 * @see es.uji.control.sip.model.emf.sip.Accreditation#getPerson
	 * @model opposite="person" containment="true"
	 * @generated
	 */
	EList<Accreditation> getAccreditationsList();

	/**
	 * Returns the value of the '<em><b>Linkages</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Linkages</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Linkages</em>' reference.
	 * @see #setLinkages(Linkage)
	 * @see es.uji.control.sip.model.emf.sip.SipPackage#getPerson_Linkages()
	 * @model
	 * @generated
	 */
	Linkage getLinkages();

	/**
	 * Sets the value of the '{@link es.uji.control.sip.model.emf.sip.Person#getLinkages <em>Linkages</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Linkages</em>' reference.
	 * @see #getLinkages()
	 * @generated
	 */
	void setLinkages(Linkage value);

} // Person

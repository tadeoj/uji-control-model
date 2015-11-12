/**
 */
package es.uji.control.sip.model.emf.sip;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see es.uji.control.sip.model.emf.sip.SipFactory
 * @model kind="package"
 * @generated
 */
public interface SipPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "sip";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sip/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "sip";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SipPackage eINSTANCE = es.uji.control.sip.model.emf.sip.impl.SipPackageImpl.init();

	/**
	 * The meta object id for the '{@link es.uji.control.sip.model.emf.sip.impl.ModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see es.uji.control.sip.model.emf.sip.impl.ModelImpl
	 * @see es.uji.control.sip.model.emf.sip.impl.SipPackageImpl#getModel()
	 * @generated
	 */
	int MODEL = 0;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__DATE = 0;

	/**
	 * The feature id for the '<em><b>Model Persons List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__MODEL_PERSONS_LIST = 1;

	/**
	 * The feature id for the '<em><b>Model Cards List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__MODEL_CARDS_LIST = 2;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link es.uji.control.sip.model.emf.sip.impl.PersonImpl <em>Person</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see es.uji.control.sip.model.emf.sip.impl.PersonImpl
	 * @see es.uji.control.sip.model.emf.sip.impl.SipPackageImpl#getPerson()
	 * @generated
	 */
	int PERSON = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__ID = 0;

	/**
	 * The feature id for the '<em><b>Identification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__IDENTIFICATION = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__NAME = 2;

	/**
	 * The feature id for the '<em><b>First Last Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__FIRST_LAST_NAME = 3;

	/**
	 * The feature id for the '<em><b>Second Last Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__SECOND_LAST_NAME = 4;

	/**
	 * The feature id for the '<em><b>Accreditations List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__ACCREDITATIONS_LIST = 5;

	/**
	 * The feature id for the '<em><b>Linkage List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__LINKAGE_LIST = 6;

	/**
	 * The number of structural features of the '<em>Person</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link es.uji.control.sip.model.emf.sip.impl.AccreditationImpl <em>Accreditation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see es.uji.control.sip.model.emf.sip.impl.AccreditationImpl
	 * @see es.uji.control.sip.model.emf.sip.impl.SipPackageImpl#getAccreditation()
	 * @generated
	 */
	int ACCREDITATION = 2;

	/**
	 * The feature id for the '<em><b>Issue Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCREDITATION__ISSUE_DATE = 0;

	/**
	 * The feature id for the '<em><b>Cancelation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCREDITATION__CANCELATION_DATE = 1;

	/**
	 * The feature id for the '<em><b>Raw</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCREDITATION__RAW = 2;

	/**
	 * The feature id for the '<em><b>Person</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCREDITATION__PERSON = 3;

	/**
	 * The number of structural features of the '<em>Accreditation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCREDITATION_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link es.uji.control.sip.model.emf.sip.impl.LinkageImpl <em>Linkage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see es.uji.control.sip.model.emf.sip.impl.LinkageImpl
	 * @see es.uji.control.sip.model.emf.sip.impl.SipPackageImpl#getLinkage()
	 * @generated
	 */
	int LINKAGE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINKAGE__NAME = 0;

	/**
	 * The number of structural features of the '<em>Linkage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINKAGE_FEATURE_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link es.uji.control.sip.model.emf.sip.Model <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see es.uji.control.sip.model.emf.sip.Model
	 * @generated
	 */
	EClass getModel();

	/**
	 * Returns the meta object for the attribute '{@link es.uji.control.sip.model.emf.sip.Model#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see es.uji.control.sip.model.emf.sip.Model#getDate()
	 * @see #getModel()
	 * @generated
	 */
	EAttribute getModel_Date();

	/**
	 * Returns the meta object for the containment reference list '{@link es.uji.control.sip.model.emf.sip.Model#getModelPersonsList <em>Model Persons List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Model Persons List</em>'.
	 * @see es.uji.control.sip.model.emf.sip.Model#getModelPersonsList()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_ModelPersonsList();

	/**
	 * Returns the meta object for the containment reference list '{@link es.uji.control.sip.model.emf.sip.Model#getModelCardsList <em>Model Cards List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Model Cards List</em>'.
	 * @see es.uji.control.sip.model.emf.sip.Model#getModelCardsList()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_ModelCardsList();

	/**
	 * Returns the meta object for class '{@link es.uji.control.sip.model.emf.sip.Person <em>Person</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Person</em>'.
	 * @see es.uji.control.sip.model.emf.sip.Person
	 * @generated
	 */
	EClass getPerson();

	/**
	 * Returns the meta object for the attribute '{@link es.uji.control.sip.model.emf.sip.Person#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see es.uji.control.sip.model.emf.sip.Person#getId()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_Id();

	/**
	 * Returns the meta object for the attribute '{@link es.uji.control.sip.model.emf.sip.Person#getIdentification <em>Identification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Identification</em>'.
	 * @see es.uji.control.sip.model.emf.sip.Person#getIdentification()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_Identification();

	/**
	 * Returns the meta object for the attribute '{@link es.uji.control.sip.model.emf.sip.Person#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see es.uji.control.sip.model.emf.sip.Person#getName()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_Name();

	/**
	 * Returns the meta object for the attribute '{@link es.uji.control.sip.model.emf.sip.Person#getFirstLastName <em>First Last Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>First Last Name</em>'.
	 * @see es.uji.control.sip.model.emf.sip.Person#getFirstLastName()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_FirstLastName();

	/**
	 * Returns the meta object for the attribute '{@link es.uji.control.sip.model.emf.sip.Person#getSecondLastName <em>Second Last Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Second Last Name</em>'.
	 * @see es.uji.control.sip.model.emf.sip.Person#getSecondLastName()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_SecondLastName();

	/**
	 * Returns the meta object for the containment reference list '{@link es.uji.control.sip.model.emf.sip.Person#getAccreditationsList <em>Accreditations List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Accreditations List</em>'.
	 * @see es.uji.control.sip.model.emf.sip.Person#getAccreditationsList()
	 * @see #getPerson()
	 * @generated
	 */
	EReference getPerson_AccreditationsList();

	/**
	 * Returns the meta object for the containment reference list '{@link es.uji.control.sip.model.emf.sip.Person#getLinkageList <em>Linkage List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Linkage List</em>'.
	 * @see es.uji.control.sip.model.emf.sip.Person#getLinkageList()
	 * @see #getPerson()
	 * @generated
	 */
	EReference getPerson_LinkageList();

	/**
	 * Returns the meta object for class '{@link es.uji.control.sip.model.emf.sip.Accreditation <em>Accreditation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Accreditation</em>'.
	 * @see es.uji.control.sip.model.emf.sip.Accreditation
	 * @generated
	 */
	EClass getAccreditation();

	/**
	 * Returns the meta object for the attribute '{@link es.uji.control.sip.model.emf.sip.Accreditation#getIssueDate <em>Issue Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Issue Date</em>'.
	 * @see es.uji.control.sip.model.emf.sip.Accreditation#getIssueDate()
	 * @see #getAccreditation()
	 * @generated
	 */
	EAttribute getAccreditation_IssueDate();

	/**
	 * Returns the meta object for the attribute '{@link es.uji.control.sip.model.emf.sip.Accreditation#getCancelationDate <em>Cancelation Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cancelation Date</em>'.
	 * @see es.uji.control.sip.model.emf.sip.Accreditation#getCancelationDate()
	 * @see #getAccreditation()
	 * @generated
	 */
	EAttribute getAccreditation_CancelationDate();

	/**
	 * Returns the meta object for the attribute '{@link es.uji.control.sip.model.emf.sip.Accreditation#getRaw <em>Raw</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Raw</em>'.
	 * @see es.uji.control.sip.model.emf.sip.Accreditation#getRaw()
	 * @see #getAccreditation()
	 * @generated
	 */
	EAttribute getAccreditation_Raw();

	/**
	 * Returns the meta object for the container reference '{@link es.uji.control.sip.model.emf.sip.Accreditation#getPerson <em>Person</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Person</em>'.
	 * @see es.uji.control.sip.model.emf.sip.Accreditation#getPerson()
	 * @see #getAccreditation()
	 * @generated
	 */
	EReference getAccreditation_Person();

	/**
	 * Returns the meta object for class '{@link es.uji.control.sip.model.emf.sip.Linkage <em>Linkage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Linkage</em>'.
	 * @see es.uji.control.sip.model.emf.sip.Linkage
	 * @generated
	 */
	EClass getLinkage();

	/**
	 * Returns the meta object for the attribute '{@link es.uji.control.sip.model.emf.sip.Linkage#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see es.uji.control.sip.model.emf.sip.Linkage#getName()
	 * @see #getLinkage()
	 * @generated
	 */
	EAttribute getLinkage_Name();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SipFactory getSipFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link es.uji.control.sip.model.emf.sip.impl.ModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see es.uji.control.sip.model.emf.sip.impl.ModelImpl
		 * @see es.uji.control.sip.model.emf.sip.impl.SipPackageImpl#getModel()
		 * @generated
		 */
		EClass MODEL = eINSTANCE.getModel();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL__DATE = eINSTANCE.getModel_Date();

		/**
		 * The meta object literal for the '<em><b>Model Persons List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__MODEL_PERSONS_LIST = eINSTANCE.getModel_ModelPersonsList();

		/**
		 * The meta object literal for the '<em><b>Model Cards List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__MODEL_CARDS_LIST = eINSTANCE.getModel_ModelCardsList();

		/**
		 * The meta object literal for the '{@link es.uji.control.sip.model.emf.sip.impl.PersonImpl <em>Person</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see es.uji.control.sip.model.emf.sip.impl.PersonImpl
		 * @see es.uji.control.sip.model.emf.sip.impl.SipPackageImpl#getPerson()
		 * @generated
		 */
		EClass PERSON = eINSTANCE.getPerson();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__ID = eINSTANCE.getPerson_Id();

		/**
		 * The meta object literal for the '<em><b>Identification</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__IDENTIFICATION = eINSTANCE.getPerson_Identification();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__NAME = eINSTANCE.getPerson_Name();

		/**
		 * The meta object literal for the '<em><b>First Last Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__FIRST_LAST_NAME = eINSTANCE.getPerson_FirstLastName();

		/**
		 * The meta object literal for the '<em><b>Second Last Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__SECOND_LAST_NAME = eINSTANCE.getPerson_SecondLastName();

		/**
		 * The meta object literal for the '<em><b>Accreditations List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERSON__ACCREDITATIONS_LIST = eINSTANCE.getPerson_AccreditationsList();

		/**
		 * The meta object literal for the '<em><b>Linkage List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERSON__LINKAGE_LIST = eINSTANCE.getPerson_LinkageList();

		/**
		 * The meta object literal for the '{@link es.uji.control.sip.model.emf.sip.impl.AccreditationImpl <em>Accreditation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see es.uji.control.sip.model.emf.sip.impl.AccreditationImpl
		 * @see es.uji.control.sip.model.emf.sip.impl.SipPackageImpl#getAccreditation()
		 * @generated
		 */
		EClass ACCREDITATION = eINSTANCE.getAccreditation();

		/**
		 * The meta object literal for the '<em><b>Issue Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACCREDITATION__ISSUE_DATE = eINSTANCE.getAccreditation_IssueDate();

		/**
		 * The meta object literal for the '<em><b>Cancelation Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACCREDITATION__CANCELATION_DATE = eINSTANCE.getAccreditation_CancelationDate();

		/**
		 * The meta object literal for the '<em><b>Raw</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACCREDITATION__RAW = eINSTANCE.getAccreditation_Raw();

		/**
		 * The meta object literal for the '<em><b>Person</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACCREDITATION__PERSON = eINSTANCE.getAccreditation_Person();

		/**
		 * The meta object literal for the '{@link es.uji.control.sip.model.emf.sip.impl.LinkageImpl <em>Linkage</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see es.uji.control.sip.model.emf.sip.impl.LinkageImpl
		 * @see es.uji.control.sip.model.emf.sip.impl.SipPackageImpl#getLinkage()
		 * @generated
		 */
		EClass LINKAGE = eINSTANCE.getLinkage();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINKAGE__NAME = eINSTANCE.getLinkage_Name();

	}

} //SipPackage

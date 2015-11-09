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
 * @see es.uji.control.model.emf.sip.SipFactory
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
	SipPackage eINSTANCE = es.uji.control.model.emf.sip.impl.SipPackageImpl.init();

	/**
	 * The meta object id for the '{@link es.uji.control.model.emf.sip.impl.ModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see es.uji.control.model.emf.sip.impl.ModelImpl
	 * @see es.uji.control.model.emf.sip.impl.SipPackageImpl#getModel()
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
	 * The feature id for the '<em><b>Zone Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__ZONE_ID = 3;

	/**
	 * The feature id for the '<em><b>Zone Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__ZONE_NAME = 4;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link es.uji.control.model.emf.sip.impl.PersonsImpl <em>Persons</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see es.uji.control.model.emf.sip.impl.PersonsImpl
	 * @see es.uji.control.model.emf.sip.impl.SipPackageImpl#getPersons()
	 * @generated
	 */
	int PERSONS = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSONS__ID = 0;

	/**
	 * The feature id for the '<em><b>Identification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSONS__IDENTIFICATION = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSONS__NAME = 2;

	/**
	 * The feature id for the '<em><b>First Name1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSONS__FIRST_NAME1 = 3;

	/**
	 * The feature id for the '<em><b>First Name2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSONS__FIRST_NAME2 = 4;

	/**
	 * The feature id for the '<em><b>Link</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSONS__LINK = 5;

	/**
	 * The feature id for the '<em><b>Cards List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSONS__CARDS_LIST = 6;

	/**
	 * The number of structural features of the '<em>Persons</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSONS_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link es.uji.control.model.emf.sip.impl.CardsImpl <em>Cards</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see es.uji.control.model.emf.sip.impl.CardsImpl
	 * @see es.uji.control.model.emf.sip.impl.SipPackageImpl#getCards()
	 * @generated
	 */
	int CARDS = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDS__ID = 0;

	/**
	 * The feature id for the '<em><b>Per Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDS__PER_ID = 1;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDS__CREATION_DATE = 2;

	/**
	 * The feature id for the '<em><b>Issue Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDS__ISSUE_DATE = 3;

	/**
	 * The feature id for the '<em><b>Cancelation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDS__CANCELATION_DATE = 4;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDS__DESCRIPTION = 5;

	/**
	 * The feature id for the '<em><b>Serial Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDS__SERIAL_NUMBER = 6;

	/**
	 * The number of structural features of the '<em>Cards</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDS_FEATURE_COUNT = 7;


	/**
	 * Returns the meta object for class '{@link es.uji.control.model.emf.sip.Model <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see es.uji.control.model.emf.sip.Model
	 * @generated
	 */
	EClass getModel();

	/**
	 * Returns the meta object for the attribute '{@link es.uji.control.model.emf.sip.Model#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see es.uji.control.model.emf.sip.Model#getDate()
	 * @see #getModel()
	 * @generated
	 */
	EAttribute getModel_Date();

	/**
	 * Returns the meta object for the containment reference list '{@link es.uji.control.model.emf.sip.Model#getModelPersonsList <em>Model Persons List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Model Persons List</em>'.
	 * @see es.uji.control.model.emf.sip.Model#getModelPersonsList()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_ModelPersonsList();

	/**
	 * Returns the meta object for the containment reference list '{@link es.uji.control.model.emf.sip.Model#getModelCardsList <em>Model Cards List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Model Cards List</em>'.
	 * @see es.uji.control.model.emf.sip.Model#getModelCardsList()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_ModelCardsList();

	/**
	 * Returns the meta object for the attribute '{@link es.uji.control.model.emf.sip.Model#getZoneId <em>Zone Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Zone Id</em>'.
	 * @see es.uji.control.model.emf.sip.Model#getZoneId()
	 * @see #getModel()
	 * @generated
	 */
	EAttribute getModel_ZoneId();

	/**
	 * Returns the meta object for the attribute '{@link es.uji.control.model.emf.sip.Model#getZoneName <em>Zone Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Zone Name</em>'.
	 * @see es.uji.control.model.emf.sip.Model#getZoneName()
	 * @see #getModel()
	 * @generated
	 */
	EAttribute getModel_ZoneName();

	/**
	 * Returns the meta object for class '{@link es.uji.control.model.emf.sip.Persons <em>Persons</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Persons</em>'.
	 * @see es.uji.control.model.emf.sip.Persons
	 * @generated
	 */
	EClass getPersons();

	/**
	 * Returns the meta object for the attribute '{@link es.uji.control.model.emf.sip.Persons#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see es.uji.control.model.emf.sip.Persons#getId()
	 * @see #getPersons()
	 * @generated
	 */
	EAttribute getPersons_Id();

	/**
	 * Returns the meta object for the attribute '{@link es.uji.control.model.emf.sip.Persons#getIdentification <em>Identification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Identification</em>'.
	 * @see es.uji.control.model.emf.sip.Persons#getIdentification()
	 * @see #getPersons()
	 * @generated
	 */
	EAttribute getPersons_Identification();

	/**
	 * Returns the meta object for the attribute '{@link es.uji.control.model.emf.sip.Persons#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see es.uji.control.model.emf.sip.Persons#getName()
	 * @see #getPersons()
	 * @generated
	 */
	EAttribute getPersons_Name();

	/**
	 * Returns the meta object for the attribute '{@link es.uji.control.model.emf.sip.Persons#getFirstName1 <em>First Name1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>First Name1</em>'.
	 * @see es.uji.control.model.emf.sip.Persons#getFirstName1()
	 * @see #getPersons()
	 * @generated
	 */
	EAttribute getPersons_FirstName1();

	/**
	 * Returns the meta object for the attribute '{@link es.uji.control.model.emf.sip.Persons#getFirstName2 <em>First Name2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>First Name2</em>'.
	 * @see es.uji.control.model.emf.sip.Persons#getFirstName2()
	 * @see #getPersons()
	 * @generated
	 */
	EAttribute getPersons_FirstName2();

	/**
	 * Returns the meta object for the attribute '{@link es.uji.control.model.emf.sip.Persons#getLink <em>Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Link</em>'.
	 * @see es.uji.control.model.emf.sip.Persons#getLink()
	 * @see #getPersons()
	 * @generated
	 */
	EAttribute getPersons_Link();

	/**
	 * Returns the meta object for the containment reference list '{@link es.uji.control.model.emf.sip.Persons#getCardsList <em>Cards List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Cards List</em>'.
	 * @see es.uji.control.model.emf.sip.Persons#getCardsList()
	 * @see #getPersons()
	 * @generated
	 */
	EReference getPersons_CardsList();

	/**
	 * Returns the meta object for class '{@link es.uji.control.model.emf.sip.Cards <em>Cards</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cards</em>'.
	 * @see es.uji.control.model.emf.sip.Cards
	 * @generated
	 */
	EClass getCards();

	/**
	 * Returns the meta object for the attribute '{@link es.uji.control.model.emf.sip.Cards#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see es.uji.control.model.emf.sip.Cards#getId()
	 * @see #getCards()
	 * @generated
	 */
	EAttribute getCards_Id();

	/**
	 * Returns the meta object for the attribute '{@link es.uji.control.model.emf.sip.Cards#getPerId <em>Per Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Per Id</em>'.
	 * @see es.uji.control.model.emf.sip.Cards#getPerId()
	 * @see #getCards()
	 * @generated
	 */
	EAttribute getCards_PerId();

	/**
	 * Returns the meta object for the attribute '{@link es.uji.control.model.emf.sip.Cards#getCreationDate <em>Creation Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Creation Date</em>'.
	 * @see es.uji.control.model.emf.sip.Cards#getCreationDate()
	 * @see #getCards()
	 * @generated
	 */
	EAttribute getCards_CreationDate();

	/**
	 * Returns the meta object for the attribute '{@link es.uji.control.model.emf.sip.Cards#getIssueDate <em>Issue Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Issue Date</em>'.
	 * @see es.uji.control.model.emf.sip.Cards#getIssueDate()
	 * @see #getCards()
	 * @generated
	 */
	EAttribute getCards_IssueDate();

	/**
	 * Returns the meta object for the attribute '{@link es.uji.control.model.emf.sip.Cards#getCancelationDate <em>Cancelation Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cancelation Date</em>'.
	 * @see es.uji.control.model.emf.sip.Cards#getCancelationDate()
	 * @see #getCards()
	 * @generated
	 */
	EAttribute getCards_CancelationDate();

	/**
	 * Returns the meta object for the attribute '{@link es.uji.control.model.emf.sip.Cards#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see es.uji.control.model.emf.sip.Cards#getDescription()
	 * @see #getCards()
	 * @generated
	 */
	EAttribute getCards_Description();

	/**
	 * Returns the meta object for the attribute '{@link es.uji.control.model.emf.sip.Cards#getSerialNumber <em>Serial Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Serial Number</em>'.
	 * @see es.uji.control.model.emf.sip.Cards#getSerialNumber()
	 * @see #getCards()
	 * @generated
	 */
	EAttribute getCards_SerialNumber();

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
		 * The meta object literal for the '{@link es.uji.control.model.emf.sip.impl.ModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see es.uji.control.model.emf.sip.impl.ModelImpl
		 * @see es.uji.control.model.emf.sip.impl.SipPackageImpl#getModel()
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
		 * The meta object literal for the '<em><b>Zone Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL__ZONE_ID = eINSTANCE.getModel_ZoneId();

		/**
		 * The meta object literal for the '<em><b>Zone Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL__ZONE_NAME = eINSTANCE.getModel_ZoneName();

		/**
		 * The meta object literal for the '{@link es.uji.control.model.emf.sip.impl.PersonsImpl <em>Persons</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see es.uji.control.model.emf.sip.impl.PersonsImpl
		 * @see es.uji.control.model.emf.sip.impl.SipPackageImpl#getPersons()
		 * @generated
		 */
		EClass PERSONS = eINSTANCE.getPersons();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSONS__ID = eINSTANCE.getPersons_Id();

		/**
		 * The meta object literal for the '<em><b>Identification</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSONS__IDENTIFICATION = eINSTANCE.getPersons_Identification();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSONS__NAME = eINSTANCE.getPersons_Name();

		/**
		 * The meta object literal for the '<em><b>First Name1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSONS__FIRST_NAME1 = eINSTANCE.getPersons_FirstName1();

		/**
		 * The meta object literal for the '<em><b>First Name2</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSONS__FIRST_NAME2 = eINSTANCE.getPersons_FirstName2();

		/**
		 * The meta object literal for the '<em><b>Link</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSONS__LINK = eINSTANCE.getPersons_Link();

		/**
		 * The meta object literal for the '<em><b>Cards List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERSONS__CARDS_LIST = eINSTANCE.getPersons_CardsList();

		/**
		 * The meta object literal for the '{@link es.uji.control.model.emf.sip.impl.CardsImpl <em>Cards</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see es.uji.control.model.emf.sip.impl.CardsImpl
		 * @see es.uji.control.model.emf.sip.impl.SipPackageImpl#getCards()
		 * @generated
		 */
		EClass CARDS = eINSTANCE.getCards();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CARDS__ID = eINSTANCE.getCards_Id();

		/**
		 * The meta object literal for the '<em><b>Per Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CARDS__PER_ID = eINSTANCE.getCards_PerId();

		/**
		 * The meta object literal for the '<em><b>Creation Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CARDS__CREATION_DATE = eINSTANCE.getCards_CreationDate();

		/**
		 * The meta object literal for the '<em><b>Issue Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CARDS__ISSUE_DATE = eINSTANCE.getCards_IssueDate();

		/**
		 * The meta object literal for the '<em><b>Cancelation Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CARDS__CANCELATION_DATE = eINSTANCE.getCards_CancelationDate();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CARDS__DESCRIPTION = eINSTANCE.getCards_Description();

		/**
		 * The meta object literal for the '<em><b>Serial Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CARDS__SERIAL_NUMBER = eINSTANCE.getCards_SerialNumber();

	}

} //SipPackage

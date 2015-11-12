/**
 */
package es.uji.control.sip.model.emf.sip.impl;

import es.uji.control.sip.model.emf.sip.Accreditation;
import es.uji.control.sip.model.emf.sip.Linkage;
import es.uji.control.sip.model.emf.sip.Person;
import es.uji.control.sip.model.emf.sip.SipPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Person</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link es.uji.control.sip.model.emf.sip.impl.PersonImpl#getId <em>Id</em>}</li>
 *   <li>{@link es.uji.control.sip.model.emf.sip.impl.PersonImpl#getIdentification <em>Identification</em>}</li>
 *   <li>{@link es.uji.control.sip.model.emf.sip.impl.PersonImpl#getName <em>Name</em>}</li>
 *   <li>{@link es.uji.control.sip.model.emf.sip.impl.PersonImpl#getFirstName1 <em>First Name1</em>}</li>
 *   <li>{@link es.uji.control.sip.model.emf.sip.impl.PersonImpl#getFirstName2 <em>First Name2</em>}</li>
 *   <li>{@link es.uji.control.sip.model.emf.sip.impl.PersonImpl#getAccreditationsList <em>Accreditations List</em>}</li>
 *   <li>{@link es.uji.control.sip.model.emf.sip.impl.PersonImpl#getLinkages <em>Linkages</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PersonImpl extends EObjectImpl implements Person {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final Long ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected Long id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getIdentification() <em>Identification</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentification()
	 * @generated
	 * @ordered
	 */
	protected static final String IDENTIFICATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIdentification() <em>Identification</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentification()
	 * @generated
	 * @ordered
	 */
	protected String identification = IDENTIFICATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getFirstName1() <em>First Name1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstName1()
	 * @generated
	 * @ordered
	 */
	protected static final String FIRST_NAME1_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFirstName1() <em>First Name1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstName1()
	 * @generated
	 * @ordered
	 */
	protected String firstName1 = FIRST_NAME1_EDEFAULT;

	/**
	 * The default value of the '{@link #getFirstName2() <em>First Name2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstName2()
	 * @generated
	 * @ordered
	 */
	protected static final String FIRST_NAME2_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFirstName2() <em>First Name2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstName2()
	 * @generated
	 * @ordered
	 */
	protected String firstName2 = FIRST_NAME2_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAccreditationsList() <em>Accreditations List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccreditationsList()
	 * @generated
	 * @ordered
	 */
	protected EList<Accreditation> accreditationsList;

	/**
	 * The cached value of the '{@link #getLinkages() <em>Linkages</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkages()
	 * @generated
	 * @ordered
	 */
	protected Linkage linkages;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PersonImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SipPackage.Literals.PERSON;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Long getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(Long newId) {
		Long oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SipPackage.PERSON__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIdentification() {
		return identification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdentification(String newIdentification) {
		String oldIdentification = identification;
		identification = newIdentification;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SipPackage.PERSON__IDENTIFICATION, oldIdentification, identification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SipPackage.PERSON__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFirstName1() {
		return firstName1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFirstName1(String newFirstName1) {
		String oldFirstName1 = firstName1;
		firstName1 = newFirstName1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SipPackage.PERSON__FIRST_NAME1, oldFirstName1, firstName1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFirstName2() {
		return firstName2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFirstName2(String newFirstName2) {
		String oldFirstName2 = firstName2;
		firstName2 = newFirstName2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SipPackage.PERSON__FIRST_NAME2, oldFirstName2, firstName2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Accreditation> getAccreditationsList() {
		if (accreditationsList == null) {
			accreditationsList = new EObjectContainmentWithInverseEList<Accreditation>(Accreditation.class, this, SipPackage.PERSON__ACCREDITATIONS_LIST, SipPackage.ACCREDITATION__PERSON);
		}
		return accreditationsList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Linkage getLinkages() {
		if (linkages != null && linkages.eIsProxy()) {
			InternalEObject oldLinkages = (InternalEObject)linkages;
			linkages = (Linkage)eResolveProxy(oldLinkages);
			if (linkages != oldLinkages) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SipPackage.PERSON__LINKAGES, oldLinkages, linkages));
			}
		}
		return linkages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Linkage basicGetLinkages() {
		return linkages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinkages(Linkage newLinkages) {
		Linkage oldLinkages = linkages;
		linkages = newLinkages;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SipPackage.PERSON__LINKAGES, oldLinkages, linkages));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SipPackage.PERSON__ACCREDITATIONS_LIST:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAccreditationsList()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SipPackage.PERSON__ACCREDITATIONS_LIST:
				return ((InternalEList<?>)getAccreditationsList()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SipPackage.PERSON__ID:
				return getId();
			case SipPackage.PERSON__IDENTIFICATION:
				return getIdentification();
			case SipPackage.PERSON__NAME:
				return getName();
			case SipPackage.PERSON__FIRST_NAME1:
				return getFirstName1();
			case SipPackage.PERSON__FIRST_NAME2:
				return getFirstName2();
			case SipPackage.PERSON__ACCREDITATIONS_LIST:
				return getAccreditationsList();
			case SipPackage.PERSON__LINKAGES:
				if (resolve) return getLinkages();
				return basicGetLinkages();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SipPackage.PERSON__ID:
				setId((Long)newValue);
				return;
			case SipPackage.PERSON__IDENTIFICATION:
				setIdentification((String)newValue);
				return;
			case SipPackage.PERSON__NAME:
				setName((String)newValue);
				return;
			case SipPackage.PERSON__FIRST_NAME1:
				setFirstName1((String)newValue);
				return;
			case SipPackage.PERSON__FIRST_NAME2:
				setFirstName2((String)newValue);
				return;
			case SipPackage.PERSON__ACCREDITATIONS_LIST:
				getAccreditationsList().clear();
				getAccreditationsList().addAll((Collection<? extends Accreditation>)newValue);
				return;
			case SipPackage.PERSON__LINKAGES:
				setLinkages((Linkage)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SipPackage.PERSON__ID:
				setId(ID_EDEFAULT);
				return;
			case SipPackage.PERSON__IDENTIFICATION:
				setIdentification(IDENTIFICATION_EDEFAULT);
				return;
			case SipPackage.PERSON__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SipPackage.PERSON__FIRST_NAME1:
				setFirstName1(FIRST_NAME1_EDEFAULT);
				return;
			case SipPackage.PERSON__FIRST_NAME2:
				setFirstName2(FIRST_NAME2_EDEFAULT);
				return;
			case SipPackage.PERSON__ACCREDITATIONS_LIST:
				getAccreditationsList().clear();
				return;
			case SipPackage.PERSON__LINKAGES:
				setLinkages((Linkage)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SipPackage.PERSON__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case SipPackage.PERSON__IDENTIFICATION:
				return IDENTIFICATION_EDEFAULT == null ? identification != null : !IDENTIFICATION_EDEFAULT.equals(identification);
			case SipPackage.PERSON__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case SipPackage.PERSON__FIRST_NAME1:
				return FIRST_NAME1_EDEFAULT == null ? firstName1 != null : !FIRST_NAME1_EDEFAULT.equals(firstName1);
			case SipPackage.PERSON__FIRST_NAME2:
				return FIRST_NAME2_EDEFAULT == null ? firstName2 != null : !FIRST_NAME2_EDEFAULT.equals(firstName2);
			case SipPackage.PERSON__ACCREDITATIONS_LIST:
				return accreditationsList != null && !accreditationsList.isEmpty();
			case SipPackage.PERSON__LINKAGES:
				return linkages != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (id: ");
		result.append(id);
		result.append(", identification: ");
		result.append(identification);
		result.append(", name: ");
		result.append(name);
		result.append(", firstName1: ");
		result.append(firstName1);
		result.append(", firstName2: ");
		result.append(firstName2);
		result.append(')');
		return result.toString();
	}

} //PersonImpl

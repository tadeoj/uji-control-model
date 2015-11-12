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

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
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
 *   <li>{@link es.uji.control.sip.model.emf.sip.impl.PersonImpl#getFirstLastName <em>First Last Name</em>}</li>
 *   <li>{@link es.uji.control.sip.model.emf.sip.impl.PersonImpl#getSecondLastName <em>Second Last Name</em>}</li>
 *   <li>{@link es.uji.control.sip.model.emf.sip.impl.PersonImpl#getAccreditationsList <em>Accreditations List</em>}</li>
 *   <li>{@link es.uji.control.sip.model.emf.sip.impl.PersonImpl#getLinkageList <em>Linkage List</em>}</li>
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
	 * The default value of the '{@link #getFirstLastName() <em>First Last Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstLastName()
	 * @generated
	 * @ordered
	 */
	protected static final String FIRST_LAST_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFirstLastName() <em>First Last Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstLastName()
	 * @generated
	 * @ordered
	 */
	protected String firstLastName = FIRST_LAST_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getSecondLastName() <em>Second Last Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecondLastName()
	 * @generated
	 * @ordered
	 */
	protected static final String SECOND_LAST_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSecondLastName() <em>Second Last Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecondLastName()
	 * @generated
	 * @ordered
	 */
	protected String secondLastName = SECOND_LAST_NAME_EDEFAULT;

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
	 * The cached value of the '{@link #getLinkageList() <em>Linkage List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkageList()
	 * @generated
	 * @ordered
	 */
	protected EList<Linkage> linkageList;

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
	public String getFirstLastName() {
		return firstLastName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFirstLastName(String newFirstLastName) {
		String oldFirstLastName = firstLastName;
		firstLastName = newFirstLastName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SipPackage.PERSON__FIRST_LAST_NAME, oldFirstLastName, firstLastName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSecondLastName() {
		return secondLastName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSecondLastName(String newSecondLastName) {
		String oldSecondLastName = secondLastName;
		secondLastName = newSecondLastName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SipPackage.PERSON__SECOND_LAST_NAME, oldSecondLastName, secondLastName));
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
	public EList<Linkage> getLinkageList() {
		if (linkageList == null) {
			linkageList = new EObjectContainmentEList<Linkage>(Linkage.class, this, SipPackage.PERSON__LINKAGE_LIST);
		}
		return linkageList;
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
			case SipPackage.PERSON__LINKAGE_LIST:
				return ((InternalEList<?>)getLinkageList()).basicRemove(otherEnd, msgs);
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
			case SipPackage.PERSON__FIRST_LAST_NAME:
				return getFirstLastName();
			case SipPackage.PERSON__SECOND_LAST_NAME:
				return getSecondLastName();
			case SipPackage.PERSON__ACCREDITATIONS_LIST:
				return getAccreditationsList();
			case SipPackage.PERSON__LINKAGE_LIST:
				return getLinkageList();
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
			case SipPackage.PERSON__FIRST_LAST_NAME:
				setFirstLastName((String)newValue);
				return;
			case SipPackage.PERSON__SECOND_LAST_NAME:
				setSecondLastName((String)newValue);
				return;
			case SipPackage.PERSON__ACCREDITATIONS_LIST:
				getAccreditationsList().clear();
				getAccreditationsList().addAll((Collection<? extends Accreditation>)newValue);
				return;
			case SipPackage.PERSON__LINKAGE_LIST:
				getLinkageList().clear();
				getLinkageList().addAll((Collection<? extends Linkage>)newValue);
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
			case SipPackage.PERSON__FIRST_LAST_NAME:
				setFirstLastName(FIRST_LAST_NAME_EDEFAULT);
				return;
			case SipPackage.PERSON__SECOND_LAST_NAME:
				setSecondLastName(SECOND_LAST_NAME_EDEFAULT);
				return;
			case SipPackage.PERSON__ACCREDITATIONS_LIST:
				getAccreditationsList().clear();
				return;
			case SipPackage.PERSON__LINKAGE_LIST:
				getLinkageList().clear();
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
			case SipPackage.PERSON__FIRST_LAST_NAME:
				return FIRST_LAST_NAME_EDEFAULT == null ? firstLastName != null : !FIRST_LAST_NAME_EDEFAULT.equals(firstLastName);
			case SipPackage.PERSON__SECOND_LAST_NAME:
				return SECOND_LAST_NAME_EDEFAULT == null ? secondLastName != null : !SECOND_LAST_NAME_EDEFAULT.equals(secondLastName);
			case SipPackage.PERSON__ACCREDITATIONS_LIST:
				return accreditationsList != null && !accreditationsList.isEmpty();
			case SipPackage.PERSON__LINKAGE_LIST:
				return linkageList != null && !linkageList.isEmpty();
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
		result.append(", firstLastName: ");
		result.append(firstLastName);
		result.append(", secondLastName: ");
		result.append(secondLastName);
		result.append(')');
		return result.toString();
	}

} //PersonImpl

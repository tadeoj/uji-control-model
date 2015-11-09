/*******************************************************************************
 * Copyright © Universitat Jaume I de Castelló 2015.
 * Aquest programari es distribueix sota les condicions de llicència EUPL 
 * o de qualsevol altra que la substituisca en el futur.
 * La llicència completa es pot descarregar de 
 * https://joinup.ec.europa.eu/community/eupl/og_page/european-union-public-licence-eupl-v11
 *******************************************************************************/
/**
 */
package es.uji.control.model.emf.sip.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import es.uji.control.model.emf.sip.Cards;
import es.uji.control.model.emf.sip.Persons;
import es.uji.control.model.emf.sip.SipPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Persons</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link es.uji.control.model.emf.sip.impl.PersonsImpl#getId <em>Id</em>}</li>
 *   <li>{@link es.uji.control.model.emf.sip.impl.PersonsImpl#getIdentification <em>Identification</em>}</li>
 *   <li>{@link es.uji.control.model.emf.sip.impl.PersonsImpl#getName <em>Name</em>}</li>
 *   <li>{@link es.uji.control.model.emf.sip.impl.PersonsImpl#getFirstName1 <em>First Name1</em>}</li>
 *   <li>{@link es.uji.control.model.emf.sip.impl.PersonsImpl#getFirstName2 <em>First Name2</em>}</li>
 *   <li>{@link es.uji.control.model.emf.sip.impl.PersonsImpl#getLink <em>Link</em>}</li>
 *   <li>{@link es.uji.control.model.emf.sip.impl.PersonsImpl#getCardsList <em>Cards List</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PersonsImpl extends EObjectImpl implements Persons {
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
	 * The cached value of the '{@link #getLink() <em>Link</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink()
	 * @generated
	 * @ordered
	 */
	protected EList<?> link;

	/**
	 * The cached value of the '{@link #getCardsList() <em>Cards List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCardsList()
	 * @generated
	 * @ordered
	 */
	protected EList<Cards> cardsList;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PersonsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SipPackage.Literals.PERSONS;
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
			eNotify(new ENotificationImpl(this, Notification.SET, SipPackage.PERSONS__ID, oldId, id));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SipPackage.PERSONS__IDENTIFICATION, oldIdentification, identification));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SipPackage.PERSONS__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SipPackage.PERSONS__FIRST_NAME1, oldFirstName1, firstName1));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SipPackage.PERSONS__FIRST_NAME2, oldFirstName2, firstName2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<?> getLink() {
		return link;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink(EList<?> newLink) {
		EList<?> oldLink = link;
		link = newLink;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SipPackage.PERSONS__LINK, oldLink, link));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Cards> getCardsList() {
		if (cardsList == null) {
			cardsList = new EObjectContainmentEList<Cards>(Cards.class, this, SipPackage.PERSONS__CARDS_LIST);
		}
		return cardsList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SipPackage.PERSONS__CARDS_LIST:
				return ((InternalEList<?>)getCardsList()).basicRemove(otherEnd, msgs);
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
			case SipPackage.PERSONS__ID:
				return getId();
			case SipPackage.PERSONS__IDENTIFICATION:
				return getIdentification();
			case SipPackage.PERSONS__NAME:
				return getName();
			case SipPackage.PERSONS__FIRST_NAME1:
				return getFirstName1();
			case SipPackage.PERSONS__FIRST_NAME2:
				return getFirstName2();
			case SipPackage.PERSONS__LINK:
				return getLink();
			case SipPackage.PERSONS__CARDS_LIST:
				return getCardsList();
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
			case SipPackage.PERSONS__ID:
				setId((Long)newValue);
				return;
			case SipPackage.PERSONS__IDENTIFICATION:
				setIdentification((String)newValue);
				return;
			case SipPackage.PERSONS__NAME:
				setName((String)newValue);
				return;
			case SipPackage.PERSONS__FIRST_NAME1:
				setFirstName1((String)newValue);
				return;
			case SipPackage.PERSONS__FIRST_NAME2:
				setFirstName2((String)newValue);
				return;
			case SipPackage.PERSONS__LINK:
				setLink((EList<?>)newValue);
				return;
			case SipPackage.PERSONS__CARDS_LIST:
				getCardsList().clear();
				getCardsList().addAll((Collection<? extends Cards>)newValue);
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
			case SipPackage.PERSONS__ID:
				setId(ID_EDEFAULT);
				return;
			case SipPackage.PERSONS__IDENTIFICATION:
				setIdentification(IDENTIFICATION_EDEFAULT);
				return;
			case SipPackage.PERSONS__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SipPackage.PERSONS__FIRST_NAME1:
				setFirstName1(FIRST_NAME1_EDEFAULT);
				return;
			case SipPackage.PERSONS__FIRST_NAME2:
				setFirstName2(FIRST_NAME2_EDEFAULT);
				return;
			case SipPackage.PERSONS__LINK:
				setLink((EList<?>)null);
				return;
			case SipPackage.PERSONS__CARDS_LIST:
				getCardsList().clear();
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
			case SipPackage.PERSONS__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case SipPackage.PERSONS__IDENTIFICATION:
				return IDENTIFICATION_EDEFAULT == null ? identification != null : !IDENTIFICATION_EDEFAULT.equals(identification);
			case SipPackage.PERSONS__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case SipPackage.PERSONS__FIRST_NAME1:
				return FIRST_NAME1_EDEFAULT == null ? firstName1 != null : !FIRST_NAME1_EDEFAULT.equals(firstName1);
			case SipPackage.PERSONS__FIRST_NAME2:
				return FIRST_NAME2_EDEFAULT == null ? firstName2 != null : !FIRST_NAME2_EDEFAULT.equals(firstName2);
			case SipPackage.PERSONS__LINK:
				return link != null;
			case SipPackage.PERSONS__CARDS_LIST:
				return cardsList != null && !cardsList.isEmpty();
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
		result.append(", link: ");
		result.append(link);
		result.append(')');
		return result.toString();
	}

} //PersonsImpl

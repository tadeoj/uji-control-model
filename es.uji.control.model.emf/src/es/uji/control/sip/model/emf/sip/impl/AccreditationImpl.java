/**
 */
package es.uji.control.sip.model.emf.sip.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import es.uji.control.sip.model.emf.sip.Accreditation;
import es.uji.control.sip.model.emf.sip.Person;
import es.uji.control.sip.model.emf.sip.SipPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Accreditation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link es.uji.control.sip.model.emf.sip.impl.AccreditationImpl#getRaw <em>Raw</em>}</li>
 *   <li>{@link es.uji.control.sip.model.emf.sip.impl.AccreditationImpl#getType <em>Type</em>}</li>
 *   <li>{@link es.uji.control.sip.model.emf.sip.impl.AccreditationImpl#getPerson <em>Person</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AccreditationImpl extends EObjectImpl implements Accreditation {
	/**
	 * The default value of the '{@link #getRaw() <em>Raw</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRaw()
	 * @generated
	 * @ordered
	 */
	protected static final Long RAW_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRaw() <em>Raw</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRaw()
	 * @generated
	 * @ordered
	 */
	protected Long raw = RAW_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AccreditationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SipPackage.Literals.ACCREDITATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Long getRaw() {
		return raw;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRaw(Long newRaw) {
		Long oldRaw = raw;
		raw = newRaw;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SipPackage.ACCREDITATION__RAW, oldRaw, raw));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SipPackage.ACCREDITATION__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Person getPerson() {
		if (eContainerFeatureID() != SipPackage.ACCREDITATION__PERSON) return null;
		return (Person)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPerson(Person newPerson, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newPerson, SipPackage.ACCREDITATION__PERSON, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPerson(Person newPerson) {
		if (newPerson != eInternalContainer() || (eContainerFeatureID() != SipPackage.ACCREDITATION__PERSON && newPerson != null)) {
			if (EcoreUtil.isAncestor(this, newPerson))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newPerson != null)
				msgs = ((InternalEObject)newPerson).eInverseAdd(this, SipPackage.PERSON__ACCREDITATIONS_LIST, Person.class, msgs);
			msgs = basicSetPerson(newPerson, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SipPackage.ACCREDITATION__PERSON, newPerson, newPerson));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SipPackage.ACCREDITATION__PERSON:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetPerson((Person)otherEnd, msgs);
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
			case SipPackage.ACCREDITATION__PERSON:
				return basicSetPerson(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case SipPackage.ACCREDITATION__PERSON:
				return eInternalContainer().eInverseRemove(this, SipPackage.PERSON__ACCREDITATIONS_LIST, Person.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SipPackage.ACCREDITATION__RAW:
				return getRaw();
			case SipPackage.ACCREDITATION__TYPE:
				return getType();
			case SipPackage.ACCREDITATION__PERSON:
				return getPerson();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SipPackage.ACCREDITATION__RAW:
				setRaw((Long)newValue);
				return;
			case SipPackage.ACCREDITATION__TYPE:
				setType((String)newValue);
				return;
			case SipPackage.ACCREDITATION__PERSON:
				setPerson((Person)newValue);
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
			case SipPackage.ACCREDITATION__RAW:
				setRaw(RAW_EDEFAULT);
				return;
			case SipPackage.ACCREDITATION__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case SipPackage.ACCREDITATION__PERSON:
				setPerson((Person)null);
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
			case SipPackage.ACCREDITATION__RAW:
				return RAW_EDEFAULT == null ? raw != null : !RAW_EDEFAULT.equals(raw);
			case SipPackage.ACCREDITATION__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case SipPackage.ACCREDITATION__PERSON:
				return getPerson() != null;
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
		result.append(" (raw: ");
		result.append(raw);
		result.append(", type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //AccreditationImpl

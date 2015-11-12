/**
 */
package es.uji.control.sip.model.emf.sip.impl;

import es.uji.control.sip.model.emf.sip.Accreditation;
import es.uji.control.sip.model.emf.sip.Person;
import es.uji.control.sip.model.emf.sip.SipPackage;

import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Accreditation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link es.uji.control.sip.model.emf.sip.impl.AccreditationImpl#getIssueDate <em>Issue Date</em>}</li>
 *   <li>{@link es.uji.control.sip.model.emf.sip.impl.AccreditationImpl#getCancelationDate <em>Cancelation Date</em>}</li>
 *   <li>{@link es.uji.control.sip.model.emf.sip.impl.AccreditationImpl#getRaw <em>Raw</em>}</li>
 *   <li>{@link es.uji.control.sip.model.emf.sip.impl.AccreditationImpl#getPerson <em>Person</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AccreditationImpl extends EObjectImpl implements Accreditation {
	/**
	 * The default value of the '{@link #getIssueDate() <em>Issue Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIssueDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date ISSUE_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIssueDate() <em>Issue Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIssueDate()
	 * @generated
	 * @ordered
	 */
	protected Date issueDate = ISSUE_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getCancelationDate() <em>Cancelation Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCancelationDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date CANCELATION_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCancelationDate() <em>Cancelation Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCancelationDate()
	 * @generated
	 * @ordered
	 */
	protected Date cancelationDate = CANCELATION_DATE_EDEFAULT;

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
	public Date getIssueDate() {
		return issueDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIssueDate(Date newIssueDate) {
		Date oldIssueDate = issueDate;
		issueDate = newIssueDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SipPackage.ACCREDITATION__ISSUE_DATE, oldIssueDate, issueDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getCancelationDate() {
		return cancelationDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCancelationDate(Date newCancelationDate) {
		Date oldCancelationDate = cancelationDate;
		cancelationDate = newCancelationDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SipPackage.ACCREDITATION__CANCELATION_DATE, oldCancelationDate, cancelationDate));
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
				msgs = ((InternalEObject)newPerson).eInverseAdd(this, SipPackage.PERSON__CARDS_LIST, Person.class, msgs);
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
				return eInternalContainer().eInverseRemove(this, SipPackage.PERSON__CARDS_LIST, Person.class, msgs);
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
			case SipPackage.ACCREDITATION__ISSUE_DATE:
				return getIssueDate();
			case SipPackage.ACCREDITATION__CANCELATION_DATE:
				return getCancelationDate();
			case SipPackage.ACCREDITATION__RAW:
				return getRaw();
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
			case SipPackage.ACCREDITATION__ISSUE_DATE:
				setIssueDate((Date)newValue);
				return;
			case SipPackage.ACCREDITATION__CANCELATION_DATE:
				setCancelationDate((Date)newValue);
				return;
			case SipPackage.ACCREDITATION__RAW:
				setRaw((Long)newValue);
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
			case SipPackage.ACCREDITATION__ISSUE_DATE:
				setIssueDate(ISSUE_DATE_EDEFAULT);
				return;
			case SipPackage.ACCREDITATION__CANCELATION_DATE:
				setCancelationDate(CANCELATION_DATE_EDEFAULT);
				return;
			case SipPackage.ACCREDITATION__RAW:
				setRaw(RAW_EDEFAULT);
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
			case SipPackage.ACCREDITATION__ISSUE_DATE:
				return ISSUE_DATE_EDEFAULT == null ? issueDate != null : !ISSUE_DATE_EDEFAULT.equals(issueDate);
			case SipPackage.ACCREDITATION__CANCELATION_DATE:
				return CANCELATION_DATE_EDEFAULT == null ? cancelationDate != null : !CANCELATION_DATE_EDEFAULT.equals(cancelationDate);
			case SipPackage.ACCREDITATION__RAW:
				return RAW_EDEFAULT == null ? raw != null : !RAW_EDEFAULT.equals(raw);
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
		result.append(" (issueDate: ");
		result.append(issueDate);
		result.append(", cancelationDate: ");
		result.append(cancelationDate);
		result.append(", raw: ");
		result.append(raw);
		result.append(')');
		return result.toString();
	}

} //AccreditationImpl

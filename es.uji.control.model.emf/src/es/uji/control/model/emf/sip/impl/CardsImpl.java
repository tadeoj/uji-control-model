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

import java.util.Date;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import es.uji.control.model.emf.sip.Cards;
import es.uji.control.model.emf.sip.SipPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cards</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link es.uji.control.model.emf.sip.impl.CardsImpl#getId <em>Id</em>}</li>
 *   <li>{@link es.uji.control.model.emf.sip.impl.CardsImpl#getPerId <em>Per Id</em>}</li>
 *   <li>{@link es.uji.control.model.emf.sip.impl.CardsImpl#getCreationDate <em>Creation Date</em>}</li>
 *   <li>{@link es.uji.control.model.emf.sip.impl.CardsImpl#getIssueDate <em>Issue Date</em>}</li>
 *   <li>{@link es.uji.control.model.emf.sip.impl.CardsImpl#getCancelationDate <em>Cancelation Date</em>}</li>
 *   <li>{@link es.uji.control.model.emf.sip.impl.CardsImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link es.uji.control.model.emf.sip.impl.CardsImpl#getSerialNumber <em>Serial Number</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CardsImpl extends EObjectImpl implements Cards {
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
	 * The default value of the '{@link #getPerId() <em>Per Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPerId()
	 * @generated
	 * @ordered
	 */
	protected static final Long PER_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPerId() <em>Per Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPerId()
	 * @generated
	 * @ordered
	 */
	protected Long perId = PER_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getCreationDate() <em>Creation Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreationDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date CREATION_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCreationDate() <em>Creation Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreationDate()
	 * @generated
	 * @ordered
	 */
	protected Date creationDate = CREATION_DATE_EDEFAULT;

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
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getSerialNumber() <em>Serial Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSerialNumber()
	 * @generated
	 * @ordered
	 */
	protected static final Long SERIAL_NUMBER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSerialNumber() <em>Serial Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSerialNumber()
	 * @generated
	 * @ordered
	 */
	protected Long serialNumber = SERIAL_NUMBER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CardsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SipPackage.Literals.CARDS;
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
			eNotify(new ENotificationImpl(this, Notification.SET, SipPackage.CARDS__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Long getPerId() {
		return perId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPerId(Long newPerId) {
		Long oldPerId = perId;
		perId = newPerId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SipPackage.CARDS__PER_ID, oldPerId, perId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreationDate(Date newCreationDate) {
		Date oldCreationDate = creationDate;
		creationDate = newCreationDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SipPackage.CARDS__CREATION_DATE, oldCreationDate, creationDate));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SipPackage.CARDS__ISSUE_DATE, oldIssueDate, issueDate));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SipPackage.CARDS__CANCELATION_DATE, oldCancelationDate, cancelationDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SipPackage.CARDS__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Long getSerialNumber() {
		return serialNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSerialNumber(Long newSerialNumber) {
		Long oldSerialNumber = serialNumber;
		serialNumber = newSerialNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SipPackage.CARDS__SERIAL_NUMBER, oldSerialNumber, serialNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SipPackage.CARDS__ID:
				return getId();
			case SipPackage.CARDS__PER_ID:
				return getPerId();
			case SipPackage.CARDS__CREATION_DATE:
				return getCreationDate();
			case SipPackage.CARDS__ISSUE_DATE:
				return getIssueDate();
			case SipPackage.CARDS__CANCELATION_DATE:
				return getCancelationDate();
			case SipPackage.CARDS__DESCRIPTION:
				return getDescription();
			case SipPackage.CARDS__SERIAL_NUMBER:
				return getSerialNumber();
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
			case SipPackage.CARDS__ID:
				setId((Long)newValue);
				return;
			case SipPackage.CARDS__PER_ID:
				setPerId((Long)newValue);
				return;
			case SipPackage.CARDS__CREATION_DATE:
				setCreationDate((Date)newValue);
				return;
			case SipPackage.CARDS__ISSUE_DATE:
				setIssueDate((Date)newValue);
				return;
			case SipPackage.CARDS__CANCELATION_DATE:
				setCancelationDate((Date)newValue);
				return;
			case SipPackage.CARDS__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case SipPackage.CARDS__SERIAL_NUMBER:
				setSerialNumber((Long)newValue);
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
			case SipPackage.CARDS__ID:
				setId(ID_EDEFAULT);
				return;
			case SipPackage.CARDS__PER_ID:
				setPerId(PER_ID_EDEFAULT);
				return;
			case SipPackage.CARDS__CREATION_DATE:
				setCreationDate(CREATION_DATE_EDEFAULT);
				return;
			case SipPackage.CARDS__ISSUE_DATE:
				setIssueDate(ISSUE_DATE_EDEFAULT);
				return;
			case SipPackage.CARDS__CANCELATION_DATE:
				setCancelationDate(CANCELATION_DATE_EDEFAULT);
				return;
			case SipPackage.CARDS__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case SipPackage.CARDS__SERIAL_NUMBER:
				setSerialNumber(SERIAL_NUMBER_EDEFAULT);
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
			case SipPackage.CARDS__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case SipPackage.CARDS__PER_ID:
				return PER_ID_EDEFAULT == null ? perId != null : !PER_ID_EDEFAULT.equals(perId);
			case SipPackage.CARDS__CREATION_DATE:
				return CREATION_DATE_EDEFAULT == null ? creationDate != null : !CREATION_DATE_EDEFAULT.equals(creationDate);
			case SipPackage.CARDS__ISSUE_DATE:
				return ISSUE_DATE_EDEFAULT == null ? issueDate != null : !ISSUE_DATE_EDEFAULT.equals(issueDate);
			case SipPackage.CARDS__CANCELATION_DATE:
				return CANCELATION_DATE_EDEFAULT == null ? cancelationDate != null : !CANCELATION_DATE_EDEFAULT.equals(cancelationDate);
			case SipPackage.CARDS__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case SipPackage.CARDS__SERIAL_NUMBER:
				return SERIAL_NUMBER_EDEFAULT == null ? serialNumber != null : !SERIAL_NUMBER_EDEFAULT.equals(serialNumber);
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
		result.append(", perId: ");
		result.append(perId);
		result.append(", creationDate: ");
		result.append(creationDate);
		result.append(", issueDate: ");
		result.append(issueDate);
		result.append(", cancelationDate: ");
		result.append(cancelationDate);
		result.append(", description: ");
		result.append(description);
		result.append(", serialNumber: ");
		result.append(serialNumber);
		result.append(')');
		return result.toString();
	}

} //CardsImpl

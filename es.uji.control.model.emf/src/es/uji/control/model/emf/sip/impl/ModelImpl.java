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
import java.util.Date;

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
import es.uji.control.model.emf.sip.Model;
import es.uji.control.model.emf.sip.Persons;
import es.uji.control.model.emf.sip.SipPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link es.uji.control.model.emf.sip.impl.ModelImpl#getDate <em>Date</em>}</li>
 *   <li>{@link es.uji.control.model.emf.sip.impl.ModelImpl#getModelPersonsList <em>Model Persons List</em>}</li>
 *   <li>{@link es.uji.control.model.emf.sip.impl.ModelImpl#getModelCardsList <em>Model Cards List</em>}</li>
 *   <li>{@link es.uji.control.model.emf.sip.impl.ModelImpl#getZoneId <em>Zone Id</em>}</li>
 *   <li>{@link es.uji.control.model.emf.sip.impl.ModelImpl#getZoneName <em>Zone Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModelImpl extends EObjectImpl implements Model {
	/**
	 * The default value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected Date date = DATE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getModelPersonsList() <em>Model Persons List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelPersonsList()
	 * @generated
	 * @ordered
	 */
	protected EList<Persons> modelPersonsList;

	/**
	 * The cached value of the '{@link #getModelCardsList() <em>Model Cards List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelCardsList()
	 * @generated
	 * @ordered
	 */
	protected EList<Cards> modelCardsList;

	/**
	 * The default value of the '{@link #getZoneId() <em>Zone Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getZoneId()
	 * @generated
	 * @ordered
	 */
	protected static final long ZONE_ID_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getZoneId() <em>Zone Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getZoneId()
	 * @generated
	 * @ordered
	 */
	protected long zoneId = ZONE_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getZoneName() <em>Zone Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getZoneName()
	 * @generated
	 * @ordered
	 */
	protected static final String ZONE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getZoneName() <em>Zone Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getZoneName()
	 * @generated
	 * @ordered
	 */
	protected String zoneName = ZONE_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SipPackage.Literals.MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDate(Date newDate) {
		Date oldDate = date;
		date = newDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SipPackage.MODEL__DATE, oldDate, date));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Persons> getModelPersonsList() {
		if (modelPersonsList == null) {
			modelPersonsList = new EObjectContainmentEList<Persons>(Persons.class, this, SipPackage.MODEL__MODEL_PERSONS_LIST);
		}
		return modelPersonsList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Cards> getModelCardsList() {
		if (modelCardsList == null) {
			modelCardsList = new EObjectContainmentEList<Cards>(Cards.class, this, SipPackage.MODEL__MODEL_CARDS_LIST);
		}
		return modelCardsList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getZoneId() {
		return zoneId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setZoneId(long newZoneId) {
		long oldZoneId = zoneId;
		zoneId = newZoneId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SipPackage.MODEL__ZONE_ID, oldZoneId, zoneId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getZoneName() {
		return zoneName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setZoneName(String newZoneName) {
		String oldZoneName = zoneName;
		zoneName = newZoneName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SipPackage.MODEL__ZONE_NAME, oldZoneName, zoneName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SipPackage.MODEL__MODEL_PERSONS_LIST:
				return ((InternalEList<?>)getModelPersonsList()).basicRemove(otherEnd, msgs);
			case SipPackage.MODEL__MODEL_CARDS_LIST:
				return ((InternalEList<?>)getModelCardsList()).basicRemove(otherEnd, msgs);
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
			case SipPackage.MODEL__DATE:
				return getDate();
			case SipPackage.MODEL__MODEL_PERSONS_LIST:
				return getModelPersonsList();
			case SipPackage.MODEL__MODEL_CARDS_LIST:
				return getModelCardsList();
			case SipPackage.MODEL__ZONE_ID:
				return getZoneId();
			case SipPackage.MODEL__ZONE_NAME:
				return getZoneName();
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
			case SipPackage.MODEL__DATE:
				setDate((Date)newValue);
				return;
			case SipPackage.MODEL__MODEL_PERSONS_LIST:
				getModelPersonsList().clear();
				getModelPersonsList().addAll((Collection<? extends Persons>)newValue);
				return;
			case SipPackage.MODEL__MODEL_CARDS_LIST:
				getModelCardsList().clear();
				getModelCardsList().addAll((Collection<? extends Cards>)newValue);
				return;
			case SipPackage.MODEL__ZONE_ID:
				setZoneId((Long)newValue);
				return;
			case SipPackage.MODEL__ZONE_NAME:
				setZoneName((String)newValue);
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
			case SipPackage.MODEL__DATE:
				setDate(DATE_EDEFAULT);
				return;
			case SipPackage.MODEL__MODEL_PERSONS_LIST:
				getModelPersonsList().clear();
				return;
			case SipPackage.MODEL__MODEL_CARDS_LIST:
				getModelCardsList().clear();
				return;
			case SipPackage.MODEL__ZONE_ID:
				setZoneId(ZONE_ID_EDEFAULT);
				return;
			case SipPackage.MODEL__ZONE_NAME:
				setZoneName(ZONE_NAME_EDEFAULT);
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
			case SipPackage.MODEL__DATE:
				return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
			case SipPackage.MODEL__MODEL_PERSONS_LIST:
				return modelPersonsList != null && !modelPersonsList.isEmpty();
			case SipPackage.MODEL__MODEL_CARDS_LIST:
				return modelCardsList != null && !modelCardsList.isEmpty();
			case SipPackage.MODEL__ZONE_ID:
				return zoneId != ZONE_ID_EDEFAULT;
			case SipPackage.MODEL__ZONE_NAME:
				return ZONE_NAME_EDEFAULT == null ? zoneName != null : !ZONE_NAME_EDEFAULT.equals(zoneName);
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
		result.append(" (date: ");
		result.append(date);
		result.append(", zoneId: ");
		result.append(zoneId);
		result.append(", zoneName: ");
		result.append(zoneName);
		result.append(')');
		return result.toString();
	}

} //ModelImpl

/**
 */
package es.uji.control.sip.model.emf.sip.impl;

import es.uji.control.sip.model.emf.sip.Accreditation;
import es.uji.control.sip.model.emf.sip.Model;
import es.uji.control.sip.model.emf.sip.Person;
import es.uji.control.sip.model.emf.sip.SipPackage;

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

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link es.uji.control.sip.model.emf.sip.impl.ModelImpl#getDate <em>Date</em>}</li>
 *   <li>{@link es.uji.control.sip.model.emf.sip.impl.ModelImpl#getModelPersonsList <em>Model Persons List</em>}</li>
 *   <li>{@link es.uji.control.sip.model.emf.sip.impl.ModelImpl#getModelCardsList <em>Model Cards List</em>}</li>
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
	protected EList<Person> modelPersonsList;

	/**
	 * The cached value of the '{@link #getModelCardsList() <em>Model Cards List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelCardsList()
	 * @generated
	 * @ordered
	 */
	protected EList<Accreditation> modelCardsList;

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
	public EList<Person> getModelPersonsList() {
		if (modelPersonsList == null) {
			modelPersonsList = new EObjectContainmentEList<Person>(Person.class, this, SipPackage.MODEL__MODEL_PERSONS_LIST);
		}
		return modelPersonsList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Accreditation> getModelCardsList() {
		if (modelCardsList == null) {
			modelCardsList = new EObjectContainmentEList<Accreditation>(Accreditation.class, this, SipPackage.MODEL__MODEL_CARDS_LIST);
		}
		return modelCardsList;
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
				getModelPersonsList().addAll((Collection<? extends Person>)newValue);
				return;
			case SipPackage.MODEL__MODEL_CARDS_LIST:
				getModelCardsList().clear();
				getModelCardsList().addAll((Collection<? extends Accreditation>)newValue);
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
		result.append(')');
		return result.toString();
	}

} //ModelImpl

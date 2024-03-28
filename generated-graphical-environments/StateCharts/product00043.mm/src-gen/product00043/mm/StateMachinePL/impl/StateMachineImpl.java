/**
 */
package product00043.mm.StateMachinePL.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import product00043.mm.StateMachinePL.State;
import product00043.mm.StateMachinePL.StateMachine;
import product00043.mm.StateMachinePL.StateMachinePLPackage;
import product00043.mm.StateMachinePL.Transition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>State Machine</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link product00043.mm.StateMachinePL.impl.StateMachineImpl#getStates <em>States</em>}</li>
 *   <li>{@link product00043.mm.StateMachinePL.impl.StateMachineImpl#getTransitions <em>Transitions</em>}</li>
 *   <li>{@link product00043.mm.StateMachinePL.impl.StateMachineImpl#getCurrentTime <em>Current Time</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StateMachineImpl extends MinimalEObjectImpl.Container implements StateMachine {
	/**
	 * The cached value of the '{@link #getStates() <em>States</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStates()
	 * @generated
	 * @ordered
	 */
	protected EList<State> states;

	/**
	 * The cached value of the '{@link #getTransitions() <em>Transitions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransitions()
	 * @generated
	 * @ordered
	 */
	protected EList<Transition> transitions;

	/**
	 * The default value of the '{@link #getCurrentTime() <em>Current Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentTime()
	 * @generated
	 * @ordered
	 */
	protected static final int CURRENT_TIME_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCurrentTime() <em>Current Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentTime()
	 * @generated
	 * @ordered
	 */
	protected int currentTime = CURRENT_TIME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StateMachineImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StateMachinePLPackage.Literals.STATE_MACHINE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<State> getStates() {
		if (states == null) {
			states = new EObjectContainmentEList<State>(State.class, this, StateMachinePLPackage.STATE_MACHINE__STATES);
		}
		return states;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Transition> getTransitions() {
		if (transitions == null) {
			transitions = new EObjectContainmentEList<Transition>(Transition.class, this,
					StateMachinePLPackage.STATE_MACHINE__TRANSITIONS);
		}
		return transitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getCurrentTime() {
		return currentTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCurrentTime(int newCurrentTime) {
		int oldCurrentTime = currentTime;
		currentTime = newCurrentTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StateMachinePLPackage.STATE_MACHINE__CURRENT_TIME,
					oldCurrentTime, currentTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case StateMachinePLPackage.STATE_MACHINE__STATES:
			return ((InternalEList<?>) getStates()).basicRemove(otherEnd, msgs);
		case StateMachinePLPackage.STATE_MACHINE__TRANSITIONS:
			return ((InternalEList<?>) getTransitions()).basicRemove(otherEnd, msgs);
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
		case StateMachinePLPackage.STATE_MACHINE__STATES:
			return getStates();
		case StateMachinePLPackage.STATE_MACHINE__TRANSITIONS:
			return getTransitions();
		case StateMachinePLPackage.STATE_MACHINE__CURRENT_TIME:
			return getCurrentTime();
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
		case StateMachinePLPackage.STATE_MACHINE__STATES:
			getStates().clear();
			getStates().addAll((Collection<? extends State>) newValue);
			return;
		case StateMachinePLPackage.STATE_MACHINE__TRANSITIONS:
			getTransitions().clear();
			getTransitions().addAll((Collection<? extends Transition>) newValue);
			return;
		case StateMachinePLPackage.STATE_MACHINE__CURRENT_TIME:
			setCurrentTime((Integer) newValue);
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
		case StateMachinePLPackage.STATE_MACHINE__STATES:
			getStates().clear();
			return;
		case StateMachinePLPackage.STATE_MACHINE__TRANSITIONS:
			getTransitions().clear();
			return;
		case StateMachinePLPackage.STATE_MACHINE__CURRENT_TIME:
			setCurrentTime(CURRENT_TIME_EDEFAULT);
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
		case StateMachinePLPackage.STATE_MACHINE__STATES:
			return states != null && !states.isEmpty();
		case StateMachinePLPackage.STATE_MACHINE__TRANSITIONS:
			return transitions != null && !transitions.isEmpty();
		case StateMachinePLPackage.STATE_MACHINE__CURRENT_TIME:
			return currentTime != CURRENT_TIME_EDEFAULT;
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
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (currentTime: ");
		result.append(currentTime);
		result.append(')');
		return result.toString();
	}

} //StateMachineImpl

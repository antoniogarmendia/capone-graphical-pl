/**
 */
package product00043.mm.StateMachinePL.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import product00043.mm.StateMachinePL.State;
import product00043.mm.StateMachinePL.StateMachinePLPackage;
import product00043.mm.StateMachinePL.Transition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link product00043.mm.StateMachinePL.impl.TransitionImpl#getFrom <em>From</em>}</li>
 *   <li>{@link product00043.mm.StateMachinePL.impl.TransitionImpl#getTo <em>To</em>}</li>
 *   <li>{@link product00043.mm.StateMachinePL.impl.TransitionImpl#getTime <em>Time</em>}</li>
 *   <li>{@link product00043.mm.StateMachinePL.impl.TransitionImpl#isIsImmediate <em>Is Immediate</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TransitionImpl extends MinimalEObjectImpl.Container implements Transition {
	/**
	 * The cached value of the '{@link #getFrom() <em>From</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrom()
	 * @generated
	 * @ordered
	 */
	protected State from;

	/**
	 * The cached value of the '{@link #getTo() <em>To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTo()
	 * @generated
	 * @ordered
	 */
	protected State to;

	/**
	 * The default value of the '{@link #getTime() <em>Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTime()
	 * @generated
	 * @ordered
	 */
	protected static final int TIME_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getTime() <em>Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTime()
	 * @generated
	 * @ordered
	 */
	protected int time = TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsImmediate() <em>Is Immediate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsImmediate()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_IMMEDIATE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsImmediate() <em>Is Immediate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsImmediate()
	 * @generated
	 * @ordered
	 */
	protected boolean isImmediate = IS_IMMEDIATE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StateMachinePLPackage.Literals.TRANSITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public State getFrom() {
		if (from != null && from.eIsProxy()) {
			InternalEObject oldFrom = (InternalEObject) from;
			from = (State) eResolveProxy(oldFrom);
			if (from != oldFrom) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StateMachinePLPackage.TRANSITION__FROM,
							oldFrom, from));
			}
		}
		return from;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State basicGetFrom() {
		return from;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFrom(State newFrom) {
		State oldFrom = from;
		from = newFrom;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StateMachinePLPackage.TRANSITION__FROM, oldFrom,
					from));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public State getTo() {
		if (to != null && to.eIsProxy()) {
			InternalEObject oldTo = (InternalEObject) to;
			to = (State) eResolveProxy(oldTo);
			if (to != oldTo) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StateMachinePLPackage.TRANSITION__TO,
							oldTo, to));
			}
		}
		return to;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State basicGetTo() {
		return to;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTo(State newTo) {
		State oldTo = to;
		to = newTo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StateMachinePLPackage.TRANSITION__TO, oldTo, to));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getTime() {
		return time;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTime(int newTime) {
		int oldTime = time;
		time = newTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StateMachinePLPackage.TRANSITION__TIME, oldTime,
					time));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsImmediate() {
		return isImmediate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsImmediate(boolean newIsImmediate) {
		boolean oldIsImmediate = isImmediate;
		isImmediate = newIsImmediate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StateMachinePLPackage.TRANSITION__IS_IMMEDIATE,
					oldIsImmediate, isImmediate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case StateMachinePLPackage.TRANSITION__FROM:
			if (resolve)
				return getFrom();
			return basicGetFrom();
		case StateMachinePLPackage.TRANSITION__TO:
			if (resolve)
				return getTo();
			return basicGetTo();
		case StateMachinePLPackage.TRANSITION__TIME:
			return getTime();
		case StateMachinePLPackage.TRANSITION__IS_IMMEDIATE:
			return isIsImmediate();
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
		case StateMachinePLPackage.TRANSITION__FROM:
			setFrom((State) newValue);
			return;
		case StateMachinePLPackage.TRANSITION__TO:
			setTo((State) newValue);
			return;
		case StateMachinePLPackage.TRANSITION__TIME:
			setTime((Integer) newValue);
			return;
		case StateMachinePLPackage.TRANSITION__IS_IMMEDIATE:
			setIsImmediate((Boolean) newValue);
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
		case StateMachinePLPackage.TRANSITION__FROM:
			setFrom((State) null);
			return;
		case StateMachinePLPackage.TRANSITION__TO:
			setTo((State) null);
			return;
		case StateMachinePLPackage.TRANSITION__TIME:
			setTime(TIME_EDEFAULT);
			return;
		case StateMachinePLPackage.TRANSITION__IS_IMMEDIATE:
			setIsImmediate(IS_IMMEDIATE_EDEFAULT);
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
		case StateMachinePLPackage.TRANSITION__FROM:
			return from != null;
		case StateMachinePLPackage.TRANSITION__TO:
			return to != null;
		case StateMachinePLPackage.TRANSITION__TIME:
			return time != TIME_EDEFAULT;
		case StateMachinePLPackage.TRANSITION__IS_IMMEDIATE:
			return isImmediate != IS_IMMEDIATE_EDEFAULT;
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
		result.append(" (time: ");
		result.append(time);
		result.append(", isImmediate: ");
		result.append(isImmediate);
		result.append(')');
		return result.toString();
	}

} //TransitionImpl

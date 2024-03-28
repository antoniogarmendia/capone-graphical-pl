/**
 */
package product00005.mm.NetworkingPL.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import product00005.mm.NetworkingPL.Link;
import product00005.mm.NetworkingPL.NetworkingPLPackage;
import product00005.mm.NetworkingPL.Node;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link product00005.mm.NetworkingPL.impl.LinkImpl#getFrom <em>From</em>}</li>
 *   <li>{@link product00005.mm.NetworkingPL.impl.LinkImpl#getTo <em>To</em>}</li>
 *   <li>{@link product00005.mm.NetworkingPL.impl.LinkImpl#getSpeed <em>Speed</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LinkImpl extends MinimalEObjectImpl.Container implements Link {
	/**
	 * The cached value of the '{@link #getFrom() <em>From</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrom()
	 * @generated
	 * @ordered
	 */
	protected Node from;

	/**
	 * The cached value of the '{@link #getTo() <em>To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTo()
	 * @generated
	 * @ordered
	 */
	protected Node to;

	/**
	 * The default value of the '{@link #getSpeed() <em>Speed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpeed()
	 * @generated
	 * @ordered
	 */
	protected static final double SPEED_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getSpeed() <em>Speed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpeed()
	 * @generated
	 * @ordered
	 */
	protected double speed = SPEED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LinkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NetworkingPLPackage.Literals.LINK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Node getFrom() {
		if (from != null && from.eIsProxy()) {
			InternalEObject oldFrom = (InternalEObject) from;
			from = (Node) eResolveProxy(oldFrom);
			if (from != oldFrom) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NetworkingPLPackage.LINK__FROM, oldFrom,
							from));
			}
		}
		return from;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node basicGetFrom() {
		return from;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFrom(Node newFrom) {
		Node oldFrom = from;
		from = newFrom;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkingPLPackage.LINK__FROM, oldFrom, from));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Node getTo() {
		if (to != null && to.eIsProxy()) {
			InternalEObject oldTo = (InternalEObject) to;
			to = (Node) eResolveProxy(oldTo);
			if (to != oldTo) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NetworkingPLPackage.LINK__TO, oldTo, to));
			}
		}
		return to;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node basicGetTo() {
		return to;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTo(Node newTo) {
		Node oldTo = to;
		to = newTo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkingPLPackage.LINK__TO, oldTo, to));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getSpeed() {
		return speed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSpeed(double newSpeed) {
		double oldSpeed = speed;
		speed = newSpeed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkingPLPackage.LINK__SPEED, oldSpeed, speed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case NetworkingPLPackage.LINK__FROM:
			if (resolve)
				return getFrom();
			return basicGetFrom();
		case NetworkingPLPackage.LINK__TO:
			if (resolve)
				return getTo();
			return basicGetTo();
		case NetworkingPLPackage.LINK__SPEED:
			return getSpeed();
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
		case NetworkingPLPackage.LINK__FROM:
			setFrom((Node) newValue);
			return;
		case NetworkingPLPackage.LINK__TO:
			setTo((Node) newValue);
			return;
		case NetworkingPLPackage.LINK__SPEED:
			setSpeed((Double) newValue);
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
		case NetworkingPLPackage.LINK__FROM:
			setFrom((Node) null);
			return;
		case NetworkingPLPackage.LINK__TO:
			setTo((Node) null);
			return;
		case NetworkingPLPackage.LINK__SPEED:
			setSpeed(SPEED_EDEFAULT);
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
		case NetworkingPLPackage.LINK__FROM:
			return from != null;
		case NetworkingPLPackage.LINK__TO:
			return to != null;
		case NetworkingPLPackage.LINK__SPEED:
			return speed != SPEED_EDEFAULT;
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
		result.append(" (speed: ");
		result.append(speed);
		result.append(')');
		return result.toString();
	}

} //LinkImpl

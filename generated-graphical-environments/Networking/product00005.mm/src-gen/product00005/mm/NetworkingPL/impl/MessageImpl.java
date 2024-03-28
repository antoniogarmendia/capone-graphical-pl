/**
 */
package product00005.mm.NetworkingPL.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import product00005.mm.NetworkingPL.Message;
import product00005.mm.NetworkingPL.NetworkingPLPackage;
import product00005.mm.NetworkingPL.Node;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Message</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link product00005.mm.NetworkingPL.impl.MessageImpl#getFrom <em>From</em>}</li>
 *   <li>{@link product00005.mm.NetworkingPL.impl.MessageImpl#getTo <em>To</em>}</li>
 *   <li>{@link product00005.mm.NetworkingPL.impl.MessageImpl#getAt <em>At</em>}</li>
 *   <li>{@link product00005.mm.NetworkingPL.impl.MessageImpl#getSize <em>Size</em>}</li>
 *   <li>{@link product00005.mm.NetworkingPL.impl.MessageImpl#getTimeStamp <em>Time Stamp</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MessageImpl extends MinimalEObjectImpl.Container implements Message {
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
	 * The cached value of the '{@link #getAt() <em>At</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAt()
	 * @generated
	 * @ordered
	 */
	protected Node at;

	/**
	 * The default value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected static final int SIZE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected int size = SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTimeStamp() <em>Time Stamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeStamp()
	 * @generated
	 * @ordered
	 */
	protected static final double TIME_STAMP_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getTimeStamp() <em>Time Stamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeStamp()
	 * @generated
	 * @ordered
	 */
	protected double timeStamp = TIME_STAMP_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MessageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NetworkingPLPackage.Literals.MESSAGE;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NetworkingPLPackage.MESSAGE__FROM,
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
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkingPLPackage.MESSAGE__FROM, oldFrom, from));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NetworkingPLPackage.MESSAGE__TO, oldTo,
							to));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkingPLPackage.MESSAGE__TO, oldTo, to));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Node getAt() {
		if (at != null && at.eIsProxy()) {
			InternalEObject oldAt = (InternalEObject) at;
			at = (Node) eResolveProxy(oldAt);
			if (at != oldAt) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NetworkingPLPackage.MESSAGE__AT, oldAt,
							at));
			}
		}
		return at;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node basicGetAt() {
		return at;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAt(Node newAt) {
		Node oldAt = at;
		at = newAt;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkingPLPackage.MESSAGE__AT, oldAt, at));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getSize() {
		return size;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSize(int newSize) {
		int oldSize = size;
		size = newSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkingPLPackage.MESSAGE__SIZE, oldSize, size));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getTimeStamp() {
		return timeStamp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTimeStamp(double newTimeStamp) {
		double oldTimeStamp = timeStamp;
		timeStamp = newTimeStamp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkingPLPackage.MESSAGE__TIME_STAMP, oldTimeStamp,
					timeStamp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case NetworkingPLPackage.MESSAGE__FROM:
			if (resolve)
				return getFrom();
			return basicGetFrom();
		case NetworkingPLPackage.MESSAGE__TO:
			if (resolve)
				return getTo();
			return basicGetTo();
		case NetworkingPLPackage.MESSAGE__AT:
			if (resolve)
				return getAt();
			return basicGetAt();
		case NetworkingPLPackage.MESSAGE__SIZE:
			return getSize();
		case NetworkingPLPackage.MESSAGE__TIME_STAMP:
			return getTimeStamp();
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
		case NetworkingPLPackage.MESSAGE__FROM:
			setFrom((Node) newValue);
			return;
		case NetworkingPLPackage.MESSAGE__TO:
			setTo((Node) newValue);
			return;
		case NetworkingPLPackage.MESSAGE__AT:
			setAt((Node) newValue);
			return;
		case NetworkingPLPackage.MESSAGE__SIZE:
			setSize((Integer) newValue);
			return;
		case NetworkingPLPackage.MESSAGE__TIME_STAMP:
			setTimeStamp((Double) newValue);
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
		case NetworkingPLPackage.MESSAGE__FROM:
			setFrom((Node) null);
			return;
		case NetworkingPLPackage.MESSAGE__TO:
			setTo((Node) null);
			return;
		case NetworkingPLPackage.MESSAGE__AT:
			setAt((Node) null);
			return;
		case NetworkingPLPackage.MESSAGE__SIZE:
			setSize(SIZE_EDEFAULT);
			return;
		case NetworkingPLPackage.MESSAGE__TIME_STAMP:
			setTimeStamp(TIME_STAMP_EDEFAULT);
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
		case NetworkingPLPackage.MESSAGE__FROM:
			return from != null;
		case NetworkingPLPackage.MESSAGE__TO:
			return to != null;
		case NetworkingPLPackage.MESSAGE__AT:
			return at != null;
		case NetworkingPLPackage.MESSAGE__SIZE:
			return size != SIZE_EDEFAULT;
		case NetworkingPLPackage.MESSAGE__TIME_STAMP:
			return timeStamp != TIME_STAMP_EDEFAULT;
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
		result.append(" (size: ");
		result.append(size);
		result.append(", timeStamp: ");
		result.append(timeStamp);
		result.append(')');
		return result.toString();
	}

} //MessageImpl

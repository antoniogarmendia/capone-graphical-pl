/**
 */
package product00058.mm.PetriNetsPL.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import product00058.mm.PetriNetsPL.PetriNetsPLPackage;
import product00058.mm.PetriNetsPL.Place;
import product00058.mm.PetriNetsPL.Transition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link product00058.mm.PetriNetsPL.impl.TransitionImpl#getInPlaces <em>In Places</em>}</li>
 *   <li>{@link product00058.mm.PetriNetsPL.impl.TransitionImpl#getOutPlaces <em>Out Places</em>}</li>
 *   <li>{@link product00058.mm.PetriNetsPL.impl.TransitionImpl#getInhibitorPlaces <em>Inhibitor Places</em>}</li>
 *   <li>{@link product00058.mm.PetriNetsPL.impl.TransitionImpl#getReadPlaces <em>Read Places</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TransitionImpl extends MinimalEObjectImpl.Container implements Transition {
	/**
	 * The cached value of the '{@link #getInPlaces() <em>In Places</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInPlaces()
	 * @generated
	 * @ordered
	 */
	protected EList<Place> inPlaces;

	/**
	 * The cached value of the '{@link #getOutPlaces() <em>Out Places</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutPlaces()
	 * @generated
	 * @ordered
	 */
	protected EList<Place> outPlaces;

	/**
	 * The cached value of the '{@link #getInhibitorPlaces() <em>Inhibitor Places</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInhibitorPlaces()
	 * @generated
	 * @ordered
	 */
	protected EList<Place> inhibitorPlaces;

	/**
	 * The cached value of the '{@link #getReadPlaces() <em>Read Places</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReadPlaces()
	 * @generated
	 * @ordered
	 */
	protected EList<Place> readPlaces;

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
		return PetriNetsPLPackage.Literals.TRANSITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Place> getInPlaces() {
		if (inPlaces == null) {
			inPlaces = new EObjectResolvingEList<Place>(Place.class, this, PetriNetsPLPackage.TRANSITION__IN_PLACES);
		}
		return inPlaces;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Place> getOutPlaces() {
		if (outPlaces == null) {
			outPlaces = new EObjectResolvingEList<Place>(Place.class, this, PetriNetsPLPackage.TRANSITION__OUT_PLACES);
		}
		return outPlaces;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Place> getInhibitorPlaces() {
		if (inhibitorPlaces == null) {
			inhibitorPlaces = new EObjectResolvingEList<Place>(Place.class, this,
					PetriNetsPLPackage.TRANSITION__INHIBITOR_PLACES);
		}
		return inhibitorPlaces;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Place> getReadPlaces() {
		if (readPlaces == null) {
			readPlaces = new EObjectResolvingEList<Place>(Place.class, this,
					PetriNetsPLPackage.TRANSITION__READ_PLACES);
		}
		return readPlaces;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case PetriNetsPLPackage.TRANSITION__IN_PLACES:
			return getInPlaces();
		case PetriNetsPLPackage.TRANSITION__OUT_PLACES:
			return getOutPlaces();
		case PetriNetsPLPackage.TRANSITION__INHIBITOR_PLACES:
			return getInhibitorPlaces();
		case PetriNetsPLPackage.TRANSITION__READ_PLACES:
			return getReadPlaces();
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
		case PetriNetsPLPackage.TRANSITION__IN_PLACES:
			getInPlaces().clear();
			getInPlaces().addAll((Collection<? extends Place>) newValue);
			return;
		case PetriNetsPLPackage.TRANSITION__OUT_PLACES:
			getOutPlaces().clear();
			getOutPlaces().addAll((Collection<? extends Place>) newValue);
			return;
		case PetriNetsPLPackage.TRANSITION__INHIBITOR_PLACES:
			getInhibitorPlaces().clear();
			getInhibitorPlaces().addAll((Collection<? extends Place>) newValue);
			return;
		case PetriNetsPLPackage.TRANSITION__READ_PLACES:
			getReadPlaces().clear();
			getReadPlaces().addAll((Collection<? extends Place>) newValue);
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
		case PetriNetsPLPackage.TRANSITION__IN_PLACES:
			getInPlaces().clear();
			return;
		case PetriNetsPLPackage.TRANSITION__OUT_PLACES:
			getOutPlaces().clear();
			return;
		case PetriNetsPLPackage.TRANSITION__INHIBITOR_PLACES:
			getInhibitorPlaces().clear();
			return;
		case PetriNetsPLPackage.TRANSITION__READ_PLACES:
			getReadPlaces().clear();
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
		case PetriNetsPLPackage.TRANSITION__IN_PLACES:
			return inPlaces != null && !inPlaces.isEmpty();
		case PetriNetsPLPackage.TRANSITION__OUT_PLACES:
			return outPlaces != null && !outPlaces.isEmpty();
		case PetriNetsPLPackage.TRANSITION__INHIBITOR_PLACES:
			return inhibitorPlaces != null && !inhibitorPlaces.isEmpty();
		case PetriNetsPLPackage.TRANSITION__READ_PLACES:
			return readPlaces != null && !readPlaces.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TransitionImpl

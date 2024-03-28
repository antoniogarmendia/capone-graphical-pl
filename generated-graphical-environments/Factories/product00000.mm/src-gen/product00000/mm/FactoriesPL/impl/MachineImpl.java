/**
 */
package product00000.mm.FactoriesPL.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import product00000.mm.FactoriesPL.Conveyor;
import product00000.mm.FactoriesPL.FactoriesPLPackage;
import product00000.mm.FactoriesPL.Machine;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Machine</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link product00000.mm.FactoriesPL.impl.MachineImpl#getInps <em>Inps</em>}</li>
 *   <li>{@link product00000.mm.FactoriesPL.impl.MachineImpl#getOuts <em>Outs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MachineImpl extends FElementImpl implements Machine {
	/**
	 * The cached value of the '{@link #getInps() <em>Inps</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInps()
	 * @generated
	 * @ordered
	 */
	protected EList<Conveyor> inps;

	/**
	 * The cached value of the '{@link #getOuts() <em>Outs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOuts()
	 * @generated
	 * @ordered
	 */
	protected EList<Conveyor> outs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MachineImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FactoriesPLPackage.Literals.MACHINE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Conveyor> getInps() {
		if (inps == null) {
			inps = new EObjectResolvingEList<Conveyor>(Conveyor.class, this, FactoriesPLPackage.MACHINE__INPS);
		}
		return inps;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Conveyor> getOuts() {
		if (outs == null) {
			outs = new EObjectResolvingEList<Conveyor>(Conveyor.class, this, FactoriesPLPackage.MACHINE__OUTS);
		}
		return outs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case FactoriesPLPackage.MACHINE__INPS:
			return getInps();
		case FactoriesPLPackage.MACHINE__OUTS:
			return getOuts();
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
		case FactoriesPLPackage.MACHINE__INPS:
			getInps().clear();
			getInps().addAll((Collection<? extends Conveyor>) newValue);
			return;
		case FactoriesPLPackage.MACHINE__OUTS:
			getOuts().clear();
			getOuts().addAll((Collection<? extends Conveyor>) newValue);
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
		case FactoriesPLPackage.MACHINE__INPS:
			getInps().clear();
			return;
		case FactoriesPLPackage.MACHINE__OUTS:
			getOuts().clear();
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
		case FactoriesPLPackage.MACHINE__INPS:
			return inps != null && !inps.isEmpty();
		case FactoriesPLPackage.MACHINE__OUTS:
			return outs != null && !outs.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //MachineImpl

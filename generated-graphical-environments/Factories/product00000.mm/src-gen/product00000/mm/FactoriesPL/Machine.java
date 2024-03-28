/**
 */
package product00000.mm.FactoriesPL;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Machine</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link product00000.mm.FactoriesPL.Machine#getInps <em>Inps</em>}</li>
 *   <li>{@link product00000.mm.FactoriesPL.Machine#getOuts <em>Outs</em>}</li>
 * </ul>
 *
 * @see product00000.mm.FactoriesPL.FactoriesPLPackage#getMachine()
 * @model
 * @generated
 */
public interface Machine extends FElement {
	/**
	 * Returns the value of the '<em><b>Inps</b></em>' reference list.
	 * The list contents are of type {@link product00000.mm.FactoriesPL.Conveyor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inps</em>' reference list.
	 * @see product00000.mm.FactoriesPL.FactoriesPLPackage#getMachine_Inps()
	 * @model
	 * @generated
	 */
	EList<Conveyor> getInps();

	/**
	 * Returns the value of the '<em><b>Outs</b></em>' reference list.
	 * The list contents are of type {@link product00000.mm.FactoriesPL.Conveyor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outs</em>' reference list.
	 * @see product00000.mm.FactoriesPL.FactoriesPLPackage#getMachine_Outs()
	 * @model
	 * @generated
	 */
	EList<Conveyor> getOuts();

} // Machine

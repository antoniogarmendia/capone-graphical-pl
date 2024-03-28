/**
 */
package product00043.mm.StateMachinePL;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Orthogonal Region</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link product00043.mm.StateMachinePL.OrthogonalRegion#getStates <em>States</em>}</li>
 * </ul>
 *
 * @see product00043.mm.StateMachinePL.StateMachinePLPackage#getOrthogonalRegion()
 * @model
 * @generated
 */
public interface OrthogonalRegion extends EObject {
	/**
	 * Returns the value of the '<em><b>States</b></em>' containment reference list.
	 * The list contents are of type {@link product00043.mm.StateMachinePL.State}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>States</em>' containment reference list.
	 * @see product00043.mm.StateMachinePL.StateMachinePLPackage#getOrthogonalRegion_States()
	 * @model containment="true"
	 * @generated
	 */
	EList<State> getStates();

} // OrthogonalRegion

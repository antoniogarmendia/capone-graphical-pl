/**
 */
package product00043.mm.StateMachinePL;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link product00043.mm.StateMachinePL.CompositeState#getRegions <em>Regions</em>}</li>
 * </ul>
 *
 * @see product00043.mm.StateMachinePL.StateMachinePLPackage#getCompositeState()
 * @model
 * @generated
 */
public interface CompositeState extends State {
	/**
	 * Returns the value of the '<em><b>Regions</b></em>' containment reference list.
	 * The list contents are of type {@link product00043.mm.StateMachinePL.OrthogonalRegion}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Regions</em>' containment reference list.
	 * @see product00043.mm.StateMachinePL.StateMachinePLPackage#getCompositeState_Regions()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<OrthogonalRegion> getRegions();

} // CompositeState

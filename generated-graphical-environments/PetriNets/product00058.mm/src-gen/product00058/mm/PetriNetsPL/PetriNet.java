/**
 */
package product00058.mm.PetriNetsPL;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Petri Net</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link product00058.mm.PetriNetsPL.PetriNet#getPlaces <em>Places</em>}</li>
 *   <li>{@link product00058.mm.PetriNetsPL.PetriNet#getTransitions <em>Transitions</em>}</li>
 * </ul>
 *
 * @see product00058.mm.PetriNetsPL.PetriNetsPLPackage#getPetriNet()
 * @model
 * @generated
 */
public interface PetriNet extends EObject {
	/**
	 * Returns the value of the '<em><b>Places</b></em>' containment reference list.
	 * The list contents are of type {@link product00058.mm.PetriNetsPL.Place}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Places</em>' containment reference list.
	 * @see product00058.mm.PetriNetsPL.PetriNetsPLPackage#getPetriNet_Places()
	 * @model containment="true"
	 * @generated
	 */
	EList<Place> getPlaces();

	/**
	 * Returns the value of the '<em><b>Transitions</b></em>' containment reference list.
	 * The list contents are of type {@link product00058.mm.PetriNetsPL.Transition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transitions</em>' containment reference list.
	 * @see product00058.mm.PetriNetsPL.PetriNetsPLPackage#getPetriNet_Transitions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Transition> getTransitions();

} // PetriNet

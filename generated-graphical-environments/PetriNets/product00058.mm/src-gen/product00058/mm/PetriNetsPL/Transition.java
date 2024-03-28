/**
 */
package product00058.mm.PetriNetsPL;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link product00058.mm.PetriNetsPL.Transition#getInPlaces <em>In Places</em>}</li>
 *   <li>{@link product00058.mm.PetriNetsPL.Transition#getOutPlaces <em>Out Places</em>}</li>
 *   <li>{@link product00058.mm.PetriNetsPL.Transition#getInhibitorPlaces <em>Inhibitor Places</em>}</li>
 *   <li>{@link product00058.mm.PetriNetsPL.Transition#getReadPlaces <em>Read Places</em>}</li>
 * </ul>
 *
 * @see product00058.mm.PetriNetsPL.PetriNetsPLPackage#getTransition()
 * @model
 * @generated
 */
public interface Transition extends EObject {
	/**
	 * Returns the value of the '<em><b>In Places</b></em>' reference list.
	 * The list contents are of type {@link product00058.mm.PetriNetsPL.Place}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Places</em>' reference list.
	 * @see product00058.mm.PetriNetsPL.PetriNetsPLPackage#getTransition_InPlaces()
	 * @model
	 * @generated
	 */
	EList<Place> getInPlaces();

	/**
	 * Returns the value of the '<em><b>Out Places</b></em>' reference list.
	 * The list contents are of type {@link product00058.mm.PetriNetsPL.Place}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Out Places</em>' reference list.
	 * @see product00058.mm.PetriNetsPL.PetriNetsPLPackage#getTransition_OutPlaces()
	 * @model
	 * @generated
	 */
	EList<Place> getOutPlaces();

	/**
	 * Returns the value of the '<em><b>Inhibitor Places</b></em>' reference list.
	 * The list contents are of type {@link product00058.mm.PetriNetsPL.Place}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inhibitor Places</em>' reference list.
	 * @see product00058.mm.PetriNetsPL.PetriNetsPLPackage#getTransition_InhibitorPlaces()
	 * @model
	 * @generated
	 */
	EList<Place> getInhibitorPlaces();

	/**
	 * Returns the value of the '<em><b>Read Places</b></em>' reference list.
	 * The list contents are of type {@link product00058.mm.PetriNetsPL.Place}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Read Places</em>' reference list.
	 * @see product00058.mm.PetriNetsPL.PetriNetsPLPackage#getTransition_ReadPlaces()
	 * @model
	 * @generated
	 */
	EList<Place> getReadPlaces();

} // Transition

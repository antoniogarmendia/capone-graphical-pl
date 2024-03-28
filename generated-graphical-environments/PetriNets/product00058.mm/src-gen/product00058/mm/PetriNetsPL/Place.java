/**
 */
package product00058.mm.PetriNetsPL;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Place</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link product00058.mm.PetriNetsPL.Place#getTokens <em>Tokens</em>}</li>
 * </ul>
 *
 * @see product00058.mm.PetriNetsPL.PetriNetsPLPackage#getPlace()
 * @model
 * @generated
 */
public interface Place extends EObject {
	/**
	 * Returns the value of the '<em><b>Tokens</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tokens</em>' attribute.
	 * @see #setTokens(int)
	 * @see product00058.mm.PetriNetsPL.PetriNetsPLPackage#getPlace_Tokens()
	 * @model required="true"
	 * @generated
	 */
	int getTokens();

	/**
	 * Sets the value of the '{@link product00058.mm.PetriNetsPL.Place#getTokens <em>Tokens</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tokens</em>' attribute.
	 * @see #getTokens()
	 * @generated
	 */
	void setTokens(int value);

} // Place

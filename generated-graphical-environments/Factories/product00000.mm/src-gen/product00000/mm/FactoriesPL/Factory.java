/**
 */
package product00000.mm.FactoriesPL;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Factory</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link product00000.mm.FactoriesPL.Factory#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @see product00000.mm.FactoriesPL.FactoriesPLPackage#getFactory()
 * @model
 * @generated
 */
public interface Factory extends EObject {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link product00000.mm.FactoriesPL.FElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see product00000.mm.FactoriesPL.FactoriesPLPackage#getFactory_Elements()
	 * @model containment="true"
	 * @generated
	 */
	EList<FElement> getElements();

} // Factory

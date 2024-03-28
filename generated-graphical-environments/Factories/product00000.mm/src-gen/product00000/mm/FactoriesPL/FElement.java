/**
 */
package product00000.mm.FactoriesPL;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>FElement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link product00000.mm.FactoriesPL.FElement#getName <em>Name</em>}</li>
 *   <li>{@link product00000.mm.FactoriesPL.FElement#getParts <em>Parts</em>}</li>
 * </ul>
 *
 * @see product00000.mm.FactoriesPL.FactoriesPLPackage#getFElement()
 * @model abstract="true"
 * @generated
 */
public interface FElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see product00000.mm.FactoriesPL.FactoriesPLPackage#getFElement_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link product00000.mm.FactoriesPL.FElement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Parts</b></em>' containment reference list.
	 * The list contents are of type {@link product00000.mm.FactoriesPL.Part}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parts</em>' containment reference list.
	 * @see product00000.mm.FactoriesPL.FactoriesPLPackage#getFElement_Parts()
	 * @model containment="true"
	 * @generated
	 */
	EList<Part> getParts();

} // FElement

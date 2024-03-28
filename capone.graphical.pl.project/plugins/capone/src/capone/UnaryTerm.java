/**
 */
package capone;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unary Term</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link capone.UnaryTerm#getVariable <em>Variable</em>}</li>
 * </ul>
 *
 * @see capone.CaponePackage#getUnaryTerm()
 * @model
 * @generated
 */
public interface UnaryTerm extends Term {
	/**
	 * Returns the value of the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' reference.
	 * @see #setVariable(capone.Module)
	 * @see capone.CaponePackage#getUnaryTerm_Variable()
	 * @model required="true"
	 * @generated
	 */
	capone.Module getVariable();

	/**
	 * Sets the value of the '{@link capone.UnaryTerm#getVariable <em>Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' reference.
	 * @see #getVariable()
	 * @generated
	 */
	void setVariable(capone.Module value);

} // UnaryTerm

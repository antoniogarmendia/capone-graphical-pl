/**
 */
package capone;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binary Term</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link capone.BinaryTerm#getOperand1 <em>Operand1</em>}</li>
 *   <li>{@link capone.BinaryTerm#getOperand2 <em>Operand2</em>}</li>
 *   <li>{@link capone.BinaryTerm#getBoperator <em>Boperator</em>}</li>
 * </ul>
 *
 * @see capone.CaponePackage#getBinaryTerm()
 * @model
 * @generated
 */
public interface BinaryTerm extends Term {
	/**
	 * Returns the value of the '<em><b>Operand1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operand1</em>' containment reference.
	 * @see #setOperand1(Term)
	 * @see capone.CaponePackage#getBinaryTerm_Operand1()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Term getOperand1();

	/**
	 * Sets the value of the '{@link capone.BinaryTerm#getOperand1 <em>Operand1</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operand1</em>' containment reference.
	 * @see #getOperand1()
	 * @generated
	 */
	void setOperand1(Term value);

	/**
	 * Returns the value of the '<em><b>Operand2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operand2</em>' containment reference.
	 * @see #setOperand2(Term)
	 * @see capone.CaponePackage#getBinaryTerm_Operand2()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Term getOperand2();

	/**
	 * Sets the value of the '{@link capone.BinaryTerm#getOperand2 <em>Operand2</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operand2</em>' containment reference.
	 * @see #getOperand2()
	 * @generated
	 */
	void setOperand2(Term value);

	/**
	 * Returns the value of the '<em><b>Boperator</b></em>' attribute.
	 * The literals are from the enumeration {@link capone.BinaryOperator}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Boperator</em>' attribute.
	 * @see capone.BinaryOperator
	 * @see #setBoperator(BinaryOperator)
	 * @see capone.CaponePackage#getBinaryTerm_Boperator()
	 * @model required="true"
	 * @generated
	 */
	BinaryOperator getBoperator();

	/**
	 * Sets the value of the '{@link capone.BinaryTerm#getBoperator <em>Boperator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Boperator</em>' attribute.
	 * @see capone.BinaryOperator
	 * @see #getBoperator()
	 * @generated
	 */
	void setBoperator(BinaryOperator value);

} // BinaryTerm

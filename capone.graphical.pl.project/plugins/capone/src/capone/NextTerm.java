/**
 */
package capone;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Next Term</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link capone.NextTerm#getBoperator <em>Boperator</em>}</li>
 *   <li>{@link capone.NextTerm#getTerm <em>Term</em>}</li>
 * </ul>
 *
 * @see capone.CaponePackage#getNextTerm()
 * @model
 * @generated
 */
public interface NextTerm extends EObject {
	/**
	 * Returns the value of the '<em><b>Boperator</b></em>' attribute.
	 * The literals are from the enumeration {@link capone.BinaryOperator}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Boperator</em>' attribute.
	 * @see capone.BinaryOperator
	 * @see #setBoperator(BinaryOperator)
	 * @see capone.CaponePackage#getNextTerm_Boperator()
	 * @model required="true"
	 * @generated
	 */
	BinaryOperator getBoperator();

	/**
	 * Sets the value of the '{@link capone.NextTerm#getBoperator <em>Boperator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Boperator</em>' attribute.
	 * @see capone.BinaryOperator
	 * @see #getBoperator()
	 * @generated
	 */
	void setBoperator(BinaryOperator value);

	/**
	 * Returns the value of the '<em><b>Term</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Term</em>' containment reference.
	 * @see #setTerm(Term)
	 * @see capone.CaponePackage#getNextTerm_Term()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Term getTerm();

	/**
	 * Sets the value of the '{@link capone.NextTerm#getTerm <em>Term</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Term</em>' containment reference.
	 * @see #getTerm()
	 * @generated
	 */
	void setTerm(Term value);

} // NextTerm

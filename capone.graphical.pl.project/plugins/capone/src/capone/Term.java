/**
 */
package capone;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Term</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link capone.Term#getUoperator <em>Uoperator</em>}</li>
 *   <li>{@link capone.Term#getNext <em>Next</em>}</li>
 * </ul>
 *
 * @see capone.CaponePackage#getTerm()
 * @model abstract="true"
 * @generated
 */
public interface Term extends EObject {
	/**
	 * Returns the value of the '<em><b>Uoperator</b></em>' attribute.
	 * The literals are from the enumeration {@link capone.UnaryOperator}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uoperator</em>' attribute.
	 * @see capone.UnaryOperator
	 * @see #setUoperator(UnaryOperator)
	 * @see capone.CaponePackage#getTerm_Uoperator()
	 * @model
	 * @generated
	 */
	UnaryOperator getUoperator();

	/**
	 * Sets the value of the '{@link capone.Term#getUoperator <em>Uoperator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uoperator</em>' attribute.
	 * @see capone.UnaryOperator
	 * @see #getUoperator()
	 * @generated
	 */
	void setUoperator(UnaryOperator value);

	/**
	 * Returns the value of the '<em><b>Next</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Next</em>' containment reference.
	 * @see #setNext(NextTerm)
	 * @see capone.CaponePackage#getTerm_Next()
	 * @model containment="true"
	 * @generated
	 */
	NextTerm getNext();

	/**
	 * Sets the value of the '{@link capone.Term#getNext <em>Next</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Next</em>' containment reference.
	 * @see #getNext()
	 * @generated
	 */
	void setNext(NextTerm value);

} // Term

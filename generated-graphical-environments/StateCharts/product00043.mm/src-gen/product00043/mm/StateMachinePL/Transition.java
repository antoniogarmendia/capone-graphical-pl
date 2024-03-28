/**
 */
package product00043.mm.StateMachinePL;

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
 *   <li>{@link product00043.mm.StateMachinePL.Transition#getFrom <em>From</em>}</li>
 *   <li>{@link product00043.mm.StateMachinePL.Transition#getTo <em>To</em>}</li>
 *   <li>{@link product00043.mm.StateMachinePL.Transition#getTime <em>Time</em>}</li>
 *   <li>{@link product00043.mm.StateMachinePL.Transition#isIsImmediate <em>Is Immediate</em>}</li>
 * </ul>
 *
 * @see product00043.mm.StateMachinePL.StateMachinePLPackage#getTransition()
 * @model
 * @generated
 */
public interface Transition extends EObject {
	/**
	 * Returns the value of the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From</em>' reference.
	 * @see #setFrom(State)
	 * @see product00043.mm.StateMachinePL.StateMachinePLPackage#getTransition_From()
	 * @model required="true"
	 * @generated
	 */
	State getFrom();

	/**
	 * Sets the value of the '{@link product00043.mm.StateMachinePL.Transition#getFrom <em>From</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From</em>' reference.
	 * @see #getFrom()
	 * @generated
	 */
	void setFrom(State value);

	/**
	 * Returns the value of the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To</em>' reference.
	 * @see #setTo(State)
	 * @see product00043.mm.StateMachinePL.StateMachinePLPackage#getTransition_To()
	 * @model required="true"
	 * @generated
	 */
	State getTo();

	/**
	 * Sets the value of the '{@link product00043.mm.StateMachinePL.Transition#getTo <em>To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To</em>' reference.
	 * @see #getTo()
	 * @generated
	 */
	void setTo(State value);

	/**
	 * Returns the value of the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time</em>' attribute.
	 * @see #setTime(int)
	 * @see product00043.mm.StateMachinePL.StateMachinePLPackage#getTransition_Time()
	 * @model
	 * @generated
	 */
	int getTime();

	/**
	 * Sets the value of the '{@link product00043.mm.StateMachinePL.Transition#getTime <em>Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time</em>' attribute.
	 * @see #getTime()
	 * @generated
	 */
	void setTime(int value);

	/**
	 * Returns the value of the '<em><b>Is Immediate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Immediate</em>' attribute.
	 * @see #setIsImmediate(boolean)
	 * @see product00043.mm.StateMachinePL.StateMachinePLPackage#getTransition_IsImmediate()
	 * @model
	 * @generated
	 */
	boolean isIsImmediate();

	/**
	 * Sets the value of the '{@link product00043.mm.StateMachinePL.Transition#isIsImmediate <em>Is Immediate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Immediate</em>' attribute.
	 * @see #isIsImmediate()
	 * @generated
	 */
	void setIsImmediate(boolean value);

} // Transition

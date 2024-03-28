/**
 */
package product00043.mm.StateMachinePL;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State Machine</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link product00043.mm.StateMachinePL.StateMachine#getStates <em>States</em>}</li>
 *   <li>{@link product00043.mm.StateMachinePL.StateMachine#getTransitions <em>Transitions</em>}</li>
 *   <li>{@link product00043.mm.StateMachinePL.StateMachine#getCurrentTime <em>Current Time</em>}</li>
 * </ul>
 *
 * @see product00043.mm.StateMachinePL.StateMachinePLPackage#getStateMachine()
 * @model
 * @generated
 */
public interface StateMachine extends EObject {
	/**
	 * Returns the value of the '<em><b>States</b></em>' containment reference list.
	 * The list contents are of type {@link product00043.mm.StateMachinePL.State}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>States</em>' containment reference list.
	 * @see product00043.mm.StateMachinePL.StateMachinePLPackage#getStateMachine_States()
	 * @model containment="true"
	 * @generated
	 */
	EList<State> getStates();

	/**
	 * Returns the value of the '<em><b>Transitions</b></em>' containment reference list.
	 * The list contents are of type {@link product00043.mm.StateMachinePL.Transition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transitions</em>' containment reference list.
	 * @see product00043.mm.StateMachinePL.StateMachinePLPackage#getStateMachine_Transitions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Transition> getTransitions();

	/**
	 * Returns the value of the '<em><b>Current Time</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current Time</em>' attribute.
	 * @see #setCurrentTime(int)
	 * @see product00043.mm.StateMachinePL.StateMachinePLPackage#getStateMachine_CurrentTime()
	 * @model default="0"
	 * @generated
	 */
	int getCurrentTime();

	/**
	 * Sets the value of the '{@link product00043.mm.StateMachinePL.StateMachine#getCurrentTime <em>Current Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current Time</em>' attribute.
	 * @see #getCurrentTime()
	 * @generated
	 */
	void setCurrentTime(int value);

} // StateMachine

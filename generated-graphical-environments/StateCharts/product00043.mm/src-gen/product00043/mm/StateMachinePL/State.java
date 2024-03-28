/**
 */
package product00043.mm.StateMachinePL;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link product00043.mm.StateMachinePL.State#isIsInitial <em>Is Initial</em>}</li>
 *   <li>{@link product00043.mm.StateMachinePL.State#isIsFinal <em>Is Final</em>}</li>
 *   <li>{@link product00043.mm.StateMachinePL.State#getEvent <em>Event</em>}</li>
 * </ul>
 *
 * @see product00043.mm.StateMachinePL.StateMachinePLPackage#getState()
 * @model
 * @generated
 */
public interface State extends EObject {
	/**
	 * Returns the value of the '<em><b>Is Initial</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Initial</em>' attribute.
	 * @see #setIsInitial(boolean)
	 * @see product00043.mm.StateMachinePL.StateMachinePLPackage#getState_IsInitial()
	 * @model
	 * @generated
	 */
	boolean isIsInitial();

	/**
	 * Sets the value of the '{@link product00043.mm.StateMachinePL.State#isIsInitial <em>Is Initial</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Initial</em>' attribute.
	 * @see #isIsInitial()
	 * @generated
	 */
	void setIsInitial(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Final</em>' attribute.
	 * @see #setIsFinal(boolean)
	 * @see product00043.mm.StateMachinePL.StateMachinePLPackage#getState_IsFinal()
	 * @model
	 * @generated
	 */
	boolean isIsFinal();

	/**
	 * Sets the value of the '{@link product00043.mm.StateMachinePL.State#isIsFinal <em>Is Final</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Final</em>' attribute.
	 * @see #isIsFinal()
	 * @generated
	 */
	void setIsFinal(boolean value);

	/**
	 * Returns the value of the '<em><b>Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event</em>' attribute.
	 * @see #setEvent(String)
	 * @see product00043.mm.StateMachinePL.StateMachinePLPackage#getState_Event()
	 * @model
	 * @generated
	 */
	String getEvent();

	/**
	 * Sets the value of the '{@link product00043.mm.StateMachinePL.State#getEvent <em>Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event</em>' attribute.
	 * @see #getEvent()
	 * @generated
	 */
	void setEvent(String value);

} // State

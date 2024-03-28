/**
 */
package product00043.mm.StateMachinePL;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see product00043.mm.StateMachinePL.StateMachinePLFactory
 * @model kind="package"
 * @generated
 */
public interface StateMachinePLPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "StateMachinePL";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://statemachines/product00043";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "statemachines";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StateMachinePLPackage eINSTANCE = product00043.mm.StateMachinePL.impl.StateMachinePLPackageImpl.init();

	/**
	 * The meta object id for the '{@link product00043.mm.StateMachinePL.impl.StateMachineImpl <em>State Machine</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see product00043.mm.StateMachinePL.impl.StateMachineImpl
	 * @see product00043.mm.StateMachinePL.impl.StateMachinePLPackageImpl#getStateMachine()
	 * @generated
	 */
	int STATE_MACHINE = 0;

	/**
	 * The feature id for the '<em><b>States</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE__STATES = 0;

	/**
	 * The feature id for the '<em><b>Transitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE__TRANSITIONS = 1;

	/**
	 * The feature id for the '<em><b>Current Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE__CURRENT_TIME = 2;

	/**
	 * The number of structural features of the '<em>State Machine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>State Machine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link product00043.mm.StateMachinePL.impl.StateImpl <em>State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see product00043.mm.StateMachinePL.impl.StateImpl
	 * @see product00043.mm.StateMachinePL.impl.StateMachinePLPackageImpl#getState()
	 * @generated
	 */
	int STATE = 1;

	/**
	 * The feature id for the '<em><b>Is Initial</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__IS_INITIAL = 0;

	/**
	 * The feature id for the '<em><b>Is Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__IS_FINAL = 1;

	/**
	 * The feature id for the '<em><b>Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__EVENT = 2;

	/**
	 * The number of structural features of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link product00043.mm.StateMachinePL.impl.TransitionImpl <em>Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see product00043.mm.StateMachinePL.impl.TransitionImpl
	 * @see product00043.mm.StateMachinePL.impl.StateMachinePLPackageImpl#getTransition()
	 * @generated
	 */
	int TRANSITION = 2;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__FROM = 0;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__TO = 1;

	/**
	 * The feature id for the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__TIME = 2;

	/**
	 * The feature id for the '<em><b>Is Immediate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__IS_IMMEDIATE = 3;

	/**
	 * The number of structural features of the '<em>Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link product00043.mm.StateMachinePL.impl.CompositeStateImpl <em>Composite State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see product00043.mm.StateMachinePL.impl.CompositeStateImpl
	 * @see product00043.mm.StateMachinePL.impl.StateMachinePLPackageImpl#getCompositeState()
	 * @generated
	 */
	int COMPOSITE_STATE = 3;

	/**
	 * The feature id for the '<em><b>Is Initial</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_STATE__IS_INITIAL = STATE__IS_INITIAL;

	/**
	 * The feature id for the '<em><b>Is Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_STATE__IS_FINAL = STATE__IS_FINAL;

	/**
	 * The feature id for the '<em><b>Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_STATE__EVENT = STATE__EVENT;

	/**
	 * The feature id for the '<em><b>Regions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_STATE__REGIONS = STATE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Composite State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_STATE_FEATURE_COUNT = STATE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Composite State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_STATE_OPERATION_COUNT = STATE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link product00043.mm.StateMachinePL.impl.OrthogonalRegionImpl <em>Orthogonal Region</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see product00043.mm.StateMachinePL.impl.OrthogonalRegionImpl
	 * @see product00043.mm.StateMachinePL.impl.StateMachinePLPackageImpl#getOrthogonalRegion()
	 * @generated
	 */
	int ORTHOGONAL_REGION = 4;

	/**
	 * The feature id for the '<em><b>States</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORTHOGONAL_REGION__STATES = 0;

	/**
	 * The number of structural features of the '<em>Orthogonal Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORTHOGONAL_REGION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Orthogonal Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORTHOGONAL_REGION_OPERATION_COUNT = 0;

	/**
	 * Returns the meta object for class '{@link product00043.mm.StateMachinePL.StateMachine <em>State Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State Machine</em>'.
	 * @see product00043.mm.StateMachinePL.StateMachine
	 * @generated
	 */
	EClass getStateMachine();

	/**
	 * Returns the meta object for the containment reference list '{@link product00043.mm.StateMachinePL.StateMachine#getStates <em>States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>States</em>'.
	 * @see product00043.mm.StateMachinePL.StateMachine#getStates()
	 * @see #getStateMachine()
	 * @generated
	 */
	EReference getStateMachine_States();

	/**
	 * Returns the meta object for the containment reference list '{@link product00043.mm.StateMachinePL.StateMachine#getTransitions <em>Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Transitions</em>'.
	 * @see product00043.mm.StateMachinePL.StateMachine#getTransitions()
	 * @see #getStateMachine()
	 * @generated
	 */
	EReference getStateMachine_Transitions();

	/**
	 * Returns the meta object for the attribute '{@link product00043.mm.StateMachinePL.StateMachine#getCurrentTime <em>Current Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Current Time</em>'.
	 * @see product00043.mm.StateMachinePL.StateMachine#getCurrentTime()
	 * @see #getStateMachine()
	 * @generated
	 */
	EAttribute getStateMachine_CurrentTime();

	/**
	 * Returns the meta object for class '{@link product00043.mm.StateMachinePL.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State</em>'.
	 * @see product00043.mm.StateMachinePL.State
	 * @generated
	 */
	EClass getState();

	/**
	 * Returns the meta object for the attribute '{@link product00043.mm.StateMachinePL.State#isIsInitial <em>Is Initial</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Initial</em>'.
	 * @see product00043.mm.StateMachinePL.State#isIsInitial()
	 * @see #getState()
	 * @generated
	 */
	EAttribute getState_IsInitial();

	/**
	 * Returns the meta object for the attribute '{@link product00043.mm.StateMachinePL.State#isIsFinal <em>Is Final</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Final</em>'.
	 * @see product00043.mm.StateMachinePL.State#isIsFinal()
	 * @see #getState()
	 * @generated
	 */
	EAttribute getState_IsFinal();

	/**
	 * Returns the meta object for the attribute '{@link product00043.mm.StateMachinePL.State#getEvent <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Event</em>'.
	 * @see product00043.mm.StateMachinePL.State#getEvent()
	 * @see #getState()
	 * @generated
	 */
	EAttribute getState_Event();

	/**
	 * Returns the meta object for class '{@link product00043.mm.StateMachinePL.Transition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transition</em>'.
	 * @see product00043.mm.StateMachinePL.Transition
	 * @generated
	 */
	EClass getTransition();

	/**
	 * Returns the meta object for the reference '{@link product00043.mm.StateMachinePL.Transition#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>From</em>'.
	 * @see product00043.mm.StateMachinePL.Transition#getFrom()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_From();

	/**
	 * Returns the meta object for the reference '{@link product00043.mm.StateMachinePL.Transition#getTo <em>To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>To</em>'.
	 * @see product00043.mm.StateMachinePL.Transition#getTo()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_To();

	/**
	 * Returns the meta object for the attribute '{@link product00043.mm.StateMachinePL.Transition#getTime <em>Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time</em>'.
	 * @see product00043.mm.StateMachinePL.Transition#getTime()
	 * @see #getTransition()
	 * @generated
	 */
	EAttribute getTransition_Time();

	/**
	 * Returns the meta object for the attribute '{@link product00043.mm.StateMachinePL.Transition#isIsImmediate <em>Is Immediate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Immediate</em>'.
	 * @see product00043.mm.StateMachinePL.Transition#isIsImmediate()
	 * @see #getTransition()
	 * @generated
	 */
	EAttribute getTransition_IsImmediate();

	/**
	 * Returns the meta object for class '{@link product00043.mm.StateMachinePL.CompositeState <em>Composite State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite State</em>'.
	 * @see product00043.mm.StateMachinePL.CompositeState
	 * @generated
	 */
	EClass getCompositeState();

	/**
	 * Returns the meta object for the containment reference list '{@link product00043.mm.StateMachinePL.CompositeState#getRegions <em>Regions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Regions</em>'.
	 * @see product00043.mm.StateMachinePL.CompositeState#getRegions()
	 * @see #getCompositeState()
	 * @generated
	 */
	EReference getCompositeState_Regions();

	/**
	 * Returns the meta object for class '{@link product00043.mm.StateMachinePL.OrthogonalRegion <em>Orthogonal Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Orthogonal Region</em>'.
	 * @see product00043.mm.StateMachinePL.OrthogonalRegion
	 * @generated
	 */
	EClass getOrthogonalRegion();

	/**
	 * Returns the meta object for the containment reference list '{@link product00043.mm.StateMachinePL.OrthogonalRegion#getStates <em>States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>States</em>'.
	 * @see product00043.mm.StateMachinePL.OrthogonalRegion#getStates()
	 * @see #getOrthogonalRegion()
	 * @generated
	 */
	EReference getOrthogonalRegion_States();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	StateMachinePLFactory getStateMachinePLFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link product00043.mm.StateMachinePL.impl.StateMachineImpl <em>State Machine</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see product00043.mm.StateMachinePL.impl.StateMachineImpl
		 * @see product00043.mm.StateMachinePL.impl.StateMachinePLPackageImpl#getStateMachine()
		 * @generated
		 */
		EClass STATE_MACHINE = eINSTANCE.getStateMachine();

		/**
		 * The meta object literal for the '<em><b>States</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_MACHINE__STATES = eINSTANCE.getStateMachine_States();

		/**
		 * The meta object literal for the '<em><b>Transitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_MACHINE__TRANSITIONS = eINSTANCE.getStateMachine_Transitions();

		/**
		 * The meta object literal for the '<em><b>Current Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE_MACHINE__CURRENT_TIME = eINSTANCE.getStateMachine_CurrentTime();

		/**
		 * The meta object literal for the '{@link product00043.mm.StateMachinePL.impl.StateImpl <em>State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see product00043.mm.StateMachinePL.impl.StateImpl
		 * @see product00043.mm.StateMachinePL.impl.StateMachinePLPackageImpl#getState()
		 * @generated
		 */
		EClass STATE = eINSTANCE.getState();

		/**
		 * The meta object literal for the '<em><b>Is Initial</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE__IS_INITIAL = eINSTANCE.getState_IsInitial();

		/**
		 * The meta object literal for the '<em><b>Is Final</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE__IS_FINAL = eINSTANCE.getState_IsFinal();

		/**
		 * The meta object literal for the '<em><b>Event</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE__EVENT = eINSTANCE.getState_Event();

		/**
		 * The meta object literal for the '{@link product00043.mm.StateMachinePL.impl.TransitionImpl <em>Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see product00043.mm.StateMachinePL.impl.TransitionImpl
		 * @see product00043.mm.StateMachinePL.impl.StateMachinePLPackageImpl#getTransition()
		 * @generated
		 */
		EClass TRANSITION = eINSTANCE.getTransition();

		/**
		 * The meta object literal for the '<em><b>From</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__FROM = eINSTANCE.getTransition_From();

		/**
		 * The meta object literal for the '<em><b>To</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__TO = eINSTANCE.getTransition_To();

		/**
		 * The meta object literal for the '<em><b>Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSITION__TIME = eINSTANCE.getTransition_Time();

		/**
		 * The meta object literal for the '<em><b>Is Immediate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSITION__IS_IMMEDIATE = eINSTANCE.getTransition_IsImmediate();

		/**
		 * The meta object literal for the '{@link product00043.mm.StateMachinePL.impl.CompositeStateImpl <em>Composite State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see product00043.mm.StateMachinePL.impl.CompositeStateImpl
		 * @see product00043.mm.StateMachinePL.impl.StateMachinePLPackageImpl#getCompositeState()
		 * @generated
		 */
		EClass COMPOSITE_STATE = eINSTANCE.getCompositeState();

		/**
		 * The meta object literal for the '<em><b>Regions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_STATE__REGIONS = eINSTANCE.getCompositeState_Regions();

		/**
		 * The meta object literal for the '{@link product00043.mm.StateMachinePL.impl.OrthogonalRegionImpl <em>Orthogonal Region</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see product00043.mm.StateMachinePL.impl.OrthogonalRegionImpl
		 * @see product00043.mm.StateMachinePL.impl.StateMachinePLPackageImpl#getOrthogonalRegion()
		 * @generated
		 */
		EClass ORTHOGONAL_REGION = eINSTANCE.getOrthogonalRegion();

		/**
		 * The meta object literal for the '<em><b>States</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ORTHOGONAL_REGION__STATES = eINSTANCE.getOrthogonalRegion_States();

	}

} //StateMachinePLPackage

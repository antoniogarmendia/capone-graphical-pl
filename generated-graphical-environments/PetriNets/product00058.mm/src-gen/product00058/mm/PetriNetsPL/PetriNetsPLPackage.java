/**
 */
package product00058.mm.PetriNetsPL;

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
 * @see product00058.mm.PetriNetsPL.PetriNetsPLFactory
 * @model kind="package"
 * @generated
 */
public interface PetriNetsPLPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "PetriNetsPL";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://petrinets/product00058";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "petrinets";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PetriNetsPLPackage eINSTANCE = product00058.mm.PetriNetsPL.impl.PetriNetsPLPackageImpl.init();

	/**
	 * The meta object id for the '{@link product00058.mm.PetriNetsPL.impl.PetriNetImpl <em>Petri Net</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see product00058.mm.PetriNetsPL.impl.PetriNetImpl
	 * @see product00058.mm.PetriNetsPL.impl.PetriNetsPLPackageImpl#getPetriNet()
	 * @generated
	 */
	int PETRI_NET = 0;

	/**
	 * The feature id for the '<em><b>Places</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PETRI_NET__PLACES = 0;

	/**
	 * The feature id for the '<em><b>Transitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PETRI_NET__TRANSITIONS = 1;

	/**
	 * The number of structural features of the '<em>Petri Net</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PETRI_NET_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Petri Net</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PETRI_NET_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link product00058.mm.PetriNetsPL.impl.PlaceImpl <em>Place</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see product00058.mm.PetriNetsPL.impl.PlaceImpl
	 * @see product00058.mm.PetriNetsPL.impl.PetriNetsPLPackageImpl#getPlace()
	 * @generated
	 */
	int PLACE = 1;

	/**
	 * The feature id for the '<em><b>Tokens</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__TOKENS = 0;

	/**
	 * The number of structural features of the '<em>Place</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Place</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link product00058.mm.PetriNetsPL.impl.TransitionImpl <em>Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see product00058.mm.PetriNetsPL.impl.TransitionImpl
	 * @see product00058.mm.PetriNetsPL.impl.PetriNetsPLPackageImpl#getTransition()
	 * @generated
	 */
	int TRANSITION = 2;

	/**
	 * The feature id for the '<em><b>In Places</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__IN_PLACES = 0;

	/**
	 * The feature id for the '<em><b>Out Places</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__OUT_PLACES = 1;

	/**
	 * The feature id for the '<em><b>Inhibitor Places</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__INHIBITOR_PLACES = 2;

	/**
	 * The feature id for the '<em><b>Read Places</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__READ_PLACES = 3;

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
	 * Returns the meta object for class '{@link product00058.mm.PetriNetsPL.PetriNet <em>Petri Net</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Petri Net</em>'.
	 * @see product00058.mm.PetriNetsPL.PetriNet
	 * @generated
	 */
	EClass getPetriNet();

	/**
	 * Returns the meta object for the containment reference list '{@link product00058.mm.PetriNetsPL.PetriNet#getPlaces <em>Places</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Places</em>'.
	 * @see product00058.mm.PetriNetsPL.PetriNet#getPlaces()
	 * @see #getPetriNet()
	 * @generated
	 */
	EReference getPetriNet_Places();

	/**
	 * Returns the meta object for the containment reference list '{@link product00058.mm.PetriNetsPL.PetriNet#getTransitions <em>Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Transitions</em>'.
	 * @see product00058.mm.PetriNetsPL.PetriNet#getTransitions()
	 * @see #getPetriNet()
	 * @generated
	 */
	EReference getPetriNet_Transitions();

	/**
	 * Returns the meta object for class '{@link product00058.mm.PetriNetsPL.Place <em>Place</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Place</em>'.
	 * @see product00058.mm.PetriNetsPL.Place
	 * @generated
	 */
	EClass getPlace();

	/**
	 * Returns the meta object for the attribute '{@link product00058.mm.PetriNetsPL.Place#getTokens <em>Tokens</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tokens</em>'.
	 * @see product00058.mm.PetriNetsPL.Place#getTokens()
	 * @see #getPlace()
	 * @generated
	 */
	EAttribute getPlace_Tokens();

	/**
	 * Returns the meta object for class '{@link product00058.mm.PetriNetsPL.Transition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transition</em>'.
	 * @see product00058.mm.PetriNetsPL.Transition
	 * @generated
	 */
	EClass getTransition();

	/**
	 * Returns the meta object for the reference list '{@link product00058.mm.PetriNetsPL.Transition#getInPlaces <em>In Places</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>In Places</em>'.
	 * @see product00058.mm.PetriNetsPL.Transition#getInPlaces()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_InPlaces();

	/**
	 * Returns the meta object for the reference list '{@link product00058.mm.PetriNetsPL.Transition#getOutPlaces <em>Out Places</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Out Places</em>'.
	 * @see product00058.mm.PetriNetsPL.Transition#getOutPlaces()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_OutPlaces();

	/**
	 * Returns the meta object for the reference list '{@link product00058.mm.PetriNetsPL.Transition#getInhibitorPlaces <em>Inhibitor Places</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Inhibitor Places</em>'.
	 * @see product00058.mm.PetriNetsPL.Transition#getInhibitorPlaces()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_InhibitorPlaces();

	/**
	 * Returns the meta object for the reference list '{@link product00058.mm.PetriNetsPL.Transition#getReadPlaces <em>Read Places</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Read Places</em>'.
	 * @see product00058.mm.PetriNetsPL.Transition#getReadPlaces()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_ReadPlaces();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PetriNetsPLFactory getPetriNetsPLFactory();

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
		 * The meta object literal for the '{@link product00058.mm.PetriNetsPL.impl.PetriNetImpl <em>Petri Net</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see product00058.mm.PetriNetsPL.impl.PetriNetImpl
		 * @see product00058.mm.PetriNetsPL.impl.PetriNetsPLPackageImpl#getPetriNet()
		 * @generated
		 */
		EClass PETRI_NET = eINSTANCE.getPetriNet();

		/**
		 * The meta object literal for the '<em><b>Places</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PETRI_NET__PLACES = eINSTANCE.getPetriNet_Places();

		/**
		 * The meta object literal for the '<em><b>Transitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PETRI_NET__TRANSITIONS = eINSTANCE.getPetriNet_Transitions();

		/**
		 * The meta object literal for the '{@link product00058.mm.PetriNetsPL.impl.PlaceImpl <em>Place</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see product00058.mm.PetriNetsPL.impl.PlaceImpl
		 * @see product00058.mm.PetriNetsPL.impl.PetriNetsPLPackageImpl#getPlace()
		 * @generated
		 */
		EClass PLACE = eINSTANCE.getPlace();

		/**
		 * The meta object literal for the '<em><b>Tokens</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLACE__TOKENS = eINSTANCE.getPlace_Tokens();

		/**
		 * The meta object literal for the '{@link product00058.mm.PetriNetsPL.impl.TransitionImpl <em>Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see product00058.mm.PetriNetsPL.impl.TransitionImpl
		 * @see product00058.mm.PetriNetsPL.impl.PetriNetsPLPackageImpl#getTransition()
		 * @generated
		 */
		EClass TRANSITION = eINSTANCE.getTransition();

		/**
		 * The meta object literal for the '<em><b>In Places</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__IN_PLACES = eINSTANCE.getTransition_InPlaces();

		/**
		 * The meta object literal for the '<em><b>Out Places</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__OUT_PLACES = eINSTANCE.getTransition_OutPlaces();

		/**
		 * The meta object literal for the '<em><b>Inhibitor Places</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__INHIBITOR_PLACES = eINSTANCE.getTransition_InhibitorPlaces();

		/**
		 * The meta object literal for the '<em><b>Read Places</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__READ_PLACES = eINSTANCE.getTransition_ReadPlaces();

	}

} //PetriNetsPLPackage

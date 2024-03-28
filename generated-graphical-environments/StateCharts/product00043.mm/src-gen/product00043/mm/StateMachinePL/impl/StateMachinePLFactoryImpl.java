/**
 */
package product00043.mm.StateMachinePL.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import product00043.mm.StateMachinePL.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StateMachinePLFactoryImpl extends EFactoryImpl implements StateMachinePLFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static StateMachinePLFactory init() {
		try {
			StateMachinePLFactory theStateMachinePLFactory = (StateMachinePLFactory) EPackage.Registry.INSTANCE
					.getEFactory(StateMachinePLPackage.eNS_URI);
			if (theStateMachinePLFactory != null) {
				return theStateMachinePLFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new StateMachinePLFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateMachinePLFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case StateMachinePLPackage.STATE_MACHINE:
			return createStateMachine();
		case StateMachinePLPackage.STATE:
			return createState();
		case StateMachinePLPackage.TRANSITION:
			return createTransition();
		case StateMachinePLPackage.COMPOSITE_STATE:
			return createCompositeState();
		case StateMachinePLPackage.ORTHOGONAL_REGION:
			return createOrthogonalRegion();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StateMachine createStateMachine() {
		StateMachineImpl stateMachine = new StateMachineImpl();
		return stateMachine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public State createState() {
		StateImpl state = new StateImpl();
		return state;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Transition createTransition() {
		TransitionImpl transition = new TransitionImpl();
		return transition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CompositeState createCompositeState() {
		CompositeStateImpl compositeState = new CompositeStateImpl();
		return compositeState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OrthogonalRegion createOrthogonalRegion() {
		OrthogonalRegionImpl orthogonalRegion = new OrthogonalRegionImpl();
		return orthogonalRegion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StateMachinePLPackage getStateMachinePLPackage() {
		return (StateMachinePLPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static StateMachinePLPackage getPackage() {
		return StateMachinePLPackage.eINSTANCE;
	}

} //StateMachinePLFactoryImpl

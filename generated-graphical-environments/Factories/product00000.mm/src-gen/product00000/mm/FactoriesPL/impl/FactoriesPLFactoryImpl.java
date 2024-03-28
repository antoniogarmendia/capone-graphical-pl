/**
 */
package product00000.mm.FactoriesPL.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import product00000.mm.FactoriesPL.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FactoriesPLFactoryImpl extends EFactoryImpl implements FactoriesPLFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FactoriesPLFactory init() {
		try {
			FactoriesPLFactory theFactoriesPLFactory = (FactoriesPLFactory) EPackage.Registry.INSTANCE
					.getEFactory(FactoriesPLPackage.eNS_URI);
			if (theFactoriesPLFactory != null) {
				return theFactoriesPLFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new FactoriesPLFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FactoriesPLFactoryImpl() {
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
		case FactoriesPLPackage.FACTORY:
			return createFactory();
		case FactoriesPLPackage.MACHINE:
			return createMachine();
		case FactoriesPLPackage.CONVEYOR:
			return createConveyor();
		case FactoriesPLPackage.PART:
			return createPart();
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
	public Factory createFactory() {
		FactoryImpl factory = new FactoryImpl();
		return factory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Machine createMachine() {
		MachineImpl machine = new MachineImpl();
		return machine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Conveyor createConveyor() {
		ConveyorImpl conveyor = new ConveyorImpl();
		return conveyor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Part createPart() {
		PartImpl part = new PartImpl();
		return part;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FactoriesPLPackage getFactoriesPLPackage() {
		return (FactoriesPLPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static FactoriesPLPackage getPackage() {
		return FactoriesPLPackage.eINSTANCE;
	}

} //FactoriesPLFactoryImpl

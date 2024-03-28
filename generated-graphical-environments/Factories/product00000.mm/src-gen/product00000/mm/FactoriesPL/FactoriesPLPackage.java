/**
 */
package product00000.mm.FactoriesPL;

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
 * @see product00000.mm.FactoriesPL.FactoriesPLFactory
 * @model kind="package"
 * @generated
 */
public interface FactoriesPLPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "FactoriesPL";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://factories/product00000";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "factories";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FactoriesPLPackage eINSTANCE = product00000.mm.FactoriesPL.impl.FactoriesPLPackageImpl.init();

	/**
	 * The meta object id for the '{@link product00000.mm.FactoriesPL.impl.FactoryImpl <em>Factory</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see product00000.mm.FactoriesPL.impl.FactoryImpl
	 * @see product00000.mm.FactoriesPL.impl.FactoriesPLPackageImpl#getFactory()
	 * @generated
	 */
	int FACTORY = 0;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACTORY__ELEMENTS = 0;

	/**
	 * The number of structural features of the '<em>Factory</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACTORY_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Factory</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACTORY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link product00000.mm.FactoriesPL.impl.FElementImpl <em>FElement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see product00000.mm.FactoriesPL.impl.FElementImpl
	 * @see product00000.mm.FactoriesPL.impl.FactoriesPLPackageImpl#getFElement()
	 * @generated
	 */
	int FELEMENT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FELEMENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FELEMENT__PARTS = 1;

	/**
	 * The number of structural features of the '<em>FElement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FELEMENT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>FElement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link product00000.mm.FactoriesPL.impl.MachineImpl <em>Machine</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see product00000.mm.FactoriesPL.impl.MachineImpl
	 * @see product00000.mm.FactoriesPL.impl.FactoriesPLPackageImpl#getMachine()
	 * @generated
	 */
	int MACHINE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE__NAME = FELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE__PARTS = FELEMENT__PARTS;

	/**
	 * The feature id for the '<em><b>Inps</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE__INPS = FELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Outs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE__OUTS = FELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Machine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_FEATURE_COUNT = FELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Machine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_OPERATION_COUNT = FELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link product00000.mm.FactoriesPL.impl.ConveyorImpl <em>Conveyor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see product00000.mm.FactoriesPL.impl.ConveyorImpl
	 * @see product00000.mm.FactoriesPL.impl.FactoriesPLPackageImpl#getConveyor()
	 * @generated
	 */
	int CONVEYOR = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVEYOR__NAME = FELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVEYOR__PARTS = FELEMENT__PARTS;

	/**
	 * The number of structural features of the '<em>Conveyor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVEYOR_FEATURE_COUNT = FELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Conveyor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVEYOR_OPERATION_COUNT = FELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link product00000.mm.FactoriesPL.impl.PartImpl <em>Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see product00000.mm.FactoriesPL.impl.PartImpl
	 * @see product00000.mm.FactoriesPL.impl.FactoriesPLPackageImpl#getPart()
	 * @generated
	 */
	int PART = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PART__NAME = 0;

	/**
	 * The number of structural features of the '<em>Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PART_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PART_OPERATION_COUNT = 0;

	/**
	 * Returns the meta object for class '{@link product00000.mm.FactoriesPL.Factory <em>Factory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Factory</em>'.
	 * @see product00000.mm.FactoriesPL.Factory
	 * @generated
	 */
	EClass getFactory();

	/**
	 * Returns the meta object for the containment reference list '{@link product00000.mm.FactoriesPL.Factory#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see product00000.mm.FactoriesPL.Factory#getElements()
	 * @see #getFactory()
	 * @generated
	 */
	EReference getFactory_Elements();

	/**
	 * Returns the meta object for class '{@link product00000.mm.FactoriesPL.Machine <em>Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Machine</em>'.
	 * @see product00000.mm.FactoriesPL.Machine
	 * @generated
	 */
	EClass getMachine();

	/**
	 * Returns the meta object for the reference list '{@link product00000.mm.FactoriesPL.Machine#getInps <em>Inps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Inps</em>'.
	 * @see product00000.mm.FactoriesPL.Machine#getInps()
	 * @see #getMachine()
	 * @generated
	 */
	EReference getMachine_Inps();

	/**
	 * Returns the meta object for the reference list '{@link product00000.mm.FactoriesPL.Machine#getOuts <em>Outs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outs</em>'.
	 * @see product00000.mm.FactoriesPL.Machine#getOuts()
	 * @see #getMachine()
	 * @generated
	 */
	EReference getMachine_Outs();

	/**
	 * Returns the meta object for class '{@link product00000.mm.FactoriesPL.Conveyor <em>Conveyor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Conveyor</em>'.
	 * @see product00000.mm.FactoriesPL.Conveyor
	 * @generated
	 */
	EClass getConveyor();

	/**
	 * Returns the meta object for class '{@link product00000.mm.FactoriesPL.FElement <em>FElement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FElement</em>'.
	 * @see product00000.mm.FactoriesPL.FElement
	 * @generated
	 */
	EClass getFElement();

	/**
	 * Returns the meta object for the attribute '{@link product00000.mm.FactoriesPL.FElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see product00000.mm.FactoriesPL.FElement#getName()
	 * @see #getFElement()
	 * @generated
	 */
	EAttribute getFElement_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link product00000.mm.FactoriesPL.FElement#getParts <em>Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parts</em>'.
	 * @see product00000.mm.FactoriesPL.FElement#getParts()
	 * @see #getFElement()
	 * @generated
	 */
	EReference getFElement_Parts();

	/**
	 * Returns the meta object for class '{@link product00000.mm.FactoriesPL.Part <em>Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Part</em>'.
	 * @see product00000.mm.FactoriesPL.Part
	 * @generated
	 */
	EClass getPart();

	/**
	 * Returns the meta object for the attribute '{@link product00000.mm.FactoriesPL.Part#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see product00000.mm.FactoriesPL.Part#getName()
	 * @see #getPart()
	 * @generated
	 */
	EAttribute getPart_Name();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	FactoriesPLFactory getFactoriesPLFactory();

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
		 * The meta object literal for the '{@link product00000.mm.FactoriesPL.impl.FactoryImpl <em>Factory</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see product00000.mm.FactoriesPL.impl.FactoryImpl
		 * @see product00000.mm.FactoriesPL.impl.FactoriesPLPackageImpl#getFactory()
		 * @generated
		 */
		EClass FACTORY = eINSTANCE.getFactory();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FACTORY__ELEMENTS = eINSTANCE.getFactory_Elements();

		/**
		 * The meta object literal for the '{@link product00000.mm.FactoriesPL.impl.MachineImpl <em>Machine</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see product00000.mm.FactoriesPL.impl.MachineImpl
		 * @see product00000.mm.FactoriesPL.impl.FactoriesPLPackageImpl#getMachine()
		 * @generated
		 */
		EClass MACHINE = eINSTANCE.getMachine();

		/**
		 * The meta object literal for the '<em><b>Inps</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MACHINE__INPS = eINSTANCE.getMachine_Inps();

		/**
		 * The meta object literal for the '<em><b>Outs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MACHINE__OUTS = eINSTANCE.getMachine_Outs();

		/**
		 * The meta object literal for the '{@link product00000.mm.FactoriesPL.impl.ConveyorImpl <em>Conveyor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see product00000.mm.FactoriesPL.impl.ConveyorImpl
		 * @see product00000.mm.FactoriesPL.impl.FactoriesPLPackageImpl#getConveyor()
		 * @generated
		 */
		EClass CONVEYOR = eINSTANCE.getConveyor();

		/**
		 * The meta object literal for the '{@link product00000.mm.FactoriesPL.impl.FElementImpl <em>FElement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see product00000.mm.FactoriesPL.impl.FElementImpl
		 * @see product00000.mm.FactoriesPL.impl.FactoriesPLPackageImpl#getFElement()
		 * @generated
		 */
		EClass FELEMENT = eINSTANCE.getFElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FELEMENT__NAME = eINSTANCE.getFElement_Name();

		/**
		 * The meta object literal for the '<em><b>Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FELEMENT__PARTS = eINSTANCE.getFElement_Parts();

		/**
		 * The meta object literal for the '{@link product00000.mm.FactoriesPL.impl.PartImpl <em>Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see product00000.mm.FactoriesPL.impl.PartImpl
		 * @see product00000.mm.FactoriesPL.impl.FactoriesPLPackageImpl#getPart()
		 * @generated
		 */
		EClass PART = eINSTANCE.getPart();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PART__NAME = eINSTANCE.getPart_Name();

	}

} //FactoriesPLPackage

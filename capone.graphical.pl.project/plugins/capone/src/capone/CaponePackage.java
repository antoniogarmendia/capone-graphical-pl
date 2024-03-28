/**
 */
package capone;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
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
 * @see capone.CaponeFactory
 * @model kind="package"
 * @generated
 */
public interface CaponePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "capone";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://capone/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "capone";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CaponePackage eINSTANCE = capone.impl.CaponePackageImpl.init();

	/**
	 * The meta object id for the '{@link capone.impl.ModuleImpl <em>Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see capone.impl.ModuleImpl
	 * @see capone.impl.CaponePackageImpl#getModule()
	 * @generated
	 */
	int MODULE = 0;

	/**
	 * The feature id for the '<em><b>Is Top</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__IS_TOP = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__NAME = 1;

	/**
	 * The feature id for the '<em><b>Metamodel</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__METAMODEL = 2;

	/**
	 * The feature id for the '<em><b>Module Mandatory</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__MODULE_MANDATORY = 3;

	/**
	 * The feature id for the '<em><b>Module Optional</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__MODULE_OPTIONAL = 4;

	/**
	 * The feature id for the '<em><b>Module Alternative</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__MODULE_ALTERNATIVE = 5;

	/**
	 * The feature id for the '<em><b>Module Or</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__MODULE_OR = 6;

	/**
	 * The feature id for the '<em><b>Rules</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__RULES = 7;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__IMPORTS = 8;

	/**
	 * The feature id for the '<em><b>Formula</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__FORMULA = 9;

	/**
	 * The feature id for the '<em><b>Choose Diagram</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__CHOOSE_DIAGRAM = 10;

	/**
	 * The number of structural features of the '<em>Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_FEATURE_COUNT = 11;

	/**
	 * The operation id for the '<em>Get All Module Dependencies</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE___GET_ALL_MODULE_DEPENDENCIES = 0;

	/**
	 * The number of operations of the '<em>Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link capone.impl.RuleImpl <em>Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see capone.impl.RuleImpl
	 * @see capone.impl.CaponePackageImpl#getRule()
	 * @generated
	 */
	int RULE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Extendsrule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__EXTENDSRULE = 1;

	/**
	 * The number of structural features of the '<em>Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link capone.impl.DiagramImpl <em>Diagram</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see capone.impl.DiagramImpl
	 * @see capone.impl.CaponePackageImpl#getDiagram()
	 * @generated
	 */
	int DIAGRAM = 2;

	/**
	 * The feature id for the '<em><b>Viewpoint File URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM__VIEWPOINT_FILE_URI = 0;

	/**
	 * The feature id for the '<em><b>Overrides Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM__OVERRIDES_ELEMENTS = 1;

	/**
	 * The feature id for the '<em><b>Merge</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM__MERGE = 2;

	/**
	 * The number of structural features of the '<em>Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link capone.impl.RuleSetImpl <em>Rule Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see capone.impl.RuleSetImpl
	 * @see capone.impl.CaponePackageImpl#getRuleSet()
	 * @generated
	 */
	int RULE_SET = 3;

	/**
	 * The feature id for the '<em><b>Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SET__RULES = 0;

	/**
	 * The feature id for the '<em><b>Rulefile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SET__RULEFILE = 1;

	/**
	 * The number of structural features of the '<em>Rule Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SET_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Rule Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SET_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link capone.impl.FileURIImpl <em>File URI</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see capone.impl.FileURIImpl
	 * @see capone.impl.CaponePackageImpl#getFileURI()
	 * @generated
	 */
	int FILE_URI = 4;

	/**
	 * The feature id for the '<em><b>Import URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_URI__IMPORT_URI = 0;

	/**
	 * The number of structural features of the '<em>File URI</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_URI_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>File URI</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_URI_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link capone.impl.FormulaImpl <em>Formula</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see capone.impl.FormulaImpl
	 * @see capone.impl.CaponePackageImpl#getFormula()
	 * @generated
	 */
	int FORMULA = 5;

	/**
	 * The feature id for the '<em><b>Term</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMULA__TERM = 0;

	/**
	 * The number of structural features of the '<em>Formula</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMULA_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Formula</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMULA_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link capone.impl.TermImpl <em>Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see capone.impl.TermImpl
	 * @see capone.impl.CaponePackageImpl#getTerm()
	 * @generated
	 */
	int TERM = 6;

	/**
	 * The feature id for the '<em><b>Uoperator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM__UOPERATOR = 0;

	/**
	 * The feature id for the '<em><b>Next</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM__NEXT = 1;

	/**
	 * The number of structural features of the '<em>Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link capone.impl.NextTermImpl <em>Next Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see capone.impl.NextTermImpl
	 * @see capone.impl.CaponePackageImpl#getNextTerm()
	 * @generated
	 */
	int NEXT_TERM = 7;

	/**
	 * The feature id for the '<em><b>Boperator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEXT_TERM__BOPERATOR = 0;

	/**
	 * The feature id for the '<em><b>Term</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEXT_TERM__TERM = 1;

	/**
	 * The number of structural features of the '<em>Next Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEXT_TERM_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Next Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEXT_TERM_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link capone.impl.UnaryTermImpl <em>Unary Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see capone.impl.UnaryTermImpl
	 * @see capone.impl.CaponePackageImpl#getUnaryTerm()
	 * @generated
	 */
	int UNARY_TERM = 8;

	/**
	 * The feature id for the '<em><b>Uoperator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_TERM__UOPERATOR = TERM__UOPERATOR;

	/**
	 * The feature id for the '<em><b>Next</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_TERM__NEXT = TERM__NEXT;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_TERM__VARIABLE = TERM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Unary Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_TERM_FEATURE_COUNT = TERM_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Unary Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_TERM_OPERATION_COUNT = TERM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link capone.impl.BinaryTermImpl <em>Binary Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see capone.impl.BinaryTermImpl
	 * @see capone.impl.CaponePackageImpl#getBinaryTerm()
	 * @generated
	 */
	int BINARY_TERM = 9;

	/**
	 * The feature id for the '<em><b>Uoperator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_TERM__UOPERATOR = TERM__UOPERATOR;

	/**
	 * The feature id for the '<em><b>Next</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_TERM__NEXT = TERM__NEXT;

	/**
	 * The feature id for the '<em><b>Operand1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_TERM__OPERAND1 = TERM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operand2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_TERM__OPERAND2 = TERM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Boperator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_TERM__BOPERATOR = TERM_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Binary Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_TERM_FEATURE_COUNT = TERM_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Binary Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_TERM_OPERATION_COUNT = TERM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link capone.impl.ElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see capone.impl.ElementImpl
	 * @see capone.impl.CaponePackageImpl#getElement()
	 * @generated
	 */
	int ELEMENT = 10;

	/**
	 * The feature id for the '<em><b>Over Modules</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__OVER_MODULES = 0;

	/**
	 * The feature id for the '<em><b>Element Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__ELEMENT_ID = 1;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__FEATURE = 2;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link capone.impl.FeatureElementImpl <em>Feature Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see capone.impl.FeatureElementImpl
	 * @see capone.impl.CaponePackageImpl#getFeatureElement()
	 * @generated
	 */
	int FEATURE_ELEMENT = 11;

	/**
	 * The feature id for the '<em><b>Feature Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_ELEMENT__FEATURE_ID = 0;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_ELEMENT__FEATURE = 1;

	/**
	 * The number of structural features of the '<em>Feature Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_ELEMENT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Feature Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link capone.UnaryOperator <em>Unary Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see capone.UnaryOperator
	 * @see capone.impl.CaponePackageImpl#getUnaryOperator()
	 * @generated
	 */
	int UNARY_OPERATOR = 12;

	/**
	 * The meta object id for the '{@link capone.BinaryOperator <em>Binary Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see capone.BinaryOperator
	 * @see capone.impl.CaponePackageImpl#getBinaryOperator()
	 * @generated
	 */
	int BINARY_OPERATOR = 13;


	/**
	 * Returns the meta object for class '{@link capone.Module <em>Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Module</em>'.
	 * @see capone.Module
	 * @generated
	 */
	EClass getModule();

	/**
	 * Returns the meta object for the attribute '{@link capone.Module#isIsTop <em>Is Top</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Top</em>'.
	 * @see capone.Module#isIsTop()
	 * @see #getModule()
	 * @generated
	 */
	EAttribute getModule_IsTop();

	/**
	 * Returns the meta object for the attribute '{@link capone.Module#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see capone.Module#getName()
	 * @see #getModule()
	 * @generated
	 */
	EAttribute getModule_Name();

	/**
	 * Returns the meta object for the attribute '{@link capone.Module#getMetamodel <em>Metamodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Metamodel</em>'.
	 * @see capone.Module#getMetamodel()
	 * @see #getModule()
	 * @generated
	 */
	EAttribute getModule_Metamodel();

	/**
	 * Returns the meta object for the reference list '{@link capone.Module#getModuleMandatory <em>Module Mandatory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Module Mandatory</em>'.
	 * @see capone.Module#getModuleMandatory()
	 * @see #getModule()
	 * @generated
	 */
	EReference getModule_ModuleMandatory();

	/**
	 * Returns the meta object for the reference list '{@link capone.Module#getModuleOptional <em>Module Optional</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Module Optional</em>'.
	 * @see capone.Module#getModuleOptional()
	 * @see #getModule()
	 * @generated
	 */
	EReference getModule_ModuleOptional();

	/**
	 * Returns the meta object for the reference list '{@link capone.Module#getModuleAlternative <em>Module Alternative</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Module Alternative</em>'.
	 * @see capone.Module#getModuleAlternative()
	 * @see #getModule()
	 * @generated
	 */
	EReference getModule_ModuleAlternative();

	/**
	 * Returns the meta object for the reference list '{@link capone.Module#getModuleOr <em>Module Or</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Module Or</em>'.
	 * @see capone.Module#getModuleOr()
	 * @see #getModule()
	 * @generated
	 */
	EReference getModule_ModuleOr();

	/**
	 * Returns the meta object for the containment reference '{@link capone.Module#getRules <em>Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Rules</em>'.
	 * @see capone.Module#getRules()
	 * @see #getModule()
	 * @generated
	 */
	EReference getModule_Rules();

	/**
	 * Returns the meta object for the containment reference list '{@link capone.Module#getImports <em>Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Imports</em>'.
	 * @see capone.Module#getImports()
	 * @see #getModule()
	 * @generated
	 */
	EReference getModule_Imports();

	/**
	 * Returns the meta object for the containment reference '{@link capone.Module#getFormula <em>Formula</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Formula</em>'.
	 * @see capone.Module#getFormula()
	 * @see #getModule()
	 * @generated
	 */
	EReference getModule_Formula();

	/**
	 * Returns the meta object for the containment reference '{@link capone.Module#getChooseDiagram <em>Choose Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Choose Diagram</em>'.
	 * @see capone.Module#getChooseDiagram()
	 * @see #getModule()
	 * @generated
	 */
	EReference getModule_ChooseDiagram();

	/**
	 * Returns the meta object for the '{@link capone.Module#getAllModuleDependencies() <em>Get All Module Dependencies</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get All Module Dependencies</em>' operation.
	 * @see capone.Module#getAllModuleDependencies()
	 * @generated
	 */
	EOperation getModule__GetAllModuleDependencies();

	/**
	 * Returns the meta object for class '{@link capone.Rule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rule</em>'.
	 * @see capone.Rule
	 * @generated
	 */
	EClass getRule();

	/**
	 * Returns the meta object for the attribute '{@link capone.Rule#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see capone.Rule#getName()
	 * @see #getRule()
	 * @generated
	 */
	EAttribute getRule_Name();

	/**
	 * Returns the meta object for the reference '{@link capone.Rule#getExtendsrule <em>Extendsrule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Extendsrule</em>'.
	 * @see capone.Rule#getExtendsrule()
	 * @see #getRule()
	 * @generated
	 */
	EReference getRule_Extendsrule();

	/**
	 * Returns the meta object for class '{@link capone.Diagram <em>Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Diagram</em>'.
	 * @see capone.Diagram
	 * @generated
	 */
	EClass getDiagram();

	/**
	 * Returns the meta object for the attribute '{@link capone.Diagram#getViewpointFileURI <em>Viewpoint File URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Viewpoint File URI</em>'.
	 * @see capone.Diagram#getViewpointFileURI()
	 * @see #getDiagram()
	 * @generated
	 */
	EAttribute getDiagram_ViewpointFileURI();

	/**
	 * Returns the meta object for the containment reference list '{@link capone.Diagram#getOverridesElements <em>Overrides Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Overrides Elements</em>'.
	 * @see capone.Diagram#getOverridesElements()
	 * @see #getDiagram()
	 * @generated
	 */
	EReference getDiagram_OverridesElements();

	/**
	 * Returns the meta object for the containment reference list '{@link capone.Diagram#getMerge <em>Merge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Merge</em>'.
	 * @see capone.Diagram#getMerge()
	 * @see #getDiagram()
	 * @generated
	 */
	EReference getDiagram_Merge();

	/**
	 * Returns the meta object for class '{@link capone.RuleSet <em>Rule Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rule Set</em>'.
	 * @see capone.RuleSet
	 * @generated
	 */
	EClass getRuleSet();

	/**
	 * Returns the meta object for the containment reference list '{@link capone.RuleSet#getRules <em>Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rules</em>'.
	 * @see capone.RuleSet#getRules()
	 * @see #getRuleSet()
	 * @generated
	 */
	EReference getRuleSet_Rules();

	/**
	 * Returns the meta object for the attribute '{@link capone.RuleSet#getRulefile <em>Rulefile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rulefile</em>'.
	 * @see capone.RuleSet#getRulefile()
	 * @see #getRuleSet()
	 * @generated
	 */
	EAttribute getRuleSet_Rulefile();

	/**
	 * Returns the meta object for class '{@link capone.FileURI <em>File URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File URI</em>'.
	 * @see capone.FileURI
	 * @generated
	 */
	EClass getFileURI();

	/**
	 * Returns the meta object for the attribute '{@link capone.FileURI#getImportURI <em>Import URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Import URI</em>'.
	 * @see capone.FileURI#getImportURI()
	 * @see #getFileURI()
	 * @generated
	 */
	EAttribute getFileURI_ImportURI();

	/**
	 * Returns the meta object for class '{@link capone.Formula <em>Formula</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Formula</em>'.
	 * @see capone.Formula
	 * @generated
	 */
	EClass getFormula();

	/**
	 * Returns the meta object for the containment reference '{@link capone.Formula#getTerm <em>Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Term</em>'.
	 * @see capone.Formula#getTerm()
	 * @see #getFormula()
	 * @generated
	 */
	EReference getFormula_Term();

	/**
	 * Returns the meta object for class '{@link capone.Term <em>Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Term</em>'.
	 * @see capone.Term
	 * @generated
	 */
	EClass getTerm();

	/**
	 * Returns the meta object for the attribute '{@link capone.Term#getUoperator <em>Uoperator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uoperator</em>'.
	 * @see capone.Term#getUoperator()
	 * @see #getTerm()
	 * @generated
	 */
	EAttribute getTerm_Uoperator();

	/**
	 * Returns the meta object for the containment reference '{@link capone.Term#getNext <em>Next</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Next</em>'.
	 * @see capone.Term#getNext()
	 * @see #getTerm()
	 * @generated
	 */
	EReference getTerm_Next();

	/**
	 * Returns the meta object for class '{@link capone.NextTerm <em>Next Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Next Term</em>'.
	 * @see capone.NextTerm
	 * @generated
	 */
	EClass getNextTerm();

	/**
	 * Returns the meta object for the attribute '{@link capone.NextTerm#getBoperator <em>Boperator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Boperator</em>'.
	 * @see capone.NextTerm#getBoperator()
	 * @see #getNextTerm()
	 * @generated
	 */
	EAttribute getNextTerm_Boperator();

	/**
	 * Returns the meta object for the containment reference '{@link capone.NextTerm#getTerm <em>Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Term</em>'.
	 * @see capone.NextTerm#getTerm()
	 * @see #getNextTerm()
	 * @generated
	 */
	EReference getNextTerm_Term();

	/**
	 * Returns the meta object for class '{@link capone.UnaryTerm <em>Unary Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unary Term</em>'.
	 * @see capone.UnaryTerm
	 * @generated
	 */
	EClass getUnaryTerm();

	/**
	 * Returns the meta object for the reference '{@link capone.UnaryTerm#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variable</em>'.
	 * @see capone.UnaryTerm#getVariable()
	 * @see #getUnaryTerm()
	 * @generated
	 */
	EReference getUnaryTerm_Variable();

	/**
	 * Returns the meta object for class '{@link capone.BinaryTerm <em>Binary Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binary Term</em>'.
	 * @see capone.BinaryTerm
	 * @generated
	 */
	EClass getBinaryTerm();

	/**
	 * Returns the meta object for the containment reference '{@link capone.BinaryTerm#getOperand1 <em>Operand1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Operand1</em>'.
	 * @see capone.BinaryTerm#getOperand1()
	 * @see #getBinaryTerm()
	 * @generated
	 */
	EReference getBinaryTerm_Operand1();

	/**
	 * Returns the meta object for the containment reference '{@link capone.BinaryTerm#getOperand2 <em>Operand2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Operand2</em>'.
	 * @see capone.BinaryTerm#getOperand2()
	 * @see #getBinaryTerm()
	 * @generated
	 */
	EReference getBinaryTerm_Operand2();

	/**
	 * Returns the meta object for the attribute '{@link capone.BinaryTerm#getBoperator <em>Boperator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Boperator</em>'.
	 * @see capone.BinaryTerm#getBoperator()
	 * @see #getBinaryTerm()
	 * @generated
	 */
	EAttribute getBinaryTerm_Boperator();

	/**
	 * Returns the meta object for class '{@link capone.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see capone.Element
	 * @generated
	 */
	EClass getElement();

	/**
	 * Returns the meta object for the reference list '{@link capone.Element#getOverModules <em>Over Modules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Over Modules</em>'.
	 * @see capone.Element#getOverModules()
	 * @see #getElement()
	 * @generated
	 */
	EReference getElement_OverModules();

	/**
	 * Returns the meta object for the attribute '{@link capone.Element#getElementId <em>Element Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Element Id</em>'.
	 * @see capone.Element#getElementId()
	 * @see #getElement()
	 * @generated
	 */
	EAttribute getElement_ElementId();

	/**
	 * Returns the meta object for the containment reference '{@link capone.Element#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Feature</em>'.
	 * @see capone.Element#getFeature()
	 * @see #getElement()
	 * @generated
	 */
	EReference getElement_Feature();

	/**
	 * Returns the meta object for class '{@link capone.FeatureElement <em>Feature Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Element</em>'.
	 * @see capone.FeatureElement
	 * @generated
	 */
	EClass getFeatureElement();

	/**
	 * Returns the meta object for the attribute '{@link capone.FeatureElement#getFeatureId <em>Feature Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Feature Id</em>'.
	 * @see capone.FeatureElement#getFeatureId()
	 * @see #getFeatureElement()
	 * @generated
	 */
	EAttribute getFeatureElement_FeatureId();

	/**
	 * Returns the meta object for the containment reference '{@link capone.FeatureElement#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Feature</em>'.
	 * @see capone.FeatureElement#getFeature()
	 * @see #getFeatureElement()
	 * @generated
	 */
	EReference getFeatureElement_Feature();

	/**
	 * Returns the meta object for enum '{@link capone.UnaryOperator <em>Unary Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Unary Operator</em>'.
	 * @see capone.UnaryOperator
	 * @generated
	 */
	EEnum getUnaryOperator();

	/**
	 * Returns the meta object for enum '{@link capone.BinaryOperator <em>Binary Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Binary Operator</em>'.
	 * @see capone.BinaryOperator
	 * @generated
	 */
	EEnum getBinaryOperator();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CaponeFactory getCaponeFactory();

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
		 * The meta object literal for the '{@link capone.impl.ModuleImpl <em>Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see capone.impl.ModuleImpl
		 * @see capone.impl.CaponePackageImpl#getModule()
		 * @generated
		 */
		EClass MODULE = eINSTANCE.getModule();

		/**
		 * The meta object literal for the '<em><b>Is Top</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODULE__IS_TOP = eINSTANCE.getModule_IsTop();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODULE__NAME = eINSTANCE.getModule_Name();

		/**
		 * The meta object literal for the '<em><b>Metamodel</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODULE__METAMODEL = eINSTANCE.getModule_Metamodel();

		/**
		 * The meta object literal for the '<em><b>Module Mandatory</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULE__MODULE_MANDATORY = eINSTANCE.getModule_ModuleMandatory();

		/**
		 * The meta object literal for the '<em><b>Module Optional</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULE__MODULE_OPTIONAL = eINSTANCE.getModule_ModuleOptional();

		/**
		 * The meta object literal for the '<em><b>Module Alternative</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULE__MODULE_ALTERNATIVE = eINSTANCE.getModule_ModuleAlternative();

		/**
		 * The meta object literal for the '<em><b>Module Or</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULE__MODULE_OR = eINSTANCE.getModule_ModuleOr();

		/**
		 * The meta object literal for the '<em><b>Rules</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULE__RULES = eINSTANCE.getModule_Rules();

		/**
		 * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULE__IMPORTS = eINSTANCE.getModule_Imports();

		/**
		 * The meta object literal for the '<em><b>Formula</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULE__FORMULA = eINSTANCE.getModule_Formula();

		/**
		 * The meta object literal for the '<em><b>Choose Diagram</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULE__CHOOSE_DIAGRAM = eINSTANCE.getModule_ChooseDiagram();

		/**
		 * The meta object literal for the '<em><b>Get All Module Dependencies</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODULE___GET_ALL_MODULE_DEPENDENCIES = eINSTANCE.getModule__GetAllModuleDependencies();

		/**
		 * The meta object literal for the '{@link capone.impl.RuleImpl <em>Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see capone.impl.RuleImpl
		 * @see capone.impl.CaponePackageImpl#getRule()
		 * @generated
		 */
		EClass RULE = eINSTANCE.getRule();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULE__NAME = eINSTANCE.getRule_Name();

		/**
		 * The meta object literal for the '<em><b>Extendsrule</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE__EXTENDSRULE = eINSTANCE.getRule_Extendsrule();

		/**
		 * The meta object literal for the '{@link capone.impl.DiagramImpl <em>Diagram</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see capone.impl.DiagramImpl
		 * @see capone.impl.CaponePackageImpl#getDiagram()
		 * @generated
		 */
		EClass DIAGRAM = eINSTANCE.getDiagram();

		/**
		 * The meta object literal for the '<em><b>Viewpoint File URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAGRAM__VIEWPOINT_FILE_URI = eINSTANCE.getDiagram_ViewpointFileURI();

		/**
		 * The meta object literal for the '<em><b>Overrides Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIAGRAM__OVERRIDES_ELEMENTS = eINSTANCE.getDiagram_OverridesElements();

		/**
		 * The meta object literal for the '<em><b>Merge</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIAGRAM__MERGE = eINSTANCE.getDiagram_Merge();

		/**
		 * The meta object literal for the '{@link capone.impl.RuleSetImpl <em>Rule Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see capone.impl.RuleSetImpl
		 * @see capone.impl.CaponePackageImpl#getRuleSet()
		 * @generated
		 */
		EClass RULE_SET = eINSTANCE.getRuleSet();

		/**
		 * The meta object literal for the '<em><b>Rules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE_SET__RULES = eINSTANCE.getRuleSet_Rules();

		/**
		 * The meta object literal for the '<em><b>Rulefile</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULE_SET__RULEFILE = eINSTANCE.getRuleSet_Rulefile();

		/**
		 * The meta object literal for the '{@link capone.impl.FileURIImpl <em>File URI</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see capone.impl.FileURIImpl
		 * @see capone.impl.CaponePackageImpl#getFileURI()
		 * @generated
		 */
		EClass FILE_URI = eINSTANCE.getFileURI();

		/**
		 * The meta object literal for the '<em><b>Import URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_URI__IMPORT_URI = eINSTANCE.getFileURI_ImportURI();

		/**
		 * The meta object literal for the '{@link capone.impl.FormulaImpl <em>Formula</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see capone.impl.FormulaImpl
		 * @see capone.impl.CaponePackageImpl#getFormula()
		 * @generated
		 */
		EClass FORMULA = eINSTANCE.getFormula();

		/**
		 * The meta object literal for the '<em><b>Term</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FORMULA__TERM = eINSTANCE.getFormula_Term();

		/**
		 * The meta object literal for the '{@link capone.impl.TermImpl <em>Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see capone.impl.TermImpl
		 * @see capone.impl.CaponePackageImpl#getTerm()
		 * @generated
		 */
		EClass TERM = eINSTANCE.getTerm();

		/**
		 * The meta object literal for the '<em><b>Uoperator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TERM__UOPERATOR = eINSTANCE.getTerm_Uoperator();

		/**
		 * The meta object literal for the '<em><b>Next</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TERM__NEXT = eINSTANCE.getTerm_Next();

		/**
		 * The meta object literal for the '{@link capone.impl.NextTermImpl <em>Next Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see capone.impl.NextTermImpl
		 * @see capone.impl.CaponePackageImpl#getNextTerm()
		 * @generated
		 */
		EClass NEXT_TERM = eINSTANCE.getNextTerm();

		/**
		 * The meta object literal for the '<em><b>Boperator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NEXT_TERM__BOPERATOR = eINSTANCE.getNextTerm_Boperator();

		/**
		 * The meta object literal for the '<em><b>Term</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NEXT_TERM__TERM = eINSTANCE.getNextTerm_Term();

		/**
		 * The meta object literal for the '{@link capone.impl.UnaryTermImpl <em>Unary Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see capone.impl.UnaryTermImpl
		 * @see capone.impl.CaponePackageImpl#getUnaryTerm()
		 * @generated
		 */
		EClass UNARY_TERM = eINSTANCE.getUnaryTerm();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNARY_TERM__VARIABLE = eINSTANCE.getUnaryTerm_Variable();

		/**
		 * The meta object literal for the '{@link capone.impl.BinaryTermImpl <em>Binary Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see capone.impl.BinaryTermImpl
		 * @see capone.impl.CaponePackageImpl#getBinaryTerm()
		 * @generated
		 */
		EClass BINARY_TERM = eINSTANCE.getBinaryTerm();

		/**
		 * The meta object literal for the '<em><b>Operand1</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_TERM__OPERAND1 = eINSTANCE.getBinaryTerm_Operand1();

		/**
		 * The meta object literal for the '<em><b>Operand2</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_TERM__OPERAND2 = eINSTANCE.getBinaryTerm_Operand2();

		/**
		 * The meta object literal for the '<em><b>Boperator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BINARY_TERM__BOPERATOR = eINSTANCE.getBinaryTerm_Boperator();

		/**
		 * The meta object literal for the '{@link capone.impl.ElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see capone.impl.ElementImpl
		 * @see capone.impl.CaponePackageImpl#getElement()
		 * @generated
		 */
		EClass ELEMENT = eINSTANCE.getElement();

		/**
		 * The meta object literal for the '<em><b>Over Modules</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT__OVER_MODULES = eINSTANCE.getElement_OverModules();

		/**
		 * The meta object literal for the '<em><b>Element Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT__ELEMENT_ID = eINSTANCE.getElement_ElementId();

		/**
		 * The meta object literal for the '<em><b>Feature</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT__FEATURE = eINSTANCE.getElement_Feature();

		/**
		 * The meta object literal for the '{@link capone.impl.FeatureElementImpl <em>Feature Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see capone.impl.FeatureElementImpl
		 * @see capone.impl.CaponePackageImpl#getFeatureElement()
		 * @generated
		 */
		EClass FEATURE_ELEMENT = eINSTANCE.getFeatureElement();

		/**
		 * The meta object literal for the '<em><b>Feature Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_ELEMENT__FEATURE_ID = eINSTANCE.getFeatureElement_FeatureId();

		/**
		 * The meta object literal for the '<em><b>Feature</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_ELEMENT__FEATURE = eINSTANCE.getFeatureElement_Feature();

		/**
		 * The meta object literal for the '{@link capone.UnaryOperator <em>Unary Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see capone.UnaryOperator
		 * @see capone.impl.CaponePackageImpl#getUnaryOperator()
		 * @generated
		 */
		EEnum UNARY_OPERATOR = eINSTANCE.getUnaryOperator();

		/**
		 * The meta object literal for the '{@link capone.BinaryOperator <em>Binary Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see capone.BinaryOperator
		 * @see capone.impl.CaponePackageImpl#getBinaryOperator()
		 * @generated
		 */
		EEnum BINARY_OPERATOR = eINSTANCE.getBinaryOperator();

	}

} //CaponePackage

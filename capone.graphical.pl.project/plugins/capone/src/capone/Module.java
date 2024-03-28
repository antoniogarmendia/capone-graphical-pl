/**
 */
package capone;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Module</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link capone.Module#isIsTop <em>Is Top</em>}</li>
 *   <li>{@link capone.Module#getName <em>Name</em>}</li>
 *   <li>{@link capone.Module#getMetamodel <em>Metamodel</em>}</li>
 *   <li>{@link capone.Module#getModuleMandatory <em>Module Mandatory</em>}</li>
 *   <li>{@link capone.Module#getModuleOptional <em>Module Optional</em>}</li>
 *   <li>{@link capone.Module#getModuleAlternative <em>Module Alternative</em>}</li>
 *   <li>{@link capone.Module#getModuleOr <em>Module Or</em>}</li>
 *   <li>{@link capone.Module#getRules <em>Rules</em>}</li>
 *   <li>{@link capone.Module#getImports <em>Imports</em>}</li>
 *   <li>{@link capone.Module#getFormula <em>Formula</em>}</li>
 *   <li>{@link capone.Module#getChooseDiagram <em>Choose Diagram</em>}</li>
 * </ul>
 *
 * @see capone.CaponePackage#getModule()
 * @model
 * @generated
 */
public interface Module extends EObject {
	/**
	 * Returns the value of the '<em><b>Is Top</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Top</em>' attribute.
	 * @see #setIsTop(boolean)
	 * @see capone.CaponePackage#getModule_IsTop()
	 * @model required="true"
	 * @generated
	 */
	boolean isIsTop();

	/**
	 * Sets the value of the '{@link capone.Module#isIsTop <em>Is Top</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Top</em>' attribute.
	 * @see #isIsTop()
	 * @generated
	 */
	void setIsTop(boolean value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see capone.CaponePackage#getModule_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link capone.Module#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Metamodel</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metamodel</em>' attribute.
	 * @see #setMetamodel(String)
	 * @see capone.CaponePackage#getModule_Metamodel()
	 * @model
	 * @generated
	 */
	String getMetamodel();

	/**
	 * Sets the value of the '{@link capone.Module#getMetamodel <em>Metamodel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metamodel</em>' attribute.
	 * @see #getMetamodel()
	 * @generated
	 */
	void setMetamodel(String value);

	/**
	 * Returns the value of the '<em><b>Module Mandatory</b></em>' reference list.
	 * The list contents are of type {@link capone.Module}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Module Mandatory</em>' reference list.
	 * @see capone.CaponePackage#getModule_ModuleMandatory()
	 * @model
	 * @generated
	 */
	EList<Module> getModuleMandatory();

	/**
	 * Returns the value of the '<em><b>Module Optional</b></em>' reference list.
	 * The list contents are of type {@link capone.Module}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Module Optional</em>' reference list.
	 * @see capone.CaponePackage#getModule_ModuleOptional()
	 * @model
	 * @generated
	 */
	EList<Module> getModuleOptional();

	/**
	 * Returns the value of the '<em><b>Module Alternative</b></em>' reference list.
	 * The list contents are of type {@link capone.Module}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Module Alternative</em>' reference list.
	 * @see capone.CaponePackage#getModule_ModuleAlternative()
	 * @model
	 * @generated
	 */
	EList<Module> getModuleAlternative();

	/**
	 * Returns the value of the '<em><b>Module Or</b></em>' reference list.
	 * The list contents are of type {@link capone.Module}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Module Or</em>' reference list.
	 * @see capone.CaponePackage#getModule_ModuleOr()
	 * @model
	 * @generated
	 */
	EList<Module> getModuleOr();

	/**
	 * Returns the value of the '<em><b>Rules</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rules</em>' containment reference.
	 * @see #setRules(RuleSet)
	 * @see capone.CaponePackage#getModule_Rules()
	 * @model containment="true"
	 * @generated
	 */
	RuleSet getRules();

	/**
	 * Sets the value of the '{@link capone.Module#getRules <em>Rules</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rules</em>' containment reference.
	 * @see #getRules()
	 * @generated
	 */
	void setRules(RuleSet value);

	/**
	 * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
	 * The list contents are of type {@link capone.FileURI}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imports</em>' containment reference list.
	 * @see capone.CaponePackage#getModule_Imports()
	 * @model containment="true"
	 * @generated
	 */
	EList<FileURI> getImports();

	/**
	 * Returns the value of the '<em><b>Formula</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Formula</em>' containment reference.
	 * @see #setFormula(Formula)
	 * @see capone.CaponePackage#getModule_Formula()
	 * @model containment="true"
	 * @generated
	 */
	Formula getFormula();

	/**
	 * Sets the value of the '{@link capone.Module#getFormula <em>Formula</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Formula</em>' containment reference.
	 * @see #getFormula()
	 * @generated
	 */
	void setFormula(Formula value);

	/**
	 * Returns the value of the '<em><b>Choose Diagram</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Choose Diagram</em>' containment reference.
	 * @see #setChooseDiagram(Diagram)
	 * @see capone.CaponePackage#getModule_ChooseDiagram()
	 * @model containment="true"
	 * @generated
	 */
	Diagram getChooseDiagram();

	/**
	 * Sets the value of the '{@link capone.Module#getChooseDiagram <em>Choose Diagram</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Choose Diagram</em>' containment reference.
	 * @see #getChooseDiagram()
	 * @generated
	 */
	void setChooseDiagram(Diagram value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" ordered="false"
	 * @generated
	 */
	EList<Module> getAllModuleDependencies();

} // Module

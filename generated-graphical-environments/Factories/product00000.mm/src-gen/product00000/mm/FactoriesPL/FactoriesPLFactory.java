/**
 */
package product00000.mm.FactoriesPL;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see product00000.mm.FactoriesPL.FactoriesPLPackage
 * @generated
 */
public interface FactoriesPLFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FactoriesPLFactory eINSTANCE = product00000.mm.FactoriesPL.impl.FactoriesPLFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Factory</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Factory</em>'.
	 * @generated
	 */
	Factory createFactory();

	/**
	 * Returns a new object of class '<em>Machine</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Machine</em>'.
	 * @generated
	 */
	Machine createMachine();

	/**
	 * Returns a new object of class '<em>Conveyor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Conveyor</em>'.
	 * @generated
	 */
	Conveyor createConveyor();

	/**
	 * Returns a new object of class '<em>Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Part</em>'.
	 * @generated
	 */
	Part createPart();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	FactoriesPLPackage getFactoriesPLPackage();

} //FactoriesPLFactory

/**
 */
package capone;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link capone.Rule#getName <em>Name</em>}</li>
 *   <li>{@link capone.Rule#getExtendsrule <em>Extendsrule</em>}</li>
 * </ul>
 *
 * @see capone.CaponePackage#getRule()
 * @model
 * @generated
 */
public interface Rule extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see capone.CaponePackage#getRule_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link capone.Rule#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Extendsrule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extendsrule</em>' reference.
	 * @see #setExtendsrule(Rule)
	 * @see capone.CaponePackage#getRule_Extendsrule()
	 * @model
	 * @generated
	 */
	Rule getExtendsrule();

	/**
	 * Sets the value of the '{@link capone.Rule#getExtendsrule <em>Extendsrule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extendsrule</em>' reference.
	 * @see #getExtendsrule()
	 * @generated
	 */
	void setExtendsrule(Rule value);

} // Rule

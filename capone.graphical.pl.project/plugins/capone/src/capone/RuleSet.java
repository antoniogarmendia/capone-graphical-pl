/**
 */
package capone;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link capone.RuleSet#getRules <em>Rules</em>}</li>
 *   <li>{@link capone.RuleSet#getRulefile <em>Rulefile</em>}</li>
 * </ul>
 *
 * @see capone.CaponePackage#getRuleSet()
 * @model
 * @generated
 */
public interface RuleSet extends EObject {
	/**
	 * Returns the value of the '<em><b>Rules</b></em>' containment reference list.
	 * The list contents are of type {@link capone.Rule}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rules</em>' containment reference list.
	 * @see capone.CaponePackage#getRuleSet_Rules()
	 * @model containment="true"
	 * @generated
	 */
	EList<Rule> getRules();

	/**
	 * Returns the value of the '<em><b>Rulefile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rulefile</em>' attribute.
	 * @see #setRulefile(String)
	 * @see capone.CaponePackage#getRuleSet_Rulefile()
	 * @model required="true"
	 * @generated
	 */
	String getRulefile();

	/**
	 * Sets the value of the '{@link capone.RuleSet#getRulefile <em>Rulefile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rulefile</em>' attribute.
	 * @see #getRulefile()
	 * @generated
	 */
	void setRulefile(String value);

} // RuleSet

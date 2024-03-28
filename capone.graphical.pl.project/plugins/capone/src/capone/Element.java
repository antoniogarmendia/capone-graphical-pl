/**
 */
package capone;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link capone.Element#getOverModules <em>Over Modules</em>}</li>
 *   <li>{@link capone.Element#getElementId <em>Element Id</em>}</li>
 *   <li>{@link capone.Element#getFeature <em>Feature</em>}</li>
 * </ul>
 *
 * @see capone.CaponePackage#getElement()
 * @model
 * @generated
 */
public interface Element extends EObject {
	/**
	 * Returns the value of the '<em><b>Over Modules</b></em>' reference list.
	 * The list contents are of type {@link capone.Module}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Over Modules</em>' reference list.
	 * @see capone.CaponePackage#getElement_OverModules()
	 * @model
	 * @generated
	 */
	EList<capone.Module> getOverModules();

	/**
	 * Returns the value of the '<em><b>Element Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element Id</em>' attribute.
	 * @see #setElementId(String)
	 * @see capone.CaponePackage#getElement_ElementId()
	 * @model
	 * @generated
	 */
	String getElementId();

	/**
	 * Sets the value of the '{@link capone.Element#getElementId <em>Element Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element Id</em>' attribute.
	 * @see #getElementId()
	 * @generated
	 */
	void setElementId(String value);

	/**
	 * Returns the value of the '<em><b>Feature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature</em>' containment reference.
	 * @see #setFeature(FeatureElement)
	 * @see capone.CaponePackage#getElement_Feature()
	 * @model containment="true"
	 * @generated
	 */
	FeatureElement getFeature();

	/**
	 * Sets the value of the '{@link capone.Element#getFeature <em>Feature</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature</em>' containment reference.
	 * @see #getFeature()
	 * @generated
	 */
	void setFeature(FeatureElement value);

} // Element

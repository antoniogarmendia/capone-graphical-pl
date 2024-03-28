/**
 */
package capone;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link capone.FeatureElement#getFeatureId <em>Feature Id</em>}</li>
 *   <li>{@link capone.FeatureElement#getFeature <em>Feature</em>}</li>
 * </ul>
 *
 * @see capone.CaponePackage#getFeatureElement()
 * @model
 * @generated
 */
public interface FeatureElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Feature Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This is the string that contains the name of the EAttribute or a Containment Reference
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Feature Id</em>' attribute.
	 * @see #setFeatureId(String)
	 * @see capone.CaponePackage#getFeatureElement_FeatureId()
	 * @model
	 * @generated
	 */
	String getFeatureId();

	/**
	 * Sets the value of the '{@link capone.FeatureElement#getFeatureId <em>Feature Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature Id</em>' attribute.
	 * @see #getFeatureId()
	 * @generated
	 */
	void setFeatureId(String value);

	/**
	 * Returns the value of the '<em><b>Feature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature</em>' containment reference.
	 * @see #setFeature(FeatureElement)
	 * @see capone.CaponePackage#getFeatureElement_Feature()
	 * @model containment="true"
	 * @generated
	 */
	FeatureElement getFeature();

	/**
	 * Sets the value of the '{@link capone.FeatureElement#getFeature <em>Feature</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature</em>' containment reference.
	 * @see #getFeature()
	 * @generated
	 */
	void setFeature(FeatureElement value);

} // FeatureElement

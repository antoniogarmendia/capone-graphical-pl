/**
 */
package capone;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Diagram</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link capone.Diagram#getViewpointFileURI <em>Viewpoint File URI</em>}</li>
 *   <li>{@link capone.Diagram#getOverridesElements <em>Overrides Elements</em>}</li>
 *   <li>{@link capone.Diagram#getMerge <em>Merge</em>}</li>
 * </ul>
 *
 * @see capone.CaponePackage#getDiagram()
 * @model
 * @generated
 */
public interface Diagram extends EObject {
	/**
	 * Returns the value of the '<em><b>Viewpoint File URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Viewpoint File URI</em>' attribute.
	 * @see #setViewpointFileURI(String)
	 * @see capone.CaponePackage#getDiagram_ViewpointFileURI()
	 * @model
	 * @generated
	 */
	String getViewpointFileURI();

	/**
	 * Sets the value of the '{@link capone.Diagram#getViewpointFileURI <em>Viewpoint File URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Viewpoint File URI</em>' attribute.
	 * @see #getViewpointFileURI()
	 * @generated
	 */
	void setViewpointFileURI(String value);

	/**
	 * Returns the value of the '<em><b>Overrides Elements</b></em>' containment reference list.
	 * The list contents are of type {@link capone.Element}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Overrides Elements</em>' containment reference list.
	 * @see capone.CaponePackage#getDiagram_OverridesElements()
	 * @model containment="true"
	 * @generated
	 */
	EList<Element> getOverridesElements();

	/**
	 * Returns the value of the '<em><b>Merge</b></em>' containment reference list.
	 * The list contents are of type {@link capone.Element}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Merge</em>' containment reference list.
	 * @see capone.CaponePackage#getDiagram_Merge()
	 * @model containment="true"
	 * @generated
	 */
	EList<Element> getMerge();

} // Diagram

/**
 */
package product00005.mm.NetworkingPL;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link product00005.mm.NetworkingPL.Link#getFrom <em>From</em>}</li>
 *   <li>{@link product00005.mm.NetworkingPL.Link#getTo <em>To</em>}</li>
 *   <li>{@link product00005.mm.NetworkingPL.Link#getSpeed <em>Speed</em>}</li>
 * </ul>
 *
 * @see product00005.mm.NetworkingPL.NetworkingPLPackage#getLink()
 * @model
 * @generated
 */
public interface Link extends EObject {
	/**
	 * Returns the value of the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From</em>' reference.
	 * @see #setFrom(Node)
	 * @see product00005.mm.NetworkingPL.NetworkingPLPackage#getLink_From()
	 * @model
	 * @generated
	 */
	Node getFrom();

	/**
	 * Sets the value of the '{@link product00005.mm.NetworkingPL.Link#getFrom <em>From</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From</em>' reference.
	 * @see #getFrom()
	 * @generated
	 */
	void setFrom(Node value);

	/**
	 * Returns the value of the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To</em>' reference.
	 * @see #setTo(Node)
	 * @see product00005.mm.NetworkingPL.NetworkingPLPackage#getLink_To()
	 * @model
	 * @generated
	 */
	Node getTo();

	/**
	 * Sets the value of the '{@link product00005.mm.NetworkingPL.Link#getTo <em>To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To</em>' reference.
	 * @see #getTo()
	 * @generated
	 */
	void setTo(Node value);

	/**
	 * Returns the value of the '<em><b>Speed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Speed</em>' attribute.
	 * @see #setSpeed(double)
	 * @see product00005.mm.NetworkingPL.NetworkingPLPackage#getLink_Speed()
	 * @model
	 * @generated
	 */
	double getSpeed();

	/**
	 * Sets the value of the '{@link product00005.mm.NetworkingPL.Link#getSpeed <em>Speed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Speed</em>' attribute.
	 * @see #getSpeed()
	 * @generated
	 */
	void setSpeed(double value);

} // Link

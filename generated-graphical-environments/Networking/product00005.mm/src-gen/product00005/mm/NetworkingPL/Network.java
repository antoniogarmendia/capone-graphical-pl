/**
 */
package product00005.mm.NetworkingPL;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Network</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link product00005.mm.NetworkingPL.Network#getNodes <em>Nodes</em>}</li>
 *   <li>{@link product00005.mm.NetworkingPL.Network#getMessages <em>Messages</em>}</li>
 *   <li>{@link product00005.mm.NetworkingPL.Network#getLinks <em>Links</em>}</li>
 * </ul>
 *
 * @see product00005.mm.NetworkingPL.NetworkingPLPackage#getNetwork()
 * @model
 * @generated
 */
public interface Network extends EObject {
	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link product00005.mm.NetworkingPL.Node}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see product00005.mm.NetworkingPL.NetworkingPLPackage#getNetwork_Nodes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Node> getNodes();

	/**
	 * Returns the value of the '<em><b>Messages</b></em>' containment reference list.
	 * The list contents are of type {@link product00005.mm.NetworkingPL.Message}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Messages</em>' containment reference list.
	 * @see product00005.mm.NetworkingPL.NetworkingPLPackage#getNetwork_Messages()
	 * @model containment="true"
	 * @generated
	 */
	EList<Message> getMessages();

	/**
	 * Returns the value of the '<em><b>Links</b></em>' containment reference list.
	 * The list contents are of type {@link product00005.mm.NetworkingPL.Link}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Links</em>' containment reference list.
	 * @see product00005.mm.NetworkingPL.NetworkingPLPackage#getNetwork_Links()
	 * @model containment="true"
	 * @generated
	 */
	EList<Link> getLinks();

} // Network

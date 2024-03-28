/**
 */
package product00005.mm.NetworkingPL;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see product00005.mm.NetworkingPL.NetworkingPLFactory
 * @model kind="package"
 * @generated
 */
public interface NetworkingPLPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "NetworkingPL";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://networking/product00005";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "networking";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	NetworkingPLPackage eINSTANCE = product00005.mm.NetworkingPL.impl.NetworkingPLPackageImpl.init();

	/**
	 * The meta object id for the '{@link product00005.mm.NetworkingPL.impl.NetworkImpl <em>Network</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see product00005.mm.NetworkingPL.impl.NetworkImpl
	 * @see product00005.mm.NetworkingPL.impl.NetworkingPLPackageImpl#getNetwork()
	 * @generated
	 */
	int NETWORK = 0;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK__NODES = 0;

	/**
	 * The feature id for the '<em><b>Messages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK__MESSAGES = 1;

	/**
	 * The feature id for the '<em><b>Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK__LINKS = 2;

	/**
	 * The number of structural features of the '<em>Network</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Network</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link product00005.mm.NetworkingPL.impl.NodeImpl <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see product00005.mm.NetworkingPL.impl.NodeImpl
	 * @see product00005.mm.NetworkingPL.impl.NetworkingPLPackageImpl#getNode()
	 * @generated
	 */
	int NODE = 1;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link product00005.mm.NetworkingPL.impl.MessageImpl <em>Message</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see product00005.mm.NetworkingPL.impl.MessageImpl
	 * @see product00005.mm.NetworkingPL.impl.NetworkingPLPackageImpl#getMessage()
	 * @generated
	 */
	int MESSAGE = 2;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__FROM = 0;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__TO = 1;

	/**
	 * The feature id for the '<em><b>At</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__AT = 2;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__SIZE = 3;

	/**
	 * The feature id for the '<em><b>Time Stamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__TIME_STAMP = 4;

	/**
	 * The number of structural features of the '<em>Message</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Message</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link product00005.mm.NetworkingPL.impl.LinkImpl <em>Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see product00005.mm.NetworkingPL.impl.LinkImpl
	 * @see product00005.mm.NetworkingPL.impl.NetworkingPLPackageImpl#getLink()
	 * @generated
	 */
	int LINK = 3;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__FROM = 0;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__TO = 1;

	/**
	 * The feature id for the '<em><b>Speed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__SPEED = 2;

	/**
	 * The number of structural features of the '<em>Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_OPERATION_COUNT = 0;

	/**
	 * Returns the meta object for class '{@link product00005.mm.NetworkingPL.Network <em>Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Network</em>'.
	 * @see product00005.mm.NetworkingPL.Network
	 * @generated
	 */
	EClass getNetwork();

	/**
	 * Returns the meta object for the containment reference list '{@link product00005.mm.NetworkingPL.Network#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nodes</em>'.
	 * @see product00005.mm.NetworkingPL.Network#getNodes()
	 * @see #getNetwork()
	 * @generated
	 */
	EReference getNetwork_Nodes();

	/**
	 * Returns the meta object for the containment reference list '{@link product00005.mm.NetworkingPL.Network#getMessages <em>Messages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Messages</em>'.
	 * @see product00005.mm.NetworkingPL.Network#getMessages()
	 * @see #getNetwork()
	 * @generated
	 */
	EReference getNetwork_Messages();

	/**
	 * Returns the meta object for the containment reference list '{@link product00005.mm.NetworkingPL.Network#getLinks <em>Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Links</em>'.
	 * @see product00005.mm.NetworkingPL.Network#getLinks()
	 * @see #getNetwork()
	 * @generated
	 */
	EReference getNetwork_Links();

	/**
	 * Returns the meta object for class '{@link product00005.mm.NetworkingPL.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see product00005.mm.NetworkingPL.Node
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the meta object for class '{@link product00005.mm.NetworkingPL.Message <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Message</em>'.
	 * @see product00005.mm.NetworkingPL.Message
	 * @generated
	 */
	EClass getMessage();

	/**
	 * Returns the meta object for the reference '{@link product00005.mm.NetworkingPL.Message#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>From</em>'.
	 * @see product00005.mm.NetworkingPL.Message#getFrom()
	 * @see #getMessage()
	 * @generated
	 */
	EReference getMessage_From();

	/**
	 * Returns the meta object for the reference '{@link product00005.mm.NetworkingPL.Message#getTo <em>To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>To</em>'.
	 * @see product00005.mm.NetworkingPL.Message#getTo()
	 * @see #getMessage()
	 * @generated
	 */
	EReference getMessage_To();

	/**
	 * Returns the meta object for the reference '{@link product00005.mm.NetworkingPL.Message#getAt <em>At</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>At</em>'.
	 * @see product00005.mm.NetworkingPL.Message#getAt()
	 * @see #getMessage()
	 * @generated
	 */
	EReference getMessage_At();

	/**
	 * Returns the meta object for the attribute '{@link product00005.mm.NetworkingPL.Message#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see product00005.mm.NetworkingPL.Message#getSize()
	 * @see #getMessage()
	 * @generated
	 */
	EAttribute getMessage_Size();

	/**
	 * Returns the meta object for the attribute '{@link product00005.mm.NetworkingPL.Message#getTimeStamp <em>Time Stamp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time Stamp</em>'.
	 * @see product00005.mm.NetworkingPL.Message#getTimeStamp()
	 * @see #getMessage()
	 * @generated
	 */
	EAttribute getMessage_TimeStamp();

	/**
	 * Returns the meta object for class '{@link product00005.mm.NetworkingPL.Link <em>Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link</em>'.
	 * @see product00005.mm.NetworkingPL.Link
	 * @generated
	 */
	EClass getLink();

	/**
	 * Returns the meta object for the reference '{@link product00005.mm.NetworkingPL.Link#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>From</em>'.
	 * @see product00005.mm.NetworkingPL.Link#getFrom()
	 * @see #getLink()
	 * @generated
	 */
	EReference getLink_From();

	/**
	 * Returns the meta object for the reference '{@link product00005.mm.NetworkingPL.Link#getTo <em>To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>To</em>'.
	 * @see product00005.mm.NetworkingPL.Link#getTo()
	 * @see #getLink()
	 * @generated
	 */
	EReference getLink_To();

	/**
	 * Returns the meta object for the attribute '{@link product00005.mm.NetworkingPL.Link#getSpeed <em>Speed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Speed</em>'.
	 * @see product00005.mm.NetworkingPL.Link#getSpeed()
	 * @see #getLink()
	 * @generated
	 */
	EAttribute getLink_Speed();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	NetworkingPLFactory getNetworkingPLFactory();

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
		 * The meta object literal for the '{@link product00005.mm.NetworkingPL.impl.NetworkImpl <em>Network</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see product00005.mm.NetworkingPL.impl.NetworkImpl
		 * @see product00005.mm.NetworkingPL.impl.NetworkingPLPackageImpl#getNetwork()
		 * @generated
		 */
		EClass NETWORK = eINSTANCE.getNetwork();

		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NETWORK__NODES = eINSTANCE.getNetwork_Nodes();

		/**
		 * The meta object literal for the '<em><b>Messages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NETWORK__MESSAGES = eINSTANCE.getNetwork_Messages();

		/**
		 * The meta object literal for the '<em><b>Links</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NETWORK__LINKS = eINSTANCE.getNetwork_Links();

		/**
		 * The meta object literal for the '{@link product00005.mm.NetworkingPL.impl.NodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see product00005.mm.NetworkingPL.impl.NodeImpl
		 * @see product00005.mm.NetworkingPL.impl.NetworkingPLPackageImpl#getNode()
		 * @generated
		 */
		EClass NODE = eINSTANCE.getNode();

		/**
		 * The meta object literal for the '{@link product00005.mm.NetworkingPL.impl.MessageImpl <em>Message</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see product00005.mm.NetworkingPL.impl.MessageImpl
		 * @see product00005.mm.NetworkingPL.impl.NetworkingPLPackageImpl#getMessage()
		 * @generated
		 */
		EClass MESSAGE = eINSTANCE.getMessage();

		/**
		 * The meta object literal for the '<em><b>From</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE__FROM = eINSTANCE.getMessage_From();

		/**
		 * The meta object literal for the '<em><b>To</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE__TO = eINSTANCE.getMessage_To();

		/**
		 * The meta object literal for the '<em><b>At</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE__AT = eINSTANCE.getMessage_At();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MESSAGE__SIZE = eINSTANCE.getMessage_Size();

		/**
		 * The meta object literal for the '<em><b>Time Stamp</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MESSAGE__TIME_STAMP = eINSTANCE.getMessage_TimeStamp();

		/**
		 * The meta object literal for the '{@link product00005.mm.NetworkingPL.impl.LinkImpl <em>Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see product00005.mm.NetworkingPL.impl.LinkImpl
		 * @see product00005.mm.NetworkingPL.impl.NetworkingPLPackageImpl#getLink()
		 * @generated
		 */
		EClass LINK = eINSTANCE.getLink();

		/**
		 * The meta object literal for the '<em><b>From</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINK__FROM = eINSTANCE.getLink_From();

		/**
		 * The meta object literal for the '<em><b>To</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINK__TO = eINSTANCE.getLink_To();

		/**
		 * The meta object literal for the '<em><b>Speed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINK__SPEED = eINSTANCE.getLink_Speed();

	}

} //NetworkingPLPackage

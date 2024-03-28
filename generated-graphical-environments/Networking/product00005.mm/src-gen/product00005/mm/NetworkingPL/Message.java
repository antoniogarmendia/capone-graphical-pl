/**
 */
package product00005.mm.NetworkingPL;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Message</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link product00005.mm.NetworkingPL.Message#getFrom <em>From</em>}</li>
 *   <li>{@link product00005.mm.NetworkingPL.Message#getTo <em>To</em>}</li>
 *   <li>{@link product00005.mm.NetworkingPL.Message#getAt <em>At</em>}</li>
 *   <li>{@link product00005.mm.NetworkingPL.Message#getSize <em>Size</em>}</li>
 *   <li>{@link product00005.mm.NetworkingPL.Message#getTimeStamp <em>Time Stamp</em>}</li>
 * </ul>
 *
 * @see product00005.mm.NetworkingPL.NetworkingPLPackage#getMessage()
 * @model
 * @generated
 */
public interface Message extends EObject {
	/**
	 * Returns the value of the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From</em>' reference.
	 * @see #setFrom(Node)
	 * @see product00005.mm.NetworkingPL.NetworkingPLPackage#getMessage_From()
	 * @model required="true"
	 * @generated
	 */
	Node getFrom();

	/**
	 * Sets the value of the '{@link product00005.mm.NetworkingPL.Message#getFrom <em>From</em>}' reference.
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
	 * @see product00005.mm.NetworkingPL.NetworkingPLPackage#getMessage_To()
	 * @model required="true"
	 * @generated
	 */
	Node getTo();

	/**
	 * Sets the value of the '{@link product00005.mm.NetworkingPL.Message#getTo <em>To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To</em>' reference.
	 * @see #getTo()
	 * @generated
	 */
	void setTo(Node value);

	/**
	 * Returns the value of the '<em><b>At</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>At</em>' reference.
	 * @see #setAt(Node)
	 * @see product00005.mm.NetworkingPL.NetworkingPLPackage#getMessage_At()
	 * @model required="true"
	 * @generated
	 */
	Node getAt();

	/**
	 * Sets the value of the '{@link product00005.mm.NetworkingPL.Message#getAt <em>At</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>At</em>' reference.
	 * @see #getAt()
	 * @generated
	 */
	void setAt(Node value);

	/**
	 * Returns the value of the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' attribute.
	 * @see #setSize(int)
	 * @see product00005.mm.NetworkingPL.NetworkingPLPackage#getMessage_Size()
	 * @model
	 * @generated
	 */
	int getSize();

	/**
	 * Sets the value of the '{@link product00005.mm.NetworkingPL.Message#getSize <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' attribute.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(int value);

	/**
	 * Returns the value of the '<em><b>Time Stamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Stamp</em>' attribute.
	 * @see #setTimeStamp(double)
	 * @see product00005.mm.NetworkingPL.NetworkingPLPackage#getMessage_TimeStamp()
	 * @model
	 * @generated
	 */
	double getTimeStamp();

	/**
	 * Sets the value of the '{@link product00005.mm.NetworkingPL.Message#getTimeStamp <em>Time Stamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Stamp</em>' attribute.
	 * @see #getTimeStamp()
	 * @generated
	 */
	void setTimeStamp(double value);

} // Message

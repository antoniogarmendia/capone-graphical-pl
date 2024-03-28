/**
 */
package capone.impl;

import capone.CaponePackage;
import capone.Diagram;

import capone.Element;
import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Diagram</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link capone.impl.DiagramImpl#getViewpointFileURI <em>Viewpoint File URI</em>}</li>
 *   <li>{@link capone.impl.DiagramImpl#getOverridesElements <em>Overrides Elements</em>}</li>
 *   <li>{@link capone.impl.DiagramImpl#getMerge <em>Merge</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DiagramImpl extends MinimalEObjectImpl.Container implements Diagram {
	/**
	 * The default value of the '{@link #getViewpointFileURI() <em>Viewpoint File URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getViewpointFileURI()
	 * @generated
	 * @ordered
	 */
	protected static final String VIEWPOINT_FILE_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getViewpointFileURI() <em>Viewpoint File URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getViewpointFileURI()
	 * @generated
	 * @ordered
	 */
	protected String viewpointFileURI = VIEWPOINT_FILE_URI_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOverridesElements() <em>Overrides Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOverridesElements()
	 * @generated
	 * @ordered
	 */
	protected EList<Element> overridesElements;

	/**
	 * The cached value of the '{@link #getMerge() <em>Merge</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMerge()
	 * @generated
	 * @ordered
	 */
	protected EList<Element> merge;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DiagramImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CaponePackage.Literals.DIAGRAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getViewpointFileURI() {
		return viewpointFileURI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setViewpointFileURI(String newViewpointFileURI) {
		String oldViewpointFileURI = viewpointFileURI;
		viewpointFileURI = newViewpointFileURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CaponePackage.DIAGRAM__VIEWPOINT_FILE_URI, oldViewpointFileURI, viewpointFileURI));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Element> getOverridesElements() {
		if (overridesElements == null) {
			overridesElements = new EObjectContainmentEList<Element>(Element.class, this, CaponePackage.DIAGRAM__OVERRIDES_ELEMENTS);
		}
		return overridesElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Element> getMerge() {
		if (merge == null) {
			merge = new EObjectContainmentEList<Element>(Element.class, this, CaponePackage.DIAGRAM__MERGE);
		}
		return merge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CaponePackage.DIAGRAM__OVERRIDES_ELEMENTS:
				return ((InternalEList<?>)getOverridesElements()).basicRemove(otherEnd, msgs);
			case CaponePackage.DIAGRAM__MERGE:
				return ((InternalEList<?>)getMerge()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CaponePackage.DIAGRAM__VIEWPOINT_FILE_URI:
				return getViewpointFileURI();
			case CaponePackage.DIAGRAM__OVERRIDES_ELEMENTS:
				return getOverridesElements();
			case CaponePackage.DIAGRAM__MERGE:
				return getMerge();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CaponePackage.DIAGRAM__VIEWPOINT_FILE_URI:
				setViewpointFileURI((String)newValue);
				return;
			case CaponePackage.DIAGRAM__OVERRIDES_ELEMENTS:
				getOverridesElements().clear();
				getOverridesElements().addAll((Collection<? extends Element>)newValue);
				return;
			case CaponePackage.DIAGRAM__MERGE:
				getMerge().clear();
				getMerge().addAll((Collection<? extends Element>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case CaponePackage.DIAGRAM__VIEWPOINT_FILE_URI:
				setViewpointFileURI(VIEWPOINT_FILE_URI_EDEFAULT);
				return;
			case CaponePackage.DIAGRAM__OVERRIDES_ELEMENTS:
				getOverridesElements().clear();
				return;
			case CaponePackage.DIAGRAM__MERGE:
				getMerge().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CaponePackage.DIAGRAM__VIEWPOINT_FILE_URI:
				return VIEWPOINT_FILE_URI_EDEFAULT == null ? viewpointFileURI != null : !VIEWPOINT_FILE_URI_EDEFAULT.equals(viewpointFileURI);
			case CaponePackage.DIAGRAM__OVERRIDES_ELEMENTS:
				return overridesElements != null && !overridesElements.isEmpty();
			case CaponePackage.DIAGRAM__MERGE:
				return merge != null && !merge.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (viewpointFileURI: ");
		result.append(viewpointFileURI);
		result.append(')');
		return result.toString();
	}

} //DiagramImpl

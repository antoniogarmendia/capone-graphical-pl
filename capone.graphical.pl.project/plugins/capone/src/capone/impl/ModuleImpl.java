/**
 */
package capone.impl;

import capone.CaponePackage;
import capone.Diagram;
import capone.FileURI;
import capone.Formula;
import capone.RuleSet;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Module</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link capone.impl.ModuleImpl#isIsTop <em>Is Top</em>}</li>
 *   <li>{@link capone.impl.ModuleImpl#getName <em>Name</em>}</li>
 *   <li>{@link capone.impl.ModuleImpl#getMetamodel <em>Metamodel</em>}</li>
 *   <li>{@link capone.impl.ModuleImpl#getModuleMandatory <em>Module Mandatory</em>}</li>
 *   <li>{@link capone.impl.ModuleImpl#getModuleOptional <em>Module Optional</em>}</li>
 *   <li>{@link capone.impl.ModuleImpl#getModuleAlternative <em>Module Alternative</em>}</li>
 *   <li>{@link capone.impl.ModuleImpl#getModuleOr <em>Module Or</em>}</li>
 *   <li>{@link capone.impl.ModuleImpl#getRules <em>Rules</em>}</li>
 *   <li>{@link capone.impl.ModuleImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link capone.impl.ModuleImpl#getFormula <em>Formula</em>}</li>
 *   <li>{@link capone.impl.ModuleImpl#getChooseDiagram <em>Choose Diagram</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModuleImpl extends MinimalEObjectImpl.Container implements capone.Module {
	/**
	 * The default value of the '{@link #isIsTop() <em>Is Top</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsTop()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_TOP_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsTop() <em>Is Top</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsTop()
	 * @generated
	 * @ordered
	 */
	protected boolean isTop = IS_TOP_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getMetamodel() <em>Metamodel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetamodel()
	 * @generated
	 * @ordered
	 */
	protected static final String METAMODEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMetamodel() <em>Metamodel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetamodel()
	 * @generated
	 * @ordered
	 */
	protected String metamodel = METAMODEL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getModuleMandatory() <em>Module Mandatory</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModuleMandatory()
	 * @generated
	 * @ordered
	 */
	protected EList<capone.Module> moduleMandatory;

	/**
	 * The cached value of the '{@link #getModuleOptional() <em>Module Optional</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModuleOptional()
	 * @generated
	 * @ordered
	 */
	protected EList<capone.Module> moduleOptional;

	/**
	 * The cached value of the '{@link #getModuleAlternative() <em>Module Alternative</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModuleAlternative()
	 * @generated
	 * @ordered
	 */
	protected EList<capone.Module> moduleAlternative;

	/**
	 * The cached value of the '{@link #getModuleOr() <em>Module Or</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModuleOr()
	 * @generated
	 * @ordered
	 */
	protected EList<capone.Module> moduleOr;

	/**
	 * The cached value of the '{@link #getRules() <em>Rules</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRules()
	 * @generated
	 * @ordered
	 */
	protected RuleSet rules;

	/**
	 * The cached value of the '{@link #getImports() <em>Imports</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImports()
	 * @generated
	 * @ordered
	 */
	protected EList<FileURI> imports;

	/**
	 * The cached value of the '{@link #getFormula() <em>Formula</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormula()
	 * @generated
	 * @ordered
	 */
	protected Formula formula;

	/**
	 * The cached value of the '{@link #getChooseDiagram() <em>Choose Diagram</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChooseDiagram()
	 * @generated
	 * @ordered
	 */
	protected Diagram chooseDiagram;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CaponePackage.Literals.MODULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsTop() {
		return isTop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsTop(boolean newIsTop) {
		boolean oldIsTop = isTop;
		isTop = newIsTop;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CaponePackage.MODULE__IS_TOP, oldIsTop, isTop));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CaponePackage.MODULE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMetamodel() {
		return metamodel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetamodel(String newMetamodel) {
		String oldMetamodel = metamodel;
		metamodel = newMetamodel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CaponePackage.MODULE__METAMODEL, oldMetamodel, metamodel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<capone.Module> getModuleMandatory() {
		if (moduleMandatory == null) {
			moduleMandatory = new EObjectResolvingEList<capone.Module>(capone.Module.class, this, CaponePackage.MODULE__MODULE_MANDATORY);
		}
		return moduleMandatory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<capone.Module> getModuleOptional() {
		if (moduleOptional == null) {
			moduleOptional = new EObjectResolvingEList<capone.Module>(capone.Module.class, this, CaponePackage.MODULE__MODULE_OPTIONAL);
		}
		return moduleOptional;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<capone.Module> getModuleAlternative() {
		if (moduleAlternative == null) {
			moduleAlternative = new EObjectResolvingEList<capone.Module>(capone.Module.class, this, CaponePackage.MODULE__MODULE_ALTERNATIVE);
		}
		return moduleAlternative;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<capone.Module> getModuleOr() {
		if (moduleOr == null) {
			moduleOr = new EObjectResolvingEList<capone.Module>(capone.Module.class, this, CaponePackage.MODULE__MODULE_OR);
		}
		return moduleOr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleSet getRules() {
		return rules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRules(RuleSet newRules, NotificationChain msgs) {
		RuleSet oldRules = rules;
		rules = newRules;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CaponePackage.MODULE__RULES, oldRules, newRules);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRules(RuleSet newRules) {
		if (newRules != rules) {
			NotificationChain msgs = null;
			if (rules != null)
				msgs = ((InternalEObject)rules).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CaponePackage.MODULE__RULES, null, msgs);
			if (newRules != null)
				msgs = ((InternalEObject)newRules).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CaponePackage.MODULE__RULES, null, msgs);
			msgs = basicSetRules(newRules, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CaponePackage.MODULE__RULES, newRules, newRules));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FileURI> getImports() {
		if (imports == null) {
			imports = new EObjectContainmentEList<FileURI>(FileURI.class, this, CaponePackage.MODULE__IMPORTS);
		}
		return imports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Formula getFormula() {
		return formula;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFormula(Formula newFormula, NotificationChain msgs) {
		Formula oldFormula = formula;
		formula = newFormula;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CaponePackage.MODULE__FORMULA, oldFormula, newFormula);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFormula(Formula newFormula) {
		if (newFormula != formula) {
			NotificationChain msgs = null;
			if (formula != null)
				msgs = ((InternalEObject)formula).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CaponePackage.MODULE__FORMULA, null, msgs);
			if (newFormula != null)
				msgs = ((InternalEObject)newFormula).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CaponePackage.MODULE__FORMULA, null, msgs);
			msgs = basicSetFormula(newFormula, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CaponePackage.MODULE__FORMULA, newFormula, newFormula));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Diagram getChooseDiagram() {
		return chooseDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetChooseDiagram(Diagram newChooseDiagram, NotificationChain msgs) {
		Diagram oldChooseDiagram = chooseDiagram;
		chooseDiagram = newChooseDiagram;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CaponePackage.MODULE__CHOOSE_DIAGRAM, oldChooseDiagram, newChooseDiagram);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChooseDiagram(Diagram newChooseDiagram) {
		if (newChooseDiagram != chooseDiagram) {
			NotificationChain msgs = null;
			if (chooseDiagram != null)
				msgs = ((InternalEObject)chooseDiagram).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CaponePackage.MODULE__CHOOSE_DIAGRAM, null, msgs);
			if (newChooseDiagram != null)
				msgs = ((InternalEObject)newChooseDiagram).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CaponePackage.MODULE__CHOOSE_DIAGRAM, null, msgs);
			msgs = basicSetChooseDiagram(newChooseDiagram, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CaponePackage.MODULE__CHOOSE_DIAGRAM, newChooseDiagram, newChooseDiagram));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<capone.Module> getAllModuleDependencies() {
		EList<capone.Module> dependencies = new BasicEList<capone.Module>();
		dependencies.addAll(getModuleMandatory());
		dependencies.addAll(getModuleOptional());
		dependencies.addAll(getModuleAlternative());
		dependencies.addAll(getModuleOr());
		return dependencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CaponePackage.MODULE__RULES:
				return basicSetRules(null, msgs);
			case CaponePackage.MODULE__IMPORTS:
				return ((InternalEList<?>)getImports()).basicRemove(otherEnd, msgs);
			case CaponePackage.MODULE__FORMULA:
				return basicSetFormula(null, msgs);
			case CaponePackage.MODULE__CHOOSE_DIAGRAM:
				return basicSetChooseDiagram(null, msgs);
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
			case CaponePackage.MODULE__IS_TOP:
				return isIsTop();
			case CaponePackage.MODULE__NAME:
				return getName();
			case CaponePackage.MODULE__METAMODEL:
				return getMetamodel();
			case CaponePackage.MODULE__MODULE_MANDATORY:
				return getModuleMandatory();
			case CaponePackage.MODULE__MODULE_OPTIONAL:
				return getModuleOptional();
			case CaponePackage.MODULE__MODULE_ALTERNATIVE:
				return getModuleAlternative();
			case CaponePackage.MODULE__MODULE_OR:
				return getModuleOr();
			case CaponePackage.MODULE__RULES:
				return getRules();
			case CaponePackage.MODULE__IMPORTS:
				return getImports();
			case CaponePackage.MODULE__FORMULA:
				return getFormula();
			case CaponePackage.MODULE__CHOOSE_DIAGRAM:
				return getChooseDiagram();
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
			case CaponePackage.MODULE__IS_TOP:
				setIsTop((Boolean)newValue);
				return;
			case CaponePackage.MODULE__NAME:
				setName((String)newValue);
				return;
			case CaponePackage.MODULE__METAMODEL:
				setMetamodel((String)newValue);
				return;
			case CaponePackage.MODULE__MODULE_MANDATORY:
				getModuleMandatory().clear();
				getModuleMandatory().addAll((Collection<? extends capone.Module>)newValue);
				return;
			case CaponePackage.MODULE__MODULE_OPTIONAL:
				getModuleOptional().clear();
				getModuleOptional().addAll((Collection<? extends capone.Module>)newValue);
				return;
			case CaponePackage.MODULE__MODULE_ALTERNATIVE:
				getModuleAlternative().clear();
				getModuleAlternative().addAll((Collection<? extends capone.Module>)newValue);
				return;
			case CaponePackage.MODULE__MODULE_OR:
				getModuleOr().clear();
				getModuleOr().addAll((Collection<? extends capone.Module>)newValue);
				return;
			case CaponePackage.MODULE__RULES:
				setRules((RuleSet)newValue);
				return;
			case CaponePackage.MODULE__IMPORTS:
				getImports().clear();
				getImports().addAll((Collection<? extends FileURI>)newValue);
				return;
			case CaponePackage.MODULE__FORMULA:
				setFormula((Formula)newValue);
				return;
			case CaponePackage.MODULE__CHOOSE_DIAGRAM:
				setChooseDiagram((Diagram)newValue);
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
			case CaponePackage.MODULE__IS_TOP:
				setIsTop(IS_TOP_EDEFAULT);
				return;
			case CaponePackage.MODULE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CaponePackage.MODULE__METAMODEL:
				setMetamodel(METAMODEL_EDEFAULT);
				return;
			case CaponePackage.MODULE__MODULE_MANDATORY:
				getModuleMandatory().clear();
				return;
			case CaponePackage.MODULE__MODULE_OPTIONAL:
				getModuleOptional().clear();
				return;
			case CaponePackage.MODULE__MODULE_ALTERNATIVE:
				getModuleAlternative().clear();
				return;
			case CaponePackage.MODULE__MODULE_OR:
				getModuleOr().clear();
				return;
			case CaponePackage.MODULE__RULES:
				setRules((RuleSet)null);
				return;
			case CaponePackage.MODULE__IMPORTS:
				getImports().clear();
				return;
			case CaponePackage.MODULE__FORMULA:
				setFormula((Formula)null);
				return;
			case CaponePackage.MODULE__CHOOSE_DIAGRAM:
				setChooseDiagram((Diagram)null);
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
			case CaponePackage.MODULE__IS_TOP:
				return isTop != IS_TOP_EDEFAULT;
			case CaponePackage.MODULE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CaponePackage.MODULE__METAMODEL:
				return METAMODEL_EDEFAULT == null ? metamodel != null : !METAMODEL_EDEFAULT.equals(metamodel);
			case CaponePackage.MODULE__MODULE_MANDATORY:
				return moduleMandatory != null && !moduleMandatory.isEmpty();
			case CaponePackage.MODULE__MODULE_OPTIONAL:
				return moduleOptional != null && !moduleOptional.isEmpty();
			case CaponePackage.MODULE__MODULE_ALTERNATIVE:
				return moduleAlternative != null && !moduleAlternative.isEmpty();
			case CaponePackage.MODULE__MODULE_OR:
				return moduleOr != null && !moduleOr.isEmpty();
			case CaponePackage.MODULE__RULES:
				return rules != null;
			case CaponePackage.MODULE__IMPORTS:
				return imports != null && !imports.isEmpty();
			case CaponePackage.MODULE__FORMULA:
				return formula != null;
			case CaponePackage.MODULE__CHOOSE_DIAGRAM:
				return chooseDiagram != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case CaponePackage.MODULE___GET_ALL_MODULE_DEPENDENCIES:
				return getAllModuleDependencies();
		}
		return super.eInvoke(operationID, arguments);
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
		result.append(" (isTop: ");
		result.append(isTop);
		result.append(", name: ");
		result.append(name);
		result.append(", metamodel: ");
		result.append(metamodel);
		result.append(')');
		return result.toString();
	}

} //ModuleImpl

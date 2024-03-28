package capone.composer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.sirius.diagram.description.NodeMapping;
import org.eclipse.sirius.diagram.description.impl.DescriptionPackageImpl;
import org.eclipse.sirius.diagram.description.style.NodeStyleDescription;
import org.eclipse.sirius.diagram.description.style.SquareDescription;
import org.eclipse.sirius.diagram.description.style.impl.StylePackageImpl;
import org.eclipse.sirius.viewpoint.description.DescriptionPackage;
import org.eclipse.sirius.viewpoint.description.Group;
import org.eclipse.sirius.viewpoint.description.IdentifiedElement;

import capone.Element;
import capone.FeatureElement;
import capone.Module;
import capone.composer.helper.CaponeHelper;
import capone.composer.helper.EMFUtils;
import de.ovgu.featureide.fm.core.configuration.Configuration;

public class ViewpointComposer {
	/*
	 * Root Capone Module
	 */
	final Module caponeModule;
	/*
	 * Folder to store the viewpoint
	 */
	final IFolder iFolder; 
	/*
	 * FeatureIDE Configuration
	 */
	final Configuration configuration;
	/*
	 * Mapping of each module to its submodules
	 */
	final Map<Module, List<Module>> modules;
	/*
	 * Trace of every object. This means where originaly each object come from (which module)
	 */
	Map<String, Module> pathEObjectToModule;
	/*
	 * Generate Ecore for this configuration
	 */
	final EPackage ePackage;
	
	public ViewpointComposer(final Module caponeModule, final IFolder iFolder, final Configuration configuration,
			final Map<Module, List<Module>> modules, Resource ecore) {
		this.caponeModule = caponeModule;
		this.iFolder = iFolder;
		this.configuration = configuration;
		this.modules = modules;
		this.pathEObjectToModule = new HashMap<String, Module>();
		if (ecore != null)
			this.ePackage = (EPackage) ecore.getContents().get(0);
		else 
			this.ePackage = null;
	}

	public Group generateViewpoint() {
		// Get the odesign
		if (getCaponeModule().getChooseDiagram() == null)
			return null;
		final String viewpointFile = getCaponeModule().getChooseDiagram().getViewpointFileURI();
		final Path viewpointPath = new Path(
				getiFolder().getProject().getFullPath().toOSString() + String.valueOf(Path.SEPARATOR) + viewpointFile);
		final Group moduleViewpoint = EMFUtils.loadOdesign(viewpointPath);
		if (moduleViewpoint == null) {
			System.out.println("The viewpoint " + viewpointPath + "does not exist");
		}
		final Group viewpointComposer = EcoreUtil.copy(moduleViewpoint);
		//Initialize the path
		this.pathEObjectToModule = EMFUtils.pathEObjectToModule(viewpointComposer, getCaponeModule());
		//Resource and ResourceSet for the new product
		final URI viewpointURI = URI.createFileURI(new File(
				getiFolder().getLocation().toOSString() + File.separator + getCaponeModule().getName() + ".odesign")
				.getAbsolutePath());
		final ResourceSet reset = new ResourceSetImpl();
		final Resource newr = reset.createResource(viewpointURI);
		newr.getContents().add(viewpointComposer);		
		// Compose Viewpoint with the viewpoints enabled (by the different features)
		composeViewpoint(viewpointComposer);
		// Save in the folder		
		try {
			newr.save(Collections.emptyMap());
		} catch (IOException e) {
			System.err.println("[Capone] Error saving file " + viewpointURI);
			e.printStackTrace();
		}
		return viewpointComposer;
	}
	
	/*
	 * The groupComposer is the group provided by the root module (always available)
	 * */
	private void composeViewpoint(Group groupComposer) {
		// Get active viewpoints
		final Map<Module, Group> moduleToGroup = getEnabledViewpoints(groupComposer.eResource().getResourceSet());
		for (Entry<Module, Group> entryModuleToGroup : moduleToGroup.entrySet()) {
			extend(groupComposer, entryModuleToGroup);
		}
		updateReferences(groupComposer);
	}

	@SuppressWarnings({"unchecked" })
	private void extend(Group groupComposer, Entry<Module, Group> entryModuleToGroup) {
		final Group configGroup = entryModuleToGroup.getValue();
		final Module module = entryModuleToGroup.getKey();
		final Map<EObject, EObject> composeObjectToConfigObject = new HashMap<EObject, EObject>();
		// Check same group
		if (groupComposer.getName().equals(configGroup.getName())) {
			// Add first map
			composeObjectToConfigObject.put(groupComposer, configGroup);
			//Iterate over all the elements of the config Group
			for (TreeIterator<EObject> treeIterator = configGroup.eAllContents(); treeIterator.hasNext();) {
				final EObject currentConfigEObject = treeIterator.next();
				if (currentConfigEObject instanceof IdentifiedElement currentConfigIdentifiedElement) {
					// Search in the composeViewpoint
					final EObject composeContainer = EMFUtils
							.getKeysByValue(composeObjectToConfigObject, currentConfigIdentifiedElement.eContainer());
					if (composeContainer == null) continue;
					final IdentifiedElement currentComposeIdentifiedElement = EMFUtils
							.findByName(currentConfigIdentifiedElement, composeContainer.eContents());
					if (currentComposeIdentifiedElement != null) {
						composeObjectToConfigObject.put(currentComposeIdentifiedElement, currentConfigIdentifiedElement);
						final boolean overrideElement = overrideElement(currentConfigIdentifiedElement, null, module);
						if (overrideElement) {							
							final EReference containmentFeature = currentConfigIdentifiedElement.eContainmentFeature();
							final IdentifiedElement copyConfigIdentifiedElement = EcoreUtil
									.copy(currentConfigIdentifiedElement);
							if (containmentFeature.isMany()) {
								//Add new one
								((EList<EObject>)currentComposeIdentifiedElement.eContainer()
										.eGet(containmentFeature)).add(copyConfigIdentifiedElement);
								//Remove compose Element
								((EList<EObject>)currentComposeIdentifiedElement.eContainer()
										.eGet(containmentFeature)).remove(currentComposeIdentifiedElement);										
							}
							else
								currentComposeIdentifiedElement.eContainer().eSet(containmentFeature, copyConfigIdentifiedElement);		
							//Update traces
							getPathEObjectToModule().replace(currentConfigIdentifiedElement.getName(), module);
							//Remove the composeViewpoint
							treeIterator.prune();
						} else {
							mergeIdentifiedElements(currentComposeIdentifiedElement, currentConfigIdentifiedElement, module);
						}						
					} else {
						addMissingElement(module, treeIterator, currentConfigIdentifiedElement, composeContainer);
					}					
				} else {
					//Already merged when merging identified elements
					treeIterator.prune();
				}
			}			
		} else {
			throw new AssertionError("Cannot merge group of module: " + module.getName());
		}
	}

	@SuppressWarnings("unchecked")
	private void addMissingElement(final Module module, TreeIterator<EObject> treeIterator,
			IdentifiedElement currentConfigIdentifiedElement, final EObject composeContainer) {
		//Add missing EObject
		final EObject copyCofigObject = EcoreUtil.copy(currentConfigIdentifiedElement);
		final EReference containmentFeature = currentConfigIdentifiedElement.eContainmentFeature();
		((EList<EObject>) composeContainer.eGet(containmentFeature)).add(copyCofigObject);
		getPathEObjectToModule().putAll(EMFUtils.pathEObjectToModule(copyCofigObject, module));				
		treeIterator.prune();
	}

	@SuppressWarnings({"unchecked"})
	private void updateReferences(Group viewpointComposer) {
		final Map<EObject, Collection<Setting>> externalCrossReferences = EcoreUtil.ExternalCrossReferencer
				.find(viewpointComposer);
		for (Map.Entry<EObject, Collection<Setting>> entry : externalCrossReferences.entrySet()) {
			final EObject eObject = entry.getKey();
			final Collection<Setting> settings = entry.getValue();
			if (eObject instanceof IdentifiedElement oldIdentifiedElement) {
				final IdentifiedElement newIdentifiedElement = EMFUtils.findByName(oldIdentifiedElement, viewpointComposer.eAllContents());
				for(Setting setting: settings) {
					final EObject parentEObject = setting.getEObject();
					final EStructuralFeature structFeature = setting.getEStructuralFeature();
					final Object object = parentEObject.eGet(structFeature);
					if (object instanceof Collection<?> listOfReferences) {					
						listOfReferences.remove(eObject);
						((Collection<EObject>)parentEObject.eGet(structFeature)).add(newIdentifiedElement);
					} else if (object instanceof IdentifiedElement settingElement){
						if (settingElement.getName().equals(newIdentifiedElement.getName()))
							parentEObject.eSet(structFeature, newIdentifiedElement);
					}	
				}
			}			
		}		
	}

	private void mergeIdentifiedElements(IdentifiedElement currentComposeIdentifiedElement,
			IdentifiedElement configIdentifiedElement, Module module) {
		for (Iterator<EStructuralFeature> iterator = currentComposeIdentifiedElement.eClass().getEAllStructuralFeatures()
				.iterator(); iterator.hasNext();) {
			final EStructuralFeature composeEStructFeat = iterator.next();
			if (composeEStructFeat instanceof EAttribute composeEAttribute) {
				final Object configValue = configIdentifiedElement.eGet(composeEAttribute);
				final Object composeValue = currentComposeIdentifiedElement.eGet(composeEAttribute);
				mergeEAttribute(currentComposeIdentifiedElement, configValue, composeValue, composeEAttribute, module);				
			} else if (composeEStructFeat instanceof EReference composeReference && composeReference.isDerived() == false) {
				//The derived references should not be analysed.
				mergeReferencesIE(currentComposeIdentifiedElement, configIdentifiedElement,
							composeReference, module);				
			}
		}	
	}
	
	/*
	 * Merge Refereces of Identified Elements
	 */
	private void mergeReferencesIE(final IdentifiedElement currentComposeIdentifiedElement,
			IdentifiedElement configIdentifiedElement, EReference composeReference, Module module) {
		if (!isChangeAllowed(composeReference))
			return;
		if (IdentifiedElement.class.isAssignableFrom(composeReference.getEReferenceType().getInstanceClass())) {
			if (composeReference.isContainment() == true)
				return;
			else {
				mergeIENonContainmentReferences(currentComposeIdentifiedElement, configIdentifiedElement, composeReference, module);
			}
		} else {
			if (composeReference.isContainment())
				mergeEContainmentIE(currentComposeIdentifiedElement, configIdentifiedElement, composeReference, module);
			else 
				mergeENonContainmentIE(currentComposeIdentifiedElement, configIdentifiedElement, composeReference, module);			
		}
	}
		
	private void mergeIENonContainmentReferences(final IdentifiedElement currentComposeIdentifiedElement, 
			IdentifiedElement configIdentifiedElement, EReference composeReference, Module module) {
		final Object composeValue = currentComposeIdentifiedElement.eGet(composeReference);
		final Object configValue = configIdentifiedElement.eGet(composeReference);			
		//When config and compose values are not null
		if (checkGeneralReferenceIsEmpty(configValue))
			return;
		if (!checkGeneralReferenceIsEmpty(composeValue)) {
			final boolean override = overrideElement(currentComposeIdentifiedElement, composeReference, module);
			if (override) {
				overrideGeneralReferences(currentComposeIdentifiedElement, composeReference, configValue);				
			} else {
				mergeNonContainmentReferencesToIdentifiedElements(composeReference, composeValue, 
						configValue, currentComposeIdentifiedElement, module);
			}						
		} else {
			overrideGeneralReferences(currentComposeIdentifiedElement, composeReference, configValue);
		}		
	}
	
	private void mergeNonContainmentReferencesToIdentifiedElements(final EReference composeReference, final Object composeValue,
			final Object configValue, final IdentifiedElement currentComposeIdentifiedElement, Module module) {
		if (composeReference.isMany()) {
			@SuppressWarnings("unchecked")
			final EList<EObject> composeEList = (EList<EObject>) composeValue;
			@SuppressWarnings("unchecked")
			final EList<EObject> configEList = (EList<EObject>) configValue;
			for (Object object : configEList) {
				final IdentifiedElement reference = (IdentifiedElement) object;
				final IdentifiedElement existReference = (IdentifiedElement) composeEList.stream()
											.filter(ie -> ((IdentifiedElement)ie).getName().equals(reference.getName()))
											.findAny().orElse(null);					
				if (existReference == null) 						
					composeEList.add(reference);
			}				
		} else if (isParentOfExistingValue(module, currentComposeIdentifiedElement) ||
				overrideElement(currentComposeIdentifiedElement, composeReference, module)) {
			//Replace reference
			currentComposeIdentifiedElement.eSet(composeReference, EcoreUtil.copy((EObject)configValue));
			//Update traces
			getPathEObjectToModule().replace(currentComposeIdentifiedElement.getName(), module);	
		}
	}
	
	private void mergeENonContainmentIE(final IdentifiedElement currentComposeIdentifiedElement, final IdentifiedElement configIdentifiedElement, 
			final EReference composeReference, final Module module) {
		final Object composeValue = currentComposeIdentifiedElement.eGet(composeReference);
		final Object configValue = configIdentifiedElement.eGet(composeReference);	
		//When config is null
		if (checkGeneralReferenceIsEmpty(configValue))
			return;
		if (composeReference.isMany()) {
			//Merge elements
			@SuppressWarnings("unchecked")
			final Collection<EObject> composeEList = (Collection<EObject>) composeValue;
			@SuppressWarnings("unchecked")
			final Collection<EObject> configEList = (Collection<EObject>) configValue;
			composeEList.addAll(EcoreUtil.copyAll(configEList));	
		} else {
			final EObject composeValueEObject = (EObject)composeValue;
			final EObject configValueEObject  = (EObject)configValue;
			if (composeValueEObject.eClass().equals(configValueEObject.eClass()))
				mergeEObject((EObject)composeValue, (EObject)configValue, module);
			else if (isParentOfExistingValue(module, currentComposeIdentifiedElement)){
				overrideGeneralReferences(currentComposeIdentifiedElement, composeReference, configValueEObject);
			}
		}		
	}
	
	//Merge elements that contains non identified elements contained in a IE
	private void mergeEContainmentIE(final IdentifiedElement currentComposeIdentifiedElement, final IdentifiedElement configIdentifiedElement,
			final EReference composeReference, final Module module) {
		final Object composeValue = currentComposeIdentifiedElement.eGet(composeReference);
		final Object configValue = configIdentifiedElement.eGet(composeReference);	
		//When config is null
		if (checkGeneralReferenceIsEmpty(configValue))
			return;
		if (composeReference.isMany()) {
			//Merge elements
			@SuppressWarnings("unchecked")
			final Collection<EObject> composeEList = (Collection<EObject>) composeValue;
			@SuppressWarnings("unchecked")
			final Collection<EObject> configEList = (Collection<EObject>) configValue;
			composeEList.addAll(EcoreUtil.copyAll(configEList));		
		} else {
			final EObject composeValueEObject = (EObject)composeValue;
			final EObject configValueEObject  = (EObject)configValue;
			if (checkGeneralReferenceIsEmpty(composeValueEObject))
				overrideGeneralReferences(currentComposeIdentifiedElement, composeReference, configValueEObject);
			else if (composeValueEObject.eClass().equals(configValueEObject.eClass()))
				mergeEObject((EObject)composeValue, (EObject)configValue, module);
			else if (isParentOfExistingValue(module, currentComposeIdentifiedElement)){
				overrideGeneralReferences(currentComposeIdentifiedElement, composeReference, configValueEObject);
			}
		}		
	}
	
	//Merge EObject of the same EClass 
	private void mergeEObject(EObject currentCompose, EObject currentConfig, Module module) {
		for (Iterator<EStructuralFeature> iterator = currentCompose.eClass().getEAllStructuralFeatures()
				.iterator(); iterator.hasNext();) {
			final EStructuralFeature composeEStructFeat = iterator.next();
			final Object configStructValue =  currentConfig.eGet(composeEStructFeat);
			final Object composeStructValue =  currentCompose.eGet(composeEStructFeat);
			if (checkGeneralObjectIsEmpty(configStructValue))
				continue;
			if (composeEStructFeat instanceof EAttribute eAttribute) {
				mergeEAttribute(currentCompose, configStructValue, composeStructValue, eAttribute, module);				
			} else if (composeEStructFeat instanceof EReference eReference) {
				mergeGeneralReferences(currentCompose, eReference, configStructValue, module);
			}
		}		
	}
	 
	@SuppressWarnings("unchecked")
	private void mergeGeneralReferences(EObject composeValue, EReference eReference, Object configStructValue, 
			Module module) {
		if (eReference.isMany()) {
			//Merge the elements
			((EList<EObject>)composeValue.eGet(eReference)).addAll((Collection<EObject>) configStructValue);
		} else if (eReference.isContainment() && 
				composeValue.eClass().equals(((EObject)configStructValue).eClass())) {
				mergeEObject(composeValue, ((EObject)configStructValue), module);
		} else if (isParentOfExistingValue(module,composeValue)) {
			overrideGeneralReferences(composeValue, eReference, configStructValue);			
		}		
	}

	@SuppressWarnings("unchecked")
	private void overrideGeneralReferences(final EObject currentComposeIdentifiedElement,
			final EReference composeReference, final Object configValue) {
		if (composeReference.isContainment()) {		
			if (composeReference.isMany())
				currentComposeIdentifiedElement.eSet(composeReference, EcoreUtil.copyAll((Collection<EObject>)configValue));		
			else
				currentComposeIdentifiedElement.eSet(composeReference, EcoreUtil.copy((EObject) configValue));
		} else {
			if (composeReference.isMany())
				currentComposeIdentifiedElement.eSet(composeReference, (Collection<EObject>)configValue);		
			else
				currentComposeIdentifiedElement.eSet(composeReference, (EObject) configValue);
		}
	}
	
	/*
	 * Do not allow the override in certain elements
	 * */
	private boolean isChangeAllowed(EReference composeReference) {
		final EClass containingClass = composeReference.getEContainingClass();
		if (containingClass.getName().equals("RepresentationDescription")) {
			//Do not change the meta-model reference
			if (composeReference.getFeatureID() == DescriptionPackage.REPRESENTATION_DESCRIPTION__METAMODEL)
				return false;
		}	
		return true;
	}
	
	/*
	 * Check if this object came from a parent module
	 * 
	 * configValue should be different from null
	 * */
	private boolean isParentOfExistingValue(Module module, 
			EObject currentComposeIdentifiedElement) {		
		final String pathElement = EMFUtils.getIdentifierContainerPath(currentComposeIdentifiedElement);
		final Module parentModule = getPathEObjectToModule().get(pathElement);
		if (module.equals(parentModule) || isParentOf(parentModule, module))
			return true;
		return false;		
	}
	
	/*
	 * Returns true if childModule is actually a child of parentModule 
	 * */	
	private boolean isParentOf(Module parentModule, Module childModule) {	
		final List<Module> childrenList = getModules().get(parentModule);
		// Create a Priority Queue
		final EList<Module> childrenQueue = new BasicEList<Module>();
		childrenQueue.addAll(childrenList);
		for (ListIterator<Module> listIterator = childrenQueue.listIterator(); listIterator.hasNext();) {
			final Module m = listIterator.next();
			if(m.equals(childModule))
				return true;
			// Add children to the queue
			for (Module nextChildModule: getModules().get(m)) {
				listIterator.add(nextChildModule);
				listIterator.previous();
			}
		}				
		return false;
	}
	
	private void mergeEAttribute(final EObject currentCompose, final Object configValue,
			final Object composeValue, final EAttribute composeEAttribute, final Module module) {
		if (!checkGeneralIsEmpty(configValue)
				&& !isDefaultEnumerator(composeEAttribute,configValue)) {			
			final String path = EMFUtils.getPath(currentCompose) + "." + composeEAttribute.getName();
			if(enableMerge(path, module)) {
				final String concatValue = mergeStringExpressions(composeValue.toString(),
						configValue.toString());
				currentCompose.eSet(composeEAttribute, concatValue);				
			} else if(isParentOfExistingValue(module, currentCompose)) {
				currentCompose.eSet(composeEAttribute, configValue);
			}			
		}
	}
	
	private String mergeStringExpressions(String composeString, String configString) {
		final StringBuilder mergeString = new StringBuilder();
		if (!composeString.startsWith("aql:"))
			mergeString.append("aql:" + composeString);
		else
			mergeString.append(composeString);
		if (configString.startsWith("aql:"))
			mergeString.append(".concat(" + configString.substring(4) + ")");		
		return mergeString.toString();
	}

	private boolean enableMerge(String path, Module module) {
		final EList<Element> listOfMerges = module.getChooseDiagram().getMerge();		
		for (Element mergeElement : listOfMerges) {
			String mergePath = mergeElement.getElementId();
			if (mergeElement.getFeature() != null)
				mergePath = mergePath + "." + getPathOfElement(mergeElement.getFeature()); 
			if (mergePath.equals(path))
				return true;
		}		
		return false;
	}

	private String getPathOfElement(FeatureElement featureElement) {
		final List<String> path = new ArrayList<String>();
		path.add(featureElement.getFeatureId());
		if (featureElement.getFeature() != null)
			path.add(getPathOfElement(featureElement.getFeature()));
		return String.join(".", path);
	}

	private boolean isDefaultEnumerator(EAttribute composeEAttribute, Object configValue) {
		if (configValue instanceof Enumerator enumerator) {
			if (enumerator.getValue() == 0)
				return true;			
		}
		return false;
	}
	
	private boolean checkGeneralObjectIsEmpty(Object value) {
		if (value != null) {
			if (value instanceof List) {
				return ((List<?>) value).isEmpty();
			} else 
				return false;
		}		
		return true;
	}

	private boolean checkGeneralReferenceIsEmpty(Object configReferenceValue) {
		if (configReferenceValue != null) {
			if (configReferenceValue instanceof List) {
				return ((List<?>) configReferenceValue).isEmpty();
			} else 
				return false;
		}		
		return true;
	}

	private boolean checkGeneralIsEmpty(Object configAttrValue) {
		if (configAttrValue == null)
			return true;
		if (configAttrValue instanceof String) { 
			return ((String) configAttrValue).isEmpty();
		} else if (configAttrValue instanceof List) {
			return ((List<?>) configAttrValue).isEmpty();
		} 
		return false;
	}

	private boolean overrideElement(final EObject composeEObject, final EStructuralFeature struct, final Module module) {
		final EList<Element> listOfOverridesElements = module.getChooseDiagram().getOverridesElements();
		if (listOfOverridesElements.isEmpty()) {
			return false;
		} else {
			String composeObjectPath = EMFUtils.getPath(composeEObject);
			if (struct != null)
				composeObjectPath += "." + struct.getName();
			for (Element overrideElement : listOfOverridesElements) {
				final String overridePath = EMFUtils.getPathFromOverrideElement(overrideElement);
				if (composeObjectPath.equals(overridePath)) {
					if (overrideElement.getOverModules().isEmpty())
						return true;
					final String containerPath = EMFUtils.getIdentifierContainerPath(composeEObject);
					final Module originModule =  getPathEObjectToModule().get(containerPath);
					if (overrideElement.getOverModules().indexOf(originModule) != -1)
						return true;
					else
						return false;					
				}				
			}
		}
		return false;
	}	

	public void mergeNodeMapping(NodeMapping composeNodeMapping, NodeMapping configNodeMapping) {
		final EList<EAttribute> listOfEAttributes = DescriptionPackageImpl.init().getNodeMapping().getEAllAttributes();
		// Override the Attributes
		for (Iterator<EAttribute> iterator = listOfEAttributes.iterator(); iterator.hasNext();) {
			final EAttribute eAttribute = iterator.next();
			final Object eAttrValue = composeNodeMapping.eGet(eAttribute);
			if (eAttrValue != null) {
				final Object configEAttrValue = configNodeMapping.eGet(eAttribute);
				composeNodeMapping.eSet(eAttribute, configEAttrValue);
			}
		}
		// Merge Style
		if (composeNodeMapping.getStyle() != null && configNodeMapping.getStyle() != null)
			mergeStyle(composeNodeMapping.getStyle(), configNodeMapping.getStyle());
		else if (composeNodeMapping.getStyle() == null && configNodeMapping.getStyle() != null) {
			overrideStyle(composeNodeMapping, configNodeMapping);
		}
	}
	
	private void overrideStyle(NodeMapping composedNode, NodeMapping configNode) {
		NodeStyleDescription nsd = configNode.getStyle();
		NodeStyleDescription nsdCopy = EcoreUtil.copy(nsd);
		composedNode.setStyle(nsdCopy);
	}

	private void mergeStyle(NodeStyleDescription composeStyle, NodeStyleDescription configStyle) {
		if (composeStyle instanceof SquareDescription && configStyle instanceof SquareDescription) {
			final EList<EAttribute> listOfAttributes = StylePackageImpl.init().getSquareDescription()
					.getEAllAttributes();
			final SquareDescription squareComposeStyle = (SquareDescription) composeStyle;
			final SquareDescription squareConfigStyle = (SquareDescription) configStyle;
			// Override the Attributes
			for (Iterator<EAttribute> iterator = listOfAttributes.iterator(); iterator.hasNext();) {
				final EAttribute eAttribute = iterator.next();
				final Object eAttrValue = squareComposeStyle.eGet(eAttribute);
				if (eAttrValue != null) {
					final Object configEAttrValue = squareConfigStyle.eGet(eAttribute);
					squareComposeStyle.eSet(eAttribute, configEAttrValue);
				}
			}
		} else {
			System.out.println("[Capone] The styles are different:" + composeStyle.getClass().getName() + "vs. "
					+ configStyle.getClass().getName());
		}
	}

	/*
	 * Returns a map of available module to implemented Group
	 * */
	private Map<Module, Group> getEnabledViewpoints(final ResourceSet resourceSet) {
		final Map<Module, Group> moduleToGroupVp = new LinkedHashMap<>();
		// Start from the root Capone Module. Always Active.
		final List<Module> childrenRootModule = getModules().get(getCaponeModule());
		// Create a Priority Queue
		final List<Module> childrenRootQueue = new LinkedList<Module>();
		childrenRootQueue.addAll(childrenRootModule);
		for (ListIterator<Module> listIterator = childrenRootQueue.listIterator(); listIterator.hasNext();) {
			final Module m = (Module) listIterator.next();
			if (CaponeHelper.active(m, configuration) && m.getChooseDiagram() != null) {
				final String viewpointFile = m.getChooseDiagram().getViewpointFileURI();
				final Path viewpointPath = new Path(getiFolder().getProject().getFullPath().toOSString()
						+ String.valueOf(Path.SEPARATOR) + viewpointFile);
				final Group moduleViewpoint = EMFUtils.loadOdesign(viewpointPath, resourceSet);
				moduleToGroupVp.put(m, moduleViewpoint);				
			}	
			// Add children to the Iterator
			for (Module childModule: getModules().get(m)) {
				listIterator.add(childModule);
				listIterator.previous();
			}
		}		
		return moduleToGroupVp;
	}

	public Module getCaponeModule() {
		return this.caponeModule;
	}

	public IFolder getiFolder() {
		return iFolder;
	}

	public Configuration getConfiguration() {
		return configuration;
	}

	public Map<Module, List<Module>> getModules() {
		return modules;
	}

	public Map<String, Module> getPathEObjectToModule() {
		return pathEObjectToModule;
	}

	public EPackage getePackage() {
		return ePackage;
	}
}

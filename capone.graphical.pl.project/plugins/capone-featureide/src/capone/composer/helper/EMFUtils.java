package capone.composer.helper;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

import capone.Element;
import capone.FeatureElement;
import capone.Module;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.codegen.ecore.generator.Generator;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenBaseGeneratorAdapter;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecoretools.design.ui.wizard.EcoreModelingProjectCreationOperation;
import org.eclipse.sirius.business.api.helper.SiriusUtil;
import org.eclipse.sirius.viewpoint.description.Group;
import org.eclipse.sirius.viewpoint.description.IdentifiedElement;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkingSet;

public class EMFUtils {
	
	// Suppress default constructor for noninstantiability
	private EMFUtils() {
		new AssertionError("This class cannot be subclassed");
	}
	
	public static Group loadOdesign(Path path, ResourceSet reset) {
		final Resource resource = reset.getResource(URI.createFileURI(path.toString()), true);
		return (Group) resource.getContents().get(0);
	}
	
	public static Group loadOdesign(Path path) {
		final Resource resource = loadResourceOdesign(path);	
		return (Group) resource.getContents().get(0);
	}
	
	public static Resource loadResourceOdesign(Path path) {
		final ResourceSet resourceSet = new ResourceSetImpl();
		final Resource resource = resourceSet.getResource(URI.createFileURI(path.toString()), true);
		return resource;
	}
	
	public static Resource loadResource(URI uri) {
		final ResourceSet resourceSet = new ResourceSetImpl();
		final Resource resource = resourceSet.getResource(uri, true);
		return resource;
	}
	
	@SuppressWarnings("unchecked") 
	public static <T extends IdentifiedElement> T findByName(final IdentifiedElement identifiedElement, final EList<EObject> listOfIdentifiedElements) {
		return (T) listOfIdentifiedElements.stream()
								.filter(IdentifiedElement.class::isInstance)
								.map(IdentifiedElement.class::cast)
								.filter(i -> ((IdentifiedElement)i).getName().equals(identifiedElement.getName()))
								.findAny().orElse(null);		
	}
	
	@SuppressWarnings("unchecked") 
	public static <T extends IdentifiedElement> T findByName(final IdentifiedElement identifiedElement, final TreeIterator<EObject> eAllContents) {
		for (; eAllContents.hasNext();) {
			final EObject eObject = (EObject) eAllContents.next();
			if (eObject instanceof IdentifiedElement &&
					((IdentifiedElement) eObject).getName().equals(identifiedElement.getName())) {
				return (T) eObject;
			}
		}
		return null;		
	}
	
	public static <T, E> T getKeysByValue(Map<T, E> map, E value) {
	    return map.entrySet()
	              .stream()
	              .filter(entry -> Objects.equals(entry.getValue(), value))
	              .map(Map.Entry::getKey)
	              .findAny()
	              .orElse(null);
	}	
	
	public static EPackage copyPackage(IFile ecoreFile) {
		final URI resourcePlatformURI = URI.createPlatformResourceURI(ecoreFile.getFullPath().toString(), true);
		final Resource emfResource = EMFUtils.loadResource(resourcePlatformURI);
		return (EPackage)EcoreUtil.copy(emfResource.getContents().get(0));				
	}
	
	public static Group copyGroupViewpoint(IFile viewpointIResource) {
		final URI resourcePlatformURI = URI.createPlatformResourceURI(viewpointIResource.getFullPath().toString(), true);
		final Resource emfResource = EMFUtils.loadResource(resourcePlatformURI);
		return (Group)EcoreUtil.copy(emfResource.getContents().get(0));				
	}	
	
	public static void generateEcoreEditEditorProject(String projectName, String ecoreName, EPackage ePackage, IWorkbench workbench) {
		final IPath genModelProjectLocation = new Path("/" + projectName);		
		final IPath genModelContainerPath = genModelProjectLocation.append("src-gen");
		// Ecore Modeling Project Creation
		final EcoreModelingProjectCreationOperation ecoreModelingProjectCreationOperation = 
					new EcoreModelingProjectCreationOperation(ePackage, ecoreName + ".ecore", 
							ecoreName + ".genModel", ecoreName + "." + SiriusUtil.SESSION_RESOURCE_EXTENSION,
				Collections.emptySet(), workbench, genModelContainerPath, genModelProjectLocation, new IWorkingSet[]{});		
		// Use the progess service to execute the runnable
		try {
			ecoreModelingProjectCreationOperation.run(null);
		} catch (InvocationTargetException | InterruptedException e) {
			e.printStackTrace();
		}
		
	    generateEditEditorCode(ecoreModelingProjectCreationOperation.getEcoreModel());	    
	}
	
	public static void generateEditEditorCode(IFile ecoreModelFile) {
		final Generator generator = new Generator();
		final IPath genModelPath = ecoreModelFile.getFullPath().removeFileExtension().addFileExtension("genModel");
		final GenModel genModel = loadGenModel(genModelPath);
		//Generate Model Code
		generator.setInput(genModel);
		genModel.setCanGenerate(true);
		generator.generate(genModel,GenBaseGeneratorAdapter.MODEL_PROJECT_TYPE,
				new BasicMonitor.Printing(System.err));
		//Generate Edit Code
		generator.generate(genModel,
				 GenBaseGeneratorAdapter.EDIT_PROJECT_TYPE,
				 new BasicMonitor.Printing(System.err));
		//Generate Editor Code
		generator.generate(genModel,
				GenBaseGeneratorAdapter.EDITOR_PROJECT_TYPE,
				new BasicMonitor.Printing(System.err));
	}
	
	public static GenModel loadGenModel(IPath genModelPath) {
		final ResourceSet resourceSet = new ResourceSetImpl();
		final URI genModelURI = URI.createPlatformResourceURI(genModelPath.toString(), true);
		final GenModel genmodel = (GenModel)resourceSet.getResource(genModelURI,
				true).getContents().get(0);
		return genmodel;
	}

	public static void setTargetMetamodels(Group viewpointGroup, EPackage ePackage) {
		// Remove all the meta-models in all diagram descriptions and add the ePackage
		viewpointGroup.getOwnedViewpoints().stream()
			.map(vpList -> vpList.getOwnedRepresentations())
			.flatMap(Collection::stream)
			.forEach(repreDescription -> {
				repreDescription.getMetamodel().clear();
				repreDescription.getMetamodel().add(ePackage);
			});
			;		
	}
	
	/*
	 * Get the path of the EObject that belongs to the Viewpoint Specification diagram
	 * 
	 * Containment reference should be from 0..1.
	 * */	
	public static String getPath(EObject eObject) {
		if (eObject instanceof IdentifiedElement identifiedElement)
			return identifiedElement.getName();
		final List<String> path = new ArrayList<String>();
		while(eObject.eContainer() != null) {
			final EStructuralFeature containingFeature = eObject.eContainingFeature();
			path.add(0, containingFeature.getName());
			if (eObject.eContainer() instanceof IdentifiedElement identifiedElement) {
				path.add(0, identifiedElement.getName());
				break;
			}							
			eObject = eObject.eContainer();
		}
		return String.join(".", path);
	}
	
	public static String getIdentifierContainerPath(EObject eObject) {
		while(eObject != null) {
			if (eObject instanceof IdentifiedElement identifiedElement)
				return identifiedElement.getName();
			eObject = eObject.eContainer();			
		}		
		return null;
	}
	
	/*
	 * Initialize the path of every EObject
	 * */	
	public static Map<String, Module> pathEObjectToModule(EObject rootEObject, Module module){
		final Map<String, Module> pathEObjectToModule = new TreeMap<>();
		pathEObject(module, pathEObjectToModule, null, rootEObject);	
		for (TreeIterator<EObject> treeIterator = rootEObject.eAllContents(); treeIterator.hasNext();) {
			final EObject currentEObject = treeIterator.next();
			pathEObject(module, pathEObjectToModule, treeIterator, currentEObject);						
		}		
		return pathEObjectToModule;
	}

	private static void pathEObject(Module module, final Map<String, Module> pathEObjectToModule,
			TreeIterator<EObject> treeIterator, final EObject currentEObject) {
		if (currentEObject instanceof IdentifiedElement) {
			pathEObjectToModule.put(getPath(currentEObject), module);						
		} else if (treeIterator != null){
			treeIterator.prune(); 
		}
	}
	
	//Get Path from OverrideElement
	public static String getPathFromOverrideElement(final Element overrideElement) {
		StringBuilder path = new StringBuilder(); 
		path.append(overrideElement.getElementId());
		FeatureElement featureElement = overrideElement.getFeature();
		while (featureElement != null) {
			path.append("." + featureElement.getFeatureId());
			featureElement = featureElement.getFeature();			
		}
		return path.toString();
	}
}

package capone.graphical.spl.evaluation.utils;

import java.util.stream.Stream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import capone.Diagram;
import capone.Module;

public class EMFStatsUtils {
	
	// Suppress default constructor for noninstantiability
	private EMFStatsUtils() {
		new AssertionError("This class cannot be subclassed");
	}
		
	public static int numberOfObjects(Resource res) {
		int numberOfElements = 0;
		for (TreeIterator<EObject> iterator = res.getAllContents(); iterator.hasNext();) {
			iterator.next();
			numberOfElements++;
		}		
		return numberOfElements;		
	}
	
	/*
	 * return the number of Ecore Objects, i.e., EClass, EStructuralFeature
	 * 
	 * */	
	public static int numberOfEcoreObjects(Resource res) {
		int numberOfElements = 0;
		for (TreeIterator<EObject> iterator = res.getAllContents(); iterator.hasNext();) {
			final EObject eObject =  iterator.next();
			if (eObject instanceof EClass 
					||  eObject instanceof EStructuralFeature					
					||  eObject instanceof EPackage)
				numberOfElements++;
		}		
		return numberOfElements;		
	}
	
	public static IFile findEcore(IFolder folder) {
		return findIFileWithExtension(folder, "ecore");	
	}
	
	public static IFile findOdesign(IFolder folder) {
		return findIFileWithExtension(folder, "odesign");		
	}
	
	/*
	 * Find first file
	 * */
	public static IFile findIFileWithExtension(IFolder folder, String fileExtension) {
		IFile file = null;
		try {
			file = (IFile) Stream.of(folder.members())
						.filter(member -> member instanceof IFile fileMember && fileMember.getFileExtension().equals(fileExtension))
						.findAny()
						.orElseGet(null);
		} catch (CoreException e) {
			e.printStackTrace();
		}
		return file;	
	}
	
	public static Resource emfResourceFromIFile(IFile iFile) {
		final URI fileURI = URI.createPlatformResourceURI(iFile.getFullPath().toString(), true);
		final ResourceSet reset = new ResourceSetImpl();
		final Resource resource = reset.getResource(fileURI, true);		
		return resource;
	}

	public static Resource getOdesignIfExist(Module module) {
		final Diagram diagram = module.getChooseDiagram();
		if (diagram != null) {
			final String odesignFileURI = diagram.getViewpointFileURI();
			final URI resourceURI = module.eResource().getURI();
			if (resourceURI.isPlatform()) {
				final String projectName = resourceURI.segment(1);
				final IProject iProject = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
				final IFile iFile = iProject.getFile(new Path(odesignFileURI));
				return emfResourceFromIFile(iFile);	
			} else {
				final IPath resourcePath = new Path(resourceURI.devicePath());
				final IFile[] files = ResourcesPlugin.getWorkspace().getRoot()
							.findFilesForLocationURI(resourcePath.toFile().toURI());
				if (files.length > 0) {
					final IFile iFile = files[0];
					final IProject iProject = iFile.getProject();
					final IFile odesignFile = iProject.getFile(new Path(odesignFileURI));
					return emfResourceFromIFile(odesignFile);
				}
			}				
		}		
		return null;
	}
	
	public static Resource getEcoreIfExist(Module module) {
		final String metamodelPath = module.getMetamodel();
		if (metamodelPath != null) {
			final URI resourceURI = module.eResource().getURI();
			if (resourceURI.isPlatform()) {
				final String projectName = resourceURI.segment(1);
				final IProject iProject = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
				final IFile iFile = iProject.getFile(new Path(metamodelPath));
				return emfResourceFromIFile(iFile);	
			}
			else {
				final IPath resourcePath = new Path(resourceURI.devicePath());
				final IFile[] files = ResourcesPlugin.getWorkspace().getRoot()
							.findFilesForLocationURI(resourcePath.toFile().toURI());
				if (files.length > 0) {
					final IFile iFile = files[0];
					final IProject iProject = iFile.getProject();
					final IFile metaModelFile = iProject.getFile(new Path(metamodelPath));
					return emfResourceFromIFile(metaModelFile);		
				}								
			}					
		}		
		return null;
	}
}

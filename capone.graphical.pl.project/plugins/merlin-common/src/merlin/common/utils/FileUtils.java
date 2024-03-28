package merlin.common.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

import merlin.common.issues.GenericIssue;
import merlin.common.issues.IssueLevel;
import merlin.common.issues.ValidationIssue;

public class FileUtils {
	/**
	 * Gets all files recursively in folder, with a given extension
	 * @param folder
	 * @param extension
	 * @return
	 */
	public static List<File> getAllFiles(File folder, String extension) {
		List<File> files = new ArrayList<File>();
		File[] contents = folder.listFiles();
		if (contents!=null) {
			for (File f : contents) {
				if (f.isFile() && f.getName().endsWith(extension)) files.add(f);
				else if (f.isDirectory()) files.addAll(FileUtils.getAllFiles(f, extension));
			}
		}
		return files;
	}
	
	public static List<File> getFiles(File folder, String extension) {
		List<File> files = new ArrayList<File>();
		File[] contents = folder.listFiles();
		if (contents!=null) {
			for (File f : contents) {
				if (f.isFile() && f.getName().endsWith(extension)) files.add(f);				
			}
		}
		return files;
	}
	
	public static IFile getIFile(File file) {
		IWorkspace workspace= ResourcesPlugin.getWorkspace();    
		IPath location= Path.fromOSString(file.getAbsolutePath()); 
		return workspace.getRoot().getFileForLocation(location);
	}
	
	public static IFile getIFile(String path) {
		if (path.startsWith("//")) path = path.substring(2);
		// case a) relative path
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IPath      location  = Path.fromOSString(path); 
		IFile      ifile     = workspace.getRoot().getFileForLocation(location);
		if (ifile!=null) return ifile;
		// case b) full path
		String wslocation       = workspace.getRoot().getLocation().toOSString();		
		IPath  relativelocation = location.makeRelativeTo(Path.fromOSString(wslocation));
		ifile = workspace.getRoot().getFile(relativelocation);
		return ifile;
	}
	
	public static IFile getIFile(IProject project, String fileName) {
		IFile f = project.getFile(fileName);
		if (f.exists())	return f;
		return null;
	}
	
	@SuppressWarnings("restriction")
	public static IFile getIFile(org.eclipse.core.internal.resources.File file) {
		IWorkspace workspace= ResourcesPlugin.getWorkspace();    
		IPath location= Path.fromOSString(file.getLocation().toOSString()); 
		return workspace.getRoot().getFileForLocation(location);
	}
	
	public static void cleanMarkers(IFile file) {
		String MARKER_PROBLEM = "merlin.marker.problem";
		try {
			file.deleteMarkers(MARKER_PROBLEM, true, IResource.DEPTH_INFINITE);
		} 
		catch (CoreException e) {}
	}
	
	public static String readFile(File f) {
		try (BufferedReader br = new BufferedReader(new FileReader(f))){
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		    return sb.toString();
		} catch(IOException exp) {
			return null;
		}
	}
	
	/**
	 * Gets all IFiles with a given extension in any of the open projects (directly in the root folder)
	 * @param extension
	 * @return list with IFiles of the given extension
	 */
	public static List<IFile> getAllIFiles(String extension) {
		List<IFile> files = new ArrayList<>();
		for (IProject p : ResourcesPlugin.getWorkspace().getRoot().getProjects()) {
			if (p.isOpen())
				files.addAll(getAllIFiles(p, extension));
		}
		return files;
	}
	
	public static List<IFile> getAllIFiles(IContainer p, String extension) {
		List<IFile> files = new ArrayList<>();
		try {
			for (IResource member: p.members()) {
				if (member instanceof IFile && extension.equals(member.getFileExtension()))
						files.add((IFile) member);				
				else if (member instanceof IContainer)
					files.addAll(getAllIFiles((IContainer)member, extension));
			}
		} catch (CoreException e) {			
			e.printStackTrace();			
		}
		return files;
	}

	public static void updateStringMarkers(IFile file, List<GenericIssue> issues, String markerProblem) {		
		try {
			file.deleteMarkers(markerProblem, true, IResource.DEPTH_INFINITE);
			for (GenericIssue issue : issues) {
				IMarker marker = file.createMarker(markerProblem);
				marker.setAttribute(IMarker.MESSAGE,  issue.getMessage());
				marker.setAttribute(IMarker.SEVERITY, issue.getSeverity() );
				marker.setAttribute(IMarker.LOCATION, issue.getLocation());
			}
		} 
		catch (CoreException e) {
//			System.err.println("[merlin] Problem deleting markers from "+file+" "+e);
		}
	}
	
	public static void updateMarkers (IFile file, List<ValidationIssue> issues) {
		String MARKER_PROBLEM = "merlin.marker.problem";
		try {
			file.deleteMarkers(MARKER_PROBLEM, true, IResource.DEPTH_INFINITE);
			for (ValidationIssue issue : issues) {
				IMarker marker = file.createMarker(MARKER_PROBLEM);
				marker.setAttribute(IMarker.MESSAGE,  issue.getIssue());
				marker.setAttribute(IMarker.SEVERITY, issue.getLevel()==IssueLevel.ERROR? IMarker.SEVERITY_ERROR : (issue.getLevel()==IssueLevel.WARNING? IMarker.SEVERITY_WARNING : IMarker.SEVERITY_INFO));
				marker.setAttribute(IMarker.LOCATION, issue.getWhereName());
			}
		} 
		catch (CoreException e) {
//			System.err.println("[merlin] Problem deleting markers from "+file+" "+e);
		}
	}


}

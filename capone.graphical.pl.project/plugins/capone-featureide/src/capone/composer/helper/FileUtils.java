package capone.composer.helper;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;

import merlin.common.issues.IssueLevel;
import merlin.common.issues.ValidationIssue;

public class FileUtils {
	
	public static void updateMarkers (IFile file, List<ValidationIssue> issues, String markerProblem) {
		try {
			file.deleteMarkers(markerProblem, true, IResource.DEPTH_INFINITE);
			for (ValidationIssue issue : issues) {
				IMarker marker = file.createMarker(markerProblem);
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

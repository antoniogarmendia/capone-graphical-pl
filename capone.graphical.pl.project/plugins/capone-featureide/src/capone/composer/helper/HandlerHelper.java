package capone.composer.helper;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.ui.handlers.HandlerUtil;

public class HandlerHelper {
	// it returns the file selected in the workspace
	public static IFile getSelectedFile (ExecutionEvent event) {
		IFile      file      = null;
		ISelection selection = HandlerUtil.getCurrentSelection(event);
	    if (selection instanceof IStructuredSelection) {
	    	Object first = ((IStructuredSelection)selection).getFirstElement();
	    	if (first == null) return null;
	        file         = (IFile)Platform.getAdapterManager().getAdapter(first, IFile.class);
	        if (file == null) 
	            if (first instanceof IAdaptable)
	                file = (IFile)((IAdaptable)first).getAdapter(IFile.class);
	    }
	    return file;
	}
	
	public static IFolder getSelectedFolder(ExecutionEvent event) {
		final ISelection selection = HandlerUtil.getCurrentSelection(event);
	    if (selection instanceof ITreeSelection) {
	    	final ITreeSelection treeSelection = (ITreeSelection) selection;
	    	return (IFolder) treeSelection.getFirstElement();
	    }
	    return null;
	}
}

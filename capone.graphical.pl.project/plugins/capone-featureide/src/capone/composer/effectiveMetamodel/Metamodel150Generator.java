package capone.composer.effectiveMetamodel;

import org.eclipse.core.resources.IFile;

// TO-DO: refactor!
public class Metamodel150Generator extends AbstractMetamodelGenerator{
	public Metamodel150Generator (IFile f) {
		super(f, true, "_150MM", true);
	}

	public Metamodel150Generator(IFile f, boolean b) {
		super(f, true, "_150MM", true, b);
	}	
}

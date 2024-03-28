package capone.composer.effectiveMetamodel;

import org.eclipse.core.resources.IFile;

// TO-DO: refactor!
public class EffectiveMetamodelGenerator extends AbstractMetamodelGenerator{
	public EffectiveMetamodelGenerator (IFile f) {
		super(f, false, "_effective", false);
	}	
}

package capone.composer.siriusAnalysis.conflicts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.sirius.diagram.description.AbstractNodeMapping;

import capone.Module;
import capone.composer.CaponeModuleLoader;
import capone.composer.DefaultFeatureProvider;
import merlin.common.analysis.FeatureSolver;
import merlin.common.issues.IssueLevel;
import merlin.common.issues.ValidationIssue;

public class SymbolConflict {
	protected List<AbstractNodeMapping> mappings = new ArrayList<>();
	protected List<capone.Module> modules = new ArrayList<>();
	private String conflictReason;
	protected ValidationIssue vi;
	
	public SymbolConflict (String conflictReason,
			 			   List<AbstractNodeMapping> mappings, 
						   List<capone.Module> modules) {
		this.conflictReason = conflictReason;
		this.mappings.addAll(mappings);
		this.modules.addAll(modules);
		this.vi = new ValidationIssue( this.conflictReason+": "+this.toString(), IssueLevel.ERROR, null) {
			@Override
			public String getWhereName() {
				String res = "";
				for (Module m : modules) {
					res += m.getName();
					if (modules.indexOf(m)<modules.size()-1) res+=",";
				}
				return res;
			}
		};
	}

	public ValidationIssue getConflict(CaponeModuleLoader cml, DefaultFeatureProvider dfp) {
		return vi;	
	}
	
	@Override
	public String toString() {
		String res = "";
		for (int i = 0; i < this.mappings.size(); i ++) {
			AbstractNodeMapping mapping = this.mappings.get(i);
			Module module = this.modules.get(i);
			res += mapping.getName()+" (module: "+module.getName()+")";
			if ( i < this.mappings.size() - 1) res+=", ";
		}
		return res;
	}
}

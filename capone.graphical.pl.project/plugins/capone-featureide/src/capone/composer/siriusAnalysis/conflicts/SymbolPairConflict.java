package capone.composer.siriusAnalysis.conflicts;

import java.util.Collections;
import java.util.List;

import org.eclipse.sirius.diagram.description.AbstractNodeMapping;

import capone.composer.CaponeModuleLoader;
import capone.composer.DefaultFeatureProvider;
import merlin.common.analysis.FeatureSolver;
import merlin.common.issues.ValidationIssue;

public abstract class SymbolPairConflict extends SymbolConflict{
	
	public SymbolPairConflict ( String conflictReason,
			   					List<AbstractNodeMapping> mappings, 
			   					List<capone.Module> modules) {
		super(conflictReason, mappings, modules);
	}

	@Override
	public ValidationIssue getConflict(CaponeModuleLoader cml, DefaultFeatureProvider dfp) {
		AbstractNodeMapping nm1 = this.mappings.get(0),
							nm2 = this.mappings.get(1);
		capone.Module m1 = this.modules.get(0),
					  m2 = this.modules.get(1);		
		
		if (!nm1.getName().equals(nm2.getName())) return vi;
		if (m1.getName().equals(m2.getName())) return null; // TODO: makes sense? equal nodes for same class?
		if (cml.isParentOf(m1, m2)) return null;
		List<String> features = List.of(m1.getName(), m2.getName());
		FeatureSolver fs = new FeatureSolver(null, dfp.getFeatureModelFile());	
		fs.addConstraints(features, Collections.emptyList());
		if (fs.isSat()) {
			System.out.println("[Capone] "+features+" SAT!");
			return vi;
		}
		else {
			System.out.println("[Capone] "+features+" UNSAT!");
			return null;
		}		
	}
}

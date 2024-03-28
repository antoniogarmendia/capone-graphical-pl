package capone.composer.siriusAnalysis;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.sirius.diagram.description.AbstractNodeMapping;
import org.eclipse.sirius.diagram.description.ContainerMapping;
import org.eclipse.sirius.diagram.description.NodeMapping;
import org.eclipse.sirius.diagram.description.style.NodeStyleDescription;
import org.eclipse.sirius.viewpoint.description.Group;

import capone.Module;
import capone.composer.siriusAnalysis.comparators.StyleComparator;
import capone.composer.siriusAnalysis.conflicts.OverrideSymbolConflict;
import capone.composer.siriusAnalysis.conflicts.SymbolConflict;

public class SiriusConflictsAnalyser extends AbstractSiriusAnalyser{

	public SiriusConflictsAnalyser(IFile file) {
		super(file);
		this.identifyConflicts();
	}

	private void identifyConflicts() {		
		Map<capone.Module, Group> allGroups = this.getAllGroups();
		Map<capone.Module, List<AbstractNodeMapping>> mappings = getAllMappings(allGroups);
		Map<String, Map<Module, List<AbstractNodeMapping>>> conflictMap = this.getPotentialConflicts(mappings);
		System.out.println("Conflicts:\n"+conflictMap);
		List<SymbolConflict> realConflicts = new ArrayList<SymbolConflict>();
		for (String id : conflictMap.keySet()) {
			Map<Module, List<AbstractNodeMapping>> conflictsForId = conflictMap.get(id);
			if (conflictsForId.keySet().size()>2) {
				printPotentialConflict(id, conflictsForId);
				List<SymbolConflict> sc = this.analysePotentialConflict(conflictsForId);
				realConflicts.addAll(sc);
			}
		}
		this.checkConflicts(realConflicts);
	}

	private List<SymbolConflict> analysePotentialConflict(Map<Module, List<AbstractNodeMapping>> conflicts) {
		List<Module> modules = new ArrayList<>(conflicts.keySet());
		List<SymbolConflict> allConflicts = new ArrayList<>();
		// we check conflict pairs
		for (Module m1 : modules) {
			if (m1.isIsTop()) continue;	// top cannot be in conflict
			for (Module m2 : modules.subList(modules.indexOf(m1), modules.size())) {
				if (m2.isIsTop()) continue;
				if (this.cml.isParentOf(m1, m2) || this.cml.isParentOf(m2, m1)) continue;
				// now we check if both have styles with different id
				if (this.haveConflictStyles(conflicts.get(m1).get(0), conflicts.get(m2).get(0))) {
					allConflicts.add(new OverrideSymbolConflict( conflicts.get(m1).get(0), m1,
															 conflicts.get(m2).get(0), m2));
				}
			}
		}
		return allConflicts;
	}

	// we just look at style right now
	private boolean haveConflictStyles(AbstractNodeMapping m1, AbstractNodeMapping m2) {
		if (m1 instanceof NodeMapping && m2 instanceof NodeMapping) {
			NodeMapping nm1 = (NodeMapping) m1,
					    nm2 = (NodeMapping) m2;
			if (nm1.getStyle()!=null && nm2.getStyle()!=null) {
				StyleComparator sc = StyleComparator.forStyle(nm1.getStyle());
				return !sc.isEqual(nm2.getStyle());
			}
			return false;
		}
		if (m1 instanceof ContainerMapping && m2 instanceof ContainerMapping) {
			ContainerMapping nm1 = (ContainerMapping) m1,
					    	 nm2 = (ContainerMapping) m2;
			// TODO: compare composite styles
			if (nm1.getStyle()!=null && nm2.getStyle()!=null) return true;
			return false;
		}
		return false;
	}

	private void printPotentialConflict(String id, Map<Module, List<AbstractNodeMapping>> conflictsForId) {
		System.out.print("\nPotential conflicts for node "+id+" in modules: ");
		for (Module m : conflictsForId.keySet()) {
			System.out.print(m.getName()+" ");
		}
	}

	private Map<String, Map<Module, List<AbstractNodeMapping>>> getPotentialConflicts(Map<Module, List<AbstractNodeMapping>> mappings) {
		Map<String, Map<Module, List<AbstractNodeMapping>>> conflicts = new LinkedHashMap<>();
		for (Module m : mappings.keySet()) {
			for (AbstractNodeMapping anm: mappings.get(m)) {
				String id = anm.getName();
				conflicts.putIfAbsent(id, new LinkedHashMap<>());
				Map<Module, List<AbstractNodeMapping>> conflictsForId = conflicts.get(id);
				conflictsForId.putIfAbsent(m, new ArrayList<>());
				conflictsForId.get(m).add(anm);				
			}
		}
		return conflicts;
	}

}

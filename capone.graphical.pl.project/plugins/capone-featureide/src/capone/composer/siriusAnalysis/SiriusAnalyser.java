package capone.composer.siriusAnalysis;

import java.util.*;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Path;
import org.eclipse.sirius.diagram.description.AbstractNodeMapping;
import org.eclipse.sirius.diagram.description.ContainerMapping;
import org.eclipse.sirius.diagram.description.DiagramDescription;
import org.eclipse.sirius.diagram.description.Layer;
import org.eclipse.sirius.diagram.description.NodeMapping;
import org.eclipse.sirius.viewpoint.description.Group;
import org.eclipse.sirius.viewpoint.description.RepresentationDescription;
import org.eclipse.sirius.viewpoint.description.Viewpoint;

import capone.Diagram;
import capone.Module;
import capone.composer.CaponeModuleLoader;
import capone.composer.DefaultFeatureProvider;
import capone.composer.ViewpointComposer;
import capone.composer.helper.EMFUtils;
import capone.composer.helper.FileUtils;
import capone.composer.helper.SiriusHelper;
import capone.composer.siriusAnalysis.comparators.SiriusMappingComparator;
import capone.composer.siriusAnalysis.conflicts.RepeatedSymbolConflict;
import capone.composer.siriusAnalysis.conflicts.SymbolConflict;
import merlin.common.issues.ValidationIssue;
//import merlin.common.utils.FileUtils;

public class SiriusAnalyser extends AbstractSiriusAnalyser{
		
	public SiriusAnalyser(IFile file) {
		super(file); 
		this.noRepeatedSymbol();
	}

	private void noRepeatedSymbol() {

		Map<capone.Module, Group> allGroups = this.getAllGroups();
		Map<capone.Module, List<AbstractNodeMapping>> mappings = getAllMappings(allGroups);
		List<AbstractNodeMapping> flatValues = this.flatten(mappings);
		List<SymbolConflict> conflicts = new ArrayList<>();
		
		for (AbstractNodeMapping nm1: flatValues) {
			SiriusMappingComparator smc = SiriusMappingComparator.forNode(nm1); 
			for (AbstractNodeMapping nm2: flatValues.subList(flatValues.indexOf(nm1)+1, flatValues.size())) {
				if (smc.isEqual(nm2)) {
					System.out.println(nm1.getName()+" (class "+nm1.getDomainClass()+") in module: "+this.getModuleOf(nm1, mappings).getName()+
									   " and "+nm2.getName()+" (class "+nm2.getDomainClass()+") in module: "+this.getModuleOf(nm2, mappings).getName()+ 
									   " are equal");
					conflicts.add(new RepeatedSymbolConflict(nm1, this.getModuleOf(nm1, mappings), nm2, this.getModuleOf(nm2, mappings)));
				}
				else {
					System.out.println(nm1.getName()+" (class "+nm1.getDomainClass()+") in module: "+this.getModuleOf(nm1, mappings).getName()+
							   " and "+nm2.getName()+" (class "+nm2.getDomainClass()+") in module: "+this.getModuleOf(nm2, mappings).getName()+
							   " are different");
				}
			}
		}
		this.checkConflicts(conflicts);
	}
}

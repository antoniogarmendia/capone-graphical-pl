package capone.composer.siriusAnalysis.comparators;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.sirius.diagram.description.AbstractNodeMapping;
import org.eclipse.sirius.diagram.description.ContainerMapping;
import org.eclipse.sirius.diagram.description.NodeMapping;

public class SiriusContainerNodeComparator extends SiriusMappingComparator {

	public SiriusContainerNodeComparator(AbstractNodeMapping anm) {
		super(anm);		
	}

	@Override
	public boolean isEqual(AbstractNodeMapping nm2) {
		boolean equal = super.isEqual(nm2);
		if (!equal) return false;
		if (!this.sameSubNodeMappings((ContainerMapping)nm2)) return false;
		return true;
	}

	private boolean sameSubNodeMappings(AbstractNodeMapping nm2) {
		ContainerMapping thisNode = (ContainerMapping) this.node;
		List<AbstractNodeMapping> thisSubNodes = getAllSubNodes(thisNode);
		List<AbstractNodeMapping> otherSubNodes = getAllSubNodes((ContainerMapping) nm2);			
		
		for (AbstractNodeMapping nm1: thisSubNodes) {
			SiriusMappingComparator nc = SiriusMappingComparator.forNode(nm1);
			if (!nc.someEqual(otherSubNodes)) return false; 
		}
		return true;
	}

	private List<AbstractNodeMapping> getAllSubNodes(ContainerMapping thisNode) {
		List<AbstractNodeMapping> thisSubNodes = new ArrayList<>();
		thisSubNodes.addAll(thisNode.getSubNodeMappings());
		thisSubNodes.addAll(thisNode.getSubContainerMappings());
		return thisSubNodes;
	}

}

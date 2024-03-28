package capone.composer.siriusAnalysis.comparators;

import java.util.List;

import org.eclipse.sirius.diagram.description.AbstractNodeMapping;
import org.eclipse.sirius.diagram.description.ContainerMapping;
import org.eclipse.sirius.diagram.description.NodeMapping;

public abstract class SiriusMappingComparator {
	protected AbstractNodeMapping node;

	public SiriusMappingComparator(AbstractNodeMapping anm) {
		this.node = anm;
	}

	public static SiriusMappingComparator forNode(AbstractNodeMapping anm) {
		if (anm instanceof ContainerMapping)
			return new SiriusContainerNodeComparator(anm);
		else if (anm instanceof NodeMapping)
			return new SiriusNodeComparator(anm);
		return null;
	}

	public boolean isEqual(AbstractNodeMapping nm2) {
		// common comparison for all types of nodes
		if (!this.node.getClass().equals(nm2.getClass())) return false;
		if (!this.sameLabel(nm2.getLabel())) return false;
		if (!this.sameBorderedNodeMappings(nm2.getBorderedNodeMappings())) return false;
		return true;
	}

	private boolean sameBorderedNodeMappings(List<NodeMapping> mappings) {
		if (this.node.getBorderedNodeMappings()==null && mappings==null) return true;
		if (this.node.getBorderedNodeMappings()!=null) {
			if (mappings==null) return false;
			for (NodeMapping nm1: this.node.getBorderedNodeMappings()) {
				SiriusMappingComparator nc = SiriusMappingComparator.forNode(nm1);
				if (!nc.someEqual(mappings)) return false; 
			}
		}
		return true;
	}

	protected boolean someEqual(List<? extends AbstractNodeMapping> mappings) {
		for (AbstractNodeMapping nm: mappings) 
			if (this.isEqual(nm)) return true;		
		return false;
	}

	private boolean sameLabel(String label) {
		if (this.node.getLabel()==null && label == null) return true;
		if (this.node.getLabel()==null && label.equals("")) return true;
		if (label==null && this.node.getLabel().equals("")) return true;
		if (this.node.getLabel()!=null) 
			return this.node.getLabel().equals(label);
		return false;
	}
	
	protected <S, T> boolean compatibleObjects(S obj1, T obj2) {
		if (obj1==null && obj2!=null) return false;
		if (obj1!=null && obj2==null) return false;
		if (obj1==null && obj2==null) return true;
		if (obj1.getClass().equals(obj2.getClass())) return true;
		return false;
	}
}

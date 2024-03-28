package capone.composer.siriusAnalysis.comparators;

import org.eclipse.sirius.diagram.description.AbstractNodeMapping;
import org.eclipse.sirius.diagram.description.NodeMapping;
import org.eclipse.sirius.diagram.description.style.NodeStyleDescription;

public class SiriusNodeComparator extends SiriusMappingComparator {

	public SiriusNodeComparator(AbstractNodeMapping anm) {
		super(anm);
	}
	
	@Override
	public boolean isEqual(AbstractNodeMapping nm2) {
		boolean equal = super.isEqual(nm2);
		if (!equal) return false;		
		if (!this.sameNodeStyle((NodeMapping)nm2)) return false; 
		// TO-DO: specific comparisons for Nodes
		return true;
	}

	private boolean sameNodeStyle(NodeMapping nm2) {
		NodeMapping thisNode = (NodeMapping) this.node;
		NodeStyleDescription myStyle = thisNode.getStyle();
		NodeStyleDescription otherStyle = nm2.getStyle();
		if (!this.compatibleObjects(myStyle, otherStyle)) return false;
		if (myStyle==null && otherStyle==null) return true;
		return StyleComparator.forStyle(myStyle).isEqual(otherStyle);
		//return true;
	}

}

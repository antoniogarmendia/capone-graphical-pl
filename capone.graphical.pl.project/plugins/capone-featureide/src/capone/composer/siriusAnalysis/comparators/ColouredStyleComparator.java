package capone.composer.siriusAnalysis.comparators;

import java.util.function.Function;

import org.eclipse.sirius.diagram.description.style.NodeStyleDescription;
import org.eclipse.sirius.diagram.description.style.SquareDescription;
import org.eclipse.sirius.viewpoint.description.ColorDescription;
import org.eclipse.sirius.viewpoint.description.SystemColor;

public class ColouredStyleComparator extends StyleComparator {

	private Function<NodeStyleDescription, ColorDescription> colorGetter;

	public ColouredStyleComparator( NodeStyleDescription sd, 
									Function<NodeStyleDescription, ColorDescription> colorGetter) {
		super(sd);
		this.colorGetter = colorGetter;
	}

	@Override
	public boolean isEqual(NodeStyleDescription style) {
		// we just look at the colour
		ColorDescription myColor = colorGetter.apply(this.style);
		ColorDescription otherColor = colorGetter.apply(style);
		if (myColor instanceof SystemColor myc && otherColor instanceof SystemColor oc) 
			return myc.getName().equals(oc.getName());		
		return false;
	}

}

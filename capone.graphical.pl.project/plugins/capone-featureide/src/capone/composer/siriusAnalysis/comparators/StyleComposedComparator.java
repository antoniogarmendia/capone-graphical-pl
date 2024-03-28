package capone.composer.siriusAnalysis.comparators;

import java.util.*;
import org.eclipse.sirius.diagram.description.style.NodeStyleDescription;

public class StyleComposedComparator extends StyleComparator {

	private List<StyleComparator> comparators = new ArrayList<>();

	public StyleComposedComparator(StyleComparator ...comps) {
		super(null);
		this.comparators.addAll(Arrays.asList(comps));
	}

	@Override
	public boolean isEqual(NodeStyleDescription style) {
		for (StyleComparator sc: this.comparators) 
			if (!sc.isEqual(style)) return false;		
		return true;
	}

}

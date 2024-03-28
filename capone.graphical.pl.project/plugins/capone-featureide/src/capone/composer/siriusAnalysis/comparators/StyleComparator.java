package capone.composer.siriusAnalysis.comparators;

import org.eclipse.sirius.diagram.description.style.BundledImageDescription;
import org.eclipse.sirius.diagram.description.style.DotDescription;
import org.eclipse.sirius.diagram.description.style.EllipseNodeDescription;
import org.eclipse.sirius.diagram.description.style.LozengeNodeDescription;
import org.eclipse.sirius.diagram.description.style.NodeStyleDescription;
import org.eclipse.sirius.diagram.description.style.NoteDescription;
import org.eclipse.sirius.diagram.description.style.SquareDescription;
import org.eclipse.sirius.diagram.description.style.WorkspaceImageDescription;

public abstract class StyleComparator {

	protected NodeStyleDescription style;

	public StyleComparator(NodeStyleDescription sd) {
		this.style = sd;
	}

	public static StyleComparator forStyle(NodeStyleDescription style) {
		switch(style.eClass().getName()) {
			case "SquareDescription" : return new ColouredStyleComparator(style, 
												(NodeStyleDescription t) -> ((SquareDescription)t).getColor());
			case "EllipseNodeDescription": return new ColouredStyleComparator(style, 
												(NodeStyleDescription t) -> ((EllipseNodeDescription)t).getColor());
			case "DotDescription": return new ColouredStyleComparator(style, 
					(NodeStyleDescription t) -> ((DotDescription)t).getBackgroundColor());
			case "LozengeNodeDescription": return new ColouredStyleComparator(style, 
					(NodeStyleDescription t) -> ((LozengeNodeDescription)t).getColor());
			case "NoteDescription": return new ColouredStyleComparator(style, 
						(NodeStyleDescription t) -> ((NoteDescription)t).getColor());
			case "WorkspaceImageDescription": return new ImageStyleDescritionComparator(style,
					(NodeStyleDescription t) -> ((WorkspaceImageDescription)t).getWorkspacePath());
			case "BundledImageDescription": return new 
					StyleComposedComparator( new ImageStyleDescritionComparator(style,
											(NodeStyleDescription t) -> ((BundledImageDescription)t).getShape().getLiteral()),
											new ColouredStyleComparator(style, 
											(NodeStyleDescription t) -> ((BundledImageDescription)t).getColor()));
		}
		return null;
	}
	
	public abstract boolean isEqual(NodeStyleDescription style);

}

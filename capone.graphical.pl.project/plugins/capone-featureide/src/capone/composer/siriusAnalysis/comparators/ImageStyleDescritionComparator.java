package capone.composer.siriusAnalysis.comparators;

import java.util.function.Function;

import org.eclipse.sirius.diagram.description.style.NodeStyleDescription;

public class ImageStyleDescritionComparator extends StyleComparator {

	private Function<NodeStyleDescription, String> imageGetter;

	public ImageStyleDescritionComparator(NodeStyleDescription sd,
								Function<NodeStyleDescription, String> imageGetter) {
		super(sd);
		this.imageGetter = imageGetter;
	}

	@Override
	public boolean isEqual(NodeStyleDescription style) {
		// we just look at the image path or id
		String myImage = this.imageGetter.apply(this.style);
		String otherImage = this.imageGetter.apply(style);
		return myImage.equals(otherImage);		// TODO: check for nulls
	}

}

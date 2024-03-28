package merlin.common.features;

import java.util.ArrayList;
import java.util.List;

public class PartialFeatureProvider extends DefaultFeatureProvider{

	//private IFeatureProvider featureProvider;
	private List<String> positive, negative;

	public PartialFeatureProvider(DefaultFeatureProvider dfp, List<String> positive, List<String> negative) {
		this.featureModelFile = dfp.getFeatureModelFile();
		this.fm = dfp.getFeatureModel();
		//this.featureProvider = dfp;
		this.positive = new ArrayList<>(positive);
		this.negative = new ArrayList<>(negative);
	}
	
	@Override
	public boolean getFeatureValue(String s) {
		if (this.positive.contains(s))
			return true;
		if (this.negative.contains(s))
			return false;
		// We do not know
		return false;
	}
	
}

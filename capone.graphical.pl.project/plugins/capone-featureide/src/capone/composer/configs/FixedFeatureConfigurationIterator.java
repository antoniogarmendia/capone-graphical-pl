/**
 * Iterator over the valid feature configurations of a feature model.
 * It does not rely on Feature IDE (worse performance).
 * It does not persist the configurations.
 */
package capone.composer.configs;

import java.util.ArrayList;
import java.util.List;
import de.ovgu.featureide.fm.core.analysis.cnf.formula.FeatureModelFormula;

//import de.ovgu.featureide.fm.core.analysis.cnf.formula.FeatureModelFormula;

import de.ovgu.featureide.fm.core.base.IFeatureModel;
import de.ovgu.featureide.fm.core.configuration.Configuration;
import de.ovgu.featureide.fm.core.configuration.ConfigurationPropagator;
import de.ovgu.featureide.fm.core.configuration.SelectableFeature;
import de.ovgu.featureide.fm.core.configuration.Selection;
import de.ovgu.featureide.fm.core.configuration.SelectionNotPossibleException;
//import de.ovgu.featureide.fm.core.io.manager.FeatureModelManager;
//import de.ovgu.featureide.fm.core.job.LongRunningWrapper;
import de.ovgu.featureide.fm.core.io.manager.FeatureModelManager;
import de.ovgu.featureide.fm.core.job.LongRunningWrapper;

public class FixedFeatureConfigurationIterator extends AbstractConfigurationIterator{
	protected List<Configuration> all = new ArrayList<>();
	protected int current = 0;
	
	public void init() {
		this.current = 0;
	}
	
	public void addConfiguration(Configuration cfg) {
		this.all.add(cfg);
	}
	
	@Override
	public Configuration next() {
		if (current < this.all.size())
			return this.all.get(current++);
		else
			return null;
	} 
}

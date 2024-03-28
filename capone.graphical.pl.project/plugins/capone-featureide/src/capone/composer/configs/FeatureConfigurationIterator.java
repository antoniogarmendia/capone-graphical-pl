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

public class FeatureConfigurationIterator extends AbstractConfigurationIterator{
	private IFeatureModel featureModel;
	protected List<Configuration> previous = new ArrayList<>();
	protected double combinations = 0; 
	protected int    current      = 0;
	
	// constructor for feature model
	public FeatureConfigurationIterator (IFeatureModel featureModel) { this.init (featureModel); }
	
//	// constructor for feature model referred by a 150mm
//	public FeatureConfigurationIterator (IFile ecore) {
//		List<EPackage>              packages = EMFUtils.readEcore(ecore);
//		DefaultFeatureProvider      provider = new DefaultFeatureProvider();
//		FeatureModelAnnotationCheck check    = new FeatureModelAnnotationCheck (provider, ecore.getProject());
//		check.check(packages.get(0), false);		
//		this.init (provider.getFeatureModel());
//	}
	
	private void init (IFeatureModel featureModel) {
		this.featureModel = featureModel;
		//this.combinations = Math.pow(2, new Configuration(this.featureModel).getManualFeatures().size());
		this.combinations = Math.pow(2, new Configuration(new FeatureModelFormula(this.featureModel)).getManualFeatures().size());
	}
	
	@Override
	public Configuration next() {
		Configuration next    = null;
		Boolean       isValid = false;
		while (current<combinations && !isValid) {
			//Configuration           configuration      = new Configuration(featureModel);
			Configuration configuration = new Configuration(new FeatureModelFormula(this.featureModel));			
			List<SelectableFeature> selectableFeatures = configuration.getManualFeatures();
			try {				
				// build possible configuration
				int numero = cfg(current), j = selectableFeatures.size(), resto = 0;
				while (numero > 0) {
					resto  = numero % 2;
					numero = numero / 2;
					j--;
					if (resto!=0) configuration.setManual(selectableFeatures.get(j), Selection.SELECTED);
				}
				while (j > 0) configuration.setManual(selectableFeatures.get(--j), Selection.UNSELECTED);			
				// return configuration if it is valid and is not duplicated
				//isValid = configuration.isValid();
				ConfigurationPropagator propagator = new ConfigurationPropagator(FeatureModelManager.getInstance(this.featureModel).getPersistentFormula(), configuration);
				isValid = LongRunningWrapper.runMethod(propagator.isValid());
				
				if (isValid &&  
					previous.stream().noneMatch(configuration2 ->
						configuration.getManualFeatures().size() == configuration2.getManualFeatures().size() && 
						configuration.getManualFeatures().stream().allMatch(f1 ->
							configuration2.getManualFeatures().stream().anyMatch(f2 -> 
								f1.getName().equals(f2.getName()) && f1.getSelection() == f2.getSelection())))) {
					next = configuration;
					previous.add(next);
				}
				else isValid = false;
			}
			catch (SelectionNotPossibleException e) {} // invalid configuration, try next one
			current++;
		}
		return next;
	}
	
	protected int cfg (int index) { return index; } 
}

/**
 * Iterator over the valid feature configurations of a feature model.
 * It does not rely on Feature IDE (worse performance).
 * It does not persist the configurations.
 */
package capone.composer.configs;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import de.ovgu.featureide.fm.core.AnalysesCollection;
import de.ovgu.featureide.fm.core.analysis.cnf.LiteralSet;
import de.ovgu.featureide.fm.core.analysis.cnf.LiteralSet.Order;
import de.ovgu.featureide.fm.core.analysis.cnf.formula.FeatureModelFormula;
import de.ovgu.featureide.fm.core.analysis.cnf.solver.AdvancedSatSolver;
import de.ovgu.featureide.fm.core.analysis.cnf.solver.RuntimeContradictionException;
import de.ovgu.featureide.fm.core.analysis.cnf.solver.ISatSolver.SelectionStrategy;

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

public class RandomConfigurationIterator extends AbstractConfigurationIterator{
	private IFeatureModel featureModel;
	private FeatureModelFormula fmf; 
	private final List<LiteralSet> resultList = new ArrayList<>();
	private AdvancedSatSolver solver;
	private boolean finalFound;
	private Random random;
	
	// constructor for feature model
	public RandomConfigurationIterator (IFeatureModel featureModel) { 
		this.featureModel = featureModel;
		this.fmf = new FeatureModelFormula(this.featureModel);
		this.solver = new AdvancedSatSolver(this.fmf.getCNF());
		this.solver.setSelectionStrategy(SelectionStrategy.RANDOM);
		this.random = new Random();
	}
	
	@Override
	public Configuration next() {
		if (finalFound) return null;
		solver.shuffleOrder(this.random);
		int[] solution = solver.findSolution();
		if (solution == null) return null;
		
		LiteralSet result = new LiteralSet(solution, Order.INDEX, false);
		this.resultList.add(result);
		try {
			solver.addInternalClause(result.negate());
		} catch (final RuntimeContradictionException e) {
			this.finalFound = true;
		}
		List<String> solutionList = solver.getSatInstance().getVariables().convertToString(result);
		Configuration next = new Configuration(this.fmf);
		for (final String feature : solutionList) 
			next.setManual(feature, Selection.SELECTED);
		
		return next;
	}
}

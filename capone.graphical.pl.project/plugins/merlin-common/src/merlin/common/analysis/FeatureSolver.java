package merlin.common.analysis;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EClassifier;
import org.prop4j.And;
import org.prop4j.Literal;
import org.prop4j.Node;
import org.prop4j.SatSolver;
import org.sat4j.specs.TimeoutException;

import de.ovgu.featureide.fm.core.analysis.cnf.CNF;
import de.ovgu.featureide.fm.core.analysis.cnf.IInternalVariables;
import de.ovgu.featureide.fm.core.analysis.cnf.LiteralSet;
import de.ovgu.featureide.fm.core.analysis.cnf.Nodes;
import de.ovgu.featureide.fm.core.analysis.cnf.Variables;
import de.ovgu.featureide.fm.core.analysis.cnf.formula.FeatureModelFormula;
import de.ovgu.featureide.fm.core.analysis.cnf.solver.AdvancedSatSolver;
import de.ovgu.featureide.fm.core.analysis.cnf.solver.ISatSolver.SelectionStrategy;
import de.ovgu.featureide.fm.core.analysis.cnf.solver.RuntimeContradictionException;
import de.ovgu.featureide.fm.core.base.IFeatureModel;
import de.ovgu.featureide.fm.core.configuration.Configuration;
import de.ovgu.featureide.fm.core.editing.AdvancedNodeCreator;
import de.ovgu.featureide.fm.core.editing.AdvancedNodeCreator.CNFType;
import de.ovgu.featureide.fm.core.editing.AdvancedNodeCreator.ModelType;
import de.ovgu.featureide.fm.core.filter.AbstractFeatureFilter;
import merlin.common.annotations.presenceCondition.ConditionParser;
import merlin.common.features.DefaultFeatureProvider;
import merlin.common.features.IFeatureProvider;
import merlin.common.issues.ValidationIssue;

public class FeatureSolver {
	private IFeatureProvider provider;
	private IFeatureModel fp;
	private EClassifier context;
	private AdvancedSatSolver solver;		
	
	private List<Node> constraints = new ArrayList<>();
	
	public FeatureSolver(IFeatureProvider provider, IFeatureModel fm) {
		this.provider = provider;
		this.fp = fm;		
		//this.rootNode = AdvancedNodeCreator.createNodes(this.fp, new AbstractFeatureFilter(), CNFType.Compact, ModelType.All, true);
		// TODO: migrated.
		//this.rootNode = AdvancedNodeCreator.createCNF(fm);	// I think this sets the CNFType to Compact
	}
	
	public FeatureSolver(EClassifier context, IFile f) {
		this.provider = new DefaultFeatureProvider(f);
		this.fp = ((DefaultFeatureProvider)provider).getFeatureModel();
		// this.rootNode = AdvancedNodeCreator.createNodes(this.fp, new AbstractFeatureFilter(), CNFType.Compact, ModelType.All, true);
		// TODO: migrated
		//this.rootNode = AdvancedNodeCreator.createCNF(this.fp);	// I think this sets the CNFType to Compact
		this.context = context;		
	}
	
	public void setFeatureModel (IFeatureModel fm) {
		this.fp = fm;
	}
	
	public boolean isSat() {		
		//is = new SatSolver(new And(rootNode.clone(), new And(this.constraints)), 1000);
		final FeatureModelFormula fm = new FeatureModelFormula(this.fp);
		final CNF cnf = fm.getCNF();
		this.solver = new AdvancedSatSolver(cnf);
		
		try {
			solver.addClauses(this.convertConstraintsToLiteralSet());
		} catch (RuntimeContradictionException e) {
			return false;
		}
		
		solver.setSelectionStrategy(SelectionStrategy.RANDOM);
		solver.shuffleOrder();		
		
		final int[] findSolution = solver.findSolution();
		
		if (findSolution==null) return false;
		return true;
		
		//is = new SatSolver(rootNode.clone(), 1000);
		/*try {
			// migrated: The next checked the AND of what is in the SAT and the parameter 
			if (is.isSatisfiable(new And(this.constraints)))	return true;			
		} catch (TimeoutException e1) {
			return false;
		}
		return false;*/
	}
	
	private Iterable<LiteralSet> convertConstraintsToLiteralSet() {
		Variables array = (Variables) this.solver.getInternalMapping();
		List<LiteralSet> lsets = new ArrayList<>();
		for (Node c : this.constraints) {
			Node cnf = c.toCNF();			
			List<int[]> clauses = new ArrayList<int[]>();
			this.convertToArray(cnf, array, clauses);
			for (int[] vector : clauses) {
				LiteralSet ls = new LiteralSet(vector);
				lsets.add(ls);
				//System.out.println(ls);
			}			
		}
		return lsets;
	}
	
	

	private void convertToArray(Node cnf, Variables array, List<int[]> vectors) throws RuntimeContradictionException{		
		if (cnf instanceof And) {
			for (Node n : cnf.getChildren()) {
				convertToArray(n, array, vectors);
			}
		} else if (cnf instanceof Literal) {
			int[] clause = new int[cnf.getUniqueVariables().size()];
			Literal l = (Literal) cnf;
			int idx = 0;
			for (String s : l.getUniqueContainedFeatures()) {
				int var = array.getVariable(s);
				if (var == 0 && s.equals("false")) {
					//System.out.println("error!");
					throw new RuntimeContradictionException("false was found!");
				}
				clause[idx++] = ((Literal)cnf).positive ? var : -var;
			}
			vectors.add(clause);
		}		
	}

	public List<String> getModel(boolean pos) {
		List<String> solFeats = new ArrayList<>();
		int[] solution = solver.getSolution();
		Variables array = (Variables) this.solver.getInternalMapping();
		for (int s : solution) {
			if (s>0) solFeats.add(array.getName(s));			
		}
		return solFeats;
		//return solver.getSolution(pos);
	}

	public Collection<ValidationIssue> addConstraint(String constraint) {
		ConditionParser cp = new ConditionParser(constraint, this.context, this.provider);
		Collection<ValidationIssue> errors = cp.parse();
		if (errors.size()==0) {
			this.constraints.add(cp.getAST().toFeatureIDENode()); 
		}
		else 
			System.out.println("[merlin] parsing errors : "+errors);
		return errors;
	}
		
	public Collection<ValidationIssue> addConstraints(Configuration ...cfgs) {
		Set<String> feats = new LinkedHashSet<>();
		Set<String> negated = new LinkedHashSet<>();
		
		for (Configuration c : cfgs) { 
			feats.addAll(c.getSelectedFeatureNames());
			negated.addAll(c.getUnSelectedFeatures().stream().map(f -> f.getName()).collect(Collectors.toList()));
		}
		
		return this.addConstraints(feats, negated);
	}
	
	public Collection<ValidationIssue> addConstraints(Collection<String> feats, Collection<String> negated) {
		String concat = "";
		boolean first = true;
		for (String cond : feats) {
			if (!first) concat+= " and ";
			concat += cond;
			first = false;
		}
		
		for (String cond : negated) {
			if (!first) concat+= " and ";
			concat += "not "+cond;
			first = false;
		}
		
		return this.addConstraint(concat);
	}
	
	public void addNegatedConstraint(String constraint) {
		String negated = "not ("+constraint+")";
		this.addConstraint(negated);
	}
	

}

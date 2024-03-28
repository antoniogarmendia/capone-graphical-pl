package capone.composer.handlers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.prop4j.And;
import org.prop4j.Equals;
import org.prop4j.Implies;
import org.prop4j.Literal;
import org.prop4j.Node;
import org.prop4j.Not;
import org.prop4j.Or;

import capone.BinaryOperator;
import capone.BinaryTerm;
import capone.Formula;
import capone.Module;
import capone.Term;
import capone.UnaryOperator;
import capone.UnaryTerm;
import capone.composer.CaponeModuleLoader;
import capone.composer.Dependency;
import capone.composer.helper.HandlerHelper;
import de.ovgu.featureide.fm.core.base.IFeature;
import de.ovgu.featureide.fm.core.base.IFeatureModel;
import de.ovgu.featureide.fm.core.base.IFeatureModelFactory;
import de.ovgu.featureide.fm.core.base.impl.DefaultFeatureModelFactory;
import de.ovgu.featureide.fm.core.io.xml.XmlFeatureModelFormat;

public class FeatureModelGeneratorHandler extends AbstractHandler {

	private CaponeModuleLoader cml;
	private IFeatureModelFactory mf;
	private IFeatureModel fm;
	private IProject project;
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		//MessageDialog.openInformation(null, "Capone", "This functionality is not implemented yet...");
		IFile file = HandlerHelper.getSelectedFile(event);
		this.project = file.getProject();
		this.genFeatureModel(file);
   		
		System.out.println("[CAPONE] Capone feature model generator");
		return Status.OK_STATUS;
	}

	private void genFeatureModel(IFile file) {		
		// FeatureModel fm = new FeatureModel(DefaultFeatureModelFactory.ID);	
		this.cml = new CaponeModuleLoader(file, true); 
		List<capone.Module> modules = cml.getModules();
		System.out.println("[CAPONE] modules "+modules);
		this.mf = DefaultFeatureModelFactory.getInstance();
		this.fm = mf.create();
		Map<String, IFeature> pending = new LinkedHashMap<>();
		List<String> features = new ArrayList<>();
		Map<String, List<String>> shared = new LinkedHashMap<>();
		
		IFeature root = getRoot(file, pending, features);		
		
		this.buildFeatureModel (root, root.getName(), pending, features, shared);
		int idx = 0;		
		while (idx < features.size()) {
			String fName = features.get(idx);
			IFeature feat = pending.get(fName);
			this.buildFeatureModel(feat, fName, pending, features, shared);
			idx++;
		}
		
		this.addSharedConstraints(shared);
		this.addFeatureConstraints(modules);
		writeFeatureModelToFile(file, fm);
	}

	private void addSharedConstraints(Map<String, List<String>> shared) {
		for (String fn : shared.keySet()) {
			List<String> fNames = shared.get(fn);
			for (int i = 0; i < fNames.size()-1; i++) {
				String f1 = fNames.get(i), f2 = fNames.get(i+1);				
				Node equals = new Equals(new Literal(f1), new Literal(f2));
				fm.addConstraint(mf.createConstraint(fm, equals));
			}
		}
	}

	private IFeature getRoot(IFile file, Map<String, IFeature> pending, List<String> features) {
		// checks whether there is just one root or several ones
		String featureName;
		List<capone.Module> top = this.cml.getTopModules();
		if (top.size() > 1) 
			featureName = file.getProject().getName();
		else 
			featureName = file.getName().substring(0, file.getName().indexOf(".capone"));
		IFeature root = mf.createFeature(fm, featureName);
		fm.addFeature(root);
		fm.getStructure().setRoot(root.getStructure());
		if (top.size()>1) {
			for (capone.Module m : top) {
				IFeature child = mf.createFeature(fm, m.getName());
				fm.addFeature(child);
				child.getStructure().setMandatory(true); 
				root.getStructure().addChild(child.getStructure());
				pending.put(m.getName(), child);
				features.add(m.getName());
			}
		}		
		return root;
	}
		
	private String sharedFeature(Map<String, List<String>> shared, String featureName) {
		for (String f : shared.keySet()) 
			if (shared.get(f).contains(featureName)) return f;
		return null;
	}
	
	private String getRealName(Map<String, List<String>> shared, String featureName) {
		String fName = this.sharedFeature(shared, featureName);
		if (fName == null) return featureName;
		else return fName;
	}
	
	// TO-DO: Not going to work if shared features have children -> name repetition (should concat!!)
	private void buildFeatureModel(IFeature feature, String featureName, Map<String, IFeature> pending, List<String> features, Map<String, List<String>> shared) {
		IFeature altFake = null, orFake = null;
		String sharedFeature; 
		if ((sharedFeature = sharedFeature(shared, featureName))!=null) 
			featureName = sharedFeature;
		
		for (String m : cml.getChildrenOf(featureName)) {
			if (this.cml.isShared(m) || sharedFeature != null) {
				System.out.println("[CAPONE] "+m+" is shared!");
				if (!shared.containsKey(m)) shared.put(m, new ArrayList<>());
				String sharedName = feature.getName()+"_"+m;
				shared.get(m).add(sharedName);
				m = sharedName;
			}
			IFeature child = mf.createFeature(fm, m);
			fm.addFeature(child);
			pending.put(m, child);
			features.add(m);
			//IFeatureStructure childS = new FeatureStructure(child);
			Dependency dk = cml.getDependencyKind(getRealName(shared, featureName), getRealName(shared, m));
			switch (dk) {
			case OPTIONAL: {
				child.getStructure().setMandatory(false); 
				feature.getStructure().addChild(child.getStructure());
				break;
			}
			case MANDATORY: {
				child.getStructure().setMandatory(true); 
				feature.getStructure().addChild(child.getStructure());
				break;
			}
			case ALT : {
				if (cml.childrenOfKind(featureName, Dependency.OPTIONAL, Dependency.MANDATORY, Dependency.OR).size()>0 && altFake==null) {
					altFake = mf.createFeature(fm, featureName+"ALT");
					fm.addFeature(altFake);
					altFake.getStructure().setMandatory(true);
					altFake.getStructure().setAlternative();
					feature.getStructure().addChild(altFake.getStructure());
					altFake.getStructure().addChild(child.getStructure());
				}
				else if (altFake == null){
					feature.getStructure().setAlternative(); 	
					feature.getStructure().addChild(child.getStructure());
				}
				else {
					altFake.getStructure().addChild(child.getStructure());
				}
				break;
			}
			case OR : {
				if (cml.childrenOfKind(featureName, Dependency.OPTIONAL, Dependency.MANDATORY, Dependency.ALT).size()>0 && orFake==null) {
					orFake = mf.createFeature(fm, featureName+"OR");
					fm.addFeature(orFake);
					orFake.getStructure().setMandatory(true);
					orFake.getStructure().setOr();
					feature.getStructure().addChild(orFake.getStructure());
					orFake.getStructure().addChild(child.getStructure());
				}
				else if (orFake == null) {
					feature.getStructure().setOr();
					feature.getStructure().addChild(child.getStructure());
				}				
				else {
					orFake.getStructure().addChild(child.getStructure());
				}
				break;
			}
			}						
		}		
	}		
	
	private void addFeatureConstraints (List<capone.Module> modules) {
		this.cml.resolveAllProxies();
		for (capone.Module module : modules) 
			if (module.getFormula() != null) 
				fm.addConstraint(mf.createConstraint(fm, buildConstraint(module, module.getFormula().getTerm())));
	}
	
	private Node buildConstraint (Module parent, Term term) {
		Node constraint = null;		

		// unary term (module)
		if (term instanceof UnaryTerm) {			
			capone.Module variable = ((UnaryTerm)term).getVariable();
			String name = variable.getName();
			if (name==null) 
				name = this.parseNameFromProxy(parent, term, variable);
			constraint = new Literal(name);
		}
			
		// binary term (operand1 operator operand2)
		else {
			Term operand1 = ((BinaryTerm)term).getOperand1();
			Term operand2 = ((BinaryTerm)term).getOperand2();
			BinaryOperator boperator = ((BinaryTerm)term).getBoperator();
			if (boperator==BinaryOperator.AND)
				constraint = new And(buildConstraint(parent, operand1), buildConstraint(parent, operand2));
			else if (boperator==BinaryOperator.OR)
				constraint = new Or(buildConstraint(parent, operand1), buildConstraint(parent, operand2));
			else if (boperator==BinaryOperator.IMPLIES) {
				constraint = new Implies(buildConstraint(parent, operand1), buildConstraint(parent, operand2));
			}
		}
		
		// unary operator (not term)
		if (term.getUoperator()==UnaryOperator.NOT)
			constraint = new Not(constraint);
			
		// next term in the formula
		if (term.getNext()!=null) {
			BinaryOperator boperator = term.getNext().getBoperator();
			if (boperator==BinaryOperator.AND)
				constraint = new And(constraint, buildConstraint(parent, term.getNext().getTerm()));
			else if (boperator==BinaryOperator.OR)
				constraint = new Or(constraint, buildConstraint(parent, term.getNext().getTerm()));
			else if (boperator==BinaryOperator.IMPLIES)
				constraint = new Implies(constraint, buildConstraint(parent, term.getNext().getTerm()));
		}

		return constraint;
	}
	
	private String parseNameFromProxy(Module parent, Term term, Module variable) {
		File file = this.cml.getFile(parent.getName());
		Set<String> resolvedVariables = this.getAllResolvedVariables(parent);
		List<String> reserved = List.of("and", "or", "not", "implies", "(", ")");
		
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();
			while (line != null) {
				if (line.contains("formula")) {
					int pos = line.lastIndexOf("formula");
					String formula = line.substring(pos+"formula".length());
					String tokens[] = formula.split("\\s+");
					for (String tok : tokens) {
						if (tok.equals("")) continue;
						if (!reserved.contains(tok.trim()) &&
							!resolvedVariables.contains(tok.trim())) {
							reader.close();
							return tok;
						}							
					}
				}
				line = reader.readLine();
			}
		} catch (Exception e) {
			return "";
		}
		return "";
	}

	private Set<String> getAllResolvedVariables(Module parent) {
		Set<String> variables = new LinkedHashSet<>();

		TreeIterator<EObject> iter = parent.eAllContents();
		
		while (iter.hasNext()) {
			EObject eo = iter.next();
			if (eo instanceof UnaryTerm) {
				UnaryTerm variable = (UnaryTerm) eo;
				Module m = variable.getVariable();
				if (m.getName()!=null) variables.add(m.getName());
			}
		}

		return variables;
	}

	private void writeFeatureModelToFile(IFile file, IFeatureModel fm) {
		XmlFeatureModelFormat fmw = new XmlFeatureModelFormat();	
		String str = fmw.write(fm);
		try {			
			String fName = file.getRawLocation().toOSString();
			int p = fName.lastIndexOf(".capone");
			String modelName = fName.substring(0, p)+".xml";
			PrintWriter pw = new PrintWriter(modelName);
			pw.println(str);
			System.out.println("[CAPONE] "+str);
			pw.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}

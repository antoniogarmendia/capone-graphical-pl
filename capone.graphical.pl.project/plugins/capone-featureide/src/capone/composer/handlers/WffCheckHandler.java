package capone.composer.handlers;

import java.util.*;
import java.util.stream.Collectors;

import org.eclipse.core.commands.*;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.*;

import capone.composer.DefaultFeatureProvider;
import capone.composer.configs.RandomConfigurationIterator;
import capone.composer.effectiveMetamodel.Metamodel150Generator;
import capone.composer.helper.EMFHandler;
import capone.composer.helper.HandlerHelper;
import merlin.common.analysis.FeatureSolver;
import merlin.common.issues.IssueLevel;
import merlin.common.issues.ValidationIssue;
import merlin.common.utils.FileUtils;
import de.ovgu.featureide.fm.core.configuration.Configuration;

public class WffCheckHandler extends AbstractHandler {
	private EPackage pck150;
	private String featureFileName;
	private DefaultFeatureProvider dfp;
	private String caponeFileName;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		//MessageDialog.openInformation(null, "Capone", "This functionality is not implemented yet...");
		IFile file = HandlerHelper.getSelectedFile(event);
		this.caponeFileName = file.getName();
		System.out.println("[Capone] Checking wff of "+this.caponeFileName);
		this.featureFileName   = this.caponeFileName.replaceAll(".capone", ".xml");
		IFile featureFile = file.getProject().getFile(featureFileName); 
		this.dfp = new DefaultFeatureProvider(featureFile);
		//this.testConfigs();
		this.generate150MM(file);
		List<ValidationIssue> issues = this.checkClassNames();
		FileUtils.updateMarkers(file, issues);
		return Status.OK_STATUS;
	}

	private void testConfigs() {
		RandomConfigurationIterator ci = new RandomConfigurationIterator(this.dfp.getFeatureModel());
		Configuration cfg = ci.next();
		int i = 0;
		while (cfg!=null) {
			System.out.println("Config ->"+cfg.getSelectedFeatures());
			cfg = ci.next();
			i++;
		}
		System.out.println("configs : "+i);
	}

	private List<ValidationIssue> checkClassNames() {
		List<ValidationIssue> issues = new ArrayList<>();
		Map<String, List<EClassifier>> duplics = this.findDuplicates(this.pck150.getEClassifiers());
		System.out.println("Duplicates: "+duplics);
		for (String n : duplics.keySet()) { 
			ValidationIssue vi = this.checkValid(duplics.get(n));
			if (vi!=null) issues.add(vi);
		}
		return issues;
	}
	
	private ValidationIssue checkValid(List<EClassifier> list) {
		// By now assume list has size 2
		List<String> features = this.getFeatures(list);
		FeatureSolver fs = new FeatureSolver(list.get(0), this.dfp.getFeatureModelFile());	
		fs.addConstraints(features, Collections.emptyList());
		if (fs.isSat()) {
			System.out.println("[Capone] "+features+" SAT!");
			return new ValidationIssue( "Repeated class name: "+list.get(0).getName()+
										" in modules: "+features,
										IssueLevel.ERROR, list.get(0));
		}
		else {
			System.out.println("[Capone] "+features+" UNSAT!");
			return null;
		}
	}

	private List<String> getFeatures(List<EClassifier> list) {
		List<String> annots = new ArrayList<>();
		for (EClassifier cl : list) {
			for (EAnnotation an : cl.getEAnnotations()) {
				if (an.getSource().equals("presence")) {
					annots.add(an.getDetails().get("condition"));
				}
			}
		}
		return annots;
	}

	private <T extends ENamedElement> Map<String, List<T>> findDuplicates(Collection<T> collection) {
	    Map<String, List<T>> dups = new LinkedHashMap<>();
	    List<String> names = collection.stream().map(e -> e.getName()).collect(Collectors.toList());
	    for (String n : names) 
	    	if (Collections.frequency(names, n)>1) dups.put(n, new ArrayList<>());
	    for (T element : collection) {
	    	if (dups.containsKey(element.getName()))
	    		dups.get(element.getName()).add(element);
	    }
	    return dups;
	}

	private EPackage generate150MM(IFile file) {
		String ecore150Name = file.getName().replace(".capone", "_150MM.ecore");
		IFile ecore150 = file.getProject().getFile(ecore150Name);		
		if (!ecore150.exists()) {
			System.out.println("[Capone] Generating 150% MM");
			Metamodel150Generator emg = new Metamodel150Generator(file, false);
			this.pck150 = (EPackage) emg.generateEcore(file.getParent()).getContents().get(0);
		} // TO-DO check modification date??
		else {
			EMFHandler emf = new EMFHandler();
			this.pck150 = (EPackage) emf.readEcore(ecore150).getContents().get(0);
		}
		return this.pck150;
	}

}

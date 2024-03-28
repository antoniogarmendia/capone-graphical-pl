package capone.composer;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Rule;

import capone.composer.helper.CaponeHelper;
import capone.composer.helper.HenshinHelper;
import de.ovgu.featureide.fm.core.configuration.Configuration;

public class TrafoComposer {

	public void genTrafo(
			capone.Module caponeModule,        // top module 
			IFolder folder,                    // folder that will store the generated transformation
			Configuration configuration,       // feature configuration 
			Resource ecore,                    // ecore generated for the configuration
			Map<capone.Module, List<capone.Module>> modules) // mapping of each module to its submodules
	{
		if (caponeModule.getRules()==null) return;
		String trafoName = null;
		IPath  trafoPath = null;
		IFile  trafoFile = null; 
		URI    uri       = null;
		Module henshinTrafo, deltaTrafo;
		try {
			// create transformation module 
			List<EPackage> packages = new ArrayList<EPackage>();
			ecore.getContents().forEach(obj -> { if (obj instanceof EPackage) packages.add((EPackage)obj); });
			henshinTrafo = HenshinHelper.createModule(packages);

			// get active modules, ordered using breadth first traversal		
			List<capone.Module> activeModules = new ArrayList<>();
			activeModules.add(caponeModule); // top module
			for (int i=0; i<activeModules.size(); i++) {
				for (capone.Module child : modules.get(activeModules.get(i))) {
					if (CaponeHelper.active(child, configuration)) {
						activeModules.add(child);
					}
				}
			}
			
			// process active modules
			Map<String, Rule> ruleMapping = new HashMap<String, Rule>(); // mapping of capone-rule-name to henshin-rule
			for (capone.Module module : activeModules) {
				
				// load transformation specified in module
				if (module.getRules()==null) continue;
				trafoName = module.getRules().getRulefile();
				trafoPath = new Path(trafoName);
				trafoFile = folder.getProject().getFile(trafoPath); 
				if (!trafoFile.exists()) return;
				deltaTrafo = HenshinHelper.load(trafoFile);
				
				// for each rule in the module...
				for (capone.Rule caponeRule : module.getRules().getRules()) {
					if (caponeRule.getName().equals("CommFailures_move"))
						System.out.println("catcha");
					String ruleName = getScopedRuleName(caponeRule, module); 
					
					// ...if it is not a rule extension, copy the rule to the generated transformation
					if (caponeRule.getExtendsrule() == null) {
						Rule henshinRule = getRuleByName(deltaTrafo, caponeRule);
						henshinRule.setName(ruleName);						
						henshinTrafo.getUnits().add(/*HenshinHelper.clone(*/henshinRule/*, packages)*/);
						ruleMapping.put(ruleName, henshinRule);
					}
					
					// ...if it is a rule extension, merge the rule with the extended rule
					else {
						Rule henshinRuleExtension = getRuleByName(deltaTrafo, caponeRule);
						String extendedRule      = getScopedRuleName(caponeRule.getExtendsrule(), module);
						Rule henshinRuleExtended = ruleMapping.get(extendedRule);
						HenshinHelper.extend(henshinRuleExtended, henshinRuleExtension);
						ruleMapping.put(ruleName, henshinRuleExtended);
					}
				}
			}
						
			// save transformation module 
			trafoName = caponeModule.getRules().getRulefile();
			trafoPath = new Path(trafoName);
			trafoFile = folder.getProject().getFile(trafoPath); 
			if (!trafoFile.exists()) return;
			String fileName = trafoFile.getName(); // this.module.getName();
			uri = URI.createFileURI(new File(folder.getLocation().toOSString()+File.separator+fileName).getAbsolutePath());
			HenshinHelper.save(henshinTrafo, uri);
		} 
		catch (Exception e) { 
			System.err.println("[Capone]"+e);
			e.printStackTrace();
			System.err.println("[Capone] Error saving transformation file " + uri); 
		}
	}

	public static Rule getRuleByName(Module deltaTrafo, capone.Rule caponeRule) {
		return deltaTrafo.getAllRules()
							.stream()
							.filter(r -> r.getName().equals(caponeRule.getName()))
							.findFirst().get();
	}
	
	private String getScopedRuleName (capone.Rule rule, capone.Module module) {
		if (rule.eContainer()==null) 
			return module.getName() + "_" + rule.getName();
		return ((capone.Module)(rule.eContainer().eContainer())).getName() + "_" + rule.getName();
	}
}

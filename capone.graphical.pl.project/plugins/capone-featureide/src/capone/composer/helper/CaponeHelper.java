package capone.composer.helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import capone.Module;
import capone.composer.Dependency;
import de.ovgu.featureide.fm.core.configuration.Configuration;

public class CaponeHelper {	
	public static Map<Dependency,List<String>> getDependencies (File file) {
		Map<Dependency, List<String>> deps = new LinkedHashMap<>();
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();
			while (line != null) {
				for (String depKind : Dependency.depKinds) {
					if (line.contains(depKind)) { 
						addDependency(depKind, deps, line);
						break;
					}
				}
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return deps;
	}
	
	/*public static List<String> getDependencies (File file) {
		List<String> deps = new ArrayList<>();
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();
			while (line != null) {
				for (String depKind : CaponeHelper.depKinds) {
					if (line.contains(depKind)) { 
						addDependency(depKind, deps, line);
						break;
					}
				}
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return deps;
	}*/

	private static void addDependency(String kind, Map<Dependency, List<String>> deps, String line) {
		//line = line.substring(line.indexOf(kind)+kind.length());
		String[] segments = line.split(kind);
		Dependency dk = Dependency.get(kind);
		if (!deps.containsKey(dk))
			deps.put(dk, new ArrayList<>());
		String[] parts = segments[1].trim().split("\\s+");
		deps.get(dk).add(parts[0].trim());
		
		
		/*for (String s : segments) {
			if (!deps.containsKey(dk))
				deps.put(dk, new ArrayList<>());
			deps.get(dk).add(s.trim());
		}*/
	}
	
	public static boolean active(Module m, Configuration configuration) {
		//boolean eval = m.getPc().eval(configuration.getSelectedFeatureNames());
		// return eval;
		// We just check that the module name is among the selected features
		// of the configuration
		for (String sfn : configuration.getSelectedFeatureNames()) {
			if (isFeatureNameOf(sfn,m.getName())) return true;
		}
		return false;
	}

	private static boolean isFeatureNameOf(String sfn, String name) {
		if (sfn.equals(name)) return true;
		//if (sfn.endsWith("OR")) return sfn.equals(name+"OR");
		String[] compName = sfn.split("_");
		if (compName.length>1) 
			return compName[compName.length-1].equals(name);
		
		return false;
	}
}

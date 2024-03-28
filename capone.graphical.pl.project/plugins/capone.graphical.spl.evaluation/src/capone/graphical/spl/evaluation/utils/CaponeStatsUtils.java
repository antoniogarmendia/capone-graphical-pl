package capone.graphical.spl.evaluation.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import capone.Module;
import capone.composer.CaponeModuleLoader;

public class CaponeStatsUtils {
	
	// Suppress default constructor for noninstantiability
	private CaponeStatsUtils() {
		new AssertionError("This class cannot be subclassed");
	}
	
	public static final String[] HEADERS = {"Module", "Size *.odesign", "Size *.ecore"};
	
	public static final void writeCaponeGraphicalModuleStats(IFile caponeFile) {
		final IFile csvIFile = caponeFile.getParent().getFile(new Path(caponeFile.getName() + "_module_stats.csv"));
		try {final FileWriter out = new FileWriter(csvIFile.getRawLocation().makeAbsolute().toFile());
	    final CSVFormat csvFormat = CSVFormat.DEFAULT
	    		.withHeader(HEADERS);  				
		    try (CSVPrinter printer = new CSVPrinter(out, csvFormat)) {
		    	final Resource resource = EMFStatsUtils.emfResourceFromIFile(caponeFile);
				final EObject rootEObject = resource.getContents().get(0);
				if (rootEObject instanceof Module topModule) {
					final CaponeModuleLoader caponeLoader = new CaponeModuleLoader(caponeFile, true); 
					final List<capone.Module> listOfModules = caponeLoader.getModules();
					for (ListIterator<Module> iterator = listOfModules.listIterator(); iterator.hasNext();) {
						final Module module = (Module) iterator.next();
						final Resource odesignResource = EMFStatsUtils.getOdesignIfExist(module);
						final Resource ecoreResource = EMFStatsUtils.getEcoreIfExist(module);
						int numberOfObjectsOdesign = 0;
						int numberOfObjectsEcore = 0;
						if (odesignResource != null) 
							numberOfObjectsOdesign = EMFStatsUtils.numberOfObjects(odesignResource);
						if (ecoreResource != null)
							numberOfObjectsEcore = EMFStatsUtils.numberOfEcoreObjects(ecoreResource);
						printer.printRecord(module.getName(),numberOfObjectsOdesign, numberOfObjectsEcore);						
					}			
				}		    	
		    	printer.flush();
		    	printer.close();
		    	printer.close();
		    } catch (IOException e) {
				e.printStackTrace();
			}			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

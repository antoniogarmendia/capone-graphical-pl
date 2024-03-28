package capone.graphical.spl.evaluation.utils;

import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;

public class ProductStatsUtils {
	
	// Suppress default constructor for noninstantiability
	private ProductStatsUtils() {
		new AssertionError("This class cannot be subclassed");
	}
	
	public static final String[] HEADERS = {"Products", "Size *.odesign", "Size *.ecore"};
	
	public static final void writeProductsStatsOfAllContainedProducts(IFolder productsFolder) {
		final IFile csvIFile = productsFolder.getFile(productsFolder.getName() + "_stats.csv");
		try {
			final FileWriter out = new FileWriter(csvIFile.getRawLocation().makeAbsolute().toFile());
		    final CSVFormat csvFormat = CSVFormat.DEFAULT
		    		.withHeader(HEADERS);  				
		    try (CSVPrinter printer = new CSVPrinter(out, csvFormat)) {
		    	for (IResource resource: productsFolder.members()) {
		    		if (resource instanceof IFolder productFolder) {
		    			final IFile ecoreFile = EMFStatsUtils.findEcore(productFolder);
		    			final IFile odesignFile = EMFStatsUtils.findOdesign(productFolder);
		    			final int numberOfObjectsEcore = EMFStatsUtils.numberOfEcoreObjects(EMFStatsUtils.emfResourceFromIFile(ecoreFile));
		    			final int numberOfObjectsOdesign = EMFStatsUtils.numberOfObjects(EMFStatsUtils.emfResourceFromIFile(odesignFile));
		    			printer.printRecord(productFolder.getName(), numberOfObjectsOdesign, numberOfObjectsEcore);
		    		}
		    	}		
		    	printer.flush();
		    	printer.close();
		    	printer.close();	    	
			} catch (IOException | CoreException e) {
				e.printStackTrace();
			}			
		} catch (IOException e) {
			e.printStackTrace();
		}			
	}

}

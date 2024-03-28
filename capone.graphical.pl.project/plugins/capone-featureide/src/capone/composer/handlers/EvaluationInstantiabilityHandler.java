package capone.composer.handlers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

import capone.composer.CaponeComposer;
import capone.composer.FeatureProjectWrapper;
import capone.composer.configs.FeatureConfigurationIterator;
import capone.composer.configs.RandomConfigurationIterator;
import capone.composer.effectiveMetamodel.Metamodel150Generator;
import capone.composer.helper.EMFHandler;
import capone.composer.helper.HandlerHelper;
import de.ovgu.featureide.core.IFeatureProject;
import de.ovgu.featureide.fm.core.base.IFeatureModel;
import de.ovgu.featureide.fm.core.configuration.Configuration;
import merlin.analysis.use.UseValidator;
import merlin.analysis.validate.properties.PropertyChecker;
import merlin.analysis.validate.properties.PropertyChecker.ProblemSpace;
import merlin.analysis.validate.properties.PropertyChecker.SolutionArity;
import merlin.analysis.validate.properties.PropertyResult;
import merlin.common.concepts.SelectedConcepts;
import merlin.common.features.DefaultFeatureProvider;

public class EvaluationInstantiabilityHandler extends AbstractHandler {
	
	private EMFHandler  emfHandler      = new EMFHandler();
	private final IPath PRODUCTS_FOLDER = new Path(File.separator+"products"+File.separator);
	private final int   NUM_REPETITIONS = 40; // repetitions of enumerative analysis

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IFile  caponeFile = HandlerHelper.getSelectedFile(event);
		try {

//			instantiability(caponeFile);
//			if (3>1) return Status.OK_STATUS;

			write2file(caponeFile.getProject());
			this.evaluate_enumerative(caponeFile);
			this.evaluate_lifted     (caponeFile);
		} 
		catch (Exception e) { e.printStackTrace(); }			   				
		return Status.OK_STATUS;
	}
	
	/**
	 * lifted analysis
	 */
	protected void evaluate_lifted (IFile caponeFile) throws Exception {
		for (int i=0; i<NUM_REPETITIONS; i++) {
			System.out.println("LIFTED "+i);
			evaluate_lifted(caponeFile, i+1);
		}
	}

	/**
	 * Lifted analysis
	 * @throws CoreException 
	 */
	protected void evaluate_lifted (IFile caponeFile, int repetition) throws CoreException {
		Result   result        = new Result();
		IProject caponeProject = caponeFile.getProject();
		
		result.start(); // ................................
		
		// generate 150 metamodel		
		Resource metamodel150 = new Metamodel150Generator(caponeFile).generateEcore(caponeProject);
	
		// read name of feature model from 150 metamodel
		EPackage    epackage    = (EPackage)metamodel150.getContents().get(0);
		EAnnotation eannotation = epackage.getEAnnotation("features");
		String      featureModel = eannotation.getDetails().get("file");
	
		// analyse instantiability
		SelectedConcepts.setFeatureModel(featureModel);
		IFile  featmodelFile    = caponeProject.getFile(featureModel);		
		IFile  metamodel150File = caponeProject.getFile( metamodel150.getURI().lastSegment() );			
		metamodel150File.refreshLocal(IResource.DEPTH_ZERO, new NullProgressMonitor());
		
		PropertyChecker checker = new PropertyChecker(metamodel150File, new DefaultFeatureProvider(featmodelFile));
		// checker.setDebug(Path.fromOSString(caponeProject.getLocation().toString()).toOSString());
		PropertyResult resultChecker = checker.check(
			""/*property*/, 
			""/*configuration scope*/, 
			SolutionArity.ONE/*number of solutions*/, // change to SolutionArity.ALL_MIN/SolutionArity.ALL_MAX to find all instantiable metamodels  
			ProblemSpace.EXISTS/*problem*/, 
			false/*generate witness*/, 
			false/*generate configuration*/, 
			false/*exercise features*/, 
			false/*check syntax*/
			);

		result.stop(); // .................................
		
		result.setAttempts(1);
		result.setInstantiable(resultChecker.getSolutions()>0);		
		
		write2file(caponeFile.getProject(), "LIFT", result);
	}
	
	/**
	 * enumerative analysis
	 */
	protected void evaluate_enumerative (IFile caponeFile) throws Exception {
		for (int i=0; i<NUM_REPETITIONS; i++) {
			System.out.println("ENUMERATIVE "+i);
			evaluate_enumerative(caponeFile, i+1);
		}
	}

	/**
	 * enumerative analysis
	 */
	protected void evaluate_enumerative (IFile caponeFile, int repetition) throws Exception {
		Result result = new Result();
		IProject        caponeProject  = caponeFile.getProject();
		IFeatureProject featureProject = new FeatureProjectWrapper(caponeFile);
		File            ecore          = emfHandler.getFileWithExtension(new File(caponeProject.getLocationURI().getPath()), "ecore");
		CaponeComposer  cc             = (CaponeComposer) featureProject.getComposer();
		cc.resolveProxyRules();
		int idx = 0;
		int attempts = 0;
		boolean isInstantiable = false;
		this.cleanProductsFolder (caponeProject);
		this.createProductsFolder(caponeProject);

		result.start(); // ................................

		// for each configuration
		RandomConfigurationIterator it = new RandomConfigurationIterator(featureProject.getFeatureModel());
		Configuration configuration = it.next();
		while (configuration!=null) {
			
			// generate metamodel
			String  number = String.format("%05d", idx);
			IPath   path   = PRODUCTS_FOLDER.append("product"+number+File.separator);
			IFolder folder = caponeProject.getFolder(path);			
			cc.buildConfiguration(folder, configuration, "config"+number);
			idx++;		

			// refresh metamodel product in eclipse
			IFile generatedEcore = folder.getFile(ecore.getName());
			generatedEcore.refreshLocal(IResource.DEPTH_ZERO, new NullProgressMonitor()); 

			// check instantiability
			List<EPackage> packages = new ArrayList<EPackage>();
			Resource metamodel = emfHandler.readEcore(generatedEcore);
			packages.add(emfHandler.getEPackage(metamodel));
			UseValidator   validator = new UseValidator(packages);
			attempts++;
			if (validator.validate()) {
				isInstantiable = true;
				break;
			}	

			// move to next configuration
			configuration = it.next();
		}
		
		result.stop(); // .................................
		
		result.setAttempts(attempts);
		result.setInstantiable(isInstantiable);
		
		write2file(caponeFile.getProject(), "ENUM", result);
	}
	
	/**
	 * name of csv file
	 */
	protected String fileName (IProject project) {
		return project.getLocation().toOSString() + File.separator + project.getName() + ".csv";
	}
	
	/**
	 * write header of csv file
	 */
	protected void write2file (IProject project) {
		try (
			 FileWriter fw = new FileWriter(fileName(project), false);
			 BufferedWriter bw = new BufferedWriter(fw);
			 PrintWriter out = new PrintWriter(bw)) {
			 out.print("METHOD;");
			 out.print("IS INSTANTIABLE?;");
			 out.print("TIME (ms);");
			 out.println("#SOLVINGS");
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * write result in csv file
	 */
	protected void write2file (IProject project, String experiment, Result result) {
		try (FileWriter fw = new FileWriter(fileName(project), true);
			 BufferedWriter bw = new BufferedWriter(fw);
			 PrintWriter out = new PrintWriter(bw)) {
			 out.print(experiment+";");
			 out.print(result.isInstantiable()+";");
			 out.print(result.timeInMseconds()+";");
			 out.println(result.getAttempts());
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * number of instantiable metamodels
	 */
	protected void instantiability (IFile caponeFile) throws Exception {
		IProject        caponeProject  = caponeFile.getProject();
		IFeatureProject featureProject = new FeatureProjectWrapper(caponeFile);
		File            ecore          = emfHandler.getFileWithExtension(new File(caponeProject.getLocationURI().getPath()), "ecore");
		CaponeComposer  cc             = (CaponeComposer) featureProject.getComposer();
		cc.resolveProxyRules();
		int idx = 0;
		int instantiable = 0, attempts = 0;
		this.cleanProductsFolder (caponeProject);
		this.createProductsFolder(caponeProject);

		// for each configuration
		RandomisedFeatureConfigurationIterator it = new RandomisedFeatureConfigurationIterator(featureProject.getFeatureModel());
		Configuration configuration = it.next();
		while (configuration!=null) {
			System.out.println("--->"+idx);
			
			// generate metamodel
			String  number = String.format("%05d", idx);
			IPath   path   = PRODUCTS_FOLDER.append("product"+number+File.separator);
			IFolder folder = caponeProject.getFolder(path);			
			cc.buildConfiguration(folder, configuration, "config"+number);
			idx++;		

			// refresh metamodel product in eclipse
			IFile generatedEcore = folder.getFile(ecore.getName());
			generatedEcore.refreshLocal(IResource.DEPTH_ZERO, new NullProgressMonitor()); 

			// check instantiability
			List<EPackage> packages = new ArrayList<EPackage>();
			Resource metamodel = emfHandler.readEcore(generatedEcore);
			packages.add(emfHandler.getEPackage(metamodel));
			UseValidator validator = new UseValidator(packages);
			attempts++;
			if (validator.validate()) {
				instantiable++;
			}
			
			// move to next configuration
			configuration = it.next();
		}
		
		System.out.println("CONFIGURATIONS="+attempts+"; INSTANTIABLE="+instantiable+" ("+(instantiable*100/attempts)+"%)");
	}
	
	/**
	 * creates products folder (enumerative method)
	 */
	private void createProductsFolder(IProject project) {
		IFolder fld = project.getFolder(PRODUCTS_FOLDER);
		if (!fld.exists()) {
			try {
				fld.create(true, true, null);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * deletes products folder (enumerative method)
	 */
	private void cleanProductsFolder(IProject project) {
		IFolder fld = project.getFolder(PRODUCTS_FOLDER);
		new Job("Delete products folder") {	
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				try {
					fld.delete(true, monitor);
					fld.refreshLocal(2, monitor);
				} catch (CoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return Status.OK_STATUS;
			}
		}.run(null);
	}
	
	private class Result {
		private long init=0, end=0;             // time
		private long init_pause=0, end_pause=0; // pause
		public void start()          { this.init = System.nanoTime(); }
		public void stop()           { this.end  = System.nanoTime(); }
		public long timeInMinutes()  { return TimeUnit.MINUTES.convert     (this.end - this.init - (this.end_pause - this.init_pause), TimeUnit.NANOSECONDS); }
		public long timeInSeconds()  { return TimeUnit.SECONDS.convert     (this.end - this.init - (this.end_pause - this.init_pause), TimeUnit.NANOSECONDS); }
		public long timeInMseconds() { return TimeUnit.MILLISECONDS.convert(this.end - this.init - (this.end_pause - this.init_pause), TimeUnit.NANOSECONDS); }

		private boolean isInstantiable;
		public  boolean isInstantiable() { return isInstantiable; }
		public  void    setInstantiable(boolean value) { isInstantiable = value; }

		private long attempts;
		public  void setAttempts(long solutions) { this.attempts = solutions; }
		public  long getAttempts() { return attempts; }
	}
	
	/**
	 * Iterator of configurations in random order. 
	 */
	private class RandomisedFeatureConfigurationIterator extends FeatureConfigurationIterator {		
		private List<Integer> randomOrder = new ArrayList<>();

		public RandomisedFeatureConfigurationIterator(IFeatureModel featureModel) {
			super(featureModel);
			for (int i=0; i<this.combinations; i++)
				randomOrder.add(i);
			Collections.shuffle(randomOrder);
		}
		
		protected int cfg (int index) { return randomOrder.get(index); } 		
	}
}
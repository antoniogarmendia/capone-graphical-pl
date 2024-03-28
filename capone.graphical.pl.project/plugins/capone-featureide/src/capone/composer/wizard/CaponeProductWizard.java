package capone.composer.wizard;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import capone.composer.CaponeComposer;
import capone.composer.configs.AbstractConfigurationIterator;
import capone.composer.configs.FeatureConfigurationIterator;
import capone.composer.configs.FixedFeatureConfigurationIterator;
import de.ovgu.featureide.core.IFeatureProject;
import de.ovgu.featureide.fm.core.analysis.cnf.formula.FeatureModelFormula;
import de.ovgu.featureide.fm.core.base.IFeatureModel;
import de.ovgu.featureide.fm.core.configuration.Configuration;
import de.ovgu.featureide.fm.core.configuration.ConfigurationAnalyzer;
import de.ovgu.featureide.fm.core.configuration.SelectableFeature;
import de.ovgu.featureide.fm.core.configuration.Selection;
import de.ovgu.featureide.fm.core.io.EclipseFileSystem;
import de.ovgu.featureide.ui.actions.generator.BuildProductsPage;
import de.ovgu.featureide.ui.actions.generator.BuildProductsWizard;
import merlin.common.utils.FileUtils;

public class CaponeProductWizard extends BuildProductsWizard{
	private IFeatureProject fp;
	private IProject prj;
	private final IPath PRODUCTS_FOLDER = new Path(File.separator+"products"+File.separator);

	public CaponeProductWizard(IFeatureProject featureProject, boolean toggleState, IProject prj) {
		super(featureProject, toggleState);
		this.fp = featureProject;
		this.prj = prj; 
	}

	@Override
	public boolean performFinish() {
		//boolean res = super.performFinish();
		AbstractConfigurationIterator it; 
		CaponeComposer cc = (CaponeComposer) this.fp.getComposer();
		cc.resolveProxyRules();

		Configuration cfg ;
		if (this.isCurrentConfig()) {
			System.out.println("[CAPONE] Current configs");
			it = this.getCurrentConfigurationIterator();
		}
		else {
			System.out.println("[CAPONE] All configs");
			it = new FeatureConfigurationIterator(this.fp.getFeatureModel());			
		}
		
		cfg = it.next();
		
		int idx = 0;
		this.createProductsFolder();
		this.cleanProductsFolder();

		//IFolder folder = ResourcesPlugin.getWorkspace().getRoot().getFolder(project.getLocation());
		while (cfg != null){
			String number = String.format("%05d", idx);
			IPath path = PRODUCTS_FOLDER.append("product"+number+File.separator);
			IFolder fld = this.prj.getFolder(path);			
			cc.buildConfiguration(fld, cfg, "config"+number);
			if (it!=null) 
				cfg = it.next();
			else
				cfg = null;
			idx++;
		}

		//this.showIssues();
		// No point in trying to show errors here, as the composer runs in a separate thread		
		return true;
	}
	

	private FixedFeatureConfigurationIterator getCurrentConfigurationIterator() {
		IFolder configFolder = this.prj.getFolder("configs");
		FixedFeatureConfigurationIterator fci = new FixedFeatureConfigurationIterator();
		try {
			for ( IResource res: configFolder.members() ) {
				if (res.getName().endsWith(".xml")) {
					java.nio.file.Path configPath = EclipseFileSystem.getPath(res);
					Configuration cfg = this.fp.loadConfiguration(configPath);
					if (cfg!=null)
						fci.addConfiguration(cfg);
				}
			}
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fci;
	}

	private boolean isCurrentConfig() {
		BuildProductsPage bpp = (BuildProductsPage) this.getPages()[0];		
		try {
			Class<BuildProductsPage> cls = (Class<BuildProductsPage>) bpp.getClass();
			Field combo = cls.getDeclaredField("comboGenerate");
			combo.setAccessible(true);
			Object comboValue = combo.get(bpp);
			Combo cmb = (Combo)comboValue;
			if (cmb.getText().equals("All current configurations"))
				return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	private void createProductsFolder() {
		IFolder fld = this.prj.getFolder(PRODUCTS_FOLDER);
		if (!fld.exists()) {
			try {
				fld.create(true, true, null);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
	}

	private void cleanProductsFolder() {
		IFolder fld = this.prj.getFolder(PRODUCTS_FOLDER);
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
		};		
	}

	private void showIssues() {
		CaponeComposer comp = (CaponeComposer)this.fp.getComposer();
		IWorkbench wb = PlatformUI.getWorkbench();
		IWorkbenchWindow window = wb.getActiveWorkbenchWindow();
		/*if (comp.getIssues().stream().anyMatch(issue -> issue.getLevel() == IssueLevel.ERROR)) 
			MessageDialog.openError      (window.getShell(), "Merlin", " Products generated with errors");
		else MessageDialog.openInformation(window.getShell(), "Maple", " Products generated successfully!");*/
	}

	protected List<Configuration> getConfigurationIndex (IFeatureModel featureModel) {
		List<Configuration> index = new ArrayList<Configuration>();
		//int combinations = new Configuration(featureModel).getManualFeatures().size();
		//TODO: migrated
		Configuration configuration = new Configuration(new FeatureModelFormula(featureModel));
		int combinations = configuration.getManualFeatures().size();
		final FeatureModelFormula fmf = new	FeatureModelFormula(featureModel);
		final ConfigurationAnalyzer configAnalyzer = new ConfigurationAnalyzer(fmf, configuration);
		for (int i=0; i<Math.pow(2, combinations); i++) {
			//Configuration           configuration      = new Configuration(featureModel);
			//TODO: migrated
			configuration      = new Configuration(new FeatureModelFormula(featureModel));
			List<SelectableFeature> selectableFeatures = configuration.getManualFeatures();
			try {
				// build possible configuration
				int numero = i, j = selectableFeatures.size(), resto = 0;
				while (numero > 0) {
					resto  = numero % 2;
					numero = numero / 2;
					j--;
					if (resto!=0) 
						configuration.setManual(selectableFeatures.get(j), Selection.SELECTED);
				}
				while (j > 0) 
					configuration.setManual(selectableFeatures.get(--j), Selection.UNSELECTED);			
				// keep configuration if it is valid and is not duplicated
				configAnalyzer.update();
				Boolean isValid = configAnalyzer.isValid();		// migrated
				if (isValid && noneMatch(index, configuration)) { //configuration.isValid() && 
					//index.stream().noneMatch(configuration2 -> repeatedConf(configuration2, configuration))) {
					/*configuration.getManualFeatures().size() == configuration2.getManualFeatures().size() && 
						configuration.getManualFeatures().stream().allMatch(f1 ->
							configuration2.getManualFeatures().stream().anyMatch(f2 -> 
								f1.getName().equals(f2.getName()) && f1.getSelection() == f2.getSelection())))) {*/
					//					System.out.println("adding cfg: "+configuration);
					index.add(configuration);
				}
				//				System.out.println("i: "+i);
			}
			catch (Exception e) {} // invalid configuration, try next one
		}		
		return index;
	}

	private boolean noneMatch(List<Configuration> index, 
			final Configuration configuration) {
		return index.stream().noneMatch(configuration2 ->
		configuration.getManualFeatures().size() == configuration2.getManualFeatures().size() && 
		configuration.getManualFeatures().stream().allMatch(f1 ->
		configuration2.getManualFeatures().stream().anyMatch(f2 -> 
		f1.getName().equals(f2.getName()) && f1.getSelection() == f2.getSelection())));
	}
}


package merlin.featureide.composer;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EPackage;

import de.ovgu.featureide.core.IFeatureProject;
import de.ovgu.featureide.core.builder.ComposerExtensionClass;
import de.ovgu.featureide.core.builder.IComposerExtensionClass;
import de.ovgu.featureide.core.fstmodel.FSTModel;
import de.ovgu.featureide.core.signature.ProjectSignatures;
import de.ovgu.featureide.fm.core.ModelMarkerHandler;
import de.ovgu.featureide.fm.core.base.IFeatureModel;
import de.ovgu.featureide.fm.core.base.impl.DefaultFeatureModelFactory;
import de.ovgu.featureide.fm.core.base.impl.FeatureModel;
import de.ovgu.featureide.fm.core.configuration.Configuration;
import de.ovgu.featureide.fm.core.io.EclipseFileSystem;
import de.ovgu.featureide.fm.core.io.manager.FeatureModelManager;
import de.ovgu.featureide.fm.core.io.manager.IFeatureModelManager;
import de.ovgu.featureide.fm.core.io.manager.IFileManager;
import de.ovgu.featureide.fm.core.io.manager.VirtualFeatureModelManager;
import merlin.common.annotations.MerlinAnnotationStructure;
import merlin.common.features.DefaultFeatureProvider;
import merlin.common.utils.EMFUtils;

public class FeatureProjectWrapper implements IFeatureProject {

	private IFile    ecore;
	private IProject project;
	private ComposerExtensionClass composer;
	private IFeatureModel featureModel;
	
	public FeatureProjectWrapper (IFile ecore) { 
		this.ecore   = ecore; 
		this.project = ecore.getProject();
		this.composer = new EcoreComposer(ecore);
		this.featureModel = loadFeatureModel();
	}
	
	@Override
	public String getProjectName() { return project.getName(); }

	@Override
	public IComposerExtensionClass getComposer() { return composer; }
	
	@Override
	public IFeatureModel getFeatureModel() { return featureModel; }
	
	@Override
	public IFolder getSourceFolder() {  return this.project.getFolder("src"); }

	@Override
	public IProject getProject() { return this.project; }
	
	@Override
	public IFolder getConfigFolder() { return this.project.getFolder("configs"); }
	
	private IFeatureModel loadFeatureModel () {
		IFeatureModel  fm = null;
		List<EPackage> metamodel = EMFUtils.readEcore(ecore);
		for (EPackage pack : metamodel) {
			EAnnotation ann = pack.getEAnnotation(MerlinAnnotationStructure.FEATURE_ANNOTATION);
			if (ann!=null) {
				String fmodel = ann.getDetails().get(MerlinAnnotationStructure.FEATURE_FILE);
				if (fmodel != null) {
					IFile f = null;
					if ((f = project.getFile(fmodel)) != null) {
						fm = new DefaultFeatureProvider(f).getFeatureModel();
						break;
					}
				}
			}
		}		
		return fm;
	}

	// ..................................................................
	// UNIMPLEMENTED METHODS
	// ..................................................................

	@Override
	public void createBuilderMarker(IResource resource, String message, int lineNumber, int severity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBuilderMarkers(IResource resource, int depth) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String getBuildPath() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IFolder getBinFolder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IFolder getLibFolder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IFolder getBuildFolder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBinPath() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getConfigPath() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSourcePath() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFeaturestubPath() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getJavaClassPath() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getContractComposition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMetaProductGeneration() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCompositionMechanism() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getAdditionalJavaClassPath() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFeatureName(IResource resource) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getConfigName(IResource resource) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFolderName(IResource resource, IFolder folder) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProjectSignatures getProjectSignatures() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FSTModel getFSTModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IFile getModelFile() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getComposerID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setComposerID(String composerID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAdditionalJavaClassPath(String[] paths) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setFSTModel(FSTModel model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setContractComposition(String contractComposition) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMetaProductGeneration(String metaProductGeneration) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCompositionMechanism(String compositionMechanism) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean buildRelevantChanges() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void built() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getProjectConfigurationPath() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getProjectBuildPath() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getProjectSourcePath() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPaths(String feature, String src, String configuration) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<String> getFalseOptionalConfigurationFeatures() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<String> getUnusedConfigurationFeatures() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void checkForProblems() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Path getCurrentConfiguration() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Configuration loadCurrentConfiguration() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Configuration loadConfiguration(Path configurationPath) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCurrentConfiguration(Path file) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IFeatureModelManager getFeatureModelManager() {
		// TODO Auto-generated method stub
		ModelMarkerHandler<IFile> modelFile = new ModelMarkerHandler<>(project.getFile("model.xml"));
		final FeatureModelManager instance = FeatureModelManager.getInstance(EclipseFileSystem.getPath(modelFile.getModelFile()));
		IFeatureModelManager featureModelManager;
		if (instance != null) {
			featureModelManager = instance;
			instance.read();
		} else {
			final DefaultFeatureModelFactory factory = DefaultFeatureModelFactory.getInstance();
			final FeatureModel errorFeatureModel = factory.create();
			factory.createFeature(errorFeatureModel, "__Error__");
			featureModelManager = new VirtualFeatureModelManager(errorFeatureModel);
			//LOGGER.logError(new IOException("File " + modelFile + " couldn't be read."));
		}
		return featureModelManager;
	}

	@Override
	public Path getInternalConfigurationFile() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Path getInternalConfigurationFile(Path configurationFile) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Path> getAllConfigurations() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

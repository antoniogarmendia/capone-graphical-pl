package capone.composer.effectiveMetamodel;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import capone.Module;
import capone.composer.CaponeModuleLoader;
import capone.composer.helper.EMFHandler;

public abstract class AbstractMetamodelGenerator {
	protected CaponeModuleLoader cml;
	private String suffix;
	private boolean genAnnot;
	private int counter = 0;
	private boolean repair;
			
	public AbstractMetamodelGenerator (IFile f, boolean reverse, String suffix, boolean genAnnot) {
		this(f, reverse, suffix, genAnnot, true);
	}
	
	public AbstractMetamodelGenerator (IFile f, boolean reverse, String suffix, boolean genAnnot, boolean repair) {
		this.cml = new CaponeModuleLoader(f, reverse);
		this.suffix = suffix;
		this.genAnnot = genAnnot;
		this.repair = repair;
	}
	
	public Resource generateEcore(IContainer container) {
		this.counter = 0;
//		System.out.println("[CAPONE] Merging ecores from: "+this.cml.getCaponeModule()+" and "+this.cml.getModules());				
		String mmFile = this.cml.getCaponeModule().getMetamodel();
		IPath mmPath = new org.eclipse.core.runtime.Path(mmFile);
		IFile ecoreFile = this.cml.getModule().getProject().getFile(mmPath);
		Resource res = this.cml.readEcore(ecoreFile);
		
		String fileName = this.cml.getModule().getName();
		fileName = fileName.replaceAll(".capone", this.suffix+".ecore");
		URI uri = URI.createFileURI(new File(container.getLocation().toOSString()+File.separator+fileName).getAbsolutePath());
		
		Map<String, Resource> ecores = this.getAllActiveEcores();
		for (String moduleName : ecores.keySet()) 
			this.cml.extend(res, ecores.get(moduleName), moduleName);		
		
		if (this.genAnnot) {
			this.genAnnot(res, this.cml.getCaponeModule().getName());
			if (this.repair) this.repair(res);
		}
		Resource newr = res.getResourceSet().createResource(uri);
		newr.getContents().addAll(EcoreUtil.copyAll(res.getContents()));
		try {
			newr.save(null);
		} catch (IOException e) {
			System.err.println("[Capone] Error saving file" + uri);
		}
//		return (EPackage)newr.getContents().get(0);
		return newr;
	}

	private void repair(Resource res) {
		EPackage root = (EPackage) res.getAllContents().next();
		for (EClassifier cl : root.getEClassifiers()) {
			if (!(cl instanceof EClass)) continue;
			EClass cls = (EClass) cl;
			if (EMFHandler.isNameRepeated(cl.getName(), root.getEClassifiers())) 
				this.changeName(cls);
			for (EStructuralFeature atr : cls.getEAllStructuralFeatures()) {
				if (EMFHandler.isNameRepeated(atr.getName(), cls.getEAllStructuralFeatures())) {
					this.changeStructuralFeatureName(cls, atr.getName());
				}
			}
		}
	}

	private void changeStructuralFeatureName(EClass cls, String name) {
		for (EStructuralFeature atr : cls.getEAllStructuralFeatures()) {
			if (atr.getName().equals(name)) {
				for (EAnnotation annot : atr.getEAnnotations()) {
					String moduleName = annot.getDetails().get("condition");
					if (moduleName!=null) atr.setName(atr.getName()+"_"+moduleName);
				}
			}
		}
	}

	private void changeName(EClass cls) {
		EAnnotation annot = cls.getEAnnotation("presence");
		if (annot==null) cls.setName(cls.getName()+(this.counter++));
		else {
			String moduleName = annot.getDetails().get("condition");
			if (moduleName!=null) cls.setName(cls.getName()+"_"+moduleName);
			else cls.setName(cls.getName()+(this.counter++));
		}
	}

	private void genAnnot(Resource res, String name) {
		EPackage root = (EPackage) res.getAllContents().next();
		EAnnotation eannot = EcoreFactory.eINSTANCE.createEAnnotation();
		eannot.setEModelElement(root);
		eannot.setSource("features");
		eannot.getDetails().put("file", name+".xml");
	}

	private Map<String, Resource> getAllActiveEcores() {
		Map<String, Resource> ecores = new LinkedHashMap<>();
		for (Module m : this.cml.getModules()) {
			if (m==this.cml.getCaponeModule()) continue;
			String ecoreFile = m.getMetamodel();
			Resource ecr = this.cml.readEcore(ecoreFile, this.cml.getModule().getProject());
			ecores.put(m.getName(), ecr);			
		}
		return ecores;
	}
}

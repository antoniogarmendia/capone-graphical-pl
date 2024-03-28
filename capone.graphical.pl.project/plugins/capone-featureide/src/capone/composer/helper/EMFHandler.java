package capone.composer.helper;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.serializer.impl.Serializer;

import com.google.inject.Injector;

import capone.CaponeDslStandaloneSetup;
import capone.CaponePackage;

public class EMFHandler {
	private ResourceSet rs;
	private Injector injector;
	private ResourceSet xtextRS;

	public EMFHandler() {
		EPackage.Registry.INSTANCE.put(CaponePackage.eNS_URI, CaponePackage.eINSTANCE);
		Injector injector = new CaponeDslStandaloneSetup().createInjectorAndDoEMFRegistration();
		this.xtextRS = injector.getInstance(XtextResourceSet.class);
	}
	
	public ResourceSet getResourceSet() {
		return this.xtextRS;
	}
	
	public Resource loadModel(File model, EPackage p) {		
		URI uri = URI.createFileURI(model.getPath());
		//rs = new ResourceSetImpl();
		if (p!=null) {
			rs.getPackageRegistry().put(p.getNsURI(), p);
		}
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("capone",new XMIResourceFactoryImpl());
		Resource resource = rs.getResource(uri, true);
		EcoreUtil.resolveAll(resource);
		return resource;
	}
	
	public EPackage getEPackage(Resource ecoreModel) {
		return (EPackage) ecoreModel.getContents().get(0);
	}
	
	public File getFileWithExtension(File folder, String ext) {
		File[] ecores = folder.listFiles((current, name) -> name.endsWith(ext));
//		File[] all = folder.listFiles();
		if (ecores == null) return null;
		return ecores.length==0 ? null : ecores[0]; 
	}
	
	public ResourceSet getModelAt(File folder) {
		File ecore = this.getFileWithExtension(folder, ".ecore");
		Resource ecoreModel = loadModel(ecore, null);
		File xmi = this.getFileWithExtension(folder, ".xmi");
		if (xmi==null) {
			System.err.println("Found no xmi file at "+folder);
			return null;
		} 
		return loadModel(xmi, this.getEPackage(ecoreModel)).getResourceSet();
	}
	
	public int getModelSize(Resource m) {
		List<EObject> content = m.getContents();
		return content.size();
	}

	public int getModelSizeInFolder(File folder) {
		File ecore = this.getFileWithExtension(folder, ".ecore");
		Resource ecoreModel = loadModel(ecore, null);
		File xmi = this.getFileWithExtension(folder, ".xmi");
		if (xmi==null) {
			System.err.println("Found no xmi file at "+folder);
			return 0;
		} 
		Resource r = loadModel(xmi, this.getEPackage(ecoreModel));
		return this.getModelSize(r);
	}
	
	public Resource loadXtextModel(File model) {
		Resource xtextInput = xtextRS.getResource(URI.createFileURI(model.getAbsolutePath()), true);
		EcoreUtil.resolveAll(xtextInput);
		EcoreUtil.resolveAll(xtextRS);
		this.resolveFormulas();
		return xtextInput;
		/*
		Resource resource = rs.createResource(URI.createPlatformResourceURI(model.getAbsolutePath(), true));

//		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION,new XMIResourceFactoryImpl());
		//rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("capone",new XtextResourceFactoryImpl());
//		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION,new XMIResourceFactoryImpl());
		
		InputStream in;
		try {
			in = new FileInputStream(model);
			resource.load(in, rs.getLoadOptions());
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}		
		EcoreUtil.resolveAll(resource);
		return resource;
		*/
	}
	
	private void resolveFormulas() {
		for (Resource r : this.xtextRS.getResources()) {
			EcoreUtil.resolveAll(r);
			EObject eo = r.getContents().get(0);
			EcoreUtil.resolveAll(eo);
		}
	}

	public String object2xtext (EObject eobj) {
		Serializer serializer = injector.getInstance(Serializer.class);  
		return serializer.serialize(eobj);
	}

	public Resource readEcore(IFile f) {
		//System.out.println("[CAPONE] Loading ecore "+f.getLocation().toOSString());
		if (!f.exists()) return null;
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
				"ecore", new EcoreResourceFactoryImpl());
		EcorePackage ecorePackage = EcorePackage.eINSTANCE;
		URI fileURI = URI.createFileURI(f.getFullPath().toOSString());
		Resource resource = resourceSet.getResource(fileURI, true);
		return resource;
	}
	
	public Resource readEcore(String fname, IProject pr) {
		//System.out.println("[CAPONE] Loading ecore "+fname+" from "+pr);
		IFile f = pr.getFile(fname);
		if (!f.exists()) {
			System.out.println("[CAPONE] Meta-model not found");
			return null;
		}
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
				"ecore", new EcoreResourceFactoryImpl());
		EcorePackage ecorePackage = EcorePackage.eINSTANCE;
		URI fileURI = URI.createFileURI(f.getFullPath().toOSString());
		Resource resource = resourceSet.getResource(fileURI, true);
		return resource;
	}

	public void setResourceSet(ResourceSet resourceSet) {
		this.rs = resourceSet;
	}
	
	public void extend(Resource res, Resource delta, String annotation) {
		EPackage droot = (EPackage) delta.getAllContents().next();
		EPackage eroot = (EPackage) res.getAllContents().next();
		Map<EClass, EClass> mappings = new LinkedHashMap<>();
		
		
		for (EClassifier cl : droot.getEClassifiers()) {
			if (!(cl instanceof EClass)) continue;
			EClass clas = (EClass) cl;
			EClass original = (EClass)eroot.getEClassifier(clas.getName());
			if (original == null || this.hasNewAnnot(clas)) {
				EClass clone = EcoreUtil.copy(clas);				
				// we remove the references, since they point to classes in the delta module
				clone.getEStructuralFeatures().removeAll(clone.getEReferences());
				if (annotation!=null) {
					this.addAnnotation(clone, annotation);
					this.addAnnotationToExistingConstraint(clone, annotation);
				}
				eroot.getEClassifiers().add(clone);
				mappings.put(clas, clone);
				continue;
			}
			else {
				// copy OCL constraints
				this.copyOCL(clas, original, annotation);
				mappings.put(clas, original);
			}
			//for (EAttribute atr : clas.getEAllAttributes()) {
			for (EAttribute atr : clas.getEAttributes()) {
				EAttribute atrc = EcoreUtil.copy(atr);
				if (annotation!=null) this.addAnnotation(atrc, annotation);
				original.getEStructuralFeatures().add(atrc);
			}
		}
		// Now we do an extra pass to update superclasses
		for (EClassifier cl : droot.getEClassifiers()) {
			if (!(cl instanceof EClass)) continue;
			EClass clas = (EClass) cl;
			EClass original = mappings.getOrDefault(clas, (EClass)eroot.getEClassifier(clas.getName()));
			//EClass original = (EClass)eroot.getEClassifier(clas.getName());
			for (EClass supClass : clas.getESuperTypes()) {
				EClass newClass = (EClass) eroot.getEClassifier(supClass.getName());
				original.getESuperTypes().remove(supClass);
				original.getESuperTypes().add(newClass);
			}
		}
		// Now we do an extra pass for references
		for (EClassifier cl : droot.getEClassifiers()) {
			if (!(cl instanceof EClass)) continue;
			EClass clas = (EClass) cl;
			//EClass original = (EClass)eroot.getEClassifier(clas.getName());
			EClass original = mappings.getOrDefault(clas, (EClass)eroot.getEClassifier(clas.getName()));
			//for (EReference ref : clas.getEAllReferences()) {
			for (EReference ref : clas.getEReferences()) {
				EReference newref = EcoreUtil.copy(ref);
				String targetClassName = newref.getEType().getName();
				EClass orig_class = (EClass) eroot.getEClassifier(targetClassName);
				newref.setEType(orig_class);
				original.getEStructuralFeatures().add(newref);
				if (annotation!=null) this.addAnnotation(newref, annotation);
			}
		}
	}

	private void copyOCL(EClass src, EClass tar, String annotation) {
		List<String> constraints = new ArrayList<>();
		for (EAnnotation an : src.getEAnnotations()) {
			EAnnotation eannot; 
			if (tar.getEAnnotation(an.getSource())!=null)
				eannot = tar.getEAnnotation(an.getSource());
			else {
				eannot = EcoreFactory.eINSTANCE.createEAnnotation();			
				eannot.setEModelElement(tar);
				eannot.setSource(an.getSource());
			}
			for (String det: an.getDetails().keySet()) {
				if (det.equals("constraints") && eannot.getDetails().containsKey(det)) {
					String currentConstrs = eannot.getDetails().get(det);					
					currentConstrs += " "+an.getDetails().get(det);
					eannot.getDetails().put(det, currentConstrs);
				}
				else eannot.getDetails().put(det, an.getDetails().get(det));
				if (det.equals("constraints")) 
					constraints.add(an.getDetails().get(det));
			}
		}
		if (annotation!=null) {
			this.addConstraintAnnotation(tar, annotation, constraints);
		}
	}

	private boolean hasNewAnnot(EClass clas) {
		for (EAnnotation an : clas.getEAnnotations())
			if (an.getSource().equals("new")) return true;
		return false;
	}

	private EAnnotation addAnnotation(EModelElement clone, String annotation) {
		EAnnotation eannot = EcoreFactory.eINSTANCE.createEAnnotation();
		eannot.setEModelElement(clone);
		eannot.setSource("presence");
		eannot.getDetails().put("condition", annotation);
		return eannot;
	}
	
	private void addConstraintAnnotation(EModelElement clone, String annotation, List<String> constr) {
		for (String cs : constr) {
			for (String c : cs.split("\\s+")) {
				EAnnotation annot = this.addAnnotation(clone, annotation);
				annot.getDetails().put("constraint", c);
			}
		}
	}
	
	private void addAnnotationToExistingConstraint(EModelElement src, String annotation) {
		List<String> constraints = new ArrayList<>();
		for (EAnnotation an : src.getEAnnotations()) {
			for (String det: an.getDetails().keySet()) {
				if (det.equals("constraints")) 
					constraints.add(an.getDetails().get(det));
			}
		}
		if (annotation!=null) 
			this.addConstraintAnnotation(src, annotation, constraints);		
	}
	
	public static boolean isNameRepeated(String name, EList<? extends ENamedElement> classifiers) {
		List<String> names = classifiers.stream().map(e -> e.getName()).collect(Collectors.toList());
		return Collections.frequency(names, name)>1;
	}
}

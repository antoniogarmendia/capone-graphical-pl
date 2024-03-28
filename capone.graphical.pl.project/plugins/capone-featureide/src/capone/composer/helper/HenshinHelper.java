package capone.composer.helper;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.AttributeCondition;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Graph;
import org.eclipse.emf.henshin.model.HenshinFactory;
import org.eclipse.emf.henshin.model.Mapping;
import org.eclipse.emf.henshin.model.MappingList;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.NestedCondition;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Parameter;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.resource.HenshinResourceFactory;
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;

public class HenshinHelper {
	
	public static Module createModule (List<EPackage> packages) {
        Module module = HenshinFactory.eINSTANCE.createModule();
        for (EPackage pack : packages) module.getImports().add(pack);
        return module;
	}
	

	public static Module load (IFile f) {
		Module m = null;
		try {
			HenshinResourceSet resourceSet = new HenshinResourceSet();
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("henshin", new HenshinResourceFactory());
			m = resourceSet.getModule(URI.createFileURI(f.getLocation().toOSString()), true);
		}
		catch (Exception e) { e.printStackTrace(); }
		return m;
	}
	
	
	public static void save (Module module, URI uri) {
        try {
	        Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
	        Map<String, Object> m = reg.getExtensionToFactoryMap();
	        m.put("henshin", new XMIResourceFactoryImpl());
	
	        // Obtain a new resource set
	        ResourceSet resSet = new ResourceSetImpl();
	
	        // create a resource
	        Resource resource = resSet.createResource(uri);
	        resource.getContents().add(module);

        	// update cross-references
        	updateCrossReferences(module);
        	
        	// save the content
            resource.save(Collections.EMPTY_MAP);
        }
    	catch (Exception e) { e.printStackTrace(); }
	}
	
	public static void extend (Rule extendedRule, Rule extensionRule) {
		extend(extendedRule.getLhs(), extensionRule.getLhs());
		extend(extendedRule.getRhs(), extensionRule.getRhs());
		extend(extendedRule.getMappings(), extensionRule.getMappings(), extendedRule.getLhs(), extendedRule.getRhs());
		extend(extendedRule.getAttributeConditions(), extensionRule.getAttributeConditions());
		extend(extendedRule.getParameters(), extensionRule.getParameters());
		// TODO: Multirules()
	}
	
	private static void extend (Graph extendedGraph, Graph extensionGraph) {
		// nodes
		for (Node extensionNode : extensionGraph.getNodes()) {
			Node extendedNode = extendedGraph.getNode(extensionNode.getName());
			if (extendedNode==null) {
				extendedNode = HenshinFactory.eINSTANCE.createNode();
				extendedNode.setName(extensionNode.getName());
				extendedNode.setDescription(extensionNode.getDescription());
				extendedNode.setType(extensionNode.getType());
				extendedGraph.getNodes().add(extendedNode);
			}
			extend(extendedNode, extensionNode);
		}
		// edges
		for (Edge extensionEdge : extensionGraph.getEdges()) {
			Edge extendedEdge = HenshinFactory.eINSTANCE.createEdge();
			extendedEdge.setAction(extensionEdge.getAction());
			extendedEdge.setSource(extendedGraph.getNode(extensionEdge.getSource().getName()));
			extendedEdge.setTarget(extendedGraph.getNode(extensionEdge.getTarget().getName()));
			extendedEdge.setType(extensionEdge.getType()); 
			extendedGraph.getEdges().add(extendedEdge);
		}
		// NACs
		for (NestedCondition extensionNAC : extensionGraph.getNACs()) {
			NestedCondition extendedNAC = extendedGraph.getNAC(getName(extensionNAC));
			if (extendedNAC==null)
				extendedNAC = extendedGraph.createNAC(getName(extensionNAC));
			extend(extendedNAC, extensionNAC);
		}
		// PACs
		for (NestedCondition extensionPAC : extensionGraph.getPACs()) {
			NestedCondition extendedPAC = extendedGraph.getPAC(getName(extensionPAC));
			if (extendedPAC==null)
				extendedPAC = extendedGraph.createNAC(getName(extensionPAC));
			extend(extendedPAC, extensionPAC);
		}
	}
	
	private static String getName (NestedCondition condition) { return condition.getConclusion().getName();	}
	
	private static void extend (Node extendedNode, Node extensionNode) {
		for (Attribute extensionAttribute : extensionNode.getAttributes()) {
			Attribute extendedAttribute = HenshinFactory.eINSTANCE.createAttribute();
			extendedAttribute.setAction(extendedAttribute.getAction());
			extendedAttribute.setType(extensionAttribute.getType());
			extendedAttribute.setValue(extensionAttribute.getValue());
			extendedNode.getAttributes().add(extendedAttribute);
		}
	}
	
	private static void extend (MappingList extendedMappingList, MappingList extensionMappingList, Graph originGraph, Graph imageGraph) {
		for (Mapping extensionMapping : extensionMappingList) {
			String origin = extensionMapping.getOrigin().getName();
			String image  = extensionMapping.getImage().getName();
			if (extendedMappingList.stream().noneMatch(m -> m.getOrigin().getName().equals(origin) && m.getImage().getName().equals(image))) {
				Mapping extendedMapping = HenshinFactory.eINSTANCE.createMapping();
				extendedMapping.setOrigin(originGraph.getNode(origin));
				extendedMapping.setImage(imageGraph.getNode(image));
				extendedMappingList.add(extendedMapping);
			}
		}
	}
	
	private static void extend (List<AttributeCondition> extendedAttConditions, List<AttributeCondition> extensionAttConditions) {
		for (AttributeCondition extensionAttCondition : extensionAttConditions) {
			if (extendedAttConditions.stream().noneMatch(c -> c.getName().equals(extensionAttCondition.getName()))) {
				AttributeCondition extendedAttCondition = HenshinFactory.eINSTANCE.createAttributeCondition();
				extendedAttCondition.setConditionText(extensionAttCondition.getConditionText());
				extendedAttCondition.setDescription(extensionAttCondition.getDescription());
				extendedAttCondition.setName(extensionAttCondition.getName());
				extendedAttConditions.add(extendedAttCondition);
			}
		}
	}
	
	private static void extend (EList<Parameter> extendedParameters, EList<Parameter> extensionParameters) {
		for (Parameter extensionParameter : extensionParameters) {
			if (extendedParameters.stream().noneMatch(c -> c.getName().equals(extensionParameter.getName()))) {
				Parameter extendedParameter = HenshinFactory.eINSTANCE.createParameter();
				extendedParameter.setType(extensionParameter.getType());
				extendedParameter.setDescription(extensionParameter.getDescription());
				extendedParameter.setKind(extensionParameter.getKind());
				extendedParameter.setName(extensionParameter.getName());
				extendedParameters.add(extendedParameter);
			}
		}
	}
	
	private static void extend (NestedCondition extendedCondition, NestedCondition extensionCondition) {
		extend(extendedCondition.getConclusion(), extensionCondition.getConclusion());
		extend(extendedCondition.getMappings(), extensionCondition.getMappings(), extendedCondition.getHost(), extendedCondition.getConclusion());
	}
	
	private static void updateCrossReferences (Module module) {
		// update URI of rule nodes, edges and attributes
		Iterator<EObject> it = module.eAllContents();
		while (it.hasNext()) {
			for (EPackage epackage : module.getImports()) {
				EObject henshinobj = it.next();
				if      (henshinobj instanceof Node)      updateCrossReferences((Node)henshinobj, epackage);
				else if (henshinobj instanceof Edge)      updateCrossReferences((Edge)henshinobj, epackage);
				else if (henshinobj instanceof Attribute) updateCrossReferences((Attribute)henshinobj, epackage);
				else if (henshinobj instanceof Parameter) updateCrossReferences((Parameter)henshinobj, epackage);
		}}			
	}

	private static void updateCrossReferences (Node node, EPackage epackage) {
		for (EClassifier classifier : epackage.getEClassifiers()) {
			if (classifier instanceof EClass && classifier.getName().equals(node.getType().getName())) {
				node.setType((EClass)classifier);
				break;
			}
		}
	}

	private static void updateCrossReferences (Edge edge, EPackage epackage) {
		for (EClassifier classifier : epackage.getEClassifiers()) {
			// check name of edge's source type
			if (classifier instanceof EClass && classifier.getName().equals(edge.getSource().getType().getName())) {
				for (EReference reference : ((EClass)classifier).getEAllReferences()) {
					    // check name of edge
					if (edge.getType().getName().equals(reference.getName()) &&
						// check name of edge's target type
						(edge.getTarget().getType().getName().equals(reference.getEType().getName()) ||
						 ((edge.getTarget().getType() instanceof EClass) &&
						  ((EClass)edge.getTarget().getType())
						  			.getESuperTypes().stream().
						  			anyMatch(supertype -> supertype.getName().equals(reference.getEType().getName()))))) {
						edge.setType(reference);
						return;
		}}}}
	}
	
	private static void updateCrossReferences (Attribute attribute, EPackage epackage) {
		for (EClassifier classifier : epackage.getEClassifiers()) {
			if (classifier instanceof EClass && classifier.getName().equals(attribute.getNode().getName())) {
				for (EAttribute att : ((EClass)classifier).getEAllAttributes()) {
					if (att.getName().equals(attribute.getType().getName())) {
						attribute.setType(att);
						return;
		}}}}
	}	
	
	private static void updateCrossReferences (Parameter parameter, EPackage epackage) {
		if (parameter.getType() instanceof EClass) {
			for (EClassifier classifier : epackage.getEClassifiers()) {
				if (classifier instanceof EClass && classifier.getName().equals(parameter.getType().getName())) {
					parameter.setType((EClass)classifier);
					break;
		}}}
	}

}

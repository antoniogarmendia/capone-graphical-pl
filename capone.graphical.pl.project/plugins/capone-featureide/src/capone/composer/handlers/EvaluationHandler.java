package capone.composer.handlers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.henshin.model.Graph;
import org.eclipse.emf.henshin.model.NestedCondition;

import capone.composer.eval.CaponeStats;
import capone.composer.eval.EcoreStats;
import capone.composer.eval.HenshinStats;
import capone.composer.eval.RuleStats;
import capone.composer.helper.EMFHandler;
import capone.composer.helper.HandlerHelper;
import capone.composer.helper.HenshinHelper;

public class EvaluationHandler implements IHandler {

	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		System.out.println("[CAPONE] Evaluation");
		IFile file = HandlerHelper.getSelectedFile(event);
		IProject project = file.getProject();
		ecoreEvaluation(project);
		henshinEvaluation(project);
				
		return Status.OK_STATUS;
	}

	private void henshinEvaluation(IProject project) {
		List<IFile> henshins = this.allFilesWithCondition(project, fileName -> fileName.endsWith(".henshin"));
		Map<IFile, HenshinStats> henshinStats = measureHenshinFiles(henshins);
		for (IFile f : henshinStats.keySet()) 
			System.out.println(f.getName()+" "+henshinStats.get(f).toString());
		
		this.saveStatsToCSV(henshinStats, project.getName()+"_henshin");
	}

	private Map<IFile, HenshinStats> measureHenshinFiles(List<IFile> henshins ) {
		Map<IFile, HenshinStats> henshinStats = new LinkedHashMap<>();
		for (IFile f : henshins) {
			org.eclipse.emf.henshin.model.Module m = HenshinHelper.load(f);
			HenshinStats hs = new HenshinStats();
			for (org.eclipse.emf.henshin.model.Rule r : m.getAllRules()) {
				Graph lhs = r.getLhs(),
					  rhs = r.getRhs();
				int mappingSize = r.getAllMappings().size();
				int numObjects = lhs.getNodes().size() + lhs.getEdges().size() +
								 rhs.getNodes().size() + rhs.getEdges().size() - mappingSize;
				// now add the NAC size
				for (NestedCondition nc : lhs.getNACs()) {
					numObjects += nc.getHost().getNodes().size() + nc.getHost().getEdges().size();
					numObjects -= nc.getMappings().size();
				}
				RuleStats rs = new RuleStats(r.getName(), numObjects);
				hs.getRules().add(rs);
			}
			henshinStats.put(f, hs);
		}
		return henshinStats;
	}

	private void ecoreEvaluation(IProject project) {
		List<IFile> ecores = this.allFilesWithCondition(project, 
														fileName -> fileName.endsWith(".ecore") && 
																	!fileName.contains("effective"));
		Map<IFile, EcoreStats> metrics = this.measure(ecores);
		for (IFile f : metrics.keySet()) 
			System.out.println(f.getName()+" "+metrics.get(f).toString());
		
		this.saveStatsToCSV(metrics, project.getName());
	}
	
	private void saveStatsToCSV(Map<IFile, ? extends CaponeStats> metrics, String name) {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter("C:\\research\\capone_ws_ws\\"+name+".csv");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		for (IFile f : metrics.keySet()) {
			CaponeStats s = metrics.get(f);
			pw.print(f.getName());
			for (Object o : s.getData()) 
				pw.print(", "+o);
			pw.println();			
		}
		pw.close();
	}

	public List<IFile> allFilesWithCondition(IContainer container, Predicate<String> condition)
	{
		List<IFile> files = new ArrayList<>();
		try {
			for (IResource member : container.members())	   
				if (member instanceof IFile && condition.test(member.getName())) 
					files.add((IFile) member);
				else if (member instanceof IFolder) 
					files.addAll(this.allFilesWithCondition((IContainer) member, condition));				
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	    
		return files;
	}	
	
	private Map<IFile, EcoreStats> measure(List<IFile> ecores) {
		Map<IFile, EcoreStats> map = new LinkedHashMap<>();
		EMFHandler emh = new EMFHandler();
		for (IFile f : ecores) {
			Resource res = emh.readEcore(f);
			EPackage droot = (EPackage) res.getAllContents().next();
			EcoreStats s = this.extractStats(droot);
			map.put(f, s);
		}
		return map;
	}

	private EcoreStats extractStats(EPackage droot) {
		EcoreStats s = new EcoreStats();
		s.setNumClasses(droot.getEClassifiers().size());
		int numAttr = 0, numRef = 0;
		for (EClassifier ec : droot.getEClassifiers()) {
			if (!(ec instanceof EClass)) continue;
			EClass c = (EClass) ec;
			numAttr += c.getEAttributes().size();
			numRef += c.getEReferences().size();
		}
		s.setNumAttributes(numAttr);
		s.setNumRefs(numRef);
		return s;
	}

	private List<File> allEcoreFiles(final File folder) {
		List<File> files = new ArrayList<>();
	    for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	        	files.addAll(allEcoreFiles(fileEntry));
	        } else if (fileEntry.getName().endsWith(".ecore") &&
	        		!fileEntry.getName().contains("effective")){
	            files.add(fileEntry);
	        }
	    }
	    return files;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isHandled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeHandlerListener(IHandlerListener handlerListener) {
		// TODO Auto-generated method stub

	}

}

package capone.composer.eval;

import java.util.*;

public class HenshinStats implements CaponeStats{
	private List<RuleStats> rules = new ArrayList<>();
	
	public List<RuleStats> getRules() { return rules; }
	public int getNumRules() { return rules.size(); }
	
	@Override
	public String toString() {
		return this.rules.toString();
	}
	@Override
	public List<Object> getData() {
		double totalSize = 0;
		for (RuleStats rs : rules) 
			totalSize += rs.getNumObjs();		
		
		return List.of(rules.size(), totalSize, totalSize/rules.size());
	}
}

package capone.composer.eval;

public class RuleStats {
	private String name;
	private int numObjs;
	
	public RuleStats(String name, int numObjs) {		
		this.name = name;
		this.numObjs = numObjs;
	}

	public int getNumObjs() {
		return this.numObjs;
	}
	
	@Override
	public String toString() {
		return "RuleStats [name=" + name + ", numObjs=" + numObjs + "]";
	}		
}

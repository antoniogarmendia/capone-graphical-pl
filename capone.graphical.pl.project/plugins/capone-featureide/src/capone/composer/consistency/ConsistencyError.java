package capone.composer.consistency;

public class ConsistencyError {
	private String moduleName;
	private String ruleName;
	
	public ConsistencyError (String module, String rule) {
		this.moduleName = module;
		this.ruleName = rule;
	}

	@Override
	public String toString() {
		return "Non-extension rule "+ this.ruleName+" in module "+this.moduleName;
	}
}

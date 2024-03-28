package capone.composer.consistency;

public class ExternalTypeConsistencyError extends ConsistencyError {
	private String typeName;
	
	public ExternalTypeConsistencyError (String module, String rule, String typeName) {
		super(module, rule);
		this.typeName = typeName;
	}

	@Override
	public String toString() {
		return super.toString()+", type "+this.typeName;
	}
}

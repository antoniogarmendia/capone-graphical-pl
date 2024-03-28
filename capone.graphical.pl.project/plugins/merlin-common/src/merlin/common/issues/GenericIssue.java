package merlin.common.issues;

public class GenericIssue {
	private String message;
	private int severity;
	private String location;
	
	public GenericIssue (String message, int level, String location) {
		this.message = message;
		this.severity = level;
		this.location = location;
	}

	public String getMessage() {
		return message;
	}

	public int getSeverity() {
		return severity;
	}

	public String getLocation() {
		return location;
	}
	
	
}

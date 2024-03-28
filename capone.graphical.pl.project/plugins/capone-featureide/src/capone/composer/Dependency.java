package capone.composer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Dependency {
	ALT("extends.alternative"), OR("extends.or"), OPTIONAL("extends.optional"), MANDATORY("extends.mandatory");
	
	private String xtext;

	Dependency (String xtext) {
		this.xtext = xtext;
	}
	
	public static final List<String> depKinds = Arrays.asList(Dependency.values()).
													   stream().
													   map(d->d.xtext).
													   collect(Collectors.toList()); 
	/*		List.of("extends.alternative",
			   "extends.or",
			   "extends.optional",
			   "extends.mandatory");*/
	
	public static Dependency get(String repr) {
		for (Dependency d : Dependency.values()) 
			if (d.xtext.equals(repr)) return d;		
		return null;
	}
}

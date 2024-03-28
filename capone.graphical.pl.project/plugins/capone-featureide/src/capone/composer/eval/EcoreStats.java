package capone.composer.eval;

import java.util.List;

public class EcoreStats implements CaponeStats {
	private int numClasses;
	private int numAttribs;
	private int numRefs;
	
	public void setNumClasses(int nc) { this.numClasses = nc; }
	public void setNumAttributes(int nc) { this.numAttribs = nc; }
	public void setNumRefs(int nc) { this.numRefs = nc; }
	
	public int getNumClasses() { return this.numClasses; }
	public int getNumAttributes() { return this.numAttribs; }
	public int getNumRefs() { return this.numRefs; }
	
	public String toString() {
		return "Classes = "+numClasses+", Attrs = "+this.numAttribs+", Refs= "+this.numRefs;
	}
	@Override
	public List<Object> getData() {		
		return List.of(numClasses, numAttribs, numRefs);
	}
}

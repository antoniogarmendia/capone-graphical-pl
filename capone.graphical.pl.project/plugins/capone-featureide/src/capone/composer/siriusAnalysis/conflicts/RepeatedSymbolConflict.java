package capone.composer.siriusAnalysis.conflicts;

import java.util.List;
import org.eclipse.sirius.diagram.description.AbstractNodeMapping;


public class RepeatedSymbolConflict extends SymbolPairConflict{
	
	public RepeatedSymbolConflict ( AbstractNodeMapping nm1, capone.Module m1,
									AbstractNodeMapping nm2, capone.Module m2) {
		super("Repeated symbol", List.of(nm1, nm2), List.of(m1, m2));
	}
}

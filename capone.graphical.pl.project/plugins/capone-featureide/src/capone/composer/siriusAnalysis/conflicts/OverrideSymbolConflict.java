package capone.composer.siriusAnalysis.conflicts;

import java.util.List;
import org.eclipse.sirius.diagram.description.AbstractNodeMapping;

public class OverrideSymbolConflict extends SymbolPairConflict{
	
	public OverrideSymbolConflict ( AbstractNodeMapping nm1, capone.Module m1,
									AbstractNodeMapping nm2, capone.Module m2) {
		super("Override conflict", List.of(nm1, nm2), List.of(m1, m2));
	}
}

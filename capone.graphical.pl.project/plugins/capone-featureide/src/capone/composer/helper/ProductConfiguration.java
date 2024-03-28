package capone.composer.helper;

import org.eclipse.core.resources.IFile;

public class ProductConfiguration {
	
	private IFile ecoreFile;
	private IFile odesignFile;
	
	public ProductConfiguration() {
		this.ecoreFile = null;
		this.odesignFile = null;
	}

	public IFile getEcoreFile() {
		return ecoreFile;
	}

	public void setEcoreFile(IFile ecoreFile) {
		this.ecoreFile = ecoreFile;
	}

	public IFile getOdesignFile() {
		return odesignFile;
	}

	public void setOdesignFile(IFile odesignFile) {
		this.odesignFile = odesignFile;
	}	
}

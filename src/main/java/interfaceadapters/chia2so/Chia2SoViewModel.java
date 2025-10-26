package interfaceadapters.chia2so;

import interfaceadapters.Publisher;

public class Chia2SoViewModel extends Publisher {
	public String result;
	public boolean hasError;
	
	public String getResult() {
		return result;
	}
	
	public boolean isHasError() {
		return hasError;
	}
}

package interfaceadapters.nhan2so;

import interfaceadapters.Publisher;

public class Nhan2SoViewModel extends Publisher {
	public String result;
	public boolean laChan;
	
	public String getResult() {
		return result;
	}
	
	public boolean isLaChan() {
		return laChan;
	}
}

package interfaceadapters.nhan2so;

import interfaceadapters.Publisher;

public class Nhan2SoViewModel extends Publisher {
	public String result;
	public String errorMessage;
	public String color;
	
	public String getResult() {
		return result;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	public String getColor() {
		return color;
	}
}

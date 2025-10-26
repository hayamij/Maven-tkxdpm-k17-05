package interfaceadapters.tru2so;

import usecases.tru2so.InputData;
import usecases.tru2so.InputInterface;

public class Tru2SoController {
	private InputInterface inBoundary;
	
	public void execute(InputDTO inDTO) {
		InputData inData = new InputData(
			Integer.parseInt(inDTO.num1), 
			Integer.parseInt(inDTO.num2));
		
		inBoundary.execute(inData);
	}
	
	public Tru2SoController(InputInterface inBoundary) {
		super();
		this.inBoundary = inBoundary;
	}
}

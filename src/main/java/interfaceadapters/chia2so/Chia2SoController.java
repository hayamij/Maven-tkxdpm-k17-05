package interfaceadapters.chia2so;

import usecases.chia2so.InputData;
import usecases.chia2so.InputInterface;

public class Chia2SoController {
	private InputInterface inBoundary;
	
	public void execute(InputDTO inDTO) {
		InputData inData = new InputData(
			Integer.parseInt(inDTO.num1), 
			Integer.parseInt(inDTO.num2));
		
		inBoundary.execute(inData);
	}
	
	public Chia2SoController(InputInterface inBoundary) {
		super();
		this.inBoundary = inBoundary;
	}
}

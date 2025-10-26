package usecases.chia2so;

import entities.chia2so.Chia2So;

public class Chia2SoUseCaseControl implements InputInterface {
	private OutputInterface out;
	private Chia2So c2so;
	private OutputData outData;
	
	public OutputData getOutData() {
		return outData;
	}

	public Chia2SoUseCaseControl(OutputInterface out, Chia2So c2so) {
		this.out = out;
		this.c2so = c2so;
	}
	
	public void execute(InputData inData) {
		c2so.setNumber1(inData.num1);
		c2so.setNumber2(inData.num2);
		
		outData = new OutputData();
		try {
			double result = c2so.chia2So(); // 2. sai khiến Entity
			outData.result = result;
			outData.errorMessage = null;
		} catch (ArithmeticException e) {
			outData.result = 0;
			outData.errorMessage = e.getMessage();
		}
		
		out.present(outData); // 3. sai khiến boundary
	}
}

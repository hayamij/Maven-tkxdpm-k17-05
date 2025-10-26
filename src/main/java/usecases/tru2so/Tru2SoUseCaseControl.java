package usecases.tru2so;

import entities.tru2so.Tru2So;

public class Tru2SoUseCaseControl implements InputInterface {
	private OutputInterface out;
	private Tru2So t2so;
	private OutputData outData;
	
	public OutputData getOutData() {
		return outData;
	}

	public Tru2SoUseCaseControl(OutputInterface out, Tru2So t2so) {
		this.out = out;
		this.t2so = t2so;
	}
	
	public void execute(InputData inData) {
		t2so.setNumber1(inData.num1);
		t2so.setNumber2(inData.num2);
		int result = t2so.tru2So(); // 2. sai khiến Entity
		
		outData = new OutputData();
		outData.result = result;
		out.present(outData); // 3. sai khiến boundary
	}
}

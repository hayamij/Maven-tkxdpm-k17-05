package usecases.cong2so;

import entities.cong2so.Cong2So;

public class Cong2SoUseCaseControl implements InputInterface {
	private OutputInterface out;
	private OutputData outData;
	
	public OutputData getOutData() {
		return outData;
	}

	public Cong2SoUseCaseControl(OutputInterface out) {
		this.out = out;
	}
	
	public void execute(InputData inData) {
		Cong2So c2so = new Cong2So(inData.num1, inData.num2);
		int result = (int) c2so.tinh2so();
	
		outData = new OutputData();
		outData.result = result;
		
		out.present(outData);
	}
}

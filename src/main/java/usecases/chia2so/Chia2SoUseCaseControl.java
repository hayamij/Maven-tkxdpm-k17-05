package usecases.chia2so;

import entities.chia2so.Chia2So;

public class Chia2SoUseCaseControl implements InputInterface {
	private OutputInterface out;
	private OutputData outData;
	
	public OutputData getOutData() {
		return outData;
	}

	public Chia2SoUseCaseControl(OutputInterface out) {
		this.out = out;
	}
	
	public void execute(InputData inData) {

		outData = new OutputData();
		if(!Chia2So.isValid(inData.num1, inData.num2)) {
			outData.errorMessage = "Invalid input";
			out.present(outData);
			return;
		}

		Chia2So c2so = new Chia2So(inData.num1, inData.num2);

		outData.result = c2so.tinh2so();
		outData.errorMessage = "";
		out.present(outData);
	}
}

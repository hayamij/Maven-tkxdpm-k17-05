package usecases.nhan2so;

import entities.nhan2so.Nhan2So;

public class Nhan2SoUseCaseControl implements InputInterface {
	private OutputInterface out;
	private OutputData outData;
	
	public OutputData getOutData() {
		return outData;
	}

	public Nhan2SoUseCaseControl(OutputInterface out) {
		this.out = out;
	}
	
	public void execute(InputData inData) {

		Nhan2So n2so = new Nhan2So(inData.num1, inData.num2);
		OutputData outData = new OutputData();

		// validate
		if (!Nhan2So.isValid(inData.num1, inData.num2)) {
			outData.errorMessage = "Invalid input: num1 and num2 must be between 0 and 9.";
			out.present(outData);
			return;
		}

		int result = (int) n2so.tinh2so();

		if (Nhan2So.isOdd(result)) {
			outData.isOdd = true;
		} else {
			outData.isOdd = false;
		}

		outData.errorMessage = "";
		outData.result = result;
		out.present(outData);

	}
}

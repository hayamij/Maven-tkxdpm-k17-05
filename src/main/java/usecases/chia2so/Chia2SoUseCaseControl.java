package usecases.chia2so;

import entities.chia2so.Chia2So;
import entities.chanle.KiemTraChanLe;

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
		Chia2So c2so = new Chia2So(inData.num1, inData.num2);
		outData = new OutputData();
		KiemTraChanLe ktcl = new KiemTraChanLe();
		try {
			double result = c2so.chia2So();
			outData.result = result;
			outData.errorMessage = null;
			
			int resultInt = (int) result;
			ktcl.setNumber(resultInt);
			boolean laChan = ktcl.laChanHayle();
			outData.laChan = laChan;
		} catch (ArithmeticException e) {
			outData.result = 0;
			outData.errorMessage = e.getMessage();
			outData.laChan = false;
		}
		
		out.present(outData);
	}
}

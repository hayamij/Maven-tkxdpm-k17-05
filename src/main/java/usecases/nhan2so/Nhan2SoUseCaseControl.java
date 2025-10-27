package usecases.nhan2so;

import entities.nhan2so.Nhan2So;
import entities.chanle.KiemTraChanLe;

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
		int result = n2so.nhan2So();
		
		KiemTraChanLe ktcl = new KiemTraChanLe(result);
		boolean laChan = ktcl.laChanHayle();
		
		outData = new OutputData();
		outData.result = result;
		outData.laChan = laChan;
		
		out.present(outData);
	}
}

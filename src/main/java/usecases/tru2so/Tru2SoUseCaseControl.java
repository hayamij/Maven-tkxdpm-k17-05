package usecases.tru2so;

import entities.tru2so.Tru2So;
import entities.chanle.KiemTraChanLe;

public class Tru2SoUseCaseControl implements InputInterface {
	private OutputInterface out;
	private OutputData outData;
	
	public OutputData getOutData() {
		return outData;
	}

	public Tru2SoUseCaseControl(OutputInterface out) {
		this.out = out;
	}
	
	public void execute(InputData inData) {
		Tru2So t2so = new Tru2So(inData.num1, inData.num2);
		int result = t2so.tru2So();
		
		KiemTraChanLe ktcl = new KiemTraChanLe(result);

		boolean laChan = ktcl.laChanHayle();
		
		outData = new OutputData();
		outData.result = result;
		outData.laChan = laChan;
		
		out.present(outData);
	}
}

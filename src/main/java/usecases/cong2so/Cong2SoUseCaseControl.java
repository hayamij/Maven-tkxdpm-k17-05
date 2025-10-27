package usecases.cong2so;

import entities.cong2so.Cong2So;
import entities.chanle.KiemTraChanLe;

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
		int result = c2so.cong2So();
		
		KiemTraChanLe ktcl = new KiemTraChanLe(result);
		boolean laChan = ktcl.laChanHayle();
		
		outData = new OutputData();
		outData.result = result;
		outData.laChan = laChan;
		
		out.present(outData);
	}
}

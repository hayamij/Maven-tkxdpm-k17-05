package usecases.tru2so;

import entities.tru2so.Tru2So;
import entities.chanle.KiemTraChanLe;

public class Tru2SoUseCaseControl implements InputInterface {
	private OutputInterface out;
	private Tru2So t2so;
	private KiemTraChanLe ktcl;
	private OutputData outData;
	
	public OutputData getOutData() {
		return outData;
	}

	public Tru2SoUseCaseControl(OutputInterface out, Tru2So t2so, KiemTraChanLe ktcl) {
		this.out = out;
		this.t2so = t2so;
		this.ktcl = ktcl;
	}
	
	public void execute(InputData inData) {
		t2so.setNumber1(inData.num1);
		t2so.setNumber2(inData.num2);
		int result = t2so.tru2So();
		
		ktcl.setNumber(result);
		boolean laChan = ktcl.laChanHayle();
		
		outData = new OutputData();
		outData.result = result;
		outData.laChan = laChan;
		
		out.present(outData);
	}
}

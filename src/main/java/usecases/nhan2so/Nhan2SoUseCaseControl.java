package usecases.nhan2so;

import entities.nhan2so.Nhan2So;
import entities.chanle.KiemTraChanLe;

public class Nhan2SoUseCaseControl implements InputInterface {
	private OutputInterface out;
	private Nhan2So n2so;
	private KiemTraChanLe ktcl;
	private OutputData outData;
	
	public OutputData getOutData() {
		return outData;
	}

	public Nhan2SoUseCaseControl(OutputInterface out, Nhan2So n2so, KiemTraChanLe ktcl) {
		this.out = out;
		this.n2so = n2so;
		this.ktcl = ktcl;
	}
	
	public void execute(InputData inData) {
		n2so.setNumber1(inData.num1);
		n2so.setNumber2(inData.num2);
		int result = n2so.nhan2So();
		
		ktcl.setNumber(result);
		boolean laChan = ktcl.laChanHayle();
		
		outData = new OutputData();
		outData.result = result;
		outData.laChan = laChan;
		
		out.present(outData);
	}
}

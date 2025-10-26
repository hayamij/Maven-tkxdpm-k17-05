package usecases.chanle;

import entities.chanle.KiemTraChanLe;

public class KiemTraChanLeUseCaseControl implements InputInterface {
	private OutputInterfaceChanLe out;
	private KiemTraChanLe ktcl;
	private OutputDataChanLe outData;
	
	public OutputDataChanLe getOutData() {
		return outData;
	}

	public KiemTraChanLeUseCaseControl(OutputInterfaceChanLe out, KiemTraChanLe ktcl) {
		this.out = out;
		this.ktcl = ktcl;
	}
	
	public void execute(InputData inData) {
		ktcl.setNumber(inData.number);
		boolean laChan = ktcl.laChanHayle(); // Sai khiến Entity
		
		outData = new OutputDataChanLe();
		outData.laChan = laChan;
		outData.number = inData.number;
		
		out.present(outData); // Sai khiến boundary
	}
}

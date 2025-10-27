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
		// 1. Tính trừ 2 số
		t2so.setNumber1(inData.num1);
		t2so.setNumber2(inData.num2);
		int result = t2so.tru2So();
		
		// 2. Kiểm tra chẵn lẻ của kết quả
		ktcl.setNumber(result);
		boolean laChan = ktcl.laChanHayle();
		
		// 3. Tạo OutputData với cả kết quả và thông tin chẵn/lẻ
		outData = new OutputData();
		outData.result = result;
		outData.laChan = laChan;
		
		// 4. Gửi cho Presenter
		out.present(outData);
	}
}

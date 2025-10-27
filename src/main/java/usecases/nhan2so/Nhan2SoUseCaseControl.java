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
		// 1. Tính nhân 2 số
		n2so.setNumber1(inData.num1);
		n2so.setNumber2(inData.num2);
		int result = n2so.nhan2So();
		
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

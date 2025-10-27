package usecases.cong2so;

import entities.cong2so.Cong2So;
import entities.chanle.KiemTraChanLe;

public class Cong2SoUseCaseControl implements InputInterface {
	private OutputInterface out;
	private Cong2So c2so;
	private KiemTraChanLe ktcl;
	private OutputData outData;
	
	public OutputData getOutData() {
		return outData;
	}

	public Cong2SoUseCaseControl(OutputInterface out, Cong2So c2so, KiemTraChanLe ktcl) {
		this.out = out;
		this.c2so = c2so;
		this.ktcl = ktcl;
	}
	
	public void execute(InputData inData) {
		// 1. Tính cộng 2 số
		c2so.setNumber1(inData.num1);
		c2so.setNumber2(inData.num2);
		int result = c2so.cong2So();
		
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

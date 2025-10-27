package usecases.chia2so;

import entities.chia2so.Chia2So;
import entities.chanle.KiemTraChanLe;

public class Chia2SoUseCaseControl implements InputInterface {
	private OutputInterface out;
	private Chia2So c2so;
	private KiemTraChanLe ktcl;
	private OutputData outData;
	
	public OutputData getOutData() {
		return outData;
	}

	public Chia2SoUseCaseControl(OutputInterface out, Chia2So c2so, KiemTraChanLe ktcl) {
		this.out = out;
		this.c2so = c2so;
		this.ktcl = ktcl;
	}
	
	public void execute(InputData inData) {
		c2so.setNumber1(inData.num1);
		c2so.setNumber2(inData.num2);
		
		outData = new OutputData();
		try {
			// 1. Tính chia 2 số
			double result = c2so.chia2So();
			outData.result = result;
			outData.errorMessage = null;
			
			// 2. Kiểm tra chẵn lẻ của kết quả (phần nguyên)
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

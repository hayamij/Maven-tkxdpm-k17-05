package entities.nhan2so;

import entities.TinhToan2So;

public class Nhan2So extends TinhToan2So {

	public Nhan2So(Integer num1, Integer num2) {
		super(num1, num2);
	}

	@Override
	public double tinh2so() {
		return num1 * num2;
	}

	public static boolean isValid(Integer num1, Integer num2) {
		if (num1 >= 0 && num1 <= 9 && num2 >= 0 && num2 <= 9) {
			return true;
		}
		return false;
	}

	public static boolean isOdd(Integer result){
		if (result % 2 != 0){
			return true;
		}
		return false;
	}
}


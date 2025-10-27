package entities.chia2so;

import entities.TinhToan2So;

public class Chia2So extends TinhToan2So {

	public Chia2So(Integer num1, Integer num2) {
		super(num1, num2);
	}

	@Override
	public double tinh2so() {
		return (double) num1 / num2;
	}

	public static boolean isValid(Integer num1, Integer num2) {
		if (num2 != 0) {
			return true;
		}
		return false;
	}
}


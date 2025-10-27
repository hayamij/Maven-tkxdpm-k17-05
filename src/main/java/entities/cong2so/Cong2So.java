package entities.cong2so;

import entities.TinhToan2So;

public class Cong2So extends TinhToan2So {

	public Cong2So(Integer num1, Integer num2) {
		super(num1, num2);
	}

	@Override
	public double tinh2so() {
		return num1 + num2;
	}
}


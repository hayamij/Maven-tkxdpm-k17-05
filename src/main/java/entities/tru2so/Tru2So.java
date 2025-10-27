package entities.tru2so;

import entities.TinhToan2So;

public class Tru2So extends TinhToan2So {

	public Tru2So(Integer num1, Integer num2) {
		super(num1, num2);
	}

	@Override
	public double tinh2so() {
		return num1 - num2;
	}
}


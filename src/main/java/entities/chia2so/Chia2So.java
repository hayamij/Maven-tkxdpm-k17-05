package entities.chia2so;

public class Chia2So {
	private int number1;
	private int number2;
	
	 
	public Chia2So() {
	}

	public Chia2So(int number1, int number2) {
		this.number1 = number1;
		this.number2 = number2;
	}


	public double chia2So() {
		if (number2 == 0) {
			throw new ArithmeticException("Không thể chia cho 0");
		}
		return  (double) number1 / number2;
	}

	public void setNumber1(int number1) {
		this.number1 = number1;
	}

	public void setNumber2(int number2) {
		this.number2 = number2;
	}
}

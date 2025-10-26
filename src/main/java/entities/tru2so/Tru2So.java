package entities.tru2so;

public class Tru2So {
	private int number1;
	private int number2;
	
	 
	public Tru2So() {
	}

	public Tru2So(int number1, int number2) {
		this.number1 = number1;
		this.number2 = number2;
	}


	public int tru2So() {
		return  number1 - number2;
	}

	public void setNumber1(int number1) {
		this.number1 = number1;
	}

	public void setNumber2(int number2) {
		this.number2 = number2;
	}
}

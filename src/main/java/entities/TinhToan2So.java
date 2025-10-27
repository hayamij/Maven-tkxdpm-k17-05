package entities;

public abstract class TinhToan2So {

    protected Integer num1;
    protected Integer num2;

    public TinhToan2So(Integer num1, Integer num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public abstract double tinh2so();
    
}

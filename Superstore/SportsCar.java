public class SportsCar extends Item {
    private int topSpeed;

    public SportsCar(String make, String model, int price, int cost, int msrp, int topSpeed) {
        super(make, model, price, cost, msrp);
        this.topSpeed = topSpeed;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    @Override
    public String toString() {
        return super.toString() + ", Top Speed: " + topSpeed + " mph";
    }
}
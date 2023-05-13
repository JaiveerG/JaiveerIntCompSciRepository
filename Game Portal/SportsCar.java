import java.util.Random;

public class SportsCar extends Item {

    public SportsCar(String category, String name, int price, int salePriceMin, int salePriceMax) {
        super(category, name, price, salePriceMin, salePriceMax);
    }

    @Override
    public int getSalePrice() {
        // Override the getSalePrice() method for Sports Cars
        Random rand = new Random();
        return (int) (super.getSalePrice() * 1.1); // Add 10% to the sale price
    }
}
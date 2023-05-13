import java.util.Random;

public class RareCar extends Item {
    public RareCar(String category, String name, int price, int salePriceMin, int salePriceMax) {
        super(category, name, price, salePriceMin, salePriceMax);
    }

    @Override
    public int getSalePrice() {
        // Override the getSalePrice() method for Rare Cars
        Random rand = new Random();
        return (int) (super.getSalePrice() * 1.2); // Add 20% to the sale price
    }
}
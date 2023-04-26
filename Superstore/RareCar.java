import java.util.Random;

public class RareCar extends Item {
    public RareCar(String category, String name, int price, int salePriceMin, int salePriceMax) {
        super(category, name, price, salePriceMin, salePriceMax);
    }

    @Override
    public int getSalePrice() {
        // Override the getSalePrice() method for rare cars
        Random rand = new Random();
        return rand.nextInt(salePriceMax - salePriceMin + 1) + salePriceMin + 5000; // Add 5,000 to the sale price
    }
}
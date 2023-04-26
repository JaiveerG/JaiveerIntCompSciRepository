import java.util.Random;

public class F1Car extends Item {
    public F1Car(String category, String name, int price, int salePriceMin, int salePriceMax) {
        super(category, name, price, salePriceMin, salePriceMax);
    }

    @Override
    public int getSalePrice() {
        // Override the getSalePrice() method for F1 cars
        Random rand = new Random();
        return rand.nextInt(salePriceMax - salePriceMin + 1) + salePriceMin - 5000; // Subtract 5,000 from the sale price
    }
}
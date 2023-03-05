import java.util.Random;

public class Item {
    private String category;
    private String name;
    private int price;
    private int salePriceMin;
    private int salePriceMax;

    public Item(String category, String name, int price, int salePriceMin, int salePriceMax) {
        this.category = category;
        this.name = name;
        this.price = price;
        this.salePriceMin = salePriceMin;
        this.salePriceMax = salePriceMax;
    }

    public int getSalePrice() {
        Random rand = new Random();
        return rand.nextInt(salePriceMax - salePriceMin + 1) + salePriceMin;
    }
}
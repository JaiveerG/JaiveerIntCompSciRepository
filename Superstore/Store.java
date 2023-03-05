import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Item> items;

    public Store() {
        items = new ArrayList<Item>();
        // add items to the store
        items.add(new Item("Sports Cars", "2023 Porsche 911", 106100, 90000, 110000));
        items.add(new Item("Sports Cars", "2023 Corvette Z06", 105300, 100000, 110000));
        items.add(new Item("Sports Cars", "2023 Dodge Challenger", 30545, 15000, 40000));
        items.add(new Item("Sports Cars", "2023 Audi R8", 158600, 150000, 175000));
        items.add(new Item("Rare Cars", "Porsche 959", 2500000, 2300000, 2600000));
        items.add(new Item("Rare Cars", "Ferrari F40 LM", 3000000, 2700000, 3200000));
        items.add(new Item("Rare Cars", "McLaren F1", 4000000, 3800000, 4300000));
        items.add(new Item("Formula 1 Cars", "2022 Williams F1", 10000000, 9300000, 12600000));
        items.add(new Item("Formula 1 Cars", "2022 McLaren F1", 12500000, 10300000, 13600000));
        items.add(new Item("Formula 1 Cars", "2022 Mercedes F1", 15000000, 14300000, 17600000)); 
    }
}
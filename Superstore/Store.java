import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Store {
    private List<Item> items;
    private List<Item> cart;
    private int balance;
    private Scanner scanner;

    public static void main(String[] args) {
        Store store = new Store();
        store.run();
    }

    public Store() {
        items = new ArrayList<Item>();
        cart = new ArrayList<Item>();
        scanner = new Scanner(System.in);
        balance = 10000000;
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

    public void run() {
        while (true) {
            System.out.println("\nWelcome to the CarSuperstore! You have a budget of $10,000,000 Please choose an option:");
            System.out.println("1. View available items");
            System.out.println("2. View cart");
            System.out.println("3. Checkout");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();
            if (choice == 1) {
                viewItems();
            } 
            else if (choice == 2) {
                viewCart();
            }   
            else if (choice == 3) {
                checkout();
            } 
            else if (choice == 4) {
                System.out.println("Thank you for shopping with us! Goodbye.");
                break;
            } 
            else {
                System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private void viewItems() {
        System.out.println("\nAvailable items:");
        int i = 1;
        for (Item item : items) {
            System.out.println(i + ". " + item.getName() + " (" + item.getCategory() + ") - Price: $" + item.getPrice());
            i++;
        }
        System.out.println("Enter the number of the item you want to add to your cart, or enter 0 to go back to the main menu:");
        int choice = scanner.nextInt();
        if (choice > 0 && choice <= items.size()) {
            Item chosenItem = items.get(choice-1);
            cart.add(chosenItem);
            System.out.println(chosenItem.getName() + " added to your cart.");
        } else if (choice != 0) {
            System.out.println("Invalid choice. Please try again.");
        }
    }

    private void viewCart() {
        if (cart.isEmpty()) {
            System.out.println("\nYour cart is empty.");
        } else {
            System.out.println("\nItems in your cart:");
            for (Item item : cart) {
                System.out.println(item.getName());
            }
        }
    }

    private void checkout() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty. Please add items to your cart before checking out.");
            return;
        }
        int total = 0;
        for (Item item : cart) {
            total += item.getSalePrice();
        }
        if (total > balance) {
            System.out.println("Sorry, you don't have enough balance to purchase these items.");
            return;
        }
        System.out.println("Thank you for your purchase!");
        balance -= total;
        cart.clear();
    }
}

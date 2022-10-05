import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner name = new Scanner(System.in);
        System.out.println("What is your name?");
        String name1 = name.nextLine();

        Scanner icecream = new Scanner(System.in);
        System.out.println("Favorite flavor of ice cream?");
        String icecream1 = icecream.nextLine();

        boolean ic;

        if (icecream1.toString().equals("Chocolate")) {
            ic = true;
        } else {
            ic = false;
        }

        if(ic) {
            System.out.println("Hello " + name1 + ", your choice of ice cream is great");
        } 
        else {
            System.out.println("Hello " + name1 + ", your choice of ice cream is not good :(");
        }
    }
}

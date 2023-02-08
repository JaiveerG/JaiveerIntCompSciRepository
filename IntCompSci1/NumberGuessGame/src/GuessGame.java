import java.util.Scanner;

public class GuessGame {
    public static void main(String[] args) {
        do {
            NumberGuessGame g = new NumberGuessGame();
            g.start();
            Scanner scan = new Scanner(System.in);
            System.out.println("Do you want to play again? (y/n)");
            String a = scan.next();
            if (a.equals("n")) {
                System.out.println("Thanks for playing!");
                break;
            }
        } while (true);
    }
}
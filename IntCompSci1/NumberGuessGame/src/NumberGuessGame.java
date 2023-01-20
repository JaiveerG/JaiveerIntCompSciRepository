/*
* Jaiveer Gupta January 20th 2023
*/

// Import all necessary functions
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

// Declare a class
public class NumberGuessGame {
    public static void main(String[] args) {
        // Make an array called guesses
        ArrayList<Integer> guesses = new ArrayList<Integer>();
        // Make a random integer
        Random rand = new Random();
        try (Scanner upperbound = new Scanner(System.in)) {
            // Asks user for input about what the upperbound should be
            System.out.println("Enter the upperbound: ");  
            int a = upperbound.nextInt();  
            int numberToGuess = rand.nextInt(a) + 1;
            // Sets number of tries to 0, will be added to, to keep track
            int tries = 0;
            try (Scanner input = new Scanner(System.in)) {
                int guess;
                boolean win = false;
                // Sets up a while loop that will keep running until game is won
                while (win == false) {
                    // Asking user for guess
                    System.out.println("Guess a number between 1 and " + a + ": ");
                    // If input isn't an int, reprompt
                    while (!input.hasNextInt()) {
                        System.out.println("Please enter a valid integer: ");
                        input.next();
                    }
                    // See if guess was already guessed, repromt if was
                    guess = input.nextInt();
                    if (guess < 1 || guess > a) {
                        System.out.println("Nope. Not in the range. Still counts as a guess though.");
                    }
                    if (guesses.contains(guess)) {
                        System.out.println("You have already guessed this number. Try again.");
                    } 
                    // Otherwise, add to array, add one to tries counter, see if number was right or not
                    else {
                        guesses.add(guess);
                        tries++;
                        if (guess == numberToGuess) {
                            win = true;
                        }
                        else if (guess < numberToGuess) {
                            System.out.println("Your guess is too low");
                        }
                        else if (guess > numberToGuess) {
                            System.out.println("Your guess is too high");
                        } 
                    }
                }
            }
            // If game won, print out what the number was and how long it took to guess.
            System.out.println("You win! The number was " + numberToGuess);
            System.out.println("It took you only " + tries + " tries.");
        }
    }  
}

import java.io.File;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;

public class NumberGuessGame implements Game, GameWriteable {
    private ArrayList<Integer> guesses;
    private Random rand;
    private int a;
    private int numberToGuess;
    private int tries;

    public NumberGuessGame() {
        this.guesses = new ArrayList<Integer>();
        this.rand = new Random();
        Scanner upperbound = new Scanner(System.in);
        System.out.println("Enter the upperbound: ");
        while (!upperbound.hasNextInt()) {
            System.out.println("Please enter a valid integer: ");
            upperbound.next();
        }
        this.a = upperbound.nextInt();
        this.numberToGuess = rand.nextInt(a) + 1;
        this.tries = 0;
    }

    public void start() {
        Scanner input = new Scanner(System.in);
        int guess;
        boolean win = false;
        while (win == false) {
            System.out.println("Guess a number between 1 and " + a + ": ");
            while (!input.hasNextInt()) {
                System.out.println("Please enter a valid integer: ");
                input.next();
            }
            guess = input.nextInt();
            if (guess < 1 || guess > a) {
                System.out.println("Nope. Not in the range. Still counts as a guess though.");
            }
            if (guesses.contains(guess)) {
                System.out.println("You have already guessed this number. Try again.");
            } else {
                guesses.add(guess);
                tries++;
                if (guess == numberToGuess) {
                    win = true;
                } else if (guess < numberToGuess) {
                    System.out.println("Your guess is too low");
                } else if (guess > numberToGuess) {
                    System.out.println("Your guess is too high");
                }
            }
        }
        System.out.println("You win! The number was " + numberToGuess);
        System.out.println("It took you only " + tries + " tries.");
    }

    @Override
    public String getGameName() {
        return "Number Guess Game";
    }

    @Override
    public void play() {
        start();
    }

    @Override
    public String getScore() {
        return Integer.toString(tries);
    }

    @Override
    public void writeHighScore(File f) {
        String score = getScore();
        String highScore = getBestScore(f);
        if (isHighScore(score, highScore)) {
            System.out.println("You got a new high score, which beats the previous high score of " + highScore);
            try {
                Scanner myReader = new Scanner(f);
                StringBuilder newFile = new StringBuilder();
                while (myReader.hasNextLine()) {
                    String line = myReader.nextLine();
                    String[] data = line.split(",");
                    if (!data[0].equals(getGameName())) {
                        newFile.append(line).append("\n");
                    }
                }
                newFile.append(getGameName()).append(",").append(score).append("\n");
                myReader.close();

                FileWriter myWriter = new FileWriter(f);
                myWriter.write(newFile.toString());
                myWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean isHighScore(String score, String highscore) {
        int currentScore = Integer.parseInt(score);
        int previousHighScore = (highscore != null) ? Integer.parseInt(highscore) : Integer.MAX_VALUE;
        return currentScore < previousHighScore;
    }
}
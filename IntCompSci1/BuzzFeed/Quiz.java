/*
 * Irene Feng Nov 2022
 * This is the class where we create the Quiz and run it. It has the main method.  
 */
import java.util.Scanner;

public class Quiz {
        public static void main(String[] args) throws Exception {
            // Create Categories
            Category America = new Category("America", "Christian Pulisic is going to try to take you to glory!");
            Category France = new Category("France", "The defending champions are a great team to root for!");
            Category England = new Category("England", "If you love the Premier League, this is the team for you to root for!");
            Category Argentina = new Category("Argentina", "Who doesn't love Messi!");
            Category Portugal = new Category("Portugal", "Ronaldo is the only player to score in 5 world cups, but can he win one?");
            Category Brazil = new Category("Brazil", "Let's see if Neymar can avenge his world cup woes!");
      
      
            // Create Questions
            Question q1 = new Question("What it your favorite food?");
            // Attach Answers to Questions
            q1.possibleAnswers[0] = new Answer("Hot Dogs", America); //America
            q1.possibleAnswers[1] = new Answer("Croissant", France); //France
            q1.possibleAnswers[2] = new Answer("Fish and Chips", England); //England
            q1.possibleAnswers[3] = new Answer("Asado", Argentina); //Argentina
            q1.possibleAnswers[4] = new Answer("Farofa", Brazil); //Brazil
            q1.possibleAnswers[5] = new Answer("Arroz de Pato", Portugal); //Portugal
      
      
            Question q2 = new Question("Who is your favorite actor/actress?");
            q2.possibleAnswers[0] = new Answer("Gisele Bundchen", Brazil); //Brazil
            q2.possibleAnswers[1] = new Answer("Vincent Cassel", France); //France
            q2.possibleAnswers[2] = new Answer("Millie Bobby Brown", England); //England
            q2.possibleAnswers[3] = new Answer("Dwayne Johnson", America); //America
            q2.possibleAnswers[4] = new Answer("Olivia Hussey", Argentina); //Argentina
            q2.possibleAnswers[5] = new Answer("Daniela Melchior", Portugal); //Portugal
           
      
            Question q3 = new Question("Which is a tourist attraction you would like to go to?");
            q3.possibleAnswers[0] = new Answer("The Eiffel Tower", France); //France
            q3.possibleAnswers[1] = new Answer("The Statue of Liberty", America); //America
            q3.possibleAnswers[2] = new Answer("The Belem Tower", Portugal); //Portugal
            q3.possibleAnswers[3] = new Answer("The Christ the Redeemer", Brazil); //Brazil
            q3.possibleAnswers[4] = new Answer("The Buckingham Tower", England); //England
            q3.possibleAnswers[5] = new Answer("The Iguazu Falls", Argentina); //Argentina
      
            Question q4 = new Question("Who is your favorite musical artist?");
            q4.possibleAnswers[0] = new Answer("Gustavo Cerati", America); //Argentina
            q4.possibleAnswers[1] = new Answer("Jorge Palma", Portugal); //Portugal
            q4.possibleAnswers[2] = new Answer("Justin Bieber", America); //America
            q4.possibleAnswers[3] = new Answer("Adele", England); //England
            q4.possibleAnswers[4] = new Answer("Francoise Hardy", France); //France
            q4.possibleAnswers[5] = new Answer("Gilberto Gil", Brazil); //Brazil
      
            Question q5 = new Question( "What is you favorite animal");
            q5.possibleAnswers[0] = new Answer("Rooster of Barcelos", Argentina); //Argentina
            q5.possibleAnswers[1] = new Answer("Hornero Bird", America); //America
            q5.possibleAnswers[2] = new Answer("Bald Eagle", Brazil); //Brazil
            q5.possibleAnswers[3] = new Answer("Jaguar", Argentina); //Argentina
            q5.possibleAnswers[4] = new Answer("Lion", England); //England
            q5.possibleAnswers[5] = new Answer("Gallic Rooster", France); //France
      
            Question q6 = new Question("What is your favorite smell?");
      
            q6.possibleAnswers[0] = new Answer("White Jungle Flora and Sandalwood", Brazil); //Brazil
            q6.possibleAnswers[1] = new Answer("Pine Forests and Rotting Trash", America); //America
            q6.possibleAnswers[2] = new Answer("Wild Thyme and Spicy Herbs", France); //France
            q6.possibleAnswers[3] = new Answer("White Floral Accords", Argentina); //Argentina
            q6.possibleAnswers[4] = new Answer("Buses and Perfume", England); //England
            q6.possibleAnswers[5] = new Answer("Garlic and Parsley", Portugal); //Portugal
      
      
            Question q7 = new Question("What is your favorite Youtube Channel?");
      
            q7.possibleAnswers[0] = new Answer("Sidemen", England); //England
            q7.possibleAnswers[1] = new Answer("Mr. Beast", America); //America
            q7.possibleAnswers[2] = new Answer("Felpie Neto", Brazil); //Brazil
            q7.possibleAnswers[3] = new Answer("Paulo Londra", Argentina); //Argentina
            q7.possibleAnswers[4] = new Answer("Virginia Fonseca", Portugal); //Portugal
            q7.possibleAnswers[5] = new Answer("Kenin Tran", France); //France
      
            Question q8 = new Question("What is your favorite clothing brand?");
      
            q8.possibleAnswers[0] = new Answer("Louis Vuitton", France); //France
            q8.possibleAnswers[1] = new Answer("Nike", America); //America
            q8.possibleAnswers[2] = new Answer("Las Pepas", Argentina); //Argentina
            q8.possibleAnswers[3] = new Answer("ISTO", Portugal); //Portugal
            q8.possibleAnswers[4] = new Answer("Farm RIO", Brazil); //Brazil
            q8.possibleAnswers[5] = new Answer("Burberry", England); //England
      
      
            // For each question, ask, read input, store answer.
            Scanner sc = new Scanner(System.in);
            gameIntro(sc);
            Question[] qList = { q1, q2, q3, q4, q5, q6, q7, q8 };
            for (Question q : qList)
             {
                Category c = q.ask(sc);
                c.points++;
            }

            // Get most common category from the questions asked
            // Return Category
            Category[] cList = { France, America, Argentina, Portugal, Brazil, England };
            int[] counts = { France.points, America.points, Argentina.points, Portugal.points, Brazil.points, England.points };
            // these need to be in the same order or the points will be incorrect!
            int index = getMostPopularCatIndex(counts);
            System.out.println("You should root for " + cList[index].label + "! ");
            System.out.println(cList[index].description);
      
        }
      
        public static void gameIntro(Scanner sc) {
            // requires 1 to keep going
            System.out.println("Which World Cup team should you root for?");
            System.out.println("You get to choose numbers 1-6 for every question. Enter '1' to play!");
            int play = sc.nextInt();
            if (play != 1) {
                System.out.println("Unidentifiable input. Please enter '1' to play");
                gameIntro(sc);
            }
        }
      
        public static int getMostPopularCatIndex(int[] counts) {
            // returns the index that is the max
            int maxCount = 0;
            int maxIndex = 0;
            for (int i = 0; i < counts.length; i++) {
                if (counts[i] > maxCount) {
                    maxCount = counts[i];
                    maxIndex = i;
                }
            }
            return maxIndex;
        }
}
     
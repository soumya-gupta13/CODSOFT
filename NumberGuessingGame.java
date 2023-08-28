import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int minVal = 1;
        int maxVal = 100;
        int maxAttempts = 10;
        int rounds = 0;
        int score = 0;

        System.out.println("\n\'Welcome to the Number Guessing Game!\'");

        boolean playAgain = true;
        while (playAgain) {
            int targetNumber = rand.nextInt(maxVal - minVal + 1) + minVal;
            int attempts = 0;
            boolean roundWon = false;
            
            System.out.println("\nRound " + (rounds + 1));
            System.out.println("I've selected a number between " + minVal + " and " + maxVal + ". Try to guess it!");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = sc.nextInt();
                attempts++;

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You've guessed the number " + targetNumber + " in " + attempts + " attempts.");
                    roundWon = true;
                    score += maxAttempts - attempts + 1;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
            }

            if (!roundWon) {
                System.out.println("Sorry, you've used all your attempts. The number was: " + targetNumber);
            }

            rounds++;
            System.out.println("\nYour current score: " + score);
            
            System.out.print("\nDo you want to play again? Enter 'y' for yes or 'n' for no: ");
            String rep = sc.next().toLowerCase();
            playAgain = rep.equals("y");
        }

        System.out.println("\nThanks for playing! Your final score: " + score);
        sc.close();
    }
}

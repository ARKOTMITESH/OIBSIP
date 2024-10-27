import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Rules:");
        System.out.println("1. Guess the number between 1 and 100.");
        System.out.println("2. You have limited attempts per round.");
        System.out.println("3. You earn points based on the number of attempts.");
        System.out.println();

        System.out.print("Enter the number of rounds you want to play: ");
        int rounds = scanner.nextInt();
        int maxAttempts = 7;  
        int totalScore = 0;  

        for (int round = 1; round <= rounds; round++) {
            int numberToGuess = random.nextInt(100) + 1;  
            int attempts = 0;
            boolean guessed = false;

            System.out.println("Round " + round + ": Start guessing!");

            while (attempts < maxAttempts && !guessed) {
                System.out.print("Enter your guess (Attempt " + (attempts + 1) + " of " + maxAttempts + "): ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    guessed = true;
                    int score = 100 - (attempts - 1) * 10;  
                    totalScore += score;
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    System.out.println("You scored " + score + " points for this round.\n");
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessed) {
                System.out.println("You've used all attempts. The correct number was " + numberToGuess + ".");
                System.out.println("No points awarded for this round.\n");
            }
        }

        System.out.println("Game Over!");
        System.out.println("Your total score: " + totalScore + " points");
        scanner.close();
    }
}

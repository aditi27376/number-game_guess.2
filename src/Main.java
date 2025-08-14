import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        final int MAX_ATTEMPTS = 7;
        final int LOWER_BOUND = 1;
        final int UPPER_BOUND = 100;
        int roundsPlayed = 0;
        int roundsWon = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        boolean playAgain;

        do {
            int targetNumber = random.nextInt(UPPER_BOUND - LOWER_BOUND + 1) + LOWER_BOUND;
            int attemptsLeft = MAX_ATTEMPTS;
            boolean guessedCorrectly = false;

            System.out.println("\nRound " + (roundsPlayed + 1));
            System.out.println("I have selected a number between " + LOWER_BOUND + " and " + UPPER_BOUND + ".");
            System.out.println("You have " + MAX_ATTEMPTS + " attempts to guess it.");

            while (attemptsLeft > 0) {
                System.out.print("Enter your guess: ");
                int userGuess;

                // Validate input
                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next(); // discard invalid input
                    continue;
                }

                userGuess = scanner.nextInt();

                if (userGuess < LOWER_BOUND || userGuess > UPPER_BOUND) {
                    System.out.println("Your guess must be between " + LOWER_BOUND + " and " + UPPER_BOUND + ".");
                    continue;
                }

                attemptsLeft--;

                if (userGuess == targetNumber) {
                    System.out.println("🎉 Correct! You've guessed the number!");
                    guessedCorrectly = true;
                    roundsWon++;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }

                System.out.println("Attempts left: " + attemptsLeft);
            }

            if (!guessedCorrectly) {
                System.out.println("❌ You've used all attempts! The correct number was: " + targetNumber);
            }

            roundsPlayed++;

            System.out.print("Do you want to play another round? (yes/no): ");
            scanner.nextLine(); // consume newline
            String response = scanner.nextLine().trim().toLowerCase();
            playAgain = response.equals("yes");

        } while (playAgain);

        // Game summary
        System.out.println("\n🎮 Game Over!");
        System.out.println("Rounds Played: " + roundsPlayed);
        System.out.println("Rounds Won: " + roundsWon);
        System.out.println("Thanks for playing!");

        scanner.close();
    }
}

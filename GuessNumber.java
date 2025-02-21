import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    // Generate Random Number
    public static int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    // Display intructions
    public static void showInstructions() {
        System.out.println("Guess the number between 1 and 100.");
        System.out.println("You have 5 attempts.");
        System.out.println("Try to guess it!");
    }

    // Get user input
    public static int getUserInput(Scanner scanner) {
        System.out.print("Enter your guess: ");
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine();
            return -1;
        }
    }

    // Check if the guess is correct
    public static boolean checkGuess(int guess, int target, int attempts) {
        if (guess < 0) return false; // Invalid input

        if (guess == target) {
            System.out.printf("Congratulations! You got it in %d attempts!%n", attempts);
            return true;
        } else if (guess < target) {
            System.out.println("Too low! Try again.");
            return false;
        } else {
            System.out.println("Too high! Try again.");
            return false;
        }
    }

    // Ask if player wants to play again
    public static boolean playAgain(Scanner scanner) {
        System.out.print("Do you want to play again? (yes/no): ");
        String response = scanner.next().trim().toLowerCase();
        return response.equals("yes") || response.equals("y");
    }

    // Main
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        do {
            showInstructions();
            int targetNumber = generateRandomNumber(1, 10);
            int attempts = 0;

            while (attempts < 5) {
                int guess = getUserInput(scanner);
                attempts++;
                scanner.nextLine();

                if (checkGuess(guess, targetNumber, attempts)) {
                    break;
                } else if (attempts == 5) {
                    System.out.printf("Sorry, you ran out of attempts. The number was %d.%n", targetNumber);
                }
            }
        } while (playAgain(scanner));
        
        System.out.println("Thanks for playing!");
        scanner.close();

    }
}
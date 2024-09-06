// Guessing the number game

import java.util.Random;
// Random is the class which is in the above package.
// built-in package in Java which is use to give random number.
import java.util.Scanner;
// Scanner is the class .Which is use to take input from the user.

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        // Created the object of Random class.

        System.out.println("Welcome to the Number Guessing Game!");

        int score = 0;

        while (true) {
            int targetNumber = random.nextInt(100) + 1;
            // generating a random target number between 1 and 100.
            int attempts = 0;

            System.out.println("I have selected a number between 1 and 100. Can you guess it?");

            while (attempts < 5) // Total number of attempts are 5 (Starting from 0 to 4)
            {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();

                attempts++;

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the number " + targetNumber + " in " + attempts + " attempts.");
                    score++;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (attempts == 5) {
                System.out.println("Sorry, you've run out of attempts. The correct number was " + targetNumber + ".");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next();

            if (!playAgainInput.equalsIgnoreCase("yes")) {
                break;
            }
        }

        System.out.println("Game over! Your score: " + score);

        scanner.close();
    }
}

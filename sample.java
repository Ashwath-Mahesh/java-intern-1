import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        boolean playAgain = true;
        int totalScore = 0;
        int roundsPlayed = 0;
        
        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            final int maxAttempts = 10;
            boolean guessedCorrectly = false;
            
            System.out.println("I've generated a number between 1 and 100. Try to guess it!");
            
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;
                
                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    totalScore += (maxAttempts - attempts + 1);  // Higher score for fewer attempts
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }
            
            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all " + maxAttempts + " attempts. The number was " + numberToGuess);
            }
            
            roundsPlayed++;
            System.out.println("Your total score: " + totalScore);
            System.out.println("Rounds played: " + roundsPlayed);
            
            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }
        
        System.out.println("Thank you for playing! Your final score: " + totalScore + " in " + roundsPlayed + " rounds.");
        scanner.close();
    }
}

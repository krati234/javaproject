package array;
import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    
    // Instance variables
    private int secretNumber;
    private int attempts;
    private Scanner scanner;
    private Random random;
    
    // Constructor
    public NumberGuessingGame() {
        scanner = new Scanner(System.in);
        random = new Random();
        attempts = 0;
    }
    
    // Method to start the game
    public void startGame() {
        System.out.println("=== Welcome to Number Guessing Game ===");
        System.out.println("I'm thinking of a number between 1 and 100!");
        
        // Generate random number between 1 and 100
        secretNumber = random.nextInt(100) + 1;
        
        playGame();
    }
    
    // Method to handle game logic
    private void playGame() {
        boolean hasWon = false;
        
        while (!hasWon) {
            System.out.print("Enter your guess: ");
            int userGuess = getUserInput();
            attempts++;
            
            if (userGuess == secretNumber) {
                hasWon = true;
                displayWinMessage();
            } else if (userGuess < secretNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }
        }
        
        askToPlayAgain();
    }
    
    // Method to get user input safely
    private int getUserInput() {
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            scanner.next(); // Clear invalid input
        }
        return scanner.nextInt();
    }
    
    // Method to display win message
    private void displayWinMessage() {
        System.out.println("\n🎉 Congratulations! 🎉");
        System.out.println("You guessed the number " + secretNumber + " correctly!");
        System.out.println("It took you " + attempts + " attempts.");
        
        if (attempts <= 5) {
            System.out.println("Excellent! You're a guessing master!");
        } else if (attempts <= 10) {
            System.out.println("Good job! Nice guessing skills!");
        } else {
            System.out.println("You got it! Keep practicing!");
        }
    }
    
    // Method to ask if user wants to play again
    private void askToPlayAgain() {
        System.out.print("\nDo you want to play again? (yes/no): ");
        String playAgain = scanner.next().toLowerCase();
        
        if (playAgain.equals("yes") || playAgain.equals("y")) {
            resetGame();
            startGame();
        } else {
            System.out.println("Thanks for playing! Goodbye!");
            scanner.close();
        }
    }
    
    // Method to reset game variables
    private void resetGame() {
        attempts = 0;
        secretNumber = 0;
    }
    
    // Main method to run the program
    public static void main(String[] args) {
        NumberGuessingGame game = new NumberGuessingGame();
        game.startGame();
    }
}

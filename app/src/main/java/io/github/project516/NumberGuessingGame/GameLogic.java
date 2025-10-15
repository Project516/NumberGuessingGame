package io.github.project516.NumberGuessingGame;

/**
 * Contains the main game logic for the Number Guessing Game. This class manages the game loop, user
 * input, and guess validation.
 */
public class GameLogic {
    // TODO port game logic from Main to GameLogic
    /**
     * Runs the main game loop. Generates a random number and prompts the user to guess it. Provides
     * feedback on each guess and tracks the number of attempts.
     */
    void game() {

        RandomNumber ranNumber = new RandomNumber();
        int number = ranNumber.number(100);
        int numOfGuesses = 0;
        ScannerHelper scan = new ScannerHelper();
        CheckGuess check = new CheckGuess();

        while (true) {

            System.out.print("Guess a number: ");
            int guess = scan.userGuess();
            check.check(guess);
            if (guess > number) {
                System.out.println("You guessed to much!");
            } else if (guess < number) {
                System.out.println("You guessed to little!");
            } else {
                numOfGuesses++;
                System.out.println("Took you " + numOfGuesses + " guesses!");
                scan.close();
                break;
            }
            numOfGuesses++;
        }
    }
}

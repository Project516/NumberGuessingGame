package io.github.project516.NumberGuessingGame;

/**
 * Contains the main game logic for the Number Guessing Game. This class manages the game loop, user
 * input, and guess validation.
 */
public class GameLogic {
    /**
     * Runs the main game loop. Generates a random number and prompts the user to guess it. Provides
     * feedback on each guess and tracks the number of attempts.
     *
     * @param scan the ScannerHelper instance to use for user input
     */
    void game(ScannerHelper scan) {

        RandomNumber ranNumber = new RandomNumber();
        int number = ranNumber.number(100);
        int numOfGuesses = 0;
        CheckGuess check = new CheckGuess();

        while (true) {

            System.out.print("Guess a number: ");
            int guess = scan.userGuess();
            check.check(guess);
            if (guess > number) {
                System.out.println("You guessed too much!");
            } else if (guess < number) {
                System.out.println("You guessed too little!");
            } else {
                numOfGuesses++;
                System.out.println("Took you " + numOfGuesses + " guesses!");
                break;
            }
            numOfGuesses++;
        }
    }
}

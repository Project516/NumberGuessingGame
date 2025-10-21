package io.github.project516.NumberGuessingGame;

/**
 * Validates user guesses in the Number Guessing Game. This class ensures that user input falls
 * within the acceptable range.
 */
public class CheckGuess {
    /**
     * Validates that a guess is within the acceptable range (1-100).
     *
     * @param guess the user's guess to validate
     * @throws IllegalArgumentException if the guess is less than 1 or greater than 101
     */
    void check(int guess) {
        if (guess < 1 || guess > 101) {
            throw new IllegalArgumentException("Invalid number!");
        }
    }

    void quit(int input) {
        // 0 is quit
        // 1 is continue
        if (input != 0 && input != 1) {
            throw new IllegalArgumentException("Invalid number!");
        }
    }
}

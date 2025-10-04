package io.github.project516.NumberGuessingGame;

import org.teavm.jso.JSExport;

/**
 * Browser-compatible entry point for the Number Guessing Game. This version adapts the game for
 * browser environment where Scanner is not available.
 */
public class BrowserMain {

    private static int numOfGuesses = 0;
    private static int targetNumber;
    private static boolean gameStarted = false;

    public static void main(String[] args) {
        System.out.println("===== DEBUG INFO =====\n");
        System.out.println("Running in browser with TeaVM");
        System.out.println("Java to JavaScript compiler");
        System.out.println("\n");

        RandomNumber ranNumber = new RandomNumber();
        targetNumber = ranNumber.number();

        System.out.println("This is a Number Guessing Game!");
        System.out.println("I'm thinking of a number between 0 and 99.");
        System.out.println("Can you guess it?\n");

        gameStarted = true;
    }

    /**
     * Checks a user's guess and returns feedback. This method is called from JavaScript when the
     * user submits a guess. The @JSExport annotation makes this method available to JavaScript.
     */
    @JSExport
    public static void checkGuess(int guess) {
        if (!gameStarted) {
            System.out.println("Game not started yet!");
            return;
        }

        numOfGuesses++;

        if (guess > targetNumber) {
            System.out.println("You guessed too much!");
        } else if (guess < targetNumber) {
            System.out.println("You guessed too little!");
        } else {
            System.out.println("\n🎉 Correct! You found the number!");
            System.out.println("Took you " + numOfGuesses + " guesses!");
            System.out.println("\nRefresh the page to play again!");
            gameStarted = false;
        }
    }
}

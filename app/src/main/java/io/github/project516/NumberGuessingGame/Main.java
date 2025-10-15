package io.github.project516.NumberGuessingGame;

/**
 * Main entry point for the Number Guessing Game application. This class initializes the game
 * components and starts the game.
 */
public class Main {

    /**
     * The main method that starts the Number Guessing Game. Initializes all necessary components,
     * displays debug information, and runs the game logic with proper error handling.
     *
     * @param args command line arguments (not currently used)
     */
    public static void main(String[] args) {
        NumberGuessingGame game = new NumberGuessingGame();
        game.run();
    }
}

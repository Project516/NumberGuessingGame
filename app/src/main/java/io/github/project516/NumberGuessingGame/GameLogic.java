// SPDX-FileCopyrightText: 2025 Project516 <138796702+Project516@users.noreply.github.com>
//
// SPDX-License-Identifier: GPL-3.0-or-later

package io.github.project516.NumberGuessingGame;

import java.util.List;

/**
 * Contains the main game logic for the Number Guessing Game. This class manages the game loop, user
 * input, and guess validation.
 */
public class GameLogic {
    private HighScoreManager highScoreManager;

    /** Constructs a new GameLogic instance and initializes the high score manager. */
    public GameLogic() {
        try {
            highScoreManager = new HighScoreManager();
        } catch (Exception e) {
            System.err.println(
                    "Warning: Could not initialize high score system: " + e.getMessage());
            highScoreManager = null;
        }
    }

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

                // Handle high score
                if (highScoreManager != null) {
                    String username = Username.promptUsername(scan);
                    if (highScoreManager.addHighScore(username, numOfGuesses)) {
                        System.out.println("Score saved!");
                    }
                    displayHighScores();
                }
                break;
            }
            numOfGuesses++;
        }
    }

    /** Displays the top high scores to the console. */
    private void displayHighScores() {
        if (highScoreManager == null) {
            return;
        }

        List<HighScore> topScores = highScoreManager.getTopHighScores(5);
        if (topScores.isEmpty()) {
            return;
        }

        System.out.println("\n=== Top High Scores ===");
        for (int i = 0; i < topScores.size(); i++) {
            System.out.println((i + 1) + ". " + topScores.get(i));
        }
        System.out.println("=======================\n");
    }
}

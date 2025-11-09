// SPDX-FileCopyrightText: 2025 Project516 <138796702+Project516@users.noreply.github.com>
//
// SPDX-License-Identifier: GPL-3.0-or-later

package io.github.project516.NumberGuessingGame;

/**
 * Console-based Number Guessing Game implementation. This class manages the console version of the
 * game, handling the game loop, user interaction, and error recovery. It prompts the user to guess
 * numbers and allows replaying the game.
 */
public class NumberGuessingGame {
    /**
     * Runs the console version of the Number Guessing Game. Initializes all game components,
     * displays debug information, and manages the game loop. The user can play multiple rounds
     * until they choose to quit.
     */
    void run() {
        ScannerHelper scan = new ScannerHelper();
        DebugInfo debugInfo = new DebugInfo();
        GameInfo gameInfo = new GameInfo();
        GameLogic logic = new GameLogic();
        CheckGuess check = new CheckGuess();

        try {
            debugInfo.launchDebug();
            gameInfo.about();
            int play = 1;
            while (play != 0) {

                try {

                    logic.game(scan);

                } catch (Exception e) {

                    System.err.println("\n===Program Crashed!===");
                    System.err.println("Error: " + e.getMessage());
                    scan.next();
                    e.printStackTrace();

                } finally {
                    System.out.print("\nPlay again? (1 -> Y / 0 -> N) ");
                    try {
                        play = scan.userGuess();
                        check.quit(play);
                    } catch (Exception e) {
                        System.err.println("\n===Program Crashed!===");
                        System.err.println("Error: " + e.getMessage());
                        scan.next();
                        e.printStackTrace();
                        break;
                    }
                }
            }
            System.out.println("\nThanks for playing!");
        } finally {
            scan.close();
        }
    }
}

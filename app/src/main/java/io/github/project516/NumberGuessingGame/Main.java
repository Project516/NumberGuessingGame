// SPDX-FileCopyrightText: 2025 Project516 <138796702+Project516@users.noreply.github.com>
//
// SPDX-License-Identifier: GPL-3.0-or-later

package io.github.project516.NumberGuessingGame;

import javax.swing.SwingUtilities;

/**
 * Main entry point for the Number Guessing Game application. This class initializes the game
 * components and starts the game. By default, launches the GUI version. Use the --console flag to
 * run the console version.
 */
public class Main {

    /**
     * The main method that starts the Number Guessing Game. By default, launches the GUI version.
     * To run the console version, pass the --console flag as a command line argument.
     *
     * @param args command line arguments. Use --console to run the console version of the game.
     */
    public static void main(String[] args) {
        // Check if console mode is requested
        boolean consoleMode = false;
        if (args.length > 0) {
            for (String arg : args) {
                if ("--console".equals(arg) || "-c".equals(arg)) {
                    consoleMode = true;
                    break;
                }
            }
        }

        if (consoleMode) {
            // Run console version
            NumberGuessingGame game = new NumberGuessingGame();
            game.run();
        } else {
            // Run GUI version (default)
            SwingUtilities.invokeLater(() -> new GUI());
        }
    }
}

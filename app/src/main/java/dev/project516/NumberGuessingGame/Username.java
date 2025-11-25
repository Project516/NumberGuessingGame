// SPDX-FileCopyrightText: 2025 Project516 <138796702+Project516@users.noreply.github.com>
//
// SPDX-License-Identifier: GPL-3.0-or-later

package dev.project516.NumberGuessingGame;

/**
 * Utility class for prompting and validating usernames in the Number Guessing Game. Used for the
 * high score system.
 */
public class Username {
    private static final int MAX_USERNAME_LENGTH = 20;
    private static final int MIN_USERNAME_LENGTH = 1;

    /**
     * Prompts the user for a username using the console.
     *
     * @param scan the ScannerHelper instance to use for user input
     * @return the validated username
     */
    public static String promptUsername(ScannerHelper scan) {
        // Clear any remaining newline from previous nextInt() call
        scan.scan.nextLine();

        while (true) {
            System.out.print("Enter your username: ");
            String username = scan.scan.nextLine().trim();

            if (isValid(username)) {
                return username;
            }

            System.out.println(
                    "Invalid username. Must be between "
                            + MIN_USERNAME_LENGTH
                            + " and "
                            + MAX_USERNAME_LENGTH
                            + " characters.");
        }
    }

    /**
     * Validates a username.
     *
     * @param username the username to validate
     * @return true if the username is valid, false otherwise
     */
    public static boolean isValid(String username) {
        if (username == null || username.trim().isEmpty()) {
            return false;
        }
        int length = username.trim().length();
        return length >= MIN_USERNAME_LENGTH && length <= MAX_USERNAME_LENGTH;
    }
}

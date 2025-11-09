// SPDX-FileCopyrightText: 2025 Project516 <138796702+Project516@users.noreply.github.com>
//
// SPDX-License-Identifier: GPL-3.0-or-later

package io.github.project516.NumberGuessingGame;

import java.util.Scanner;

/**
 * Helper class for managing user input via Scanner. This class provides methods to read user
 * guesses, usernames, and properly close the Scanner resource.
 */
public class ScannerHelper {

    /** Scanner instance for reading user input from System.in. */
    public Scanner scan = new Scanner(System.in);

    /**
     * Reads the user's guess as an integer from standard input.
     *
     * @return the user's guess as an integer
     */
    int userGuess() {
        return scan.nextInt();
    }

    /**
     * Reads the user's name as a string from standard input.
     *
     * @return the user's name as a string
     */
    String userName() {
        return scan.nextLine();
    }

    /**
     * Consumes the next token from the input stream. Used primarily for clearing invalid input
     * after an exception occurs.
     */
    void next() {
        scan.next();
    }

    /**
     * Closes the Scanner to release system resources. Should be called when the Scanner is no
     * longer needed.
     */
    void close() {
        scan.close();
    }
}

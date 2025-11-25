// SPDX-FileCopyrightText: 2025 Project516 <138796702+Project516@users.noreply.github.com>
//
// SPDX-License-Identifier: GPL-3.0-or-later

package dev.project516.NumberGuessingGame;

import java.util.*;

/**
 * Generates random numbers for the Number Guessing Game. This class uses Java's Random class to
 * generate random integers within a specified range.
 */
public class RandomNumber {

    /** Random number generator instance. */
    Random random = new Random();

    /**
     * Generates a random integer between 0 (inclusive) and the specified maximum value (inclusive).
     *
     * @param max the maximum value for the random number (inclusive)
     * @return a random integer in the range [0, max]
     */
    int number(int max) {

        return random.nextInt(max + 1);
    }
}

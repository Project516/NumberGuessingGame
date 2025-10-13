package io.github.project516.NumberGuessingGame;

import java.util.*;

/**
 * Generates random numbers for the Number Guessing Game. This class uses Java's Random class to
 * generate random integers within a specified range.
 */
public class RandomNumber {

    /** Random number generator instance. */
    Random random = new Random();

    /**
     * Generates a random integer between 0 and the specified maximum value (inclusive).
     *
     * @param max the maximum value for the random number
     * @return a random integer between 0 and max (inclusive)
     */
    int number(int max) {

        return random.nextInt(max + 1);
    }
}

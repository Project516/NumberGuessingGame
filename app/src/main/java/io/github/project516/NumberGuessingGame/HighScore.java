package io.github.project516.NumberGuessingGame;

/**
 * Represents a single high score entry in the Number Guessing Game. Each entry contains a username
 * and the number of guesses it took to win the game.
 */
public class HighScore implements Comparable<HighScore> {
    private final String username;
    private final int numberOfGuesses;

    /**
     * Constructs a new HighScore entry.
     *
     * @param username the username of the player
     * @param numberOfGuesses the number of guesses it took to win
     * @throws IllegalArgumentException if username is null or empty, or if numberOfGuesses is less
     *     than 1
     */
    public HighScore(String username, int numberOfGuesses) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
        if (numberOfGuesses < 1) {
            throw new IllegalArgumentException("Number of guesses must be at least 1");
        }
        this.username = username.trim();
        this.numberOfGuesses = numberOfGuesses;
    }

    /**
     * Gets the username for this high score entry.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets the number of guesses for this high score entry.
     *
     * @return the number of guesses
     */
    public int getNumberOfGuesses() {
        return numberOfGuesses;
    }

    /**
     * Compares this high score to another. High scores are ordered by number of guesses (ascending)
     * so that lower scores (fewer guesses) come first.
     *
     * @param other the other high score to compare to
     * @return a negative integer, zero, or a positive integer as this high score is less than,
     *     equal to, or greater than the specified high score
     */
    @Override
    public int compareTo(HighScore other) {
        return Integer.compare(this.numberOfGuesses, other.numberOfGuesses);
    }

    /**
     * Returns a string representation of this high score in the format "username: X guess(es)".
     *
     * @return a formatted string containing the username and number of guesses
     */
    @Override
    public String toString() {
        return username + ": " + numberOfGuesses + " guess" + (numberOfGuesses == 1 ? "" : "es");
    }
}

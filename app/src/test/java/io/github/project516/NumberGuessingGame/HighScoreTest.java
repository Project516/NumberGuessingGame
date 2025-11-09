// SPDX-FileCopyrightText: 2025 Project516 <138796702+Project516@users.noreply.github.com>
//
// SPDX-License-Identifier: GPL-3.0-or-later

package io.github.project516.NumberGuessingGame;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/** Unit tests for the HighScore class. */
class HighScoreTest {
    @Test
    void testHighScoreCreation() {
        HighScore score = new HighScore("Alice", 5);
        assertEquals("Alice", score.getUsername());
        assertEquals(5, score.getNumberOfGuesses());
    }

    @Test
    void testHighScoreWithWhitespace() {
        HighScore score = new HighScore("  Bob  ", 3);
        assertEquals("Bob", score.getUsername());
        assertEquals(3, score.getNumberOfGuesses());
    }

    @Test
    void testHighScoreNullUsername() {
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new HighScore(null, 5);
                });
    }

    @Test
    void testHighScoreEmptyUsername() {
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new HighScore("", 5);
                });
    }

    @Test
    void testHighScoreWhitespaceOnlyUsername() {
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new HighScore("   ", 5);
                });
    }

    @Test
    void testHighScoreInvalidGuessCount() {
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new HighScore("Alice", 0);
                });
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new HighScore("Alice", -1);
                });
    }

    @Test
    void testHighScoreComparison() {
        HighScore score1 = new HighScore("Alice", 5);
        HighScore score2 = new HighScore("Bob", 3);
        HighScore score3 = new HighScore("Charlie", 7);

        assertTrue(score2.compareTo(score1) < 0); // Bob's 3 < Alice's 5
        assertTrue(score1.compareTo(score3) < 0); // Alice's 5 < Charlie's 7
        assertTrue(score3.compareTo(score2) > 0); // Charlie's 7 > Bob's 3
    }

    @Test
    void testHighScoreToString() {
        HighScore score1 = new HighScore("Alice", 1);
        HighScore score2 = new HighScore("Bob", 5);

        assertEquals("Alice: 1 guess", score1.toString());
        assertEquals("Bob: 5 guesses", score2.toString());
    }
}

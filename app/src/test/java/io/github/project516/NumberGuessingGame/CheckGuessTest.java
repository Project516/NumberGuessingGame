// SPDX-FileCopyrightText: 2025 Project516 <138796702+Project516@users.noreply.github.com>
//
// SPDX-License-Identifier: GPL-3.0-or-later

package io.github.project516.NumberGuessingGame;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CheckGuessTest {
    @Test
    void quitAcceptsZero() {
        CheckGuess check = new CheckGuess();
        assertDoesNotThrow(() -> check.quit(0), "quit should accept 0");
    }

    @Test
    void quitAcceptsOne() {
        CheckGuess check = new CheckGuess();
        assertDoesNotThrow(() -> check.quit(1), "quit should accept 1");
    }

    @Test
    void quitRejectsOtherNumbers() {
        CheckGuess check = new CheckGuess();
        assertThrows(
                IllegalArgumentException.class,
                () -> check.quit(2),
                "quit should reject numbers other than 0 or 1");
        assertThrows(
                IllegalArgumentException.class,
                () -> check.quit(-1),
                "quit should reject numbers other than 0 or 1");
    }

    @Test
    void checkAcceptsValidGuess() {
        CheckGuess check = new CheckGuess();
        assertDoesNotThrow(() -> check.check(50), "check should accept valid guess");
        assertDoesNotThrow(() -> check.check(1), "check should accept 1");
        assertDoesNotThrow(() -> check.check(100), "check should accept 100");
    }

    @Test
    void checkRejectsInvalidGuess() {
        CheckGuess check = new CheckGuess();
        assertThrows(IllegalArgumentException.class, () -> check.check(0), "check should reject 0");
        assertThrows(
                IllegalArgumentException.class,
                () -> check.check(102),
                "check should reject numbers > 101");
    }
}

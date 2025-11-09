// SPDX-FileCopyrightText: 2024 Project516 <138796702+Project516@users.noreply.github.com>
//
// SPDX-License-Identifier: GPL-3.0-or-later

package io.github.project516.NumberGuessingGame;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/** Unit tests for the Username class. */
class UsernameTest {
    @Test
    void testValidUsername() {
        assertTrue(Username.isValid("Alice"));
        assertTrue(Username.isValid("Bob123"));
        assertTrue(Username.isValid("a")); // 1 character
        assertTrue(Username.isValid("12345678901234567890")); // 20 characters
    }

    @Test
    void testInvalidUsername() {
        assertFalse(Username.isValid(null));
        assertFalse(Username.isValid(""));
        assertFalse(Username.isValid("   "));
        assertFalse(Username.isValid("123456789012345678901")); // 21 characters - too long
    }

    @Test
    void testUsernameWithWhitespace() {
        assertTrue(Username.isValid("  Alice  ")); // Whitespace trimmed, valid
    }
}

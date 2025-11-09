// SPDX-FileCopyrightText: 2024 Project516 <138796702+Project516@users.noreply.github.com>
//
// SPDX-License-Identifier: GPL-3.0-or-later

package io.github.project516.NumberGuessingGame;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ReadVersionFileTest {
    @Test
    void readVersionReturnsNonEmptyString() {
        ReadVersionFile versionFile = new ReadVersionFile();
        String version = versionFile.readVersion();
        assertNotNull(version, "Version should not be null");
        assertFalse(version.isEmpty(), "Version should not be empty");
    }
    /*
    @Test
    void readVersionReturnsRolling() {
        ReadVersionFile versionFile = new ReadVersionFile();
        String version = versionFile.readVersion();
        assertEquals("rolling", version, "Version should be 'rolling'");
    }
    */
}

// SPDX-FileCopyrightText: 2024 Project516 <138796702+Project516@users.noreply.github.com>
//
// SPDX-License-Identifier: GPL-3.0-or-later

package io.github.project516.NumberGuessingGame;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SystemInfoTest {
    @Test
    void jdkIsHere() {
        SystemInfo classUnderTest = new SystemInfo();
        assertNotNull(classUnderTest.vendor(), "expect output!");
    }
}

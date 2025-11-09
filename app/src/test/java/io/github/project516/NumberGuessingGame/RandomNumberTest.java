// SPDX-FileCopyrightText: 2025 Project516 <138796702+Project516@users.noreply.github.com>
//
// SPDX-License-Identifier: GPL-3.0-or-later

package io.github.project516.NumberGuessingGame;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RandomNumberTest {
    @Test
    void ranNum() {
        RandomNumber classUnderTest = new RandomNumber();
        assertNotNull(classUnderTest.number(100), "expect output!");
    }
}

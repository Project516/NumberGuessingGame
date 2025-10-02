package io.github.project516.NumberGuessingGame;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RandomNumberTest {
    @Test
    void ranNum() {
        RandomNumber classUnderTest = new RandomNumber();
        assertNotNull(classUnderTest.number(), "expect output!");
    }
}

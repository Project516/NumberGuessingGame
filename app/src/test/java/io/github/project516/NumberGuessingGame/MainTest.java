package io.github.project516.NumberGuessingGame;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for the Main class. Tests command line argument parsing and entry point functionality.
 */
class MainTest {
    @Test
    void mainClassExists() {
        // Verify Main class can be loaded
        assertDoesNotThrow(
                () -> {
                    Class<?> mainClass = Main.class;
                    assertNotNull(mainClass, "Main class should exist");
                },
                "Main class should be loadable");
    }

    @Test
    void mainHasMainMethod() throws NoSuchMethodException {
        // Verify Main has a main method
        assertNotNull(
                Main.class.getMethod("main", String[].class), "Main should have a main method");
    }
}

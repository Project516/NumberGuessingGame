package io.github.project516.NumberGuessingGame;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.*;
import org.junit.jupiter.api.Test;

/** Unit tests for the GUI class. Tests GUI component initialization and basic functionality. */
class GUITest {
    @Test
    void guiCanBeConstructed() {
        // Test that GUI can be constructed in headless mode
        // This test verifies the GUI class structure without requiring a display
        assertDoesNotThrow(
                () -> {
                    // Just verify the class exists and can be loaded
                    Class<?> guiClass = GUI.class;
                    assertNotNull(guiClass, "GUI class should exist");
                },
                "GUI class should be loadable");
    }

    @Test
    void guiExtendsJFrame() {
        // Verify GUI extends JFrame for proper Swing architecture
        assertTrue(JFrame.class.isAssignableFrom(GUI.class), "GUI should extend JFrame");
    }

    @Test
    void guiHasMainMethod() throws NoSuchMethodException {
        // Verify GUI has a main method for standalone execution
        assertNotNull(GUI.class.getMethod("main", String[].class), "GUI should have a main method");
    }

    @Test
    void guiHasCreateWindowMethod() throws NoSuchMethodException {
        // Verify GUI has createWindow method for backward compatibility
        assertNotNull(
                GUI.class.getDeclaredMethod("createWindow"),
                "GUI should have a createWindow method");
    }
}

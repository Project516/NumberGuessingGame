package io.github.project516.NumberGuessingGame;

import java.awt.*;
import javax.swing.*;

// TODO

/**
 * Graphical User Interface for the Number Guessing Game. This class creates and manages the game's
 * window and UI components. Currently under development.
 */
public class GUI {
    /**
     * Creates and displays the main game window. Sets up a JFrame with a centered label showing the
     * game title.
     */
    void createWindow() {
        JFrame jframe = new JFrame("Number Guessing Game");
        JLabel jlabel = new JLabel("Number Guessing Game", SwingConstants.CENTER);
        // JButton jbutton = new JButton("Start game!");

        jframe.getContentPane().add(jlabel, BorderLayout.CENTER);

        jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Exit on close
        jframe.setSize(300, 300);

        jframe.setVisible(true); // Set visible
    }

    /**
     * Test method for the GUI. Creates a GUI instance and displays the window for testing purposes.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) { // Test GUI
        GUI GUI = new GUI();
        GUI.createWindow();
    }
}

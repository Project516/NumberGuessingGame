package io.github.project516.NumberGuessingGame;

import java.awt.*;
import javax.swing.*;

// TODO make gui window

public class GUI {
    void createWindow() {
        JFrame jframe = new JFrame("Number Guessing Game");
        JLabel jLabel = new JLabel("Number Guessing Game", SwingConstants.CENTER);

        jframe.getContentPane().add(jLabel, BorderLayout.CENTER);

        jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Exit on close
        jframe.setSize(300, 300);

        jframe.setVisible(true); // Set visible
    }

    public static void main(String[] args) { // Test GUI
        GUI GUI = new GUI();
        GUI.createWindow();
    }
}

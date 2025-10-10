package io.github.project516.NumberGuessingGame;

import javax.swing.*;

// TODO make gui window

public class GUI {
    void createWindow() {
        JFrame jframe = new JFrame();
        jframe.setVisible(true); // Set visible
        jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Exit on close
    }

    public static void main(String[] args) { // Test GUI
        GUI GUI = new GUI();
        GUI.createWindow();
    }
}

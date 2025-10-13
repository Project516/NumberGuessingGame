package io.github.project516.NumberGuessingGame;

import java.awt.*;
import javax.swing.*;

// TODO

public class GUI {
    void createWindow() {
        JFrame jframe = new JFrame("Number Guessing Game");
        JLabel jlabel = new JLabel("Number Guessing Game", SwingConstants.CENTER);
        // JButton jbutton = new JButton("Start game!");

        jframe.getContentPane().add(jlabel, BorderLayout.CENTER);

        jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Exit on close
        jframe.setSize(300, 300);

        jframe.setVisible(true); // Set visible
    }

    public static void main(String[] args) { // Test GUI
        GUI GUI = new GUI();
        GUI.createWindow();
    }
}

// SPDX-FileCopyrightText: 2024 Project516 <138796702+Project516@users.noreply.github.com>
//
// SPDX-License-Identifier: GPL-3.0-or-later

package io.github.project516.NumberGuessingGame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Graphical User Interface for the Number Guessing Game. This class creates and manages the game's
 * window and UI components using Java Swing. Provides a user-friendly interface for playing the
 * number guessing game with visual feedback and menu options.
 */
public class GUI extends JFrame {
    // Game state
    private int targetNumber;
    private int numberOfGuesses;
    private RandomNumber randomGenerator;
    private CheckGuess guessChecker;
    private GameInfo gameInfo;
    private HighScoreManager highScoreManager;

    // UI Components
    private JTextField guessField;
    private JButton submitButton;
    private JButton newGameButton;
    private JLabel feedbackLabel;
    private JLabel promptLabel;
    private JLabel guessCountLabel;
    private JPanel mainPanel;

    /**
     * Constructs the GUI and initializes all components. Sets up the game window with proper layout
     * and starts a new game.
     */
    public GUI() {
        super("Number Guessing Game");

        // Initialize game objects
        randomGenerator = new RandomNumber();
        guessChecker = new CheckGuess();
        gameInfo = new GameInfo();

        // Initialize high score manager
        try {
            highScoreManager = new HighScoreManager();
        } catch (Exception e) {
            System.err.println(
                    "Warning: Could not initialize high score system: " + e.getMessage());
            highScoreManager = null;
        }

        // Set up the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null); // Center on screen
        setResizable(false);

        // Create menu bar
        createMenuBar();

        // Create main panel
        createMainPanel();

        // Start new game
        startNewGame();

        setVisible(true);
    }

    /** Creates and configures the menu bar with File and Help menus. */
    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        // File menu
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);

        JMenuItem newGameItem = new JMenuItem("New Game", KeyEvent.VK_N);
        newGameItem.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
        newGameItem.addActionListener(e -> startNewGame());
        fileMenu.add(newGameItem);

        fileMenu.addSeparator();

        JMenuItem exitItem = new JMenuItem("Exit", KeyEvent.VK_X);
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);

        // View menu
        JMenu viewMenu = new JMenu("View");
        viewMenu.setMnemonic(KeyEvent.VK_V);

        JMenuItem highScoresItem = new JMenuItem("High Scores", KeyEvent.VK_H);
        highScoresItem.addActionListener(e -> showHighScores());
        viewMenu.add(highScoresItem);

        // Help menu
        JMenu helpMenu = new JMenu("Help");
        helpMenu.setMnemonic(KeyEvent.VK_H);

        JMenuItem aboutItem = new JMenuItem("About", KeyEvent.VK_A);
        aboutItem.addActionListener(e -> showAboutDialog());
        helpMenu.add(aboutItem);

        menuBar.add(fileMenu);
        menuBar.add(viewMenu);
        menuBar.add(helpMenu);

        setJMenuBar(menuBar);
    }

    /** Creates and configures the main game panel with all UI components. */
    private void createMainPanel() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Title label
        JLabel titleLabel = new JLabel("Number Guessing Game");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(titleLabel);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Instructions label
        JLabel instructionsLabel = new JLabel("Guess a number between 1 and 100!");
        instructionsLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        instructionsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(instructionsLabel);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 30)));

        // Guess count label
        guessCountLabel = new JLabel("Number of guesses: 0");
        guessCountLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        guessCountLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(guessCountLabel);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Prompt label
        promptLabel = new JLabel("Enter your guess:");
        promptLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        promptLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(promptLabel);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        // Input panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        guessField = new JTextField(10);
        guessField.setFont(new Font("Arial", Font.PLAIN, 16));
        guessField.addActionListener(e -> submitGuess());
        inputPanel.add(guessField);

        submitButton = new JButton("Submit Guess");
        submitButton.setFont(new Font("Arial", Font.PLAIN, 14));
        submitButton.addActionListener(e -> submitGuess());
        inputPanel.add(submitButton);

        mainPanel.add(inputPanel);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Feedback label
        feedbackLabel = new JLabel(" ");
        feedbackLabel.setFont(new Font("Arial", Font.BOLD, 16));
        feedbackLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(feedbackLabel);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 30)));

        // New game button
        newGameButton = new JButton("New Game");
        newGameButton.setFont(new Font("Arial", Font.PLAIN, 14));
        newGameButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        newGameButton.addActionListener(e -> startNewGame());
        newGameButton.setVisible(false);
        mainPanel.add(newGameButton);

        add(mainPanel);
    }

    /** Starts a new game by resetting the game state and UI components. */
    private void startNewGame() {
        targetNumber = randomGenerator.number(100);
        numberOfGuesses = 0;

        guessField.setEnabled(true);
        submitButton.setEnabled(true);
        newGameButton.setVisible(false);

        guessField.setText("");
        feedbackLabel.setText(" ");
        feedbackLabel.setForeground(Color.BLACK);
        updateGuessCount();

        guessField.requestFocus();
    }

    /** Processes the user's guess and updates the UI with feedback. */
    private void submitGuess() {
        String input = guessField.getText().trim();

        if (input.isEmpty()) {
            showFeedback("Please enter a number!", Color.RED);
            return;
        }

        int guess;
        try {
            guess = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            showFeedback("Invalid input! Please enter a valid number.", Color.RED);
            guessField.setText("");
            return;
        }

        try {
            guessChecker.check(guess);
        } catch (IllegalArgumentException e) {
            showFeedback(e.getMessage(), Color.RED);
            guessField.setText("");
            return;
        }

        numberOfGuesses++;
        updateGuessCount();

        if (guess > targetNumber) {
            showFeedback("Too high! Try a lower number.", new Color(255, 140, 0)); // Orange
        } else if (guess < targetNumber) {
            showFeedback("Too low! Try a higher number.", new Color(30, 144, 255)); // Blue
        } else {
            // Correct guess
            showFeedback("Congratulations! You guessed it!", new Color(0, 128, 0)); // Green
            guessField.setEnabled(false);
            submitButton.setEnabled(false);
            newGameButton.setVisible(true);
            newGameButton.requestFocus();

            // Handle high score
            handleHighScore();
        }

        guessField.setText("");
        guessField.requestFocus();
    }

    /**
     * Updates the feedback label with the provided message and color.
     *
     * @param message the feedback message to display
     * @param color the color to use for the message
     */
    private void showFeedback(String message, Color color) {
        feedbackLabel.setText(message);
        feedbackLabel.setForeground(color);
    }

    /** Updates the guess count label to reflect the current number of guesses. */
    private void updateGuessCount() {
        guessCountLabel.setText("Number of guesses: " + numberOfGuesses);
    }

    /** Displays the About dialog with game information. */
    private void showAboutDialog() {
        String message =
                String.format(
                        "Number Guessing Game\n\n"
                                + "Version: %s\n"
                                + "Author: %s\n\n"
                                + "Project URL:\n%s\n\n"
                                + "Online Documentation:\n%s",
                        getVersion(),
                        gameInfo.author(),
                        gameInfo.projectURL(),
                        gameInfo.onlineJavadoc());

        JOptionPane.showMessageDialog(
                this, message, "About Number Guessing Game", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Handles high score submission after a successful game. Prompts the user for their username
     * and saves the score if applicable.
     */
    private void handleHighScore() {
        if (highScoreManager == null) {
            // Show basic congratulations dialog if high score system is unavailable
            String message =
                    String.format(
                            "You guessed the number in %d %s!",
                            numberOfGuesses, numberOfGuesses == 1 ? "guess" : "guesses");
            JOptionPane.showMessageDialog(
                    this, message, "Congratulations!", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Prompt for username
        String username =
                JOptionPane.showInputDialog(
                        this,
                        String.format(
                                "You guessed the number in %d %s!\n\nEnter your username (1-20 characters):",
                                numberOfGuesses, numberOfGuesses == 1 ? "guess" : "guesses"),
                        "Congratulations!",
                        JOptionPane.QUESTION_MESSAGE);

        // Validate username
        if (username != null && Username.isValid(username)) {
            highScoreManager.addHighScore(username, numberOfGuesses);
            showHighScores();
        } else if (username != null) {
            JOptionPane.showMessageDialog(
                    this, "Invalid username. Score not saved.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /** Displays the top high scores in a dialog. */
    private void showHighScores() {
        if (highScoreManager == null) {
            return;
        }

        java.util.List<HighScore> topScores = highScoreManager.getTopHighScores(10);
        if (topScores.isEmpty()) {
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Top High Scores\n\n");
        for (int i = 0; i < topScores.size(); i++) {
            sb.append(String.format("%d. %s\n", i + 1, topScores.get(i)));
        }

        JOptionPane.showMessageDialog(
                this, sb.toString(), "High Scores", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Gets the version of the application.
     *
     * @return the version string
     */
    private String getVersion() {
        ReadVersionFile versionReader = new ReadVersionFile();
        try {
            return versionReader.readVersion();
        } catch (Exception e) {
            return "Unknown";
        }
    }

    /**
     * Creates and displays the GUI window. This method should be called on the Event Dispatch
     * Thread for thread safety.
     */
    public void createWindow() {
        // This method is kept for backwards compatibility
        // The constructor already makes the window visible
    }

    /**
     * Main method for testing the GUI. Creates and displays the game window on the Event Dispatch
     * Thread.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        // Use SwingUtilities to ensure thread safety
        SwingUtilities.invokeLater(() -> new GUI());
    }
}

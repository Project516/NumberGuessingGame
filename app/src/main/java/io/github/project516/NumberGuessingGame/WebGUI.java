package io.github.project516.NumberGuessingGame;

import org.teavm.jso.browser.Window;
import org.teavm.jso.dom.html.*;

/**
 * Web-based GUI for the Number Guessing Game using TeaVM. This class provides a browser-native
 * interface that reuses the core game logic from the existing classes. Created specifically for
 * TeaVM compilation to JavaScript for GitHub Pages deployment.
 */
public class WebGUI {
    // Game state - reusing existing game logic classes
    private int targetNumber;
    private int numberOfGuesses;
    private RandomNumber randomGenerator;
    private CheckGuess guessChecker;

    // DOM elements
    private HTMLDocument document;
    private HTMLInputElement guessInput;
    private HTMLButtonElement submitButton;
    private HTMLButtonElement newGameButton;
    private HTMLElement feedbackElement;
    private HTMLElement guessCountElement;

    /**
     * Main entry point for the web application. TeaVM will call this method when the page loads.
     *
     * @param args command line arguments (not used in web context)
     */
    public static void main(String[] args) {
        new WebGUI().initialize();
    }

    /** Initializes the web GUI and starts a new game. */
    public void initialize() {
        // Initialize game objects - reusing existing classes
        randomGenerator = new RandomNumber();
        guessChecker = new CheckGuess();

        // Get the HTML document
        document = Window.current().getDocument();

        // Create the game UI
        createGameUI();

        // Start a new game
        startNewGame();
    }

    /** Creates the game UI elements in the HTML document. */
    private void createGameUI() {
        // Get or create the game container
        HTMLElement gameContainer = (HTMLElement) document.getElementById("game-container");
        if (gameContainer == null) {
            gameContainer = (HTMLElement) document.createElement("div");
            gameContainer.setId("game-container");
            document.getBody().appendChild(gameContainer);
        }

        // Clear existing content
        gameContainer.setInnerHTML("");

        // Create title
        HTMLElement title = (HTMLElement) document.createElement("h1");
        title.setInnerHTML("Number Guessing Game");
        gameContainer.appendChild(title);

        // Create instructions
        HTMLElement instructions = (HTMLElement) document.createElement("p");
        instructions.setInnerHTML("Guess a number between 1 and 100!");
        gameContainer.appendChild(instructions);

        // Create guess count display
        guessCountElement = (HTMLElement) document.createElement("p");
        guessCountElement.setId("guess-count");
        guessCountElement.setInnerHTML("Number of guesses: 0");
        gameContainer.appendChild(guessCountElement);

        // Create input field
        guessInput = (HTMLInputElement) document.createElement("input");
        guessInput.setType("number");
        guessInput.setAttribute("min", "1");
        guessInput.setAttribute("max", "100");
        guessInput.setAttribute("placeholder", "Enter your guess");
        guessInput.setId("guess-input");
        gameContainer.appendChild(guessInput);

        // Create submit button
        submitButton = (HTMLButtonElement) document.createElement("button");
        submitButton.setInnerHTML("Submit Guess");
        submitButton.setId("submit-button");
        submitButton.addEventListener("click", evt -> submitGuess());
        gameContainer.appendChild(submitButton);

        // Allow Enter key to submit
        guessInput.addEventListener(
                "keypress",
                evt -> {
                    if ("Enter".equals(((HTMLKeyboardEvent) evt).getKey())) {
                        submitGuess();
                    }
                });

        // Create feedback area
        feedbackElement = (HTMLElement) document.createElement("p");
        feedbackElement.setId("feedback");
        feedbackElement.setInnerHTML(" ");
        gameContainer.appendChild(feedbackElement);

        // Create new game button (initially hidden)
        newGameButton = (HTMLButtonElement) document.createElement("button");
        newGameButton.setInnerHTML("New Game");
        newGameButton.setId("new-game-button");
        newGameButton.getStyle().setProperty("display", "none");
        newGameButton.addEventListener("click", evt -> startNewGame());
        gameContainer.appendChild(newGameButton);
    }

    /** Starts a new game by resetting the game state. */
    private void startNewGame() {
        // Generate new target number using existing RandomNumber class
        targetNumber = randomGenerator.number(100);
        numberOfGuesses = 0;

        // Reset UI
        guessInput.setValue("");
        guessInput.setDisabled(false);
        submitButton.setDisabled(false);
        newGameButton.getStyle().setProperty("display", "none");
        feedbackElement.setInnerHTML(" ");
        feedbackElement.setClassName("");
        updateGuessCount();

        // Focus on input
        guessInput.focus();
    }

    /** Processes the user's guess and updates the UI with feedback. */
    private void submitGuess() {
        String input = guessInput.getValue().trim();

        if (input.isEmpty()) {
            showFeedback("Please enter a number!", "error");
            return;
        }

        int guess;
        try {
            guess = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            showFeedback("Invalid input! Please enter a valid number.", "error");
            guessInput.setValue("");
            return;
        }

        // Validate guess using existing CheckGuess class
        try {
            guessChecker.check(guess);
        } catch (IllegalArgumentException e) {
            showFeedback(e.getMessage(), "error");
            guessInput.setValue("");
            return;
        }

        numberOfGuesses++;
        updateGuessCount();

        // Check the guess
        if (guess > targetNumber) {
            showFeedback("Too high! Try a lower number.", "high");
        } else if (guess < targetNumber) {
            showFeedback("Too low! Try a higher number.", "low");
        } else {
            // Correct guess!
            showFeedback(
                    String.format(
                            "🎉 Congratulations! You guessed it in %d %s!",
                            numberOfGuesses, numberOfGuesses == 1 ? "guess" : "guesses"),
                    "success");
            guessInput.setDisabled(true);
            submitButton.setDisabled(true);
            newGameButton.getStyle().setProperty("display", "block");
            newGameButton.focus();
        }

        guessInput.setValue("");
        guessInput.focus();
    }

    /**
     * Updates the feedback message and applies the appropriate CSS class.
     *
     * @param message the feedback message to display
     * @param cssClass the CSS class to apply (error, high, low, success)
     */
    private void showFeedback(String message, String cssClass) {
        feedbackElement.setInnerHTML(message);
        feedbackElement.setClassName("feedback-" + cssClass);
    }

    /** Updates the guess count display. */
    private void updateGuessCount() {
        guessCountElement.setInnerHTML("Number of guesses: " + numberOfGuesses);
    }

    /** Keyboard event interface for handling key presses. */
    private interface HTMLKeyboardEvent extends HTMLEvent {
        String getKey();
    }

    /** Base HTML event interface. */
    private interface HTMLEvent extends org.teavm.jso.JSObject {}
}

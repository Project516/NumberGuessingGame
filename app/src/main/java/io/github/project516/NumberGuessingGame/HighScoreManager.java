// SPDX-FileCopyrightText: 2024 Project516 <138796702+Project516@users.noreply.github.com>
//
// SPDX-License-Identifier: GPL-3.0-or-later

package io.github.project516.NumberGuessingGame;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

/**
 * Manages high scores for the Number Guessing Game. Handles loading, saving, and retrieving high
 * scores from persistent storage.
 */
public class HighScoreManager {
    private static final String CONFIG_DIR = ".numberguessinggame";
    private static final String HIGH_SCORE_FILE = "highscores.properties";
    private static final int MAX_HIGH_SCORES = 10;

    private final File highScoreFile;
    private final List<HighScore> highScores;

    /**
     * Constructs a new HighScoreManager and loads existing high scores from storage.
     *
     * @throws IOException if there is an error creating the storage directory
     */
    public HighScoreManager() throws IOException {
        this(CONFIG_DIR);
    }

    /**
     * Constructs a new HighScoreManager with a custom config directory. Used primarily for testing.
     *
     * @param configDirName the name of the config directory
     * @throws IOException if there is an error creating the storage directory
     */
    HighScoreManager(String configDirName) throws IOException {
        File configDir = new File(System.getProperty("user.home"), configDirName);
        if (!configDir.exists()) {
            if (!configDir.mkdirs()) {
                throw new IOException("Failed to create config directory: " + configDir);
            }
        }

        highScoreFile = new File(configDir, HIGH_SCORE_FILE);
        highScores = new ArrayList<>();
        loadHighScores();
    }

    /**
     * Loads high scores from the properties file. If the file doesn't exist or can't be read, an
     * empty high score list is initialized.
     */
    private void loadHighScores() {
        if (!highScoreFile.exists()) {
            return;
        }

        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream(highScoreFile)) {
            props.load(fis);

            for (String key : props.stringPropertyNames()) {
                if (key.startsWith("score.")) {
                    try {
                        String[] parts = props.getProperty(key).split(":");
                        if (parts.length == 2) {
                            String username = parts[0];
                            int guesses = Integer.parseInt(parts[1]);
                            highScores.add(new HighScore(username, guesses));
                        }
                    } catch (Exception e) {
                        // Skip invalid entries
                    }
                }
            }
            Collections.sort(highScores);
        } catch (IOException e) {
            // If we can't read the file, just start with empty high scores
        }
    }

    /**
     * Saves the current high scores to the properties file.
     *
     * @throws IOException if there is an error writing to the file
     */
    private void saveHighScores() throws IOException {
        Properties props = new Properties();

        for (int i = 0; i < highScores.size(); i++) {
            HighScore score = highScores.get(i);
            props.setProperty("score." + i, score.getUsername() + ":" + score.getNumberOfGuesses());
        }

        try (FileOutputStream fos = new FileOutputStream(highScoreFile)) {
            props.store(fos, "Number Guessing Game High Scores");
        }
    }

    /**
     * Adds a new high score. The score will only be saved if it is in the top scores. The list is
     * automatically sorted and trimmed to the maximum number of high scores.
     *
     * @param username the username of the player
     * @param numberOfGuesses the number of guesses it took to win
     * @return true if the score was added to the high scores list, false otherwise
     */
    public boolean addHighScore(String username, int numberOfGuesses) {
        try {
            HighScore newScore = new HighScore(username, numberOfGuesses);
            highScores.add(newScore);
            Collections.sort(highScores);

            // Keep only top scores
            if (highScores.size() > MAX_HIGH_SCORES) {
                highScores.subList(MAX_HIGH_SCORES, highScores.size()).clear();
            }

            saveHighScores();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Gets the top high scores.
     *
     * @param limit the maximum number of high scores to return
     * @return a list of the top high scores, limited by the specified amount
     */
    public List<HighScore> getTopHighScores(int limit) {
        int count = Math.min(limit, highScores.size());
        return new ArrayList<>(highScores.subList(0, count));
    }

    /**
     * Gets all high scores.
     *
     * @return a list of all high scores
     */
    public List<HighScore> getAllHighScores() {
        return new ArrayList<>(highScores);
    }

    /**
     * Checks if a given number of guesses qualifies as a high score.
     *
     * @param numberOfGuesses the number of guesses to check
     * @return true if this would be a high score, false otherwise
     */
    public boolean isHighScore(int numberOfGuesses) {
        if (highScores.size() < MAX_HIGH_SCORES) {
            return true;
        }
        HighScore lowestHighScore = highScores.get(highScores.size() - 1);
        return numberOfGuesses < lowestHighScore.getNumberOfGuesses();
    }
}

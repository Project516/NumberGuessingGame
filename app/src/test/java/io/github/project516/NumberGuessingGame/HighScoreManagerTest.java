// SPDX-FileCopyrightText: 2024 Project516 <138796702+Project516@users.noreply.github.com>
//
// SPDX-License-Identifier: GPL-3.0-or-later

package io.github.project516.NumberGuessingGame;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

/** Unit tests for the HighScoreManager class. */
class HighScoreManagerTest {
    private static final String TEST_CONFIG_DIR = ".numberguessinggame_test";

    private void cleanup() {
        // Clean up test files
        File configDir = new File(System.getProperty("user.home"), TEST_CONFIG_DIR);
        if (configDir.exists()) {
            File[] files = configDir.listFiles();
            if (files != null) {
                for (File file : files) {
                    file.delete();
                }
            }
            configDir.delete();
        }
    }

    @AfterEach
    void cleanupAfter() {
        cleanup();
    }

    @Test
    void testHighScoreManagerCreation() {
        cleanup();
        assertDoesNotThrow(
                () -> {
                    HighScoreManager manager = new HighScoreManager(TEST_CONFIG_DIR);
                    assertNotNull(manager);
                });
    }

    @Test
    void testAddHighScore() throws IOException {
        cleanup();
        HighScoreManager manager = new HighScoreManager(TEST_CONFIG_DIR);
        assertTrue(manager.addHighScore("Alice", 5));

        List<HighScore> scores = manager.getAllHighScores();
        assertEquals(1, scores.size());
        assertEquals("Alice", scores.get(0).getUsername());
        assertEquals(5, scores.get(0).getNumberOfGuesses());
    }

    @Test
    void testHighScoresAreSorted() throws IOException {
        cleanup();
        HighScoreManager manager = new HighScoreManager(TEST_CONFIG_DIR);
        manager.addHighScore("Charlie", 7);
        manager.addHighScore("Alice", 3);
        manager.addHighScore("Bob", 5);

        List<HighScore> scores = manager.getAllHighScores();
        assertEquals(3, scores.size());
        assertEquals("Alice", scores.get(0).getUsername());
        assertEquals("Bob", scores.get(1).getUsername());
        assertEquals("Charlie", scores.get(2).getUsername());
    }

    @Test
    void testTopHighScoresLimit() throws IOException {
        cleanup();
        HighScoreManager manager = new HighScoreManager(TEST_CONFIG_DIR);

        // Add 15 scores
        for (int i = 1; i <= 15; i++) {
            manager.addHighScore("Player" + i, i);
        }

        // Should only keep top 10
        List<HighScore> allScores = manager.getAllHighScores();
        assertEquals(10, allScores.size());
        assertEquals("Player1", allScores.get(0).getUsername());
        assertEquals("Player10", allScores.get(9).getUsername());
    }

    @Test
    void testGetTopHighScores() throws IOException {
        cleanup();
        HighScoreManager manager = new HighScoreManager(TEST_CONFIG_DIR);

        for (int i = 1; i <= 10; i++) {
            manager.addHighScore("Player" + i, i);
        }

        List<HighScore> top5 = manager.getTopHighScores(5);
        assertEquals(5, top5.size());
        assertEquals("Player1", top5.get(0).getUsername());
        assertEquals("Player5", top5.get(4).getUsername());
    }

    @Test
    void testIsHighScore() throws IOException {
        cleanup();
        HighScoreManager manager = new HighScoreManager(TEST_CONFIG_DIR);

        // Empty list - everything is a high score
        assertTrue(manager.isHighScore(100));

        // Add 10 scores
        for (int i = 1; i <= 10; i++) {
            manager.addHighScore("Player" + i, i * 10);
        }

        // 5 is better than all existing scores
        assertTrue(manager.isHighScore(5));

        // 50 is better than some existing scores
        assertTrue(manager.isHighScore(50));

        // 100 is equal to worst score - not better
        assertFalse(manager.isHighScore(100));

        // 150 is worse than all existing scores
        assertFalse(manager.isHighScore(150));
    }
}

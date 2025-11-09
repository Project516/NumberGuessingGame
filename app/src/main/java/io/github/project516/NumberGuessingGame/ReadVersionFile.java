// SPDX-FileCopyrightText: 2025 Project516 <138796702+Project516@users.noreply.github.com>
//
// SPDX-License-Identifier: GPL-3.0-or-later

package io.github.project516.NumberGuessingGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/** Reads version information for the Number Guessing Game from the version.txt resource file. */
public class ReadVersionFile {
    /**
     * Retrieves the current version of the game by reading from the version.txt resource file.
     *
     * @return the version string
     */
    public String readVersion() {
        String content = "1.0.0"; // Default fallback version
        try (InputStream inputStream =
                        getClass().getClassLoader().getResourceAsStream("version.txt");
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            if (inputStream != null) {
                content = reader.readLine();
                if (content != null) {
                    content = content.trim();
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading version file: " + e.getMessage());
        }
        return content;
    }
}

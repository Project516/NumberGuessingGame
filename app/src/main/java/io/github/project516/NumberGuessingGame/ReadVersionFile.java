package io.github.project516.NumberGuessingGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Reads version information for the Number Guessing Game. Currently returns a placeholder version
 * string.
 */
public class ReadVersionFile {
    /**
     * Retrieves the current version of the game by reading from the version.txt resource file.
     *
     * @return the version string, or "rolling" if the file cannot be read
     */
    public String readVersion() {
        String content = "rolling"; // Placeholder version
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

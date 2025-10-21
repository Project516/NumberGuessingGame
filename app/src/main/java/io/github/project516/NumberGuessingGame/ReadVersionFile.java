package io.github.project516.NumberGuessingGame;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Reads version information for the Number Guessing Game. Currently returns a placeholder version
 * string.
 */
public class ReadVersionFile {
    // TODO - make this read the file in the resources directory
    /**
     * Retrieves the current version of the game. Currently returns "rolling" as a placeholder.
     *
     * @return the version string
     */
    public String readVersion() {
        String filePath = "version.txt";
        String content = "rolling"; // Placeholder version
        try {
            content = new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return content;
    }
}

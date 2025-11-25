// SPDX-FileCopyrightText: 2025 Project516 <138796702+Project516@users.noreply.github.com>
//
// SPDX-License-Identifier: GPL-3.0-or-later

package dev.project516.NumberGuessingGame;

/**
 * Provides information about the Number Guessing Game application. This class contains methods to
 * display game information, author details, project URL, and online Javadoc location.
 */
public class GameInfo {
    /**
     * Displays information about the game to the console. Prints the game title and instructions
     * for the player.
     */
    void about() {
        System.out.println("This is a Number Guessing Game!");
        System.out.println("Guess a number between 1 and 100!\n");
    }

    /**
     * Returns the author of the Number Guessing Game.
     *
     * @return the author's username
     */
    String author() {
        return "project516";
    }

    /**
     * Returns the project's GitHub repository URL.
     *
     * @return the GitHub project URL
     */
    String projectURL() {
        return "https://github.com/project516/numberguessinggame";
    }

    /**
     * Returns the URL for the online Javadoc documentation.
     *
     * @return the online Javadoc URL
     */
    String onlineJavadoc() {
        return "https://project516.dev/NumberGuessingGame";
    }
}

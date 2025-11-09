// SPDX-FileCopyrightText: 2025 Project516 <138796702+Project516@users.noreply.github.com>
//
// SPDX-License-Identifier: GPL-3.0-or-later

package io.github.project516.NumberGuessingGame;

/**
 * Provides debugging information for the Number Guessing Game. This class displays system
 * information and version details, and handles game crash notifications.
 */
public class DebugInfo {

    /** System information provider. */
    SystemInfo sysInfo = new SystemInfo();

    /** Version file reader. */
    ReadVersionFile vFile = new ReadVersionFile();

    /**
     * Displays debug information including Java version, vendor, JDK name, and game version to the
     * console.
     */
    void launchDebug() {
        System.out.println("\n===== DEBUG INFO =====\n\n");
        System.out.println("Java version: " + sysInfo.version());
        System.out.println("Vendor: " + sysInfo.vendor());
        System.out.println("JDK name: " + sysInfo.name());
        System.out.println("Number Guessing Game " + vFile.readVersion());
        System.out.println("\n\n======================\n\n");
    }

    /**
     * Displays a message when the game crashes. Called when an unexpected exception occurs during
     * game execution.
     */
    void gameCrash() {
        System.out.println("\n\n===Program Crashed!===\n\n");
    }
}

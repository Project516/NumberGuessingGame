// SPDX-FileCopyrightText: 2025 Project516 <138796702+Project516@users.noreply.github.com>
//
// SPDX-License-Identifier: GPL-3.0-or-later

package io.github.project516.NumberGuessingGame;

/**
 * Provides system information about the Java Virtual Machine. This class retrieves JVM properties
 * such as vendor, name, and version.
 */
public class SystemInfo {

    /**
     * Returns the vendor of the Java Virtual Machine.
     *
     * @return the JVM vendor name
     */
    public String vendor() {
        return System.getProperty("java.vm.vendor");
    }

    /**
     * Returns the name of the Java Virtual Machine.
     *
     * @return the JVM name
     */
    public String name() {
        return System.getProperty("java.vm.name");
    }

    /**
     * Returns the version of the Java Virtual Machine.
     *
     * @return the JVM version
     */
    public String version() {
        return System.getProperty("java.vm.version");
    }
}

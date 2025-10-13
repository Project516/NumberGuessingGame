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
    String vendor() {
        return System.getProperty("java.vm.vendor");
    }

    /**
     * Returns the name of the Java Virtual Machine.
     *
     * @return the JVM name
     */
    String name() {
        return System.getProperty("java.vm.name");
    }

    /**
     * Returns the version of the Java Virtual Machine.
     *
     * @return the JVM version
     */
    String version() {
        return System.getProperty("java.vm.version");
    }
}

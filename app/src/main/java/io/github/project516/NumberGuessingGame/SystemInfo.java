package io.github.project516.NumberGuessingGame;

public class SystemInfo {
    String vendor() {
        return System.getProperty("java.vm.vendor");
    }

    String name() {
        return System.getProperty("java.vm.name");
    }

    String version() {
        return System.getProperty("java.vm.version");
    }
}

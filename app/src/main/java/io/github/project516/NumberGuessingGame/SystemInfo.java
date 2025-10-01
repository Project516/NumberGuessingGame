package io.github.project516.NumberGuessingGame;

class SystemInfo {
    String vendor() {
        return System.getProperty("java.vm.vendor");
    }

    String name() {
        return System.getProperty("java.vm.name");
    }
}

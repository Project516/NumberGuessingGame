package io.github.project516.NumberGuessingGame;

public class DebugInfo {

    SystemInfo sysInfo = new SystemInfo();

    void launchDebug() {
        System.out.println("===== DEBUG INFO =====\n\n");
        System.out.println("Java version: " + sysInfo.version());
        System.out.println("Vendor: " + sysInfo.vendor());
        System.out.println("JDK name: " + sysInfo.name());
        System.out.println("\n\n======================\n\n");
    }
}

package io.github.project516.NumberGuessingGame;

public class DebugInfo {

    SystemInfo sysInfo = new SystemInfo();
    ReadVersionFile vFile = new ReadVersionFile();

    void launchDebug() {
        System.out.println("\n===== DEBUG INFO =====\n\n");
        System.out.println("Java version: " + sysInfo.version());
        System.out.println("Vendor: " + sysInfo.vendor());
        System.out.println("JDK name: " + sysInfo.name());
        System.out.println("Number Guessing Game " + vFile.readVersion());
        System.out.println("\n\n======================\n\n");
    }

    void gameCrash() {
        System.out.println("\n\n===Program Crashed!===\n\n");
    }
}

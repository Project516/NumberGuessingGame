package io.github.project516.NumberGuessingGame;

public class Main {
    public static void main(String[] args) {
        SystemInfo SysInfo = new SystemInfo();
        System.out.println("Java version: " + Runtime.version());
        System.out.println("Vendor: " + SysInfo.vendor());
        System.out.println("JDK name: " + SysInfo.name());
    }
}

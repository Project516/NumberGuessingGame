package io.github.project516.NumberGuessingGame;

public class Main {
    public static void main(String[] args) {
        SystemInfo SysInfo = new SystemInfo();
        System.out.println("Running on " + Runtime.version());
        System.out.println(SysInfo.vendor());
    }
}

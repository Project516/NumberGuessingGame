package io.github.project516.NumberGuessingGame;

public class Main {
    public static void main(String[] args) {
        try {
            SystemInfo sysInfo = new SystemInfo();
            RandomNumber ranNumber = new RandomNumber();
            ScannerHelper scan = new ScannerHelper();

            System.out.println("===== DEBUG INFO =====\n\n");
            System.out.println("Java version: " + sysInfo.version());
            System.out.println("Vendor: " + sysInfo.vendor());
            System.out.println("JDK name: " + sysInfo.name());
            System.out.println("\n\n");

            int number = ranNumber.number();

            System.out.println("This is a Number Guessing Game!");
            System.out.print("Guess a number: ");
            int guess = scan.userGuess();
            System.out.println(guess);
            // scan.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

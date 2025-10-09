package io.github.project516.NumberGuessingGame;

public class Main {

    public static void main(String[] args) {

        int numOfGuesses = 0;

        ScannerHelper scan = new ScannerHelper();
        SystemInfo sysInfo = new SystemInfo();
        RandomNumber ranNumber = new RandomNumber();
        CheckGuess check = new CheckGuess();

        try {

            System.out.println("===== DEBUG INFO =====\n\n");
            System.out.println("Java version: " + sysInfo.version());
            System.out.println("Vendor: " + sysInfo.vendor());
            System.out.println("JDK name: " + sysInfo.name());
            System.out.println("\n\n======================\n\n");

            int number = ranNumber.number();

            System.out.println("This is a Number Guessing Game!");
            System.out.println("Guess a number between 1 and 100!\n");

            while (true) {

                System.out.print("Guess a number: ");
                int guess = scan.userGuess();
                check.check(guess);
                if (guess > number) {
                    System.out.println("You guessed to much!");
                } else if (guess < number) {
                    System.out.println("You guessed to little!");
                } else {
                    numOfGuesses++;
                    break;
                }
                numOfGuesses++;
            }

            System.out.println("Took you " + numOfGuesses + " guesses!");

        } catch (Exception e) {

            System.out.println("\n\n=====Program Crashed!=====\n\n");

            e.printStackTrace();

        } finally {

            scan.close();
        }
    }
}

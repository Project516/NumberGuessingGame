package io.github.project516.NumberGuessingGame;

public class Main {

    public static void main(String[] args) {

        int numOfGuesses = 0;

        ScannerHelper scan = new ScannerHelper();
        RandomNumber ranNumber = new RandomNumber();
        CheckGuess check = new CheckGuess();
        DebugInfo debugInfo = new DebugInfo();
        GameInfo gameInfo = new GameInfo();

        debugInfo.launchDebug();

        try {
            int number = ranNumber.number();
            gameInfo.about();

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

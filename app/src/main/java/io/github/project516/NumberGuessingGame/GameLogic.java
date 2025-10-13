package io.github.project516.NumberGuessingGame;

public class GameLogic {
    // TODO port game logic from Main to GameLogic
    void game() {

        RandomNumber ranNumber = new RandomNumber();
        int number = ranNumber.number(100);
        int numOfGuesses = 0;
        ScannerHelper scan = new ScannerHelper();
        CheckGuess check = new CheckGuess();

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
                System.out.println("Took you " + numOfGuesses + " guesses!");
                scan.close();
                break;
            }
            numOfGuesses++;
        }
    }
}

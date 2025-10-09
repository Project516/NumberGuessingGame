package io.github.project516.NumberGuessingGame;

public class CheckGuess {
    void check(int guess) {
        if (guess < 1 || guess > 101) {
            throw new IllegalArgumentException("Invalid number!");
        }
    }
}

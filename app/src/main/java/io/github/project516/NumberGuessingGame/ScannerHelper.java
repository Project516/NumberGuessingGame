package io.github.project516.NumberGuessingGame;

import java.util.Scanner;

public class ScannerHelper {

    public Scanner scan = new Scanner(System.in);

    int userGuess() {
        return scan.nextInt();
    }

    String userName() {
        return scan.nextLine();
    }

    void close() {
        scan.close();
    }
}

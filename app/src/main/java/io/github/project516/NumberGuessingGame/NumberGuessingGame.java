package io.github.project516.NumberGuessingGame;

public class NumberGuessingGame {
    void run() {
        ScannerHelper scan = new ScannerHelper();
        DebugInfo debugInfo = new DebugInfo();
        GameInfo gameInfo = new GameInfo();
        GameLogic logic = new GameLogic();

        debugInfo.launchDebug();
        gameInfo.about();
        int play = 1;
        while (play != 0) {

            try {

                logic.game();

            } catch (Exception e) {

                debugInfo.gameCrash();
                e.printStackTrace();

            } finally {
                System.out.print("\nPlay again? (1 -> Y / 0 -> N) ");
                try {
                    play = scan.userGuess();
                    if (play == 0) {
                        break;
                    } else if (play != 1) {
                        throw new IllegalArgumentException("");
                    }
                } catch (Exception e) {
                    System.out.println("Error reading input!");
                    break;
                }
            }
        }
    }
}

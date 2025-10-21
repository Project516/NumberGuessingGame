package io.github.project516.NumberGuessingGame;

public class NumberGuessingGame {
    void run() {
        ScannerHelper scan = new ScannerHelper();
        DebugInfo debugInfo = new DebugInfo();
        GameInfo gameInfo = new GameInfo();
        GameLogic logic = new GameLogic();
        CheckGuess check = new CheckGuess();

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
                    check.quit(play);
                } catch (Exception e) {
                    debugInfo.gameCrash();
                    e.printStackTrace();
                    break;
                }
            }
        }
    }
}

package io.github.project516.NumberGuessingGame;

public class Main {

    public static void main(String[] args) {

        ScannerHelper scan = new ScannerHelper();
        DebugInfo debugInfo = new DebugInfo();
        GameInfo gameInfo = new GameInfo();
        GameLogic logic = new GameLogic();

        debugInfo.launchDebug();

        try {
            
            gameInfo.about();
            logic.game();

        } catch (Exception e) {

            debugInfo.gameCrash();

            e.printStackTrace();

        } finally {

            scan.close();
        }
    }
}

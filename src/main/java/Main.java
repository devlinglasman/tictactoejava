public class Main {

    public static void main(String[] args) {
        GameLogic gameLogic = new GameLogic();
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(System.in, System.out);
        GameRunner gameRunner = new GameRunner(consoleDisplay,gameLogic);

        gameRunner.run();
    }
}

public class Main {

    public static void main(String[] args) {
        GameLogic gameLogic = new GameLogic();
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(System.in, System.out);
        ConsoleCommunicator consoleCommunicator = new ConsoleCommunicator(consoleDisplay,gameLogic);

        consoleCommunicator.run();
    }
}

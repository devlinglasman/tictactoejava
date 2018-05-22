public class Main {

    public static void main(String[] args) {

        Grid grid = new Grid();
        PlayerComputer playerComputer = new PlayerComputer("Computer", Mark.playerTwoMark);
        Validator validator = new Validator();
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(System.in, System.out);

        GameRunner gameRunner = new GameRunner(grid, validator, consoleDisplay);

        gameRunner.run();
    }
}

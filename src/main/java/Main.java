public class Main {

    public static void main(String[] args) {

        Grid grid = new Grid();
        PlayerHuman playerOne = new PlayerHuman("Player One", Mark.playerOneMark);
        PlayerHuman playerTwo = new PlayerHuman("Player Two", Mark.playerTwoMark);
        Validator validator = new Validator();
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(System.in, System.out);

        GameRunner gameRunner = new GameRunner(grid, playerOne, playerTwo, validator, consoleDisplay);

        gameRunner.run();
    }
}

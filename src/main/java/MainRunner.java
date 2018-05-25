import Console.ConsoleIO;
import Core.GameRunner;
import Core.Grid;
import Core.Mark;
import Core.Players.Player;
import Core.Players.PlayerComputer;
import Core.Players.PlayerHuman;

public class MainRunner {

    public static void main(String[] args) {

        Grid grid = new Grid();
        ConsoleIO consoleIO = new ConsoleIO(System.in, System.out);
        Player playerOne = new PlayerHuman("Player One", Mark.playerOneMark, consoleIO);
        Player playerTwo = new PlayerComputer("Computer", Mark.playerTwoMark);
        GameRunner gameRunner = new GameRunner(grid, playerOne, playerTwo, consoleIO);

        gameRunner.getGrid().setASquare(0, playerOne.getMark());
        gameRunner.getGrid().setASquare(1, playerOne.getMark());
        gameRunner.getGrid().setASquare(2, playerTwo.getMark());
        gameRunner.getGrid().setASquare(3, playerTwo.getMark());
        gameRunner.getGrid().setASquare(5, playerTwo.getMark());
        gameRunner.getGrid().setASquare(6, playerTwo.getMark());
        gameRunner.getGrid().setASquare(7, playerOne.getMark());
        gameRunner.getGrid().setASquare(8, playerOne.getMark());

        gameRunner.alternatePlayer();

        gameRunner.runGame();
    }
}

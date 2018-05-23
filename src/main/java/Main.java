import Console.ConsoleIO;
import Core.Game;
import Core.Grid;
import Core.Mark;
import Core.Players.Player;
import Core.Players.PlayerComputer;
import Core.Players.PlayerHuman;

public class Main {

    public static void main(String[] args) {

        Grid grid = new Grid();
        ConsoleIO consoleIO = new ConsoleIO(System.in, System.out);
        Player playerOne = new PlayerHuman("Player One", Mark.playerOneMark, consoleIO);
        Player playerTwo = new PlayerComputer("Computer", Mark.playerTwoMark);

        Game game = new Game(grid, playerOne, playerTwo, consoleIO);

        game.runGame();
    }
}

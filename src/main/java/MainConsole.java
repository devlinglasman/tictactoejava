import Console.ConsoleIO;
import Core.Game;
import Core.Grid;
import Core.Mark;
import Core.Players.Player;
import Core.Players.PlayerComputer;
import Core.Players.PlayerHuman;

public class MainConsole {

    public static void main(String[] args) {
        findGameMode();
    }

    public static void findGameMode() {
        Grid grid = new Grid();
        ConsoleIO consoleIO = new ConsoleIO(System.in, System.out);
        Player playerOne = new PlayerHuman("Player One", Mark.playerOneMark, consoleIO);

        consoleIO.askGameMode();
        String gameChoice = consoleIO.takeInput();

        if (gameChoice.equals("1")) {
            Player playerTwo = new PlayerComputer("Computer", Mark.playerTwoMark);
            Game game = new Game(grid, playerOne, playerTwo, consoleIO);

            game.runGame();

        } else {
            Player playerTwo = new PlayerHuman("Player Two", Mark.playerTwoMark, consoleIO);
            Game game = new Game(grid, playerOne, playerTwo, consoleIO);

            game.runGame();
        }

    }
}

package Core;

import Console.ConsoleIO;
import Core.Players.Player;
import Core.Players.PlayerComputer;
import Core.Players.PlayerHuman;

public class ConsoleGameRunner {

    private Grid grid;
    private ConsoleIO consoleIO;
    private Player playerOne;
    private Player playerTwo;

    public ConsoleGameRunner(ConsoleIO consoleIO) {
        this.consoleIO = consoleIO;
        grid = new Grid();
        playerOne = new PlayerHuman("Player One", Mark.playerOneMark, consoleIO);
    }

    public void run() {
        findGameMode();
        Game game = new Game(grid, playerOne, playerTwo, consoleIO);
        game.runGame();
    }

    private void findGameMode() {
        consoleIO.askGameMode();
        String gameChoice = consoleIO.takeInput();
        if (gameChoice.equals("1")) {
            playerTwo = new PlayerComputer("Computer", Mark.playerTwoMark);
        } else {
            playerTwo = new PlayerHuman("Player Two", Mark.playerTwoMark, consoleIO);
        }
    }
}

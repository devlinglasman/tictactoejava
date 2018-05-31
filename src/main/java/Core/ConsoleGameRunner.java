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
            playerOne = new PlayerHuman("Player One", Mark.playerOneMark, consoleIO);
            playerTwo = new PlayerComputer("Computer", Mark.playerTwoMark, Mark.playerOneMark);
        } else if (gameChoice.equals("2")) {
            playerOne = new PlayerComputer("ComputerOne", Mark.playerOneMark, Mark.playerTwoMark);
            playerTwo = new PlayerComputer("ComputerTwo", Mark.playerTwoMark, Mark.playerOneMark);
        } else {
            playerOne = new PlayerHuman("Player One", Mark.playerOneMark, consoleIO);
            playerTwo = new PlayerHuman("Player Two", Mark.playerTwoMark, consoleIO);
        }
    }
}

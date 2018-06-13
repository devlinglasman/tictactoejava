package Console;

import Core.Game;
import Core.Grid;
import Core.Mark;
import Core.Players.Player;
import Core.Players.PlayerComputer;
import Core.Players.PlayerHuman;

public class ConsoleGameRunner {

    private Grid grid;
    private ConsoleUI consoleUI;
    private Player playerOne;
    private Player playerTwo;

    public ConsoleGameRunner(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
        grid = new Grid();
    }

    public void run() {
        findGameMode();
        clearScreen();
        Game game = new Game(grid, playerOne, playerTwo, consoleUI);
        game.runGame();
    }

    private void findGameMode() {
        consoleUI.askGameMode();
        String gameChoice = consoleUI.getInput();
        if (gameChoice.equals("1")) {
            playerOne = new PlayerHuman("Player One", Mark.playerOneMark, consoleUI);
            playerTwo = new PlayerComputer("Computer", Mark.playerTwoMark, Mark.playerOneMark);
        } else if (gameChoice.equals("2")) {
            playerOne = new PlayerComputer("ComputerOne", Mark.playerOneMark, Mark.playerTwoMark);
            playerTwo = new PlayerComputer("ComputerTwo", Mark.playerTwoMark, Mark.playerOneMark);
        } else {
            playerOne = new PlayerHuman("Player One", Mark.playerOneMark, consoleUI);
            playerTwo = new PlayerHuman("Player Two", Mark.playerTwoMark, consoleUI);
        }
    }

    private void clearScreen() {
        consoleUI.clearScreen();
    }
}

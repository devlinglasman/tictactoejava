package Core;

import Core.Game;
import Core.Grid;
import Core.Mark;
import Core.Players.Player;
import Core.Players.PlayerComputer;
import Core.Players.PlayerHuman;
import Core.UI;

public class GameRunner {

    private Grid grid;
    private UI ui;
    private Player playerOne;
    private Player playerTwo;

    public GameRunner(UI ui) {
        this.ui = ui;
        grid = new Grid();
    }

    public void run() {
        String gameModeChoice = ui.findGameMode();
        setPlayers(gameModeChoice);
        Game game = new Game(grid, playerOne, playerTwo, ui);
        game.runGame();
    }

    private void setPlayers(String gameModeChoice) {
        switch (gameModeChoice) {
            case "1":
                playerOne = new PlayerHuman("Player One", Mark.playerOneMark, ui);
                playerTwo = new PlayerComputer("Computer", Mark.playerTwoMark, Mark.playerOneMark);
                break;
            case "2":
                playerOne = new PlayerComputer("ComputerOne", Mark.playerOneMark, Mark.playerTwoMark);
                playerTwo = new PlayerComputer("ComputerTwo", Mark.playerTwoMark, Mark.playerOneMark);
                break;
            case "3":
                playerOne = new PlayerHuman("Player One", Mark.playerOneMark, ui);
                playerTwo = new PlayerHuman("Player Two", Mark.playerTwoMark, ui);
        }
    }
}

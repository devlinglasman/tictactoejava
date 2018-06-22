package Core;

import Core.Players.Player;

public class Game {

    private Grid grid;
    private Player playerOne;
    private Player playerTwo;
    private UI ui;
    private Player activePlayer;

    public Game(Grid grid, Player playerOne, Player playerTwo, UI ui) {
        this.grid = grid;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.ui = ui;
        activePlayer = playerOne;
    }

    public void runGame() {
        ui.displayGrid(grid.getSquares());
        while (gameOngoing()) {
            activePlayer.makeMove(grid);
            ui.presentMove(activePlayer, grid);
            ui.displayGrid(grid.getSquares());
            alternatePlayer();
        }
        announceResult();
    }

    public Player getActivePlayer() {
        return activePlayer;
    }

    private void alternatePlayer() {
        if (activePlayer == playerOne) {
            activePlayer = playerTwo;
        } else {
            activePlayer = playerOne;
        }
    }

    private boolean gameOngoing() {
        return !grid.isFull() && !grid.winningLineExistsInGrid();
    }

    private void announceResult() {
        if (grid.winningLineExistsInGrid()) {
            alternatePlayer();
            ui.announceWinner(activePlayer);
        } else {
            ui.announceTie();
        }
    }
}



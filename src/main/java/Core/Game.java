package Core;

import Core.Players.Player;

public class Game {

    private Grid grid;
    private Player playerOne;
    private Player playerTwo;
    private Communicator communicator;
    private Player activePlayer;

    public Game(Grid grid, Player playerOne, Player playerTwo, Communicator communicator) {
        this.grid = grid;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.communicator = communicator;
        activePlayer = playerOne;
    }

    public void runGame() {
        communicator.displayGrid(grid.getSquares());
        while (gameOngoing()) {
            activePlayer.makeMove(grid);
            communicator.presentMove(activePlayer, grid);
            communicator.displayGrid(grid.getSquares());
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
            communicator.announceWinner(activePlayer);
        } else {
            communicator.announceTie();
        }
    }
}



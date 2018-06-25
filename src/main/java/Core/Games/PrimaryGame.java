package Core.Games;

import Core.Communicator;
import Core.Games.Game;
import Core.Grid;
import Core.Players.Player;

public class PrimaryGame implements Game {

    private Grid grid;
    private Player playerOne;
    private Player playerTwo;
    private Communicator communicator;
    private Player activePlayer;

    public PrimaryGame(Grid grid, Player playerOne, Player playerTwo, Communicator communicator) {
        this.grid = grid;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.communicator = communicator;
        activePlayer = playerOne;
    }

    @Override
    public void runGame() {
        communicator.displayGrid(grid.getSquares());
        while (gameOngoing()) {
            activePlayer.makeMove(grid);
            communicator.presentMove(activePlayer, grid);
            alternatePlayer();
        }
        announceResult();
    }

    @Override
    public Player getActivePlayer() {
        return activePlayer;
    }

    @Override
    public void alternatePlayer() {
        if (activePlayer == playerOne) {
            activePlayer = playerTwo;
        } else {
            activePlayer = playerOne;
        }
    }

    @Override
    public boolean gameOngoing() {
        return !grid.isFull() && !grid.winningLineExistsInGrid();
    }

    @Override
    public void announceResult() {
        if (grid.winningLineExistsInGrid()) {
            alternatePlayer();
            communicator.announceWinner(activePlayer);
        } else {
            communicator.announceTie();
        }
    }

    @Override
    public Communicator getCommunicator() {
        return communicator;
    }

    @Override
    public Grid getGrid() {
        return grid;
    }
}



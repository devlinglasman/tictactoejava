package Core.Games;

import Core.Mark;
import Core.UserInterfaces.Communicator;
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

    public void runGame() {
        displayGrid();
        while (gameOngoing()) {
            makeMove();
            presentMove();
            alternatePlayer();
        }
        announceResult();
    }

    public void makeMove() {
        int move = generateMove();
        markGrid(move);
    }

    public int generateMove() {
        return activePlayer.getMove(grid);
    }

    public void markGrid(int move) {
        grid.markSquare(move, activePlayer.getMark());
    }

    private void displayGrid() {
        communicator.displayGrid(grid.getSquares());
    }

    private void presentMove() {
        communicator.presentMove(activePlayer, grid);
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
            announceWinner();
        } else {
            communicator.announceTie();
        }
    }

    private void announceWinner() {
        if (grid.reportWinningMark() == Mark.PLAYERONEMARK) {
            communicator.announceWinner(playerOne);
        } else {
            communicator.announceWinner(playerTwo);
        }
    }
}



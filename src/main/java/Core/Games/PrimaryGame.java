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
    private Integer lastMove;

    public PrimaryGame(Grid grid, Player playerOne, Player playerTwo, Communicator communicator) {
        this.grid = grid;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.communicator = communicator;
        activePlayer = playerOne;
        lastMove = null;
    }

    public void playNextMove() {
        lastMove = generateMove();
        markGrid(lastMove);
        presentMove();
        alternatePlayer();
    }

    public int generateMove() {
        return activePlayer.getMove(grid);
    }

    public void markGrid(int move) {
        grid.markSquare(move, activePlayer.getMark());
    }

    public void displayGrid() {
        communicator.displayGrid(grid.getSquares());
    }

    public void presentMove() {
        communicator.presentMove(activePlayer, grid);
    }

    private void alternatePlayer() {
        if (activePlayer == playerOne) {
            activePlayer = playerTwo;
        } else {
            activePlayer = playerOne;
        }
    }

    public boolean gameOngoing() {
        return !grid.isFull() && !grid.winningLineExistsInGrid();
    }

    public int getLastMove() {
        return lastMove;
    }

    public void announceResult() {
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



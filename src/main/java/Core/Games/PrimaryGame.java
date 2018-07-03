package Core.Games;

import Core.Board.Mark;
import Core.UserInterfaces.Communicator;
import Core.Board.Grid;
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

    @Override
    public void playNextMove() {
        displayGrid();
        lastMove = generateMove();
        markGrid(lastMove);
        presentMove();
        alternatePlayer();
    }

    @Override
    public boolean gameOngoing() {
        return !grid.isFull() && !grid.winningLineExistsInGrid();
    }

    @Override
    public Integer getLastMove() {
        return lastMove;
    }

    @Override
    public void announceResult() {
        displayGrid();
        if (grid.winningLineExistsInGrid()) {
            announceWinner();
        } else {
            communicator.announceTie();
        }
    }

    private void displayGrid() {
        communicator.displayGrid(grid.getSquares());
    }


    private Integer generateMove() {
        return activePlayer.getMove(grid);
    }

    private void markGrid(Integer move) {
        grid.markSquare(move, activePlayer.getMark());
    }

    private void presentMove() {
        communicator.presentMove(activePlayer);
    }

    private void alternatePlayer() {
        if (activePlayer == playerOne) {
            activePlayer = playerTwo;
        } else {
            activePlayer = playerOne;
        }
    }

    private void announceWinner() {
        if (grid.reportWinningMark() == Mark.PLAYER_ONE) {
            communicator.announceWinner(playerOne);
        } else {
            communicator.announceWinner(playerTwo);
        }
    }
}



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
            makeMove(activePlayer, grid);
            alternatePlayer();
        }
        announceResult();
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

    private void makeMove(Player activePlayer, Grid grid) {
        activePlayer.makeMove(grid);
        showMove();
    }

    private void showMove() {
        announceSquareChoice();
        ui.displayGrid(grid.getSquares());
    }

    private void announceSquareChoice() {
        ui.announceSquareChoice(activePlayer.getName());
    }

    private void announceResult() {
        if (grid.winningLineExistsInGrid()) announceWinner();
        else ui.announceTie();
    }

    private void announceWinner() {
        if (grid.reportWinningMark() == activePlayer.getMark()) {
            ui.announceWinner(activePlayer.getName());
        }
        else {
            alternatePlayer();
            ui.announceWinner(activePlayer.getName());
        }
    }
}



package Core;

import Console.ConsoleIO;
import Core.Players.Player;

import java.util.ArrayList;

public class GameRunner {

    private Grid grid;
    private Player playerOne;
    private Player playerTwo;
    private ConsoleIO consoleIO;
    private Player activePlayer;

    public GameRunner(Grid grid, Player playerOne, Player playerTwo, ConsoleIO consoleIO) {
        this.grid = grid;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.consoleIO = consoleIO;
        activePlayer = playerOne;
    }

//    public void run() {
//        askGameMode();
//        String gameChoice = consoleIO.takeInput();
//        boolean gameChoiceInvalid = validatorConsoleInput.inputNotValidGameChoice(gameChoice);
//        while (gameChoiceInvalid) {
//            consoleIO.announceGameChoiceInvalid();
//            gameChoice = consoleIO.takeInput();
//            gameChoiceInvalid = validatorConsoleInput.inputNotValidGameChoice(gameChoice);
//        }
//        if (gameChoice.equals("1")) {
//            opponent = playerTwo;
//        } else {
//            opponent = computerPlayer;
//        }
//        runGame();
//    }

    public void runGame() {
        displayGrid();
        while (gameOngoing()) {
            Grid gridClone = new Grid();
            gridClone.setSquares(grid.copySquares());

            int input = activePlayer.getInput(gridClone);
            makeMove(input, activePlayer.getMark());
            announceSquareChoice();
            displayGrid();
            alternatePlayer();
        }
        announceResult();
    }

    public void alternatePlayer() {
        if (activePlayer == playerOne) {
            activePlayer = playerTwo;
        } else {
            activePlayer = playerOne;
        }
    }

    private void displayGrid() {
        consoleIO.displayGrid(getGridSquares());
    }

    private boolean gameOngoing() {
        return grid.gameOngoing();
    }

    private void makeMove(int square, Mark mark) {
        grid.markSquare(square, mark);
    }

    private void announceSquareChoice() {
        consoleIO.announceSquareChoice(activePlayer.getName());
    }

    private void announceResult() {
        if (grid.winningLineExistsInGrid()) announceWinner();
        else consoleIO.announceGameTied();
    }

    private void announceWinner() {
        if (grid.reportWinningMark() == activePlayer.getMark()) {
            consoleIO.announceWinner(activePlayer.getName());
        }
        else {
            alternatePlayer();
            consoleIO.announceWinner(activePlayer.getName());
        }
    }

    private ArrayList<Mark> getGridSquares() {
        return grid.getSquares();
    }

    public Grid getGrid() {
        return grid;
    }
}



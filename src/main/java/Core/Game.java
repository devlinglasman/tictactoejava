package Core;

import Console.ConsoleIO;
import Core.Players.Player;

import java.util.ArrayList;

public class Game {

    private Grid grid;
    private Player playerOne;
    private Player playerTwo;
    private ConsoleIO consoleIO;
    private Player activePlayer;

    public Game(Grid grid, Player playerOne, Player playerTwo, ConsoleIO consoleIO) {
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
            int input = activePlayer.getInput(grid);
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

    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getActivePlayer() {
        return activePlayer;
    }

    private void askGameMode() {
        consoleIO.askGameMode();
    }

    private void displayGrid() {
        consoleIO.displayGrid(getGridSquares());
    }

    private boolean gameOngoing() {
        return !gameTied() && !gameIsWon();
    }

    private boolean gameIsWon() {
        return grid.winningLineExistsInGrid();
    }

    private boolean gameTied() {
        return grid.isFull();
    }

    private void makeMove(int square, Mark mark) {
        grid.markSquare(square, mark);
    }

    private void announceSquareChoice() {
        consoleIO.announceSquareChoice(activePlayer.getName());
    }

    private void announceResult() {
        if (gameIsWon()) announceWinner();
        else if (gameTied()) announceGameTied();
    }

    private void announceWinner() {
        if (grid.reportWinningMark() == Mark.playerOneMark) consoleIO.announceWinner(playerOne.getName());
        else consoleIO.announceWinner(playerTwo.getName());
    }

    private void announceGameTied() {
        consoleIO.announceGameTied();
    }

    private ArrayList<Mark> getGridSquares() {
        return grid.getSquares();
    }
}



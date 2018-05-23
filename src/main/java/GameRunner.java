import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;

class GameRunner {

    private Grid grid;
    private Player playerOne;
    private Player playerTwo;
    private Player computerPlayer;
    private Validator validator;
    private ConsoleDisplay consoleDisplay;
    private Player activePlayer;
    private Player opponent;

    GameRunner(Grid grid, Validator validator, ConsoleDisplay consoleDisplay) {
        this.grid = grid;
        this.validator = validator;
        this.consoleDisplay = consoleDisplay;
        playerOne = new PlayerHuman("Player One", Mark.playerOneMark, this.consoleDisplay);
        playerTwo = new PlayerHuman("Player Two", Mark.playerTwoMark, this.consoleDisplay);
        computerPlayer = new PlayerComputer("Computer", Mark.playerTwoMark);
        activePlayer = playerOne;
    }

    public void run() {
        askGameMode();
        String gameChoice = consoleDisplay.takeInput();
        boolean gameChoiceInvalid = validator.inputNotValidGameChoice(gameChoice);
        while (gameChoiceInvalid) {
            consoleDisplay.announceGameChoiceInvalid();
            gameChoice = consoleDisplay.takeInput();
            gameChoiceInvalid = validator.inputNotValidGameChoice(gameChoice);
        }
        if (gameChoice.equals("1")) {
            opponent = playerTwo;
        } else {
            opponent = computerPlayer;
        }
        runGame();
    }

    public void runGame() {
        displayGrid();
        while (gameOngoing()) {
            int inputForGrid;
            if (activePlayer.isHumanPlayer()) {
                String input = getLegalInput();
                inputForGrid = validator.convertInputStrtoInt(input);
                inputForGrid--;
            } else {
                inputForGrid = getComputerInput();
            }
            makeMove(inputForGrid, activePlayer.getMark());
            announceSquareChoice();
            displayGrid();
            announceIfGameOver();
            alternatePlayer();
        }
    }

    public int getComputerInput() {
        GameState gameState = new GameState(grid, activePlayer, opponent);
        Minimax minimax = new Minimax(gameState);
        return minimax.minimaxCalculator(gameState);
    }

    public String getLegalInput() {
        String input = activePlayer.getInput();
        boolean inputIllegal = inputNotLegal(input);
        while (inputIllegal) {
            announceInputInvalid();
            input = activePlayer.getInput();
            inputIllegal = inputNotLegal(input);
        }
        return input;
    }

    public void alternatePlayer() {
        if (activePlayer == playerOne) {
            activePlayer = playerTwo;
            opponent = playerOne;
        } else {
            activePlayer = playerOne;
            opponent = playerTwo;
        }
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getActivePlayer() {
        return activePlayer;
    }

    public Player getOpponent() {
        return opponent;
    }

    private void askGameMode() {
        consoleDisplay.askGameMode();
    }

    private void displayGrid() {
        consoleDisplay.displayGrid(getGridSquares());
    }

    private boolean gameOngoing() {
        return !gameTied() && !gameIsWon();
    }

    private boolean gameIsWon() {
        return grid.winningLineExistsInGrid(activePlayer) || grid.winningLineExistsInGrid(opponent);
    }

    private boolean gameTied() {
        return grid.isFull();
    }

    private boolean inputNotLegal(String input) {
        return inputNotValidNumber(input) || moveNotLegal(input);
    }

    private boolean inputNotValidNumber(String input) {
        return validator.inputNotValidGridNumber(input);
    }

    private boolean moveNotLegal(String input) {
        int inputConverted = validator.convertInputStrtoInt(input);
        inputConverted--;
        return grid.moveNotLegal(inputConverted);
    }

    private void announceInputInvalid() {
        consoleDisplay.announceInputInvalid(activePlayer.getName());
    }

    private void makeMove(int square, Mark mark) {
        grid.markSquare(square, mark);
    }

    private void announceSquareChoice() {
        consoleDisplay.announceSquareChoice(activePlayer.getName());
    }

    private void announceIfGameOver() {
        if (gameIsWon()) announceWinner();
        else if (gameTied()) announceGameTied();
    }

    private void announceWinner() {
        consoleDisplay.announceWinner(activePlayer.getName());
    }

    private void announceGameTied() {
        consoleDisplay.announceGameTied();
    }

    private ArrayList<Mark> getGridSquares() {
        return grid.getSquares();
    }
}



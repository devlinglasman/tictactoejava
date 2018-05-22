import java.util.ArrayList;

class GameRunner {

    private Grid grid;
    private Player playerOne;
    private Player playerTwo;
    private Validator validator;
    private ConsoleDisplay consoleDisplay;
    private Player activePlayer;

    GameRunner(Grid grid, Validator validator, ConsoleDisplay consoleDisplay) {
        this.grid = grid;
        this.validator = validator;
        this.consoleDisplay = consoleDisplay;
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

        playerOne = new PlayerHuman("Player One", Mark.playerOneMark, consoleDisplay);
        if (gameChoice.equals("1")) {
            playerTwo = new PlayerComputer("Computer", Mark.playerTwoMark);
            activePlayer = playerOne;
        } else {
            playerTwo = new PlayerHuman("Player Two", Mark.playerTwoMark, consoleDisplay);
            activePlayer = playerOne;
        }
        runGame();
    }

    public void runGame() {
        displayGrid();
        while (gameOngoing()) {
            String input = getLegalInput(activePlayer);
            int inputConverted = validator.convertInputStrtoInt(input);
            inputConverted--;
            makeMove(inputConverted, activePlayer.getMark());
            announceSquareChoice();
            displayGrid();
            announceIfGameOver();
            alternatePlayer();
        }
    }

    public String getLegalInput(Player player) {
        String input = player.getInput();
        boolean inputIllegal = inputNotLegal(input);
        while (inputIllegal) {
            if (player.isHumanPlayer()) announceInputInvalid();
            input = player.getInput();
            inputIllegal = inputNotLegal(input);
        }
        return input;
    }

    public void alternatePlayer() {
        if (activePlayer == playerOne) activePlayer = playerTwo;
        else activePlayer = playerOne;
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getActivePlayer() {
        return activePlayer;
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
        return grid.winningLineExistsInGrid();
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



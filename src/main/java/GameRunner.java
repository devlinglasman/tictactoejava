import java.util.ArrayList;

class GameRunner {

    private Grid grid;
    private PlayerHuman playerOne;
    private PlayerHuman playerTwo;
    private PlayerComputer playerComputer;
    private Validator validator;
    private ConsoleDisplay consoleDisplay;
    private PlayerHuman activePlayer;

    GameRunner(Grid grid, PlayerHuman playerOne, PlayerHuman playerTwo, PlayerComputer playerComputer, Validator validator, ConsoleDisplay consoleDisplay) {
        this.grid = grid;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.playerComputer = playerComputer;
        this.validator = validator;
        this.consoleDisplay = consoleDisplay;
        activePlayer = playerOne;
    }

    public void run() {
        askGameMode();
        String gameChoice = consoleDisplay.takeInput();
        if (gameChoice.equals("1")) {
            runComputerGame();
        } else {
            runHumanGame();
        }
    }

    public void runComputerGame() {
       int counter = 0;
        displayGrid();
        while (gameOngoing()) {
            if (counter == 0) {
                String input = takeHumanInput(activePlayer);
                makeMove(input);
                announceHumanSquareChoice();
            } else {
                int input = playerComputer.generateComputerInput();
                boolean illegalMove = moveNotLegal(input);
                while (illegalMove) {
                    input = playerComputer.generateComputerInput();
                    illegalMove = moveNotLegal(input);
                }
                String inputConverted = Integer.toString(input);
                makeMove(inputConverted);
                announceComputerTurn();
            }
            displayGrid();
            announceIfGameOver();
            counter = (counter + 1) % 2;
        }
    }

    public void runHumanGame() {
        displayGrid();
        while (gameOngoing()) {
            String input = takeHumanInput(activePlayer);
            makeMove(input);
            announceHumanSquareChoice();
            displayGrid();
            announceIfGameOver();
            alternatePlayer();
        }
    }

    public String takeHumanInput(PlayerHuman player) {
        String input = player.askForMove(consoleDisplay);
        boolean inputNotLegal = inputNotLegal(input);
        while (inputNotLegal) {
            announceInputInvalid();
            input = player.askForMove(consoleDisplay);
            inputNotLegal = inputNotLegal(input);
        }
        return input;
    }

    private boolean inputNotLegal(String input) {
        int inputConverted = validator.convertInputStrtoInt(input) - 1;
        return validator.inputNotValidNumber(input) || moveNotLegal(inputConverted);
    }

    public void makeMove(String input) {
        int inputConverted = validator.convertInputStrtoInt(input);
        inputConverted--;
        grid.markSquare(inputConverted, activePlayer.getMark());
    }

    public void announceIfGameOver() {
        if (gameIsWon()) announceWinner();
        else if (gameTied()) announceGameTied();
    }


    private void announceHumanSquareChoice() {
        consoleDisplay.announceHumanSquareChoice();
    }

    private void displayGrid() {
        consoleDisplay.displayGrid(getGridSquares());
    }

    private void announceInputInvalid() {
        consoleDisplay.announceInputInvalid();
    }

    private void announceWinner() {
        consoleDisplay.announceWinner(activePlayer.getName());
    }

    private void announceGameTied() {
        consoleDisplay.announceGameTied();
    }

    private void askGameMode() {
        consoleDisplay.askGameMode();
    }

    private void announceComputerTurn() {
        consoleDisplay.announceComputerTurn();
    }

    public boolean gameIsWon() {
        return grid.winningLineExistsInGrid();
    }

    public boolean moveNotLegal(int input) {
        return grid.moveNotLegal(input);
    }

    public boolean gameOngoing() {
        return !gameTied() && !gameIsWon();
    }

    public boolean gameTied() {
        return grid.isFull();
    }

    public void alternatePlayer() {
        if (activePlayer == playerOne) activePlayer = playerTwo;
        else activePlayer = playerOne;
    }

    public ArrayList<Mark> getGridSquares() {
        return grid.getSquares();
    }

}



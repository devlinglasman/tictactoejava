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
        if (gameChoice.equals("1")) {
//            runComputerGame();
        } else {
            runHumanGame();
        }
    }

//    public void runComputerGame() {
//        playerOne = new PlayerHuman("Player One", Mark.playerOneMark, consoleDisplay);
//        playerTwo = new PlayerComputer("Computer", Mark.playerTwoMark);
//        displayGrid();
//        while (gameOngoing()) {
//            if (activePlayer == playerOne) {
//                String input = getLegalInput(activePlayer);
//                makeMove(input);
//                announceHumanSquareChoice();
//            } else {
////                int input = playerTwo.getInput();
//                boolean illegalMove = moveNotLegal(input);
//                while (illegalMove) {
//                    input = playerTwo.generateComputerInput();
//                    illegalMove = moveNotLegal(input);
//                }
//                String inputConverted = Integer.toString(input);
//                makeMove(inputConverted);
//                announceComputerTurn();
//            }
//            displayGrid();
//            announceIfGameOver();
//            alternatePlayer();
//        }
//    }

    public void runHumanGame() {
        playerOne = new PlayerHuman("Player One", Mark.playerOneMark, consoleDisplay);
        playerTwo = new PlayerHuman("Player Two", Mark.playerTwoMark, consoleDisplay);
        activePlayer = playerOne;
        displayGrid();
        while (gameOngoing()) {
            String input = getLegalInput(activePlayer);
            makeMove(input);
            announceHumanSquareChoice();
            displayGrid();
            announceIfGameOver();
            alternatePlayer();
        }
    }

    public String getLegalInput(Player player) {
        String input = player.getInput();
        boolean inputNotLegal = inputNotLegal(input);
        while (inputNotLegal) {
            announceInputInvalid();
            input = player.getInput();
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



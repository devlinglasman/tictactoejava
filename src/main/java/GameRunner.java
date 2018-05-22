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
            playerOne = new PlayerHuman("Player One", Mark.playerOneMark, consoleDisplay);
            playerTwo = new PlayerComputer("Computer", Mark.playerTwoMark);
            activePlayer = playerOne;
//            runComputerGame();
        } else {
            playerOne = new PlayerHuman("Player One", Mark.playerOneMark, consoleDisplay);
            playerTwo = new PlayerHuman("Player Two", Mark.playerTwoMark, consoleDisplay);
            activePlayer = playerOne;
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

    public void announceSquareChoice() {
        consoleDisplay.announceSquareChoice(activePlayer);
    }

    public void makeMove(int square, Mark mark) {
        grid.markSquare(square, mark);
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

    public boolean inputNotLegal(String input) {
        if (inputNotValidNumber(input)) return true;
        else if (moveNotLegal(input)) return true;
        else return false;
    }

    private boolean inputNotValidNumber(String input) {
        return validator.inputNotValidNumber(input);
    }

    public boolean moveNotLegal(String input) {
        int inputConverted = validator.convertInputStrtoInt(input);
        inputConverted--;
        return grid.moveNotLegal(inputConverted);
    }

    public void announceIfGameOver() {
        if (gameIsWon()) announceWinner();
        else if (gameTied()) announceGameTied();
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

    public boolean gameIsWon() {
        return grid.winningLineExistsInGrid();
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



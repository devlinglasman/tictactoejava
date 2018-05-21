import java.util.ArrayList;
import java.util.Random;

public class GameLogic {

    private Player activePlayer = Player.PLAYERONE;
    private Grid grid = new Grid();
    private Validator validator = new Validator();

    public String findGameMode(String choice) {
        if (choice.equals("1")) {
            return "computerGame";
        } else {
            return "humanGame";
        }
    }

    public String computerTurnStatus() {
        String input = generateComputerInput();
        return makeMoveReturnStatus(input);
    }

    public String makeMoveReturnStatus(String input) {
        makeMove(input);
        if (gameIsWon()) return "gameWon";
        else if (gameTied()) return "gameTied";
        else {
            alternatePlayer();
            return "nextTurn";
        }
    }

    public boolean inputNotLegal(String input) {
        if (inputNotValidNumber(input)) return true;
        else {
            int inputForMoveLegality = convertInputToGridSquare(input);
            if (moveNotLegal(inputForMoveLegality)) return true;
            else return false;
        }
    }

    public boolean itIsHumanTurn() {
        return activePlayer == Player.PLAYERONE;
    }

    private boolean inputNotValidNumber(String input) {
        return validator.inputNotValidNumber(input);
    }

    public int convertInputToGridSquare(String input) {
        int inputConverted = validator.convertInputStrtoInt(input);
        inputConverted--;
        return inputConverted;
    }

    private void makeMove(String input) {
        int inputConverted = convertInputToGridSquare(input);
        markSquare(inputConverted, activePlayer.getMark());
    }

    private void markSquare(int squareNumber, Mark mark) {
        grid.markSquare(squareNumber, mark);
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

    private boolean gameTied() {
        return grid.isFull();
    }

    public String generateComputerInput() {
        int potentialInput = 0;
        boolean moveIllegalTrue = true;
        while (moveIllegalTrue) {
            potentialInput = generateRandomComputerNumber();
            moveIllegalTrue = moveNotLegal(potentialInput);
        }
        return String.valueOf(potentialInput + 1);
    }
    
    private int generateRandomComputerNumber() {
        Random rand = new Random();
        return rand.nextInt(8);
    }

    public void alternatePlayer() {
        if (getActivePlayer() == Player.PLAYERONE) activePlayer = Player.PLAYERTWO;
        else activePlayer = Player.PLAYERONE;
    }

    public Player getActivePlayer() {
        return activePlayer;
    }

    public ArrayList<Mark> getGridSquares() {
        return grid.getSquares();
    }

}

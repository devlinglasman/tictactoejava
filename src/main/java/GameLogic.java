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

    public String runHumanTurn(String input) {
        if (inputNotValid(input)) return "inputNotValid";
        else if (moveNotLegal(input)) return "inputInvalid";
        else {
            makeMove(input);
            if (gameIsWon()) return "gameWon";
            else if (gameTied()) return "gameTied";
            else return "nextTurn";
        }
    }

    public boolean itIsHumanTurn() {
        return activePlayer == Player.PLAYERONE;
    }

    public boolean inputNotValid(String input) {
        return validator.inputIsNotValid(input);
    }

    public int convertInputToGridSquare(String input) {
        int inputConverted = validator.convertInputStrtoInt(input);
        inputConverted--;
        return inputConverted;
    }

    public void makeMove(String input) {
        int inputConverted = convertInputToGridSquare(input);
        markSquare(inputConverted, activePlayer.getMark());
    }

    public void markSquare(int squareNumber, Mark mark) {
        grid.markSquare(squareNumber, mark);
    }

    public boolean gameIsWon() {
        return grid.winningLineExistsInGrid();
    }

    public boolean moveNotLegal(String input) {
        int inputConverted = convertInputToGridSquare(input);
        return grid.moveIsNotLegal(inputConverted);
    }

    public boolean gameOngoing() {
        if (gameTied() || gameIsWon()) return false;
        else return true;
    }

    private boolean gameTied() {
        return grid.isFull();
    }

    public String generateComputerInput() {
        Random rand = new Random();
        int potentialInput = rand.nextInt(9) + 1;
        return String.valueOf(potentialInput);
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

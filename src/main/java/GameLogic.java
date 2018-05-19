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

    public boolean itIsHumanTurn() {
        return activePlayer == Player.PLAYERONE;
    }

    public boolean inputIsNotValid(String input) {
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
        grid.markSquare(squareNumber,mark);
    }

    public boolean gameIsWon() {
        return grid.winningLineExistsInGrid();
    }

    public boolean moveIsNotLegal(String input) {
        int inputConverted = convertInputToGridSquare(input);
        return grid.moveIsNotLegal(inputConverted);
    }

    public boolean gameOngoing() {
        if (grid.isFull() || gameIsWon()) return false;
        else return true;
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

    public ArrayList<String> getGridSquares() {
        return grid.getSquares();
    }

}

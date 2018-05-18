import java.util.ArrayList;

public class GameLogic {

    private Player activePlayer = Player.PLAYERONE;
    private Grid grid = new Grid();

    public void markSquare(int squareNumber, Mark mark) {
        grid.markSquare(squareNumber,mark);
    }

    public int convertInputToSquareNumber(String input) {
        return Integer.parseInt(input) - 1;
    }

    public boolean isMoveLegal(int squareNumber) {
        if (grid.isMoveLegal(squareNumber)) return true;
        else return false;
    }

    public boolean gameOngoing() {
        if (grid.isFull() || isGameWon()) return false;
        else return true;
    }

    public boolean isGameWon() {
        return grid.winningLineExistsInGrid();
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

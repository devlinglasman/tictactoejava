import java.util.Arrays;
import java.util.List;

public class Game {

    private Player playerOne = Player.PLAYERONE;
    private Player playerTwo = Player.PLAYERTWO;
    private Player activePlayer = getPlayerOne();
    private Grid grid = new Grid();

    public int convertInputToSquareNumber(String input) {
        return Integer.parseInt(input) - 1;
    }

    public void markSquare(Player activePlayer, Grid grid, int squareNumber) {
        if (activePlayer == playerOne) {
            grid.markSquare(squareNumber,"X");
        } else {
            grid.markSquare(squareNumber,"O");
        }
    }

    public boolean isBoardFull(Grid grid) {
        return grid.isBoardFull();
    }

    public boolean isGameWon(Grid grid) {
        for (String[] line : grid.getPossibleWinLines()) {
            if (winningLine(line)) return true;
        }
        return false;
    }

    public boolean winningLine(String[] line) {
        if (Arrays.asList(line).contains(" ")) return false;
        String first = line[0];
        for (String s : line) {
            if (!s.equals(first)) return false;
        }
        return true;
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public Player getActivePlayer() {
        return activePlayer;
    }

    public void alternatePlayer() {
        if (getActivePlayer() == getPlayerOne()) activePlayer = getPlayerTwo();
        else activePlayer = getPlayerOne();
    }

    public Grid getGrid() {
        return grid;
    }
}

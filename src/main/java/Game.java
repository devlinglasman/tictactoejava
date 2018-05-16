import java.util.Arrays;
import java.util.List;

public class Game {

    private Player playerOne = Player.PLAYERONE;
    private Player playerTwo = Player.PLAYERTWO;

    private String[] squares = new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "};

    private String[] group3Squares(int a, int b, int c) {
       return new String[] {squares[a], squares[b], squares[c]};
    }

    private List<String[]> possibleWinLines() {
        return Arrays.asList(
                group3Squares(0,1,2),
                group3Squares(3,4,5),
                group3Squares(6,7,8),
                group3Squares(0,3,6),
                group3Squares(1,4,7),
                group3Squares(2,5,8),
                group3Squares(0,4,8),
                group3Squares(2,4,6)
        );
    }

    public String[] getSquares() {
        return squares;
    }

    public int convertInputToSquareNumber(String input) {
        return Integer.parseInt(input) - 1;
    }

    public void markSquare(Player activePlayer, int squareNumber) {
        if (activePlayer == playerOne) {
            setSquareMark(squareNumber,"X");
        } else {
            setSquareMark(squareNumber,"O");
        }
    }

    public void setSquareMark(int input, String mark) {
        squares[input] = mark;
    }

    public boolean isBoardFull() {
        for (String square : squares) {
            if (square.equals(" ")) return false;
        }
        return true;
    }

    public boolean isGameWon(List<String[]> lines) {
        for (String[] line : lines) {
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

    public List<String[]> getPossibleWinLines() {
        return possibleWinLines();
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }
}

import java.util.Arrays;
import java.util.List;

public class Grid {

    private String[] squares = new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "};

    private List<String[]> possibleWinLines() {
        return Arrays.asList(
                group3Squares(0, 1, 2),
                group3Squares(3, 4, 5),
                group3Squares(6, 7, 8),
                group3Squares(0, 3, 6),
                group3Squares(1, 4, 7),
                group3Squares(2, 5, 8),
                group3Squares(0, 4, 8),
                group3Squares(2, 4, 6)
        );
    }

    private String[] group3Squares(int a, int b, int c) {
        return new String[]{squares[a], squares[b], squares[c]};
    }

    public void markSquare(int squareNumber, String mark) {
        squares[squareNumber] = mark;
    }

    public boolean isBoardFull() {
        for (String square : squares) {
            if (square.equals(" ")) return false;
        }
        return true;
    }

    public List<String[]> getPossibleWinLines() {
        return possibleWinLines();
    }

    public String[] getSquares() {
        return squares;
    }

}

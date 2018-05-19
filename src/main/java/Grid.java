import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Grid {

    private ArrayList<String> squares = createGrid();

    public boolean moveIsNotLegal(int squareNumber) {
        return !squares.get(squareNumber).equals(" ");
    }

    public void markSquare(int squareNumber, Mark mark) {
        squares.set(squareNumber, mark.getStringRepresentation());
    }

    public boolean isFull() {
        for (String square : squares) {
            if (square.contains(Mark.unmarkedSquare.getStringRepresentation())) return false;
        }
        return true;
    }

    public boolean winningLineExistsInGrid() {
        for (ArrayList<String> line : possibleWinLines()) {
            if (lineIsWinner(line)) return true;
        }
        return false;
    }

    public boolean lineIsWinner(ArrayList<String> line) {
        if (line.contains(Mark.unmarkedSquare.getStringRepresentation())) return false;
        String first = line.get(0);
        for (String s : line) {
            if (!s.equals(first)) return false;
        }
        return true;
    }

    public ArrayList<String> getSquares() {
        return squares;
    }

    public ArrayList<String> createGrid() {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            result.add(Mark.unmarkedSquare.getStringRepresentation());
        }
        return (ArrayList<String>) result;
    }

    private List<ArrayList<String>> possibleWinLines() {
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

    private ArrayList<String> group3Squares(int a, int b, int c) {
        List<String> result = new ArrayList<>();
        result.add(squares.get(a));
        result.add(squares.get(b));
        result.add(squares.get(c));
        return (ArrayList<String>) result;
    }

}

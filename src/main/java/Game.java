import java.util.Arrays;
import java.util.List;

public class Game {

    private String[] squares = new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "};

    private String[] row1() {
        return new String[]{squares[0],squares[1],squares[2]};
    }

    private String[] row2() {
        return new String[]{squares[3],squares[4],squares[5]};
    }

    private String[] row3() {
        return new String[]{squares[6], squares[7], squares[8]};
    }

    private String[] col1() {
        return new String[]{squares[0],squares[3],squares[6]};
    }

    private String[] col2() {
        return new String[]{squares[1], squares[4], squares[7]};
    }

    private String[] col3() {
       return new String[]{squares[2],squares[5],squares[8]};
    }

    private String[] diag1() {
        return new String[]{squares[0],squares[4],squares[8]};
    }

    private String[] diag2() {
       return new String[]{squares[2],squares[4],squares[6]};
    }

    private List<String[]> lines() {
        return Arrays.asList(row1(), row2(), row3(), col1(), col2(), col3(), diag1(), diag2());
    }

    public String[] getSquares() {
        return squares;
    }

    public int convertInputToSquareNumber(String input) {
       return Integer.parseInt(input) - 1;
    }

    public void markSquare(int activePlayer, int squareNumber) {
        if (activePlayer == 1) {
            setSquareToX(squareNumber);
        } else {
            setSquareToO(squareNumber);
        }
    }

    public void setSquareToX(int input) {
        squares[input] = "X";
    }

    public void setSquareToO(int input) {
        squares[input] = "O";
    }

    public boolean isBoardFull() {
        for (String square : squares) {
            if (square.equals(" ")) return false;
        }
        return true;
    }

    public boolean isGameWon(List<String[]> lines) {
        for (String[] line : lines) {
            if (allAreX(line) || allAreO(line)) {
                return true;
            }
        }
        return false;
    }

    public boolean allAreX(String[] line) {
        for (String s : line) {
           if (!s.equals("X")) return false;
        }
        return true;
    }

    public boolean allAreO(String[] line) {
        for (String s : line) {
            if (!s.equals("O")) return false;
        }
        return true;
    }

    public List<String[]> getLines() {
        return lines();
    }
}

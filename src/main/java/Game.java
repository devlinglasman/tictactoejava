public class Game {

    private String[] squares = new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "};

    public String[] getSquares() {
        return squares;
    }

    public int convertInputToSquareNumber(String input) {
       return Integer.parseInt(input) - 1;
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

}

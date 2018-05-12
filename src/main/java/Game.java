public class Game {

    private String square1 = " ";
    private String square2 = " ";
    private String square3 = " ";
    private String square4 = " ";
    private String square5 = " ";
    private String square6 = " ";
    private String square7 = " ";
    private String square8 = " ";
    private String square9 = " ";

    private String[] squares = new String[]{square1, square2, square3, square4, square5, square6, square7, square8, square9};

    public String[] getSquares() {
        return squares;
    }

    public int convertInputToSquareNumber(String input) {
       return Integer.parseInt(input) - 1;
    }

    public void setSquareToX(int input) {
        squares[input] = "X";
    }
}

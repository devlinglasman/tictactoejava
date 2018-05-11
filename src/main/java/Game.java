public class Game {

    private int userInput;

    private BoardSquare square1;
    private BoardSquare square2;
    private BoardSquare square3;
    private BoardSquare square4;
    private BoardSquare square5;
    private BoardSquare square6;
    private BoardSquare square7;
    private BoardSquare square8;
    private BoardSquare square9;

    private BoardSquare[] squares;

    public Game() {
        square1 = new BoardSquare();
        square2 = new BoardSquare();
        square3 = new BoardSquare();
        square4 = new BoardSquare();
        square5 = new BoardSquare();
        square6 = new BoardSquare();
        square7 = new BoardSquare();
        square8 = new BoardSquare();
        square9 = new BoardSquare();

        squares = new BoardSquare[]{square1, square2, square3, square4, square5, square6, square7, square8, square9};
    }

    public BoardSquare getSquare1() {
        return square1;
    }

    public BoardSquare[] getSquares() {
        return squares;
    }

    public void convertInput(String input) {
       userInput = Integer.parseInt(input);
    }

    public BoardSquare getSelectedSquare(int input) {
        return squares[input - 1];
    }

    public int getUserInput() {
        return userInput;
    }

    public void setSquareStatus(BoardSquare square){
        square.setStatus(2);
    }

}

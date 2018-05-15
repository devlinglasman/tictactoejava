import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GameTest {

    @Test
    public void convertInputToSquareNumber() {
        Game game = new Game();

        assertEquals(0,game.convertInputToSquareNumber("1"));
    }

    @Test
    public void markSquareX() {
        Game game = new Game();

        game.markSquare(1,0);

        assertEquals("X",game.getSquares()[0]);
    }

    @Test
    public void markSquareO() {
        Game game = new Game();

        game.markSquare(2,0);

        assertEquals("O",game.getSquares()[0]);
    }

    @Test
    public void setSquareToX() {
        Game game = new Game();

        game.setSquareToXMark(0);

        assertEquals("X",game.getSquares()[0]);
    }

    @Test
    public void setSquareToO() {
        Game game = new Game();

        game.setSquareToO(0);

        assertEquals("O",game.getSquares()[0]);
    }

    @Test
    public void isBoardFullYes() {
        Game game = new Game();

        for (int i = 0; i < game.getSquares().length; i++) {
           game.setSquareToXMark(i);
        }

        assertEquals(true, game.isBoardFull());
    }

    @Test
    public void isBoardFullNo() {
        Game game = new Game();

        assertEquals(false, game.isBoardFull());
    }

    @Test
    public void winningLineYes() {
        Game game = new Game();
        String[] row1 = {"X","X","X"};

        assertEquals(true, game.winningLine(row1));
    }

    @Test
    public void winningLineNo() {
        Game game = new Game();
        String[] row1 = {" ","X","X"};

        assertEquals(false, game.winningLine(row1));
    }

    @Test
    public void isGameWonYes() {
        Game game = new Game();
        String[] row1 = {"X","X","X"};
        String[] row2 = {" "," "," "};
        List<String[]> lines = Arrays.asList(row1,row2);

        assertEquals(true, game.isGameWon(lines));
    }

    @Test
    public void isGameWonYes2() {
        Game game = new Game();
        String[] row2 = {"O","O","O"};
        List<String[]> lines = Arrays.asList(game.getPossibleWinLines().get(0),row2);

        assertEquals(true, game.isGameWon(lines));
    }

    @Test
    public void isGameWonNo() {
        Game game = new Game();
        String[] row1 = {" "," "," "};
        String[] row2 = {" "," "," "};
        List<String[]> lines = Arrays.asList(row1,row2);

        assertEquals(false, game.isGameWon(lines));
    }
}


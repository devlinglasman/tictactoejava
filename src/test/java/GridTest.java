import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class GridTest {

    @Test
    public void moveIsLegalYes() {
        Grid grid = new Grid();

        assertTrue(grid.moveIsNotLegal(0));
    }

    @Test
    public void moveIsLegalNo() {
        Grid grid = new Grid();

        grid.markSquare(0, Mark.playerOneMarkedSquare);

        assertFalse(grid.moveIsNotLegal(0));
    }

    @Test
    public void checkSquareEmptyFirst() {
        Grid grid = new Grid();

        assertEquals(" ", grid.getSquares().get(0));
    }

    @Test
    public void markSquareX() {
        Grid grid = new Grid();

        grid.markSquare(0, Mark.playerOneMarkedSquare);

        assertEquals("X", grid.getSquares().get(0));
    }

    @Test
    public void markSquareO() {
        Grid grid = new Grid();

        grid.markSquare(0, Mark.playerTwoMarkedSquare);

        assertEquals("O", grid.getSquares().get(0));
    }

    @Test
    public void isFullYes() {
        Grid grid = new Grid();

        assertFalse(grid.isFull());
    }

    @Test
    public void isFullNo() {
        Grid grid = new Grid();

        for (int i = 0; i < 9; i++) {
           grid.markSquare(i,Mark.playerOneMarkedSquare);
        }

        assertTrue(grid.isFull());
    }

    @Test
    public void winningLineExistsInGridYes() {
        Grid grid = new Grid();

        for (int i = 0; i < 3; i++) {
            grid.markSquare(i, Mark.playerOneMarkedSquare);
        }

        assertTrue(grid.winningLineExistsInGrid());
    }

    @Test
    public void winningLineExistsInGridNo() {
        Grid grid = new Grid();

        assertFalse(grid.winningLineExistsInGrid());
    }

    @Test
    public void lineIsWinnerYes() {
        Grid grid = new Grid();
        ArrayList<String> row1 = new ArrayList<String>
                (Arrays.asList("X", "X", "X"));

        assertTrue(grid.lineIsWinner(row1));
    }

    @Test
    public void lineIsWinnerNo() {
        Grid grid = new Grid();
        ArrayList<String> row1 = new ArrayList<String>
                (Arrays.asList(" ", "X", "X"));

        assertFalse(grid.lineIsWinner(row1));
    }

}
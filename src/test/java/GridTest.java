import org.junit.Test;

import java.util.ArrayList;

import static java.util.Arrays.*;
import static org.junit.Assert.*;

public class GridTest {

    @Test
    public void moveIsLegalYes() {
        Grid grid = new Grid();

        assertFalse(grid.moveNotLegal(0));
    }

    @Test
    public void moveIsLegalNo() {
        Grid grid = new Grid();

        grid.markSquare(0, Mark.playerOneMark);

        assertTrue(grid.moveNotLegal(0));
    }

    @Test
    public void checkSquareEmptyBeforeMarkingSquare() {
        Grid grid = new Grid();

        assertEquals(Mark.unmarkedSquare, grid.getSquares().get(0));
    }

    @Test
    public void markSquarePlayerOne() {
        Grid grid = new Grid();

        grid.markSquare(0, Mark.playerOneMark);

        assertEquals(Mark.playerOneMark, grid.getSquares().get(0));
    }

    @Test
    public void markSquarePlayerTwo() {
        Grid grid = new Grid();

        grid.markSquare(0, Mark.playerTwoMark);

        assertEquals(Mark.playerTwoMark, grid.getSquares().get(0));
    }

    @Test
    public void isFullNo() {
        Grid grid = new Grid();

        assertFalse(grid.isFull());
    }

    @Test
    public void isFullYes() {
        Grid grid = new Grid();

        for (int i = 0; i < 9; i++) {
            grid.markSquare(i, Mark.playerOneMark);
        }

        assertTrue(grid.isFull());
    }

    @Test
    public void winningLineExistsInGridYes() {
        Grid grid = new Grid();

        for (int i = 0; i < 3; i++) {
            grid.markSquare(i, Mark.playerOneMark);
        }

        assertTrue(grid.winningLineExistsInGrid());
    }

    @Test
    public void winningLineExistsInGridNo() {
        Grid grid = new Grid();

        assertFalse(grid.winningLineExistsInGrid());
    }

    @Test
    public void lineIsWinnerNo() {
        Grid grid = new Grid();
        ArrayList<Mark> row1 = new ArrayList<>
                (asList(Mark.unmarkedSquare, Mark.unmarkedSquare, Mark.unmarkedSquare));

        assertFalse(grid.lineIsWinner(row1));
    }

    @Test
    public void lineIsWinnerYes() {
        Grid grid = new Grid();
        ArrayList<Mark> row1 = new ArrayList<>
                (asList(Mark.playerOneMark, Mark.playerOneMark, Mark.playerOneMark));

        assertTrue(grid.lineIsWinner(row1));
    }

}
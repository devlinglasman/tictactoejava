import Core.Grid;
import Core.Mark;
import org.junit.Test;

import java.util.ArrayList;

import static java.util.Arrays.*;
import static org.junit.Assert.*;

public class GridTest {


    @Test
    public void moveNotLegalFalse1() {
        Grid grid = new Grid();

        assertFalse(grid.moveNotLegal(0));
    }

    @Test
    public void moveNotLegalFalse2() {
        Grid grid = new Grid();

        assertFalse(grid.moveNotLegal(8));
    }

    @Test
    public void moveNotLegalTrueOutOfRange1() {
        Grid grid = new Grid();

        assertTrue(grid.moveNotLegal(-1));
    }

    @Test
    public void moveNotLegalTrueOutOfRange2() {
        Grid grid = new Grid();

        assertTrue(grid.moveNotLegal(9));
    }

    @Test
    public void moveNotLegalTrueChoiceAlreadyMarked() {
        Grid grid = new Grid();

        grid.markSquare(0, Mark.PLAYERONEMARK);

        assertTrue(grid.moveNotLegal(0));
    }

    @Test
    public void checkSquareEmptyBeforeMarkingSquare() {
        Grid grid = new Grid();

        assertEquals(Mark.UNMARKEDSQUARE, grid.getSquares().get(0));
    }

    @Test
    public void markSquarePlayerOne() {
        Grid grid = new Grid();

        grid.markSquare(0, Mark.PLAYERONEMARK);

        assertEquals(Mark.PLAYERONEMARK, grid.getSquares().get(0));
    }

    @Test
    public void markSquarePlayerTwo() {
        Grid grid = new Grid();

        grid.markSquare(0, Mark.PLAYERTWOMARK);

        assertEquals(Mark.PLAYERTWOMARK, grid.getSquares().get(0));
    }

    @Test
    public void moveNotLegalYes() {
        Grid grid = new Grid();

        grid.markSquare(0, Mark.PLAYERONEMARK);

        assertTrue(grid.moveNotLegal(0));
    }

    @Test
    public void moveNotLegalNo() {
        Grid grid = new Grid();

        assertFalse(grid.moveNotLegal(0));
    }

    @Test
    public void emptySquareIndices() {
        Grid grid = new Grid();

        ArrayList<Integer> emptySquares = new ArrayList<>
                (asList(0,1,2,3,4,5,6,7,8));

        assertEquals(emptySquares, grid.emptySquareIndices());
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
            grid.markSquare(i, Mark.PLAYERONEMARK);
        }

        assertTrue(grid.isFull());
    }
}
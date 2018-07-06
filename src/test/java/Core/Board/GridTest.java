package Core.Board;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class GridTest {

    private Grid grid;

    @Before
    public void setUp() {
        grid = new Grid(3);
    }

    @Test
    public void moveNotLegalFalse1() {
        assertFalse(grid.moveNotLegal(0));
    }

    @Test
    public void moveNotLegalFalse2() {
        assertFalse(grid.moveNotLegal(8));
    }

    @Test
    public void moveNotLegalTrueOutOfRange1() {
        assertTrue(grid.moveNotLegal(-1));
    }

    @Test
    public void moveNotLegalTrueOutOfRange2() {
        assertTrue(grid.moveNotLegal(9));
    }

    @Test
    public void moveNotLegalTrueChoiceAlreadyMarked() {
        grid.markSquare(0, Mark.PLAYER_ONE);

        assertTrue(grid.moveNotLegal(0));
    }

    @Test
    public void checkSquareEmptyBeforeMarkingSquare() {
        assertEquals(Mark.EMPTY, grid.getSquares().get(0));
    }

    @Test
    public void markSquarePlayerOne() {
        grid.markSquare(0, Mark.PLAYER_ONE);

        assertEquals(Mark.PLAYER_ONE, grid.getSquares().get(0));
    }

    @Test
    public void markSquarePlayerTwo() {
        grid.markSquare(0, Mark.PLAYER_TWO);

        assertEquals(Mark.PLAYER_TWO, grid.getSquares().get(0));
    }

    @Test
    public void moveNotLegalYes() {
        grid.markSquare(0, Mark.PLAYER_ONE);

        assertTrue(grid.moveNotLegal(0));
    }

    @Test
    public void moveNotLegalNo() {
        assertFalse(grid.moveNotLegal(0));
    }

    @Test
    public void emptySquareIndices() {
        ArrayList<Integer> emptySquares = new ArrayList<>
                (asList(0,1,2,3,4,5,6,7,8));

        assertEquals(emptySquares, grid.emptySquareIndices());
    }

    @Test
    public void isFullNo() {
        assertFalse(grid.isFull());
    }

    @Test
    public void isFullYes() {
        for (int i = 0; i < 9; i++) {
            grid.markSquare(i, Mark.PLAYER_ONE);
        }

        assertTrue(grid.isFull());
    }
}
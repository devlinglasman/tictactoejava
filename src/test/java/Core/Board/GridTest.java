package Core.Board;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class GridTest {

    private Grid grid;

    public void setUp_withGridSize(Integer gridSize) {
        grid = new Grid(gridSize);
    }

    @Test
    public void moveNotLegalFalse1() {
        setUp_withGridSize(3);
        assertFalse(grid.moveNotLegal(0));
    }

    @Test
    public void moveNotLegalFalse2() {
        setUp_withGridSize(3);
        assertFalse(grid.moveNotLegal(8));
    }

    @Test
    public void moveNotLegalTrueOutOfRange1() {
        setUp_withGridSize(3);
        assertTrue(grid.moveNotLegal(-1));
    }

    @Test
    public void moveNotLegalTrueOutOfRange2() {
        setUp_withGridSize(3);
        assertTrue(grid.moveNotLegal(9));
    }

    @Test
    public void moveNotLegalTrueChoiceAlreadyMarked() {
        setUp_withGridSize(3);
        grid.markSquare(0, Mark.PLAYER_ONE);

        assertTrue(grid.moveNotLegal(0));
    }

    @Test
    public void checkSquareEmptyBeforeMarkingSquare() {
        setUp_withGridSize(3);
        assertEquals(Mark.EMPTY, grid.getSquares().get(0));
    }

    @Test
    public void markSquarePlayerOne() {
        setUp_withGridSize(3);
        grid.markSquare(0, Mark.PLAYER_ONE);

        assertEquals(Mark.PLAYER_ONE, grid.getSquares().get(0));
    }

    @Test
    public void markSquarePlayerTwo() {
        setUp_withGridSize(3);
        grid.markSquare(0, Mark.PLAYER_TWO);

        assertEquals(Mark.PLAYER_TWO, grid.getSquares().get(0));
    }

    @Test
    public void moveNotLegalYes() {
        setUp_withGridSize(3);
        grid.markSquare(0, Mark.PLAYER_ONE);

        assertTrue(grid.moveNotLegal(0));
    }

    @Test
    public void moveNotLegalNo() {
        setUp_withGridSize(3);
        assertFalse(grid.moveNotLegal(0));
    }

    @Test
    public void emptySquareIndices() {
        setUp_withGridSize(3);
        ArrayList<Integer> emptySquares = new ArrayList<>
                (asList(0,1,2,3,4,5,6,7,8));

        assertEquals(emptySquares, grid.emptySquareIndices());
    }

    @Test
    public void isFullNo() {
        setUp_withGridSize(3);
        assertFalse(grid.isFull());
    }

    @Test
    public void isFullYes() {
        setUp_withGridSize(3);
        for (int i = 0; i < 9; i++) {
            grid.markSquare(i, Mark.PLAYER_ONE);
        }

        assertTrue(grid.isFull());
    }

    @Test
    public void winningLineExists_midRow () {
        setUp_withGridSize(3);
        grid.markSquare(3, Mark.PLAYER_ONE);
        grid.markSquare(4, Mark.PLAYER_ONE);
        grid.markSquare(5, Mark.PLAYER_ONE);

        assertTrue(grid.winningLineExists());
    }

    @Test
    public void winningLineExists_firstCol () {
        setUp_withGridSize(3);
        grid.markSquare(0, Mark.PLAYER_ONE);
        grid.markSquare(3, Mark.PLAYER_ONE);
        grid.markSquare(6, Mark.PLAYER_ONE);

        assertTrue(grid.winningLineExists());
    }

    @Test
    public void winningLineExists_lastCol () {
        setUp_withGridSize(3);
        grid.markSquare(2, Mark.PLAYER_ONE);
        grid.markSquare(5, Mark.PLAYER_ONE);
        grid.markSquare(8, Mark.PLAYER_ONE);

        assertTrue(grid.winningLineExists());
    }

    @Test
    public void winningLineExists_midCol () {
        setUp_withGridSize(3);
        grid.markSquare(1, Mark.PLAYER_ONE);
        grid.markSquare(4, Mark.PLAYER_ONE);
        grid.markSquare(7, Mark.PLAYER_ONE);

        assertTrue(grid.winningLineExists());
    }

    @Test
    public void winningLineExists_topLeftDiag () {
        setUp_withGridSize(3);
        grid.markSquare(0, Mark.PLAYER_ONE);
        grid.markSquare(4, Mark.PLAYER_ONE);
        grid.markSquare(8, Mark.PLAYER_ONE);

        assertTrue(grid.winningLineExists());
    }

    @Test
    public void winningLineExists_topRightDiag_for3 () {
        setUp_withGridSize(3);
        grid.markSquare(2, Mark.PLAYER_ONE);
        grid.markSquare(4, Mark.PLAYER_ONE);
        grid.markSquare(6, Mark.PLAYER_ONE);

        assertTrue(grid.winningLineExists());
    }

    @Test
    public void winningLineExists_topRightDiag_for4 () {
        setUp_withGridSize(4);
        grid.markSquare(3, Mark.PLAYER_ONE);
        grid.markSquare(6, Mark.PLAYER_ONE);
        grid.markSquare(9, Mark.PLAYER_ONE);
        grid.markSquare(12, Mark.PLAYER_ONE);

        assertTrue(grid.winningLineExists());
    }
}
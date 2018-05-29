import Core.Grid;
import Core.Mark;
import org.junit.Test;

import java.util.ArrayList;

import static java.util.Arrays.*;
import static org.junit.Assert.*;

public class GridTest {

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
    public void moveNotLegalYes() {
        Grid grid = new Grid();

        grid.markSquare(0, Mark.playerOneMark);

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
            grid.markSquare(i, Mark.playerOneMark);
        }

        assertTrue(grid.isFull());
    }
//
//    @Test
//    public void winningLineExistsInGridYes() {
//        Core.Grid grid = new Core.Grid();
//
//        for (int i = 0; i < 3; i++) {
//            grid.markSquare(i, Core.Mark.playerOneMark);
//        }
//
//        assertTrue(grid.winningLineExistsInGrid());
//    }
//
//    @Test
//    public void winningLineExistsInGridNo() {
//        Core.Grid grid = new Core.Grid();
//
//        assertFalse(grid.winningLineExistsInGrid());
//    }

//    @Test
//    public void lineIsWinnerNo1() {
//        Core.Grid grid = new Core.Grid();
//        ArrayList<Core.Mark> row1 = new ArrayList<>
//                (asList(Core.Mark.unmarkedSquare, Core.Mark.unmarkedSquare, Core.Mark.unmarkedSquare));
//
//        assertFalse(grid.lineIsWinner(row1));
//    }
//
//    @Test
//    public void lineIsWinnerNo2() {
//        Core.Grid grid = new Core.Grid();
//        ArrayList<Core.Mark> row1 = new ArrayList<>
//                (asList(Core.Mark.unmarkedSquare, Core.Mark.playerOneMark, Core.Mark.playerOneMark));
//
//        assertFalse(grid.lineIsWinner(row1));
//    }
//
//    @Test
//    public void lineIsWinnerYes() {
//        Core.Grid grid = new Core.Grid();
//        ArrayList<Core.Mark> row1 = new ArrayList<>
//                (asList(Core.Mark.playerOneMark, Core.Mark.playerOneMark, Core.Mark.playerOneMark));
//
//        assertTrue(grid.lineIsWinner(row1));
//    }
}
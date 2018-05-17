import org.junit.Test;

import static org.junit.Assert.*;

public class GridTest {

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
    public void isGridFullYes() {
        Grid grid = new Grid();

        for (int i = 0; i < grid.getSquares().size(); i++) {
           grid.markSquare(i,Mark.playerOneMarkedSquare);
        }

        assertTrue(grid.isGridFull());
    }

    @Test
    public void isGridFullNo() {
        Grid grid = new Grid();

        assertFalse(grid.isGridFull());
    }
}
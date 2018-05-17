import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class MovesEvaluatorTest {

    @Test
    public void gameIsOverNo() {
        MovesEvaluator movesEvaluator = new MovesEvaluator();
        Grid grid = new Grid();

        assertFalse(movesEvaluator.gameIsOver(grid));
    }

    @Test
    public void gameIsOverYes() {
        MovesEvaluator movesEvaluator = new MovesEvaluator();
        Grid grid = new Grid();

        for (int i = 0; i < grid.getSquares().size(); i++) {
            grid.markSquare(i, Mark.playerOneMarkedSquare);
        }

        assertTrue(movesEvaluator.gameIsOver(grid));
    }

    @Test
    public void isGridFullYes() {
        MovesEvaluator movesEvaluator = new MovesEvaluator();
        Grid grid = new Grid();

        for (int i = 0; i < grid.getSquares().size(); i++) {
            grid.markSquare(i, Mark.playerOneMarkedSquare);
        }

        assertTrue(movesEvaluator.isGridFull(grid));
    }

    @Test
    public void isGridFullNo() {
        MovesEvaluator movesEvaluator = new MovesEvaluator();
        Grid grid = new Grid();

        assertFalse(movesEvaluator.isGridFull(grid));
    }

    @Test
    public void isGameWonYes() {
        MovesEvaluator movesEvaluator = new MovesEvaluator();
        Grid grid = new Grid();

        for (int i = 0; i < 3; i++) {
            grid.markSquare(i, Mark.playerOneMarkedSquare);
        }

        assertTrue(movesEvaluator.isGameWon(grid));
    }

    @Test
    public void isGameWonNo() {
        MovesEvaluator movesEvaluator = new MovesEvaluator();
        Grid grid = new Grid();

        assertFalse(movesEvaluator.isGameWon(grid));
    }

    @Test
    public void winningLineYes() {
        MovesEvaluator movesEvaluator = new MovesEvaluator();
        ArrayList<String> row1 = new ArrayList<String>
                (Arrays.asList("X", "X", "X"));

        assertTrue(movesEvaluator.winningLine(row1));
    }

    @Test
    public void winningLineNo() {
        MovesEvaluator movesEvaluator = new MovesEvaluator();
        ArrayList<String> row1 = new ArrayList<String>
                (Arrays.asList(" ", "X", "X"));

        assertFalse(movesEvaluator.winningLine(row1));
    }
}


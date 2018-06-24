package Core.Players;

import Core.Grid;
import Core.Mark;
import org.junit.Test;

import java.util.ArrayList;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class PlayerSimulatedTest {

    @Test
    public void makeMove_FirstMove() {
        Grid grid = new Grid();
        ArrayList<Integer> moves = new ArrayList<>(asList(0,1));
        Player playerOne = new PlayerSimulated("Player One", Mark.PLAYERONEMARK, moves);

        playerOne.makeMove(grid);

        assertEquals(Mark.PLAYERONEMARK, grid.getSquares().get(0));
    }

    @Test
    public void makeMove_SecondMove() {
        Grid grid = new Grid();
        ArrayList<Integer> moves = new ArrayList<>(asList(0,1));
        Player playerOne = new PlayerSimulated("Player One", Mark.PLAYERONEMARK, moves);

        playerOne.makeMove(grid);
        playerOne.makeMove(grid);

        assertEquals(Mark.PLAYERONEMARK, grid.getSquares().get(1));
    }
}

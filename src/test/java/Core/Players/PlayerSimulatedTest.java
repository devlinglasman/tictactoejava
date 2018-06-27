package Core.Players;

import Core.Grid;
import Core.Mark;
import org.junit.Test;

import java.util.ArrayList;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class PlayerSimulatedTest {

    @Test
    public void getMove_1() {
        Grid grid = new Grid();
        ArrayList<Integer> moves = new ArrayList<>(asList(0,1));
        Player playerOne = new PlayerSimulated(Mark.PLAYERONEMARK, moves);

        assertEquals(0, playerOne.getMove(grid));
    }

    @Test
    public void getMove_2() {
        Grid grid = new Grid();
        ArrayList<Integer> moves = new ArrayList<>(asList(0,1));
        Player playerOne = new PlayerSimulated(Mark.PLAYERONEMARK, moves);

        playerOne.getMove(grid);

        assertEquals(1, playerOne.getMove(grid));
    }
}

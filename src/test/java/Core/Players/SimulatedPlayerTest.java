package Core.Players;

import Core.Board.Grid;
import Core.Board.Mark;
import org.junit.Test;

import java.util.ArrayList;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class SimulatedPlayerTest {

    @Test
    public void getMove_1() {
        Grid grid = new Grid();
        ArrayList<Integer> moves = new ArrayList<>(asList(0,1));
        Player playerOne = new SimulatedPlayer(Mark.PLAYER_ONE, moves);

        assertEquals(0, playerOne.getMove(grid));
    }

    @Test
    public void getMove_2() {
        Grid grid = new Grid();
        ArrayList<Integer> moves = new ArrayList<>(asList(0,1));
        Player playerOne = new SimulatedPlayer(Mark.PLAYER_ONE, moves);

        playerOne.getMove(grid);

        assertEquals(1, playerOne.getMove(grid));
    }
}

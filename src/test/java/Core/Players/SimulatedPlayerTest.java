package Core.Players;

import Core.Board.Grid;
import Core.Board.Mark;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class SimulatedPlayerTest {

    private Grid grid;
    private Player simulatedPlayer;

    @Before
    public void setUp() {
        grid = new Grid();
        ArrayList<Integer> moves = new ArrayList<>(asList(0,1));
        simulatedPlayer = new SimulatedPlayer(Mark.PLAYER_ONE, moves);
    }

    @Test
    public void getMove_1() {
        assertEquals(0, simulatedPlayer.getMove(grid));
    }

    @Test
    public void getMove_2() {
        simulatedPlayer.getMove(grid);

        assertEquals(1, simulatedPlayer.getMove(grid));
    }
}

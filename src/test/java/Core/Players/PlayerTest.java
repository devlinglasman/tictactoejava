package Core.Players;

import Core.Mark;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class PlayerTest {

    @Test
    public void testNameGeneration_PlayerOne() {
        Player player = new ComputerPlayer(Mark.PLAYER_ONE);

        assertEquals("Player One", player.getName());
    }

    @Test
    public void testNameGeneration_PlayerTwo() {
        Player player = new ComputerPlayer(Mark.PLAYER_TWO);

        assertEquals("Player Two", player.getName());
    }
}

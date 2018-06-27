package Core.Players;

import Core.Mark;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class PlayerTest {

    @Test
    public void testNameGeneration_PlayerOne() {
        Player player = new PlayerComputer(Mark.PLAYERONEMARK);

        assertEquals("Player One", player.getName());
    }

    @Test
    public void testNameGeneration_PlayerTwo() {
        Player player = new PlayerComputer(Mark.PLAYERTWOMARK);

        assertEquals("Player Two", player.getName());
    }
}

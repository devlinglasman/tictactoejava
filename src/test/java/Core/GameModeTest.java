package Core;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameModeTest {

    @Test
    public void findGameModeUsingNumber_humanvscomp() {
        assertEquals(GameMode.HUMANVSCOMP, GameMode.findGameModeUsingNumber(1));
    }

    @Test
    public void findGameModeUsingNumber_compvscomp() {
        assertEquals(GameMode.COMPVSCOMP, GameMode.findGameModeUsingNumber(2));
    }

    @Test
    public void findGameModeUsingNumber_humanvshuman() {
        assertEquals(GameMode.HUMANVSHUMAN, GameMode.findGameModeUsingNumber(3));
    }
}

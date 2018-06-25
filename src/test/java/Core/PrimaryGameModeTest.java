package Core;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrimaryGameModeTest {

    @Test
    public void findGameModeUsingNumber_humanVsComp() {
        assertEquals(GameMode.HUMANVSCOMP, GameMode.findGameModeUsingNumber(1));
    }

    @Test
    public void findGameModeUsingNumber_compVsComp() {
        assertEquals(GameMode.COMPVSCOMP, GameMode.findGameModeUsingNumber(2));
    }

    @Test
    public void findGameModeUsingNumber_humanVsHuman() {
        assertEquals(GameMode.HUMANVSHUMAN, GameMode.findGameModeUsingNumber(3));
    }

    @Test
    public void findGameModeUsingNumber_SimulatedPlay() {
        assertEquals(GameMode.SIMULATEDPLAY, GameMode.findGameModeUsingNumber(4));
    }
}

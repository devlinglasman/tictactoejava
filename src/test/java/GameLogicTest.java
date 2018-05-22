import org.junit.Test;

import static org.junit.Assert.*;

public class GameLogicTest {

    @Test
    public void alternatePlayer1() {
        GameLogic gameLogic = new GameLogic();

        gameLogic.alternatePlayer();
        gameLogic.alternatePlayer();

        assertEquals(Player.PLAYERONE, gameLogic.getActivePlayer());
    }

    @Test
    public void alternatePlayer2() {
        GameLogic gameLogic = new GameLogic();

        gameLogic.alternatePlayer();

        assertEquals(Player.PLAYERTWO, gameLogic.getActivePlayer());
    }
}
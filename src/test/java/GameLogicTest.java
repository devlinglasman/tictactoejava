import org.junit.Test;

import static org.junit.Assert.*;

public class GameLogicTest {

    @Test
    public void convertInputToSquareNumber() {
        GameLogic gameLogic = new GameLogic();

        assertEquals(0, gameLogic.convertInputToSquareNumber("1"));
    }

    @Test
    public void gameOngoingYes() {
        GameLogic gameLogic = new GameLogic();

        assertTrue(gameLogic.gameOngoing());
    }

    @Test
    public void gameOngoingNo() {
        GameLogic gameLogic = new GameLogic();

        for (int i = 0; i < 3; i++) {
            gameLogic.getGrid().markSquare(i,Mark.playerOneMarkedSquare);
        }

        assertFalse(gameLogic.gameOngoing());
    }

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
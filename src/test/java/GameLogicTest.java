import org.junit.Test;

import static org.junit.Assert.*;

public class GameLogicTest {

    @Test
    public void markSquareX() {
        GameLogic gameLogic = new GameLogic();

        gameLogic.markSquare(0, Mark.playerOneMarkedSquare);

        assertEquals("X", gameLogic.getGridSquares().get(0));
    }

    @Test
    public void convertInputToGridSquare() {
        GameLogic gameLogic = new GameLogic();
        Validator validator = new Validator();

        assertEquals(0, gameLogic.convertInputToGridSquare(("1")));
    }

    @Test
    public void isMoveLegalYes() {
        GameLogic gameLogic = new GameLogic();

        assertTrue(gameLogic.moveIsNotLegal("1"));
    }

    @Test
    public void isMoveLegalNo() {
        GameLogic gameLogic = new GameLogic();

        gameLogic.markSquare(0, Mark.playerOneMarkedSquare);

        assertFalse(gameLogic.moveIsNotLegal("1"));
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
            gameLogic.markSquare(i, Mark.playerOneMarkedSquare);
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
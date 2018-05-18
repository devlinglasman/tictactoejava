import org.junit.Test;

import static org.junit.Assert.*;

public class GameRunnerTest {

    @Test
    public void convertInputToSquareNumber() {
        GameRunner gameRunner = new GameRunner();

        assertEquals(0, gameRunner.convertInputToSquareNumber("1"));
    }

    @Test
    public void gameOngoingYes() {
        GameRunner gameRunner = new GameRunner();

        assertTrue(gameRunner.gameOngoing());
    }

    @Test
    public void gameOngoingNo() {
        GameRunner gameRunner = new GameRunner();

        for (int i = 0; i < 3; i++) {
            gameRunner.getGrid().markSquare(i,Mark.playerOneMarkedSquare);
        }

        assertFalse(gameRunner.gameOngoing());
    }

    @Test
    public void alternatePlayer1() {
        GameRunner gameRunner = new GameRunner();

        gameRunner.alternatePlayer();
        gameRunner.alternatePlayer();

        assertEquals(Player.PLAYERONE,gameRunner.getActivePlayer());
    }

    @Test
    public void alternatePlayer2() {
        GameRunner gameRunner = new GameRunner();

        gameRunner.alternatePlayer();

        assertEquals(Player.PLAYERTWO,gameRunner.getActivePlayer());
    }
}
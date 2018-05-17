import org.junit.Test;

import static org.junit.Assert.*;

public class GameRunnerTest {

    @Test
    public void convertInputToSquareNumber() {
        GameRunner gameRunner = new GameRunner();

        assertEquals(0, gameRunner.convertInputToSquareNumber("1"));
    }

    @Test
    public void alternatePlayer1() {
        GameRunner gameRunner = new GameRunner();

        gameRunner.alternatePlayer();

        assertEquals(Player.PLAYERONE,gameRunner.getActivePlayer());
    }

    @Test
    public void alternatePlayer2() {
        GameRunner gameRunner = new GameRunner();

        gameRunner.alternatePlayer();
        gameRunner.alternatePlayer();

        assertEquals(Player.PLAYERTWO,gameRunner.getActivePlayer());
    }
}
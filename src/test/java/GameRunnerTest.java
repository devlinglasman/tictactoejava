import org.junit.Test;

import static org.junit.Assert.*;

public class GameRunnerTest {

    @Test
    public void gameOngoingYes() {
        Game game = new Game();
        GameRunner gameRunner = new GameRunner(game);

        assertEquals(true, gameRunner.gameOngoing());
    }

    @Test
    public void gameOngoingNo() {
        Game game = new Game();
        GameRunner gameRunner = new GameRunner(game);

        game.setSquareMark(0,"X");
        game.setSquareMark(1,"X");
        game.setSquareMark(2,"X");

        assertEquals(false, gameRunner.gameOngoing());
    }
}
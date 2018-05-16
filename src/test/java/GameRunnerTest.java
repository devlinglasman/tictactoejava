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

        for (int i = 0; i < 3; i++) {
            game.markSquare(game.getPlayerOne(),game.getGrid(),i);
        }

        assertEquals(false, gameRunner.gameOngoing());
    }
}
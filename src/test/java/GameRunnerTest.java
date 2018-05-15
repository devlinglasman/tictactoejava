import org.junit.Test;

import static org.junit.Assert.*;

public class GameRunnerTest {

    @Test
    public void nextCounter1() {
        Game game = new Game();
        GameRunner gameRunner = new GameRunner(game);

        assertEquals(2, gameRunner.nextCounter(1));
    }

    @Test
    public void nextCounter2() {
        Game game = new Game();
        GameRunner gameRunner = new GameRunner(game);

        assertEquals(1, gameRunner.nextCounter(2));
    }

    @Test
    public void findActivePlayer1() {
        Game game = new Game();
        GameRunner gameRunner = new GameRunner(game);

        assertEquals(1, gameRunner.findActivePlayer(1));
    }

    @Test
    public void findActivePlayer2() {
        Game game = new Game();
        GameRunner gameRunner = new GameRunner(game);

        assertEquals(2, gameRunner.findActivePlayer(2));
    }

    @Test
    public void gameOnGoingYes() {
        Game game = new Game();
        GameRunner gameRunner = new GameRunner(game);

        assertEquals(true, gameRunner.gameOngoing());
    }

    @Test
    public void gameOnGoingNo() {
        Game game = new Game();
        GameRunner gameRunner = new GameRunner(game);

        game.setSquareToX(0);
        game.setSquareToX(1);
        game.setSquareToX(2);

        assertEquals(false, gameRunner.gameOngoing());
    }
}
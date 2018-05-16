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

        assertEquals(game.getPlayerOne(), gameRunner.findActivePlayer(1));
    }

    @Test
    public void findActivePlayer2() {
        Game game = new Game();
        GameRunner gameRunner = new GameRunner(game);

        assertEquals(game.getPlayerTwo(), gameRunner.findActivePlayer(2));
    }

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
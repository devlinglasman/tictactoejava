import org.junit.Test;

import static org.junit.Assert.*;

public class GameRunnerTest {

    @Test
    public void findActivePlayer1() {
        Game game = new Game();
        Cli cli = new Cli(System.in, System.out);
        GameRunner gameRunner = new GameRunner(cli, game);

        assertEquals(1, gameRunner.findActivePlayer(1));
    }

    @Test
    public void findActivePlayer2() {
        Game game = new Game();
        Cli cli = new Cli(System.in, System.out);
        GameRunner gameRunner = new GameRunner(cli, game);

        assertEquals(2, gameRunner.findActivePlayer(2));
    }

    @Test
    public void gameOnGoingYes() {
        Game game = new Game();
        Cli cli = new Cli(System.in, System.out);
        GameRunner gameRunner = new GameRunner(cli, game);

        assertEquals(true, gameRunner.gameOnGoing());
    }

    @Test
    public void gameOnGoingNo() {
        Game game = new Game();
        Cli cli = new Cli(System.in, System.out);
        GameRunner gameRunner = new GameRunner(cli, game);

        game.setSquareToX(0);
        game.setSquareToX(1);
        game.setSquareToX(2);

        assertEquals(false, gameRunner.gameOnGoing());
    }
}
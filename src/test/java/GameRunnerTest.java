import org.junit.Test;

import static org.junit.Assert.*;

public class GameRunnerTest {

    @Test
    public void alternatePlayerOne() {
        Grid grid = new Grid();
        Validator validator = new Validator();
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(System.in, System.out);
        GameRunner gameRunner = new GameRunner(grid, validator, consoleDisplay);

        gameRunner.alternatePlayer();
        gameRunner.alternatePlayer();

        assertEquals(gameRunner.getPlayerOne(), gameRunner.getActivePlayer());
    }

    @Test
    public void alternatePlayerPlayerTwo() {
        Grid grid = new Grid();
        Validator validator = new Validator();
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(System.in, System.out);
        GameRunner gameRunner = new GameRunner(grid, validator, consoleDisplay);

        gameRunner.alternatePlayer();

        assertEquals(gameRunner.getPlayerOne(), gameRunner.getActivePlayer());
    }
}
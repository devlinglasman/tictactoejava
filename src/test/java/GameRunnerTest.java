import org.junit.Test;

import static org.junit.Assert.*;

public class GameRunnerTest {

    @Test
    public void minimaxTest1() {
        Grid grid = new Grid();
        Validator validator = new Validator();
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(System.in, System.out);
        GameRunner gameRunner = new GameRunner(grid, validator, consoleDisplay);
        Player playerOne = new Player

        grid.setASquare(0, gameRunner.getActivePlayer());
        grid.setASquare(2, gameRunner.getOpponent());
        grid.setASquare(3, gameRunner.getOpponent());
        grid.setASquare(6, gameRunner.getOpponent());
        grid.setASquare(7, gameRunner.getActivePlayer());
        grid.setASquare(8, gameRunner.getActivePlayer());

        gameRunner.alternatePlayer();

        assertEquals(4, gameRunner.getComputerInput());
    }

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
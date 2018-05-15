import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CliTest {

    @Test
    public void displayBoard() {
        Game game = new Game();
        IOHelper ioHelper = new IOHelper("");
        Cli cli = new Cli(ioHelper.in, ioHelper.print, game);

        cli.showBoard();
        assertEquals("[ ][ ][ ]\n[ ][ ][ ]\n[ ][ ][ ]\n", ioHelper.output());
    }

    @Test
    public void displayBoard2() {
        Game game = new Game();
        IOHelper ioHelper = new IOHelper("");
        Cli cli = new Cli(ioHelper.in, ioHelper.print, game);

        game.setSquareToXMark(0);
        cli.showBoard();

        assertEquals("[X][ ][ ]\n[ ][ ][ ]\n[ ][ ][ ]\n", ioHelper.output());
    }

    @Test
    public void askInputPlayerOne() {
        Game game = new Game();
        IOHelper ioHelper = new IOHelper("");
        Cli cli = new Cli(ioHelper.in, ioHelper.print, game);

        cli.askInput(1);
        assertEquals("\nHi Player 1! Please select a square from 1-9\n", ioHelper.output());
    }

    @Test
    public void askInputPlayerTwo() {
        Game game = new Game();
        IOHelper ioHelper = new IOHelper("");
        Cli cli = new Cli(ioHelper.in, ioHelper.print, game);

        cli.askInput(2);
        assertEquals("\nHi Player 2! Please select a square from 1-9\n", ioHelper.output());
    }

    @Test
    public void askGameType() {
        Game game = new Game();
        IOHelper ioHelper = new IOHelper("");
        Cli cli = new Cli(ioHelper.in, ioHelper.print, game);

        cli.askGameType();
        assertEquals("\nHi! please enter '1' to play " +
                "human-vs-human or '2' to play against the computer.\n", ioHelper.output());
    }

    @Test
    public void gameWon1() {
        Game game = new Game();
        IOHelper ioHelper = new IOHelper("");
        Cli cli = new Cli(ioHelper.in, ioHelper.print, game);

        cli.gameWon(1);

        assertEquals("Congratulations Player 1 - You're the winner!\n", ioHelper.output());
    }

    @Test
    public void gameWon2() {
        Game game = new Game();
        IOHelper ioHelper = new IOHelper("");
        Cli cli = new Cli(ioHelper.in, ioHelper.print, game);

        cli.gameWon(2);

        assertEquals("Congratulations Player 2 - You're the winner!\n", ioHelper.output());
    }
}

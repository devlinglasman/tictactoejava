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
    public void askInput() {
        Game game = new Game();
        IOHelper ioHelper = new IOHelper("");
        Cli cli = new Cli(ioHelper.in, ioHelper.print, game);

        cli.askForInput();
        assertEquals("\nHi! Please select a square from 1-9\n", ioHelper.output());
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
}

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CliTest {

    @Test
    public void displayBoard() {
        Game game = new Game();
        IOHelper ioHelper = new IOHelper("");
        Cli cli = new Cli(ioHelper.in, ioHelper.print, game);

        cli.displayBoard();
        assertEquals("[ ][ ][ ]\n[ ][ ][ ]\n[ ][ ][ ]\n", ioHelper.output());
    }

    @Test
    public void displayBoard2() {
        Game game = new Game();
        IOHelper ioHelper = new IOHelper("");
        Cli cli = new Cli(ioHelper.in, ioHelper.print, game);

        game.setSquareToX(0);
        cli.displayBoard();

        assertEquals("[X][ ][ ]\n[ ][ ][ ]\n[ ][ ][ ]\n", ioHelper.output());
    }

    @Test
    public void askInput() {
        Game game = new Game();
        IOHelper ioHelper = new IOHelper("");
        Cli cli = new Cli(ioHelper.in, ioHelper.print, game);

        cli.askInput();
        assertEquals("\nHi! Please select a square from 1-9\n", ioHelper.output());
    }

}

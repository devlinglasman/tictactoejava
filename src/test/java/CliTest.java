import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CliTest {

    @Test
    public void displayBoard() {
        Game b = new Game();
        IOHelper ioHelper = new IOHelper("");
        Cli cli = new Cli(ioHelper.in, ioHelper.print, b);

        cli.displayBoard();
        assertEquals("[ ][ ][ ]\n[ ][ ][ ]\n[ ][ ][ ]", ioHelper.output());
    }

    @Test
    public void askInput() {
        Game b = new Game();
        IOHelper ioHelper = new IOHelper("");
        Cli cli = new Cli(ioHelper.in, ioHelper.print, b);

        cli.askInput();
        assertEquals("\nHi! Please select a square from 1-9", ioHelper.output());
    }

}

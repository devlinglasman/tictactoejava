import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CliTest {

    @Test
    public void displayBoard() {
        Game game = new Game();
        IOHelper ioHelper = new IOHelper("");
        Cli cli = new Cli(ioHelper.in, ioHelper.print);

        cli.displayBoard(game.getSquares());
        assertEquals("[ ][ ][ ]\n[ ][ ][ ]\n[ ][ ][ ]\n", ioHelper.output());
    }

    @Test
    public void displayBoard2() {
        Game game = new Game();
        IOHelper ioHelper = new IOHelper("");
        Cli cli = new Cli(ioHelper.in, ioHelper.print);

        game.setSquareMark(0,"X");
        cli.displayBoard(game.getSquares());

        assertEquals("[X][ ][ ]\n[ ][ ][ ]\n[ ][ ][ ]\n", ioHelper.output());
    }

    @Test
    public void askInputPlayerOne() {
        Game game = new Game();
        IOHelper ioHelper = new IOHelper("");
        Cli cli = new Cli(ioHelper.in, ioHelper.print);

        cli.askInput(game.getPlayerOne());
        assertEquals("\nHi Player One! Please select a square from 1-9\n", ioHelper.output());
    }

    @Test
    public void askInputPlayerTwo() {
        Game game = new Game();
        IOHelper ioHelper = new IOHelper("");
        Cli cli = new Cli(ioHelper.in, ioHelper.print);

        cli.askInput(game.getPlayerTwo());
        assertEquals("\nHi Player Two! Please select a square from 1-9\n", ioHelper.output());
    }

    @Test
    public void askGameMode() {
        Game game = new Game();
        IOHelper ioHelper = new IOHelper("");
        Cli cli = new Cli(ioHelper.in, ioHelper.print);

        cli.askGameMode();
        assertEquals("\nHi! please enter '1' to play " +
                "human-vs-human or '2' to play against the computer.\n", ioHelper.output());
    }

    @Test
    public void announceWinner1() {
        Game game = new Game();
        IOHelper ioHelper = new IOHelper("");
        Cli cli = new Cli(ioHelper.in, ioHelper.print);

        cli.announceWinner(game.getPlayerOne());

        assertEquals("Congratulations Player One - You're the winner!\n", ioHelper.output());
    }

    @Test
    public void announceWinner2() {
        Game game = new Game();
        IOHelper ioHelper = new IOHelper("");
        Cli cli = new Cli(ioHelper.in, ioHelper.print);

        cli.announceWinner(game.getPlayerTwo());

        assertEquals("Congratulations Player Two - You're the winner!\n", ioHelper.output());
    }
}

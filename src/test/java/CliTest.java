import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CliTest {

    @Test
    public void displayGrid() {
        GameRunner gamerunner = new GameRunner();
        IOHelper ioHelper = new IOHelper("");
        Cli cli = new Cli(ioHelper.in, ioHelper.print,gamerunner);
        ArrayList<String> squares = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
           squares.add(" ");
        }

        cli.displayGrid(squares);
        assertEquals("[ ][ ][ ]\n[ ][ ][ ]\n[ ][ ][ ]\n", ioHelper.output());
    }

    @Test
    public void displayGrid2() {
        GameRunner gamerunner = new GameRunner();
        IOHelper ioHelper = new IOHelper("");
        Cli cli = new Cli(ioHelper.in, ioHelper.print,gamerunner);
        ArrayList<String> squares = new ArrayList<>();
        squares.add("X");
        for (int i = 0; i < 8; i++) {
            squares.add(" ");
        }

        cli.displayGrid(squares);

        assertEquals("[X][ ][ ]\n[ ][ ][ ]\n[ ][ ][ ]\n", ioHelper.output());
    }

    @Test
    public void askInputPlayerOne() {
        GameRunner gamerunner = new GameRunner();
        IOHelper ioHelper = new IOHelper("");
        Cli cli = new Cli(ioHelper.in, ioHelper.print,gamerunner);

        cli.askInput(Player.PLAYERONE);
        assertEquals("\nHi Player One! Please select a square from 1-9\n", ioHelper.output());
    }

    @Test
    public void askInputPlayerTwo() {
        GameRunner gamerunner = new GameRunner();
        IOHelper ioHelper = new IOHelper("");
        Cli cli = new Cli(ioHelper.in, ioHelper.print,gamerunner);

        cli.askInput(Player.PLAYERTWO);
        assertEquals("\nHi Player Two! Please select a square from 1-9\n", ioHelper.output());
    }

    @Test
    public void askGameMode() {
        GameRunner gamerunner = new GameRunner();
        IOHelper ioHelper = new IOHelper("");
        Cli cli = new Cli(ioHelper.in, ioHelper.print,gamerunner);

        cli.askGameMode();
        assertEquals("\nHi! please enter '1' to " +
                "play against the computer or '2' to play human-vs-human.\n", ioHelper.output());
    }

    @Test
    public void announceWinner1() {
        GameRunner gamerunner = new GameRunner();
        IOHelper ioHelper = new IOHelper("");
        Cli cli = new Cli(ioHelper.in, ioHelper.print,gamerunner);

        cli.announceWinner(Player.PLAYERONE);

        assertEquals("Congratulations Player One - You're the winner!\n", ioHelper.output());
    }

    @Test
    public void announceWinner2() {
        GameRunner gamerunner = new GameRunner();
        IOHelper ioHelper = new IOHelper("");
        Cli cli = new Cli(ioHelper.in, ioHelper.print,gamerunner);

        cli.announceWinner(Player.PLAYERTWO);

        assertEquals("Congratulations Player Two - You're the winner!\n", ioHelper.output());
    }
}

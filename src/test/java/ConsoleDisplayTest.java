import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ConsoleDisplayTest {

    @Test
    public void displayGrid() {
        IOHelper ioHelper = new IOHelper("");
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(ioHelper.in, ioHelper.print);

        ArrayList<String> squares = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            squares.add(" ");
        }

        consoleDisplay.displayGrid(squares);

        assertEquals("[ ][ ][ ]\n[ ][ ][ ]\n[ ][ ][ ]\n", ioHelper.output());
    }

    @Test
    public void displayGrid2() {
        IOHelper ioHelper = new IOHelper("");
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(ioHelper.in, ioHelper.print);

        ArrayList<String> squares = new ArrayList<>();
        squares.add("X");
        for (int i = 0; i < 8; i++) {
            squares.add(" ");
        }

        consoleDisplay.displayGrid(squares);

        assertEquals("[ ][ ][ ]\n[ ][ ][ ]\n[ ][ ][ ]\n", ioHelper.output());
    }

    @Test
    public void askForInput() {
        IOHelper ioHelper = new IOHelper("");
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(ioHelper.in, ioHelper.print);

        consoleDisplay.askForInput(Player.PLAYERONE);

        assertEquals("\nHi Player One! Please select a square from 1-9\n", ioHelper.output());
    }

    @Test
    public void askGameMode() {
        IOHelper ioHelper = new IOHelper("");
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(ioHelper.in, ioHelper.print);

        consoleDisplay.askGameMode();

        assertEquals("\nHi! please enter '1' to " +
                "play against the computer or '2' to play human-vs-human.\n", ioHelper.output());
    }

    @Test
    public void announceWinner() {
        IOHelper ioHelper = new IOHelper("");
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(ioHelper.in, ioHelper.print);

        consoleDisplay.announceWinner(Player.PLAYERONE);

        assertEquals("Congratulations Player One - You're the winner!\n", ioHelper.output());
    }

    @Test
    public void announceComputerTurn() {
        IOHelper ioHelper = new IOHelper("");
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(ioHelper.in, ioHelper.print);

        consoleDisplay.announceComputerTurn();

        assertEquals("computer chooses...\n", ioHelper.output());

    }
}
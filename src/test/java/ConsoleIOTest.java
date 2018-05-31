import Console.ConsoleIO;
import Core.Mark;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ConsoleIOTest {

    @Test
    public void displayGrid() {
        IOHelper ioHelper = new IOHelper("");
        ConsoleIO consoleIO = new ConsoleIO(ioHelper.in, ioHelper.print);

        ArrayList<Mark> squares = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            squares.add(Mark.unmarkedSquare);
        }

        consoleIO.displayGrid(squares);

        assertEquals("\n[ ][ ][ ]\n[ ][ ][ ]\n[ ][ ][ ]\n", ioHelper.output());
    }

    @Test
    public void displayGrid2() {
        IOHelper ioHelper = new IOHelper("");
        ConsoleIO consoleIO = new ConsoleIO(ioHelper.in, ioHelper.print);

        ArrayList<Mark> squares = new ArrayList<>();
        squares.add(Mark.playerOneMark);
        for (int i = 0; i < 8; i++) {
            squares.add(Mark.unmarkedSquare);
        }

        consoleIO.displayGrid(squares);

        assertEquals("\n[X][ ][ ]\n[ ][ ][ ]\n[ ][ ][ ]\n", ioHelper.output());
    }

    @Test
    public void askGameMode() {
        IOHelper ioHelper = new IOHelper("");
        ConsoleIO consoleIO = new ConsoleIO(ioHelper.in, ioHelper.print);

        consoleIO.askGameMode();

        assertEquals("\nHi! please enter '1' to " +
                "play against the computer, '2' to see computer-vs-computer," +
                " or '3' for human-vs-human.\n", ioHelper.output());
    }

    @Test
    public void announceSquareChoice() {
        IOHelper ioHelper = new IOHelper("");
        ConsoleIO consoleIO = new ConsoleIO(ioHelper.in, ioHelper.print);

        consoleIO.announceSquareChoice("Core.Players.Player One");

        assertEquals("\nCore.Players.Player One picked...\n", ioHelper.output());
    }

    @Test
    public void announceGameChoiceInvalid() {
        IOHelper ioHelper = new IOHelper("");
        ConsoleIO consoleIO = new ConsoleIO(ioHelper.in, ioHelper.print);

        consoleIO.announceGameChoiceInvalid();

        assertEquals("\nUhoh please make a valid choice, 1 or 2.\n", ioHelper.output());
    }

    @Test
    public void askForSquareChoice() {
        IOHelper ioHelper = new IOHelper("");
        ConsoleIO consoleIO = new ConsoleIO(ioHelper.in, ioHelper.print);

        consoleIO.askForSquareChoice("Core.Players.Player One");

        assertEquals("\nCore.Players.Player One please select a square from 1-9.\n", ioHelper.output());
    }

    @Test
    public void announceInputInvalid() {
        IOHelper ioHelper = new IOHelper("");
        ConsoleIO consoleIO = new ConsoleIO(ioHelper.in, ioHelper.print);

        consoleIO.announceInputInvalid("Core.Players.Player One");

        assertEquals("\nLooks like Core.Players.Player One made a boo-boo! Please enter a number from 1-9 that hasn't already been picked.\n", ioHelper.output());

    }

    @Test
    public void announceWinner() {
        IOHelper ioHelper = new IOHelper("");
        ConsoleIO consoleIO = new ConsoleIO(ioHelper.in, ioHelper.print);

        consoleIO.announceWinner("Core.Players.Player One");

        assertEquals("\nCongratulations Core.Players.Player One - You're the winner!\n", ioHelper.output());
    }

    @Test
    public void announceGameTied() {
        IOHelper ioHelper = new IOHelper("");
        ConsoleIO consoleIO = new ConsoleIO(ioHelper.in, ioHelper.print);

        consoleIO.announceGameTied();

        assertEquals("\nLooks like the game was a tie!\n", ioHelper.output());
    }
}
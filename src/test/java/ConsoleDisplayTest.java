import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ConsoleDisplayTest {

    @Test
    public void displayGrid() {
        IOHelper ioHelper = new IOHelper("");
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(ioHelper.in, ioHelper.print);

        ArrayList<Mark> squares = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            squares.add(Mark.unmarkedSquare);
        }

        consoleDisplay.displayGrid(squares);

        assertEquals("\n[ ][ ][ ]\n[ ][ ][ ]\n[ ][ ][ ]\n", ioHelper.output());
    }

    @Test
    public void displayGrid2() {
        IOHelper ioHelper = new IOHelper("");
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(ioHelper.in, ioHelper.print);

        ArrayList<Mark> squares = new ArrayList<>();
        squares.add(Mark.playerOneMark);
        for (int i = 0; i < 8; i++) {
            squares.add(Mark.unmarkedSquare);
        }

        consoleDisplay.displayGrid(squares);

        assertEquals("\n[X][ ][ ]\n[ ][ ][ ]\n[ ][ ][ ]\n", ioHelper.output());
    }

    @Test
    public void askForSquareChoice() {
        IOHelper ioHelper = new IOHelper("");
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(ioHelper.in, ioHelper.print);

        consoleDisplay.askForSquareChoice(Player.PLAYERONE);

        assertEquals("\nPlayer One please select a square from 1-9.\n", ioHelper.output());
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
    public void announceInputInvalid() {
        IOHelper ioHelper = new IOHelper("");
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(ioHelper.in, ioHelper.print);

        consoleDisplay.announceInputInvalid();

        assertEquals("\nLooks like you made a boo-boo! Please enter a number from 1-9 that hasn't already been picked.\n", ioHelper.output());

    }

    @Test
    public void announceWinner() {
        IOHelper ioHelper = new IOHelper("");
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(ioHelper.in, ioHelper.print);

        consoleDisplay.announceWinner(Player.PLAYERONE);

        assertEquals("\nCongratulations Player One - You're the winner!\n", ioHelper.output());
    }

    @Test
    public void announceGameTied() {
        IOHelper ioHelper = new IOHelper("");
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(ioHelper.in, ioHelper.print);

        consoleDisplay.announceGameTied();

        assertEquals("\nLooks like the game was a tie!\n", ioHelper.output());
    }

    @Test
    public void announceComputerTurn() {
        IOHelper ioHelper = new IOHelper("");
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(ioHelper.in, ioHelper.print);

        consoleDisplay.announceComputerTurn();

        assertEquals("\nComputer chooses...\n", ioHelper.output());
    }

    @Test
    public void announceHumanSquareChoice() {
        IOHelper ioHelper = new IOHelper("");
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(ioHelper.in, ioHelper.print);

        consoleDisplay.announceHumanSquareChoice();

        assertEquals("\nThanks! You picked...\n", ioHelper.output());
    }



}
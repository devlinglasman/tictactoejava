import Console.ConsoleUI;
import Core.Mark;
import org.junit.Test;

import java.util.ArrayList;

import static Console.ConsoleUI.*;
import static org.junit.Assert.*;

public class ConsoleUITest {

    @Test
    public void displayGrid() {
        IOHelper ioHelper = new IOHelper("");
        ConsoleUI consoleUI = new ConsoleUI(ioHelper.in, ioHelper.print);

        ArrayList<Mark> squares = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            squares.add(Mark.unmarkedSquare);
        }
        consoleUI.displayGrid(squares);

        assertEquals("\n" + (ANSI_BRIGHTYELLOW + "[1]" + ANSI_RESET) + (ANSI_BRIGHTRED + "[2]" + ANSI_RESET) +
                (ANSI_BRIGHTPURPLE + "[3]" + ANSI_RESET) + "\n" + (ANSI_BRIGHTRED + "[4]" + ANSI_RESET) +
                (ANSI_BRIGHTPURPLE + "[5]" + ANSI_RESET) + (ANSI_BRIGHTBLUE + "[6]" + ANSI_RESET) +"\n" +
                (ANSI_BRIGHTPURPLE + "[7]" + ANSI_RESET) + (ANSI_BRIGHTBLUE + "[8]" + ANSI_RESET) +
                        (ANSI_BRIGHTGREEN + "[9]" + ANSI_RESET + "\n"), ioHelper.output());
    }

    @Test
    public void displayGrid2() {
        IOHelper ioHelper = new IOHelper("");
        ConsoleUI consoleUI = new ConsoleUI(ioHelper.in, ioHelper.print);

        ArrayList<Mark> squares = new ArrayList<>();
        squares.add(Mark.playerOneMark);
        for (int i = 0; i < 8; i++) {
            squares.add(Mark.unmarkedSquare);
        }

        consoleUI.displayGrid(squares);

        assertEquals("\n" + (ANSI_BRIGHTBLACK + "[X]" + ANSI_RESET) + (ANSI_BRIGHTRED + "[2]" + ANSI_RESET) +
                (ANSI_BRIGHTPURPLE + "[3]" + ANSI_RESET) + "\n" + (ANSI_BRIGHTRED + "[4]" + ANSI_RESET) +
                (ANSI_BRIGHTPURPLE + "[5]" + ANSI_RESET) + (ANSI_BRIGHTBLUE + "[6]" + ANSI_RESET) +"\n" +
                (ANSI_BRIGHTPURPLE + "[7]" + ANSI_RESET) + (ANSI_BRIGHTBLUE + "[8]" + ANSI_RESET) +
                        (ANSI_BRIGHTGREEN + "[9]" + ANSI_RESET + "\n"), ioHelper.output());
    }

    @Test
    public void askGameMode() {
        IOHelper ioHelper = new IOHelper("");
        ConsoleUI consoleUI = new ConsoleUI(ioHelper.in, ioHelper.print);

        consoleUI.askGameMode();

        assertEquals("\nHi! please enter '1' to " +
                "play against the computer, '2' to see computer-vs-computer," +
                " or '3' for human-vs-human.\n", ioHelper.output());
    }

    @Test
    public void announceSquareChoiceMessage() {
        IOHelper ioHelper = new IOHelper("");
        ConsoleUI consoleUI = new ConsoleUI(ioHelper.in, ioHelper.print);

        consoleUI.announceSquareChoiceMessage("Player One");

        assertEquals("\nPlayer One picked...\n", ioHelper.output());
    }

    @Test
    public void announceGameChoiceInvalid() {
        IOHelper ioHelper = new IOHelper("");
        ConsoleUI consoleUI = new ConsoleUI(ioHelper.in, ioHelper.print);

        consoleUI.announceGameModeChoiceInvalid();

        assertEquals("\nUhoh please make a valid choice, 1 or 2.\n", ioHelper.output());
    }

    @Test
    public void askForSquareChoice() {
        IOHelper ioHelper = new IOHelper("");
        ConsoleUI consoleUI = new ConsoleUI(ioHelper.in, ioHelper.print);

        consoleUI.askSquareChoice("Player One");

        assertEquals("\nPlayer One please select a square from 1-9.\n", ioHelper.output());
    }

    @Test
    public void announceInputInvalid() {
        IOHelper ioHelper = new IOHelper("");
        ConsoleUI consoleUI = new ConsoleUI(ioHelper.in, ioHelper.print);

        consoleUI.announceSquareChoiceInvalid("Player One");

        assertEquals("\nLooks like Player One made a boo-boo! Please enter a number from 1-9 that hasn't already been picked.\n", ioHelper.output());

    }

    @Test
    public void announceWinner() {
        IOHelper ioHelper = new IOHelper("");
        ConsoleUI consoleUI = new ConsoleUI(ioHelper.in, ioHelper.print);

        consoleUI.announceWinner("Player One");

        assertEquals("\nCongratulations Player One - You're the winner!\n", ioHelper.output());
    }

    @Test
    public void announceGameTied() {
        IOHelper ioHelper = new IOHelper("");
        ConsoleUI consoleUI = new ConsoleUI(ioHelper.in, ioHelper.print);

        consoleUI.announceTie();

        assertEquals("\nLooks like the game was a tie!\n", ioHelper.output());
    }
}
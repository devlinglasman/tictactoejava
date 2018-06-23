import Console.ConsoleUI;
import Core.Grid;
import Core.Mark;
import Core.Players.Player;
import Core.Players.PlayerHuman;
import org.junit.Test;

import java.util.ArrayList;

import static Console.ConsoleUI.*;
import static org.junit.Assert.*;

public class ConsoleUITest {

    @Test
    public void askGameMode() {
        IOHelper ioHelper = new IOHelper("");
        ConsoleUI consoleUI = new ConsoleUI(IOHelper.in, IOHelper.print, 1);

        consoleUI.askGameMode();

        assertEquals("\nHi! please enter '1' to " +
                "play against the computer, '2' to see computer-vs-computer," +
                " or '3' for human-vs-human.\n", ioHelper.output());
    }

    @Test
    public void announceNumberNotValid() {
        IOHelper ioHelper = new IOHelper("");
        ConsoleUI consoleUI = new ConsoleUI(IOHelper.in, IOHelper.print, 1);

        consoleUI.announceNumberNotValid();

        assertEquals("\nNow, that's not a valid number, is it! Try again!\n", ioHelper.output());
    }

    @Test
    public void getValidNumber_ValidAttempt1() {
        new IOHelper("1");
        ConsoleUI consoleUI = new ConsoleUI(IOHelper.in, IOHelper.print, 1);

        assertEquals(1, consoleUI.getValidNumber());
    }

    @Test
    public void getValidNumber_ValidAttempt2() {
        new IOHelper("123098457");
        ConsoleUI consoleUI = new ConsoleUI(IOHelper.in, IOHelper.print, 1);

        assertEquals(123098457, consoleUI.getValidNumber());
    }

    @Test
    public void getValidNumber_InvalidAttemptNotNumber() {
        new IOHelper("asdf\n1");
        ConsoleUI consoleUI = new ConsoleUI(IOHelper.in, IOHelper.print, 1);

        assertEquals(1, consoleUI.getValidNumber());
    }

    @Test
    public void getValidNumber_InvalidAttemptNotInteger() {
        new IOHelper("1.1\n1");
        ConsoleUI consoleUI = new ConsoleUI(IOHelper.in, IOHelper.print, 1);

        assertEquals(1, consoleUI.getValidNumber());
    }

    @Test
    public void announceGameChoiceInvalid() {
        IOHelper ioHelper = new IOHelper("");
        ConsoleUI consoleUI = new ConsoleUI(IOHelper.in, IOHelper.print, 1);

        consoleUI.announceGameModeChoiceInvalid();

        assertEquals("\nUhoh please make a valid game mode selection...\n", ioHelper.output());
    }

    @Test
    public void displayGrid() {
        IOHelper ioHelper = new IOHelper("");
        ConsoleUI consoleUI = new ConsoleUI(IOHelper.in, IOHelper.print, 1);

        ArrayList<Mark> squares = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            squares.add(Mark.UNMARKEDSQUARE);
        }
        consoleUI.displayGrid(squares);

        assertEquals("\n" + (ANSI_BRIGHTYELLOW + "[1]" + ANSI_RESET) + (ANSI_BRIGHTRED + "[2]" + ANSI_RESET) +
                (ANSI_BRIGHTPURPLE + "[3]" + ANSI_RESET) + "\n" + (ANSI_BRIGHTRED + "[4]" + ANSI_RESET) +
                (ANSI_BRIGHTPURPLE + "[5]" + ANSI_RESET) + (ANSI_BRIGHTBLUE + "[6]" + ANSI_RESET) + "\n" +
                (ANSI_BRIGHTPURPLE + "[7]" + ANSI_RESET) + (ANSI_BRIGHTBLUE + "[8]" + ANSI_RESET) +
                (ANSI_BRIGHTGREEN + "[9]" + ANSI_RESET + "\n"), ioHelper.output());
    }

    @Test
    public void displayGrid2() {
        IOHelper ioHelper = new IOHelper("");
        ConsoleUI consoleUI = new ConsoleUI(IOHelper.in, IOHelper.print, 1);

        ArrayList<Mark> squares = new ArrayList<>();
        squares.add(Mark.PLAYERONEMARK);
        for (int i = 0; i < 8; i++) {
            squares.add(Mark.UNMARKEDSQUARE);
        }

        consoleUI.displayGrid(squares);

        assertEquals("\n" + (ANSI_BRIGHTBLACK + "[X]" + ANSI_RESET) + (ANSI_BRIGHTRED + "[2]" + ANSI_RESET) +
                (ANSI_BRIGHTPURPLE + "[3]" + ANSI_RESET) + "\n" + (ANSI_BRIGHTRED + "[4]" + ANSI_RESET) +
                (ANSI_BRIGHTPURPLE + "[5]" + ANSI_RESET) + (ANSI_BRIGHTBLUE + "[6]" + ANSI_RESET) + "\n" +
                (ANSI_BRIGHTPURPLE + "[7]" + ANSI_RESET) + (ANSI_BRIGHTBLUE + "[8]" + ANSI_RESET) +
                (ANSI_BRIGHTGREEN + "[9]" + ANSI_RESET + "\n"), ioHelper.output());
    }

    @Test
    public void askForSquareChoice() {
        IOHelper ioHelper = new IOHelper("");
        ConsoleUI consoleUI = new ConsoleUI(IOHelper.in, IOHelper.print, 1);
        Player playerOne = new PlayerHuman("Player One", Mark.PLAYERONEMARK, consoleUI);

        consoleUI.askSquareChoice(playerOne);

        assertEquals("\nPlayer One please select a square from 1-9.\n", ioHelper.output());
    }

    @Test
    public void announceInputInvalid() {
        IOHelper ioHelper = new IOHelper("");
        ConsoleUI consoleUI = new ConsoleUI(IOHelper.in, IOHelper.print, 1);
        Player playerOne = new PlayerHuman("Player One", Mark.PLAYERONEMARK, consoleUI);

        consoleUI.announceSquareChoiceInvalid(playerOne);

        assertEquals("\nLooks like Player One made a boo-boo! " +
                "Please enter a valid number that hasn't already been picked.\n", ioHelper.output());

    }

    @Test
    public void presentMove() {
        IOHelper ioHelper = new IOHelper("");
        ConsoleUI consoleUI = new ConsoleUI(IOHelper.in, IOHelper.print, 1);
        Grid grid = new Grid();
        Player playerOne = new PlayerHuman("Player One", Mark.PLAYERONEMARK, consoleUI);

        consoleUI.presentMove(playerOne, grid);

        assertEquals("\033[H\033[2J\nPlayer One picked...\n", ioHelper.output());
    }

    @Test
    public void announceSquareChoice() {
        IOHelper ioHelper = new IOHelper("");
        ConsoleUI consoleUI = new ConsoleUI(IOHelper.in, IOHelper.print, 1);
        Player playerOne = new PlayerHuman("Player One", Mark.PLAYERONEMARK, consoleUI);

        consoleUI.announceSquareChoice(playerOne);

        assertEquals("\nPlayer One picked...\n", ioHelper.output());

    }

    @Test
    public void announceGameTied() {
        IOHelper ioHelper = new IOHelper("");
        ConsoleUI consoleUI = new ConsoleUI(IOHelper.in, IOHelper.print, 1);

        consoleUI.announceTie();

        assertEquals("\nLooks like the game was a tie!\n", ioHelper.output());
    }

    @Test
    public void announceWinner() {
        IOHelper ioHelper = new IOHelper("");
        ConsoleUI consoleUI = new ConsoleUI(IOHelper.in, IOHelper.print, 1);
        Player playerOne = new PlayerHuman("Player One", Mark.PLAYERONEMARK, consoleUI);

        consoleUI.announceWinner(playerOne);

        assertEquals("\nCongratulations Player One - You're the winner!\n", ioHelper.output());
    }

}
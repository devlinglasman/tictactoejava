package Console;

import Core.*;
import Core.Players.Player;
import Core.Players.PlayerHuman;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static Console.ConsoleUI.*;
import static org.junit.Assert.*;

public class ConsoleUITest {

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
    public void presentMessage() {
        IOHelper ioHelper = new IOHelper("");
        ConsoleUI consoleUI = new ConsoleUI(IOHelper.in, IOHelper.print, 1);

        consoleUI.presentMessage(Message.announceGameModeChoiceInvalid);

        Assert.assertEquals("\nUhoh please make a valid game mode selection...\n", ioHelper.output());
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

        Assert.assertEquals("\n" + (ANSI_BRIGHTYELLOW + "[1]" + ANSI_RESET) + (ANSI_BRIGHTRED + "[2]" + ANSI_RESET) +
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

        Assert.assertEquals("\n" + (ANSI_BRIGHTBLACK + "[X]" + ANSI_RESET) + (ANSI_BRIGHTRED + "[2]" + ANSI_RESET) +
                (ANSI_BRIGHTPURPLE + "[3]" + ANSI_RESET) + "\n" + (ANSI_BRIGHTRED + "[4]" + ANSI_RESET) +
                (ANSI_BRIGHTPURPLE + "[5]" + ANSI_RESET) + (ANSI_BRIGHTBLUE + "[6]" + ANSI_RESET) + "\n" +
                (ANSI_BRIGHTPURPLE + "[7]" + ANSI_RESET) + (ANSI_BRIGHTBLUE + "[8]" + ANSI_RESET) +
                (ANSI_BRIGHTGREEN + "[9]" + ANSI_RESET + "\n"), ioHelper.output());
    }

    @Test
    public void presentMove() {
        IOHelper ioHelper = new IOHelper("");
        UI ui = new ConsoleUI(IOHelper.in, IOHelper.print, 1);
        Communicator communicator = new Communicator(ui);
        Grid grid = new Grid();
        Player playerOne = new PlayerHuman("Player One", Mark.PLAYERONEMARK, communicator);

        communicator.presentMove(playerOne, grid);

        Assert.assertEquals("\033[H\033[2J\nPlayer One picked...\n", ioHelper.output());
    }
}


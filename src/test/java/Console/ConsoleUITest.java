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
    public void clearScreen() {
        IOHelper ioHelper = new IOHelper("");
        ConsoleUI consoleUI = new ConsoleUI(IOHelper.in, IOHelper.print, 1);

        consoleUI.clearScreen();

        Assert.assertEquals("\033[H\033[2J", ioHelper.output());
    }
}


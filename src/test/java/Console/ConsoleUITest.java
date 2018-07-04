package Console;

import Core.Board.Mark;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static Console.ConsoleUI.*;

public class ConsoleUITest {


    @Test
    public void presentMessage() {
        IOHelper ioHelper = new IOHelper("");
        ConsoleUI consoleUI = new ConsoleUI(ioHelper.in, ioHelper.print, 0);

        consoleUI.presentMessage("This prints a String.");

        Assert.assertEquals("This prints a String.", ioHelper.output());
    }

    @Test
    public void displayGrid_allUnmarkedSquares() {
        IOHelper ioHelper = new IOHelper("");
        ConsoleUI consoleUI = new ConsoleUI(ioHelper.in, ioHelper.print, 0);

        List<Mark> squares = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            squares.add(Mark.EMPTY);
        }
        consoleUI.displayGrid(squares);

        Assert.assertEquals("\n" + (ANSI_BRIGHTYELLOW + "[1]" + ANSI_RESET) +
                (ANSI_BRIGHTRED + "[2]" + ANSI_RESET) + (ANSI_BRIGHTPURPLE + "[3]" +
                ANSI_RESET) + "\n" + (ANSI_BRIGHTRED + "[4]" + ANSI_RESET) +
                (ANSI_BRIGHTPURPLE + "[5]" + ANSI_RESET) + (ANSI_BRIGHTBLUE + "[6]" +
                ANSI_RESET) + "\n" + (ANSI_BRIGHTPURPLE + "[7]" + ANSI_RESET) +
                (ANSI_BRIGHTBLUE + "[8]" + ANSI_RESET) + (ANSI_BRIGHTGREEN + "[9]"
                + ANSI_RESET + "\n"), ioHelper.output());
    }

    @Test
    public void displayGrid_firstSquarePlayerOneMark() {
        IOHelper ioHelper = new IOHelper("");
        ConsoleUI consoleUI = new ConsoleUI(ioHelper.in, ioHelper.print, 0);

        List<Mark> squares = new ArrayList<>();
        squares.add(Mark.PLAYER_ONE);
        for (int i = 0; i < 8; i++) {
            squares.add(Mark.EMPTY);
        }

        consoleUI.displayGrid(squares);

        Assert.assertEquals("\n" + (ANSI_BRIGHTBLACK + "[" +
                Mark.PLAYER_ONE.getStringRepresentation() + "]" + ANSI_RESET)
                + (ANSI_BRIGHTRED + "[2]" + ANSI_RESET) + (ANSI_BRIGHTPURPLE +
                "[3]" + ANSI_RESET) + "\n" + (ANSI_BRIGHTRED + "[4]" + ANSI_RESET) +
                (ANSI_BRIGHTPURPLE + "[5]" + ANSI_RESET) + (ANSI_BRIGHTBLUE +
                "[6]" + ANSI_RESET) + "\n" + (ANSI_BRIGHTPURPLE + "[7]" + ANSI_RESET)
                + (ANSI_BRIGHTBLUE + "[8]" + ANSI_RESET) + (ANSI_BRIGHTGREEN + "[9]"
                + ANSI_RESET + "\n"), ioHelper.output());
    }

    @Test
    public void displayGrid_secondSquarePlayerTwoMark() {
        IOHelper ioHelper = new IOHelper("");
        ConsoleUI consoleUI = new ConsoleUI(ioHelper.in, ioHelper.print, 0);

        List<Mark> squares = new ArrayList<>();
        squares.add(Mark.EMPTY);
        squares.add(Mark.PLAYER_TWO);
        for (int i = 0; i < 7; i++) {
            squares.add(Mark.EMPTY);
        }

        consoleUI.displayGrid(squares);

        Assert.assertEquals("\n" + (ANSI_BRIGHTYELLOW + "[1]" + ANSI_RESET)
                + (ANSI_BRIGHTWHITE + "[" + Mark.PLAYER_TWO.getStringRepresentation()
                + "]" + ANSI_RESET) + (ANSI_BRIGHTPURPLE + "[3]" + ANSI_RESET) + "\n"
                + (ANSI_BRIGHTRED + "[4]" + ANSI_RESET) + (ANSI_BRIGHTPURPLE + "[5]"
                + ANSI_RESET) + (ANSI_BRIGHTBLUE + "[6]" + ANSI_RESET) + "\n" +
                (ANSI_BRIGHTPURPLE + "[7]" + ANSI_RESET) + (ANSI_BRIGHTBLUE + "[8]" + ANSI_RESET) +
                (ANSI_BRIGHTGREEN + "[9]" + ANSI_RESET + "\n"), ioHelper.output());
    }
    @Test
    public void clearScreen_onMac() {
        IOHelper ioHelper = new IOHelper("");
        ConsoleUI consoleUI = new ConsoleUI(ioHelper.in, ioHelper.print, 0);

        consoleUI.clearScreen();

        Assert.assertEquals("\033[H\033[2J", ioHelper.output());
    }
}


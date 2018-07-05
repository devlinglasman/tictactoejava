package Console;

import Core.Board.Mark;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static Console.ConsoleUI.*;

public class ConsoleUITest {

    private IOHelper ioHelper;
    private ConsoleUI consoleUI;
    private List<Mark> expectedGridSquares;

    @Before
    public void setUp() {
        ioHelper = new IOHelper("");
        consoleUI = new ConsoleUI(ioHelper.in, ioHelper.print, 0);

        expectedGridSquares = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            expectedGridSquares.add(Mark.EMPTY);
        }
    }

    @Test
    public void presentMessage() {
        consoleUI.presentMessage("This prints a String.");

        Assert.assertEquals("This prints a String.", ioHelper.output());
    }

    @Test
    public void displayGrid_allUnmarkedSquares() {
        consoleUI.displayGrid(expectedGridSquares);

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
        expectedGridSquares.set(0, Mark.PLAYER_ONE);

        consoleUI.displayGrid(expectedGridSquares);


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
        expectedGridSquares.set(1, Mark.PLAYER_TWO);

        consoleUI.displayGrid(expectedGridSquares);

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
        consoleUI.clearScreen();

        Assert.assertEquals("\033[H\033[2J", ioHelper.output());
    }
}


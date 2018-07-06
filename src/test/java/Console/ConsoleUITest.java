package Console;

import Core.Board.Grid;
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
    private Grid grid;

    public void setUp_withGridSize(Integer gridSize) {
        ioHelper = new IOHelper("");
        consoleUI = new ConsoleUI(ioHelper.in, ioHelper.print, 0);
        grid = new Grid(gridSize);
    }

    @Test
    public void presentMessage() {
        setUp_withGridSize(3);
        consoleUI.presentMessage("This prints a String.");

        Assert.assertEquals("This prints a String.", ioHelper.output());
    }

    @Test
    public void displayGrid_allUnmarkedSquares() {
        setUp_withGridSize(3);
        consoleUI.displayGrid(grid);

        Assert.assertEquals("\n" + (ANSI_BRIGHTPURPLE + "[1]" + ANSI_RESET + " ") +
                (ANSI_BRIGHTPURPLE + "[2]" + ANSI_RESET + " ") + (ANSI_BRIGHTPURPLE + "[3]" +
                ANSI_RESET + " ") + "\n" + (ANSI_BRIGHTPURPLE + "[4]" + ANSI_RESET + " ") +
                (ANSI_BRIGHTPURPLE + "[5]" + ANSI_RESET + " ") + (ANSI_BRIGHTPURPLE + "[6]" +
                ANSI_RESET + " ") + "\n" + (ANSI_BRIGHTPURPLE + "[7]" + ANSI_RESET + " ") +
                (ANSI_BRIGHTPURPLE + "[8]" + ANSI_RESET + " ") + (ANSI_BRIGHTPURPLE + "[9]"
                + ANSI_RESET + " " + "\n"), ioHelper.output());
    }

    @Test
    public void displayGrid_firstSquarePlayerOneMark() {
        setUp_withGridSize(3);
        grid.markSquare(0, Mark.PLAYER_ONE);

        consoleUI.displayGrid(grid);


        Assert.assertEquals("\n" + (ANSI_BRIGHTBLACK + "[" +
                Mark.PLAYER_ONE.getStringRepresentation() + "]" + ANSI_RESET + " ") +
                (ANSI_BRIGHTPURPLE + "[2]" + ANSI_RESET + " ") + (ANSI_BRIGHTPURPLE + "[3]" +
                ANSI_RESET + " ") + "\n" + (ANSI_BRIGHTPURPLE + "[4]" + ANSI_RESET + " ") +
                (ANSI_BRIGHTPURPLE + "[5]" + ANSI_RESET + " ") + (ANSI_BRIGHTPURPLE + "[6]" +
                ANSI_RESET + " ") + "\n" + (ANSI_BRIGHTPURPLE + "[7]" + ANSI_RESET + " ") +
                (ANSI_BRIGHTPURPLE + "[8]" + ANSI_RESET + " ") + (ANSI_BRIGHTPURPLE + "[9]"
                + ANSI_RESET + " " + "\n"), ioHelper.output());
    }

    @Test
    public void displayGrid_secondSquarePlayerTwoMark() {
        setUp_withGridSize(3);
        grid.markSquare(1, Mark.PLAYER_TWO);

        consoleUI.displayGrid(grid);

        Assert.assertEquals("\n" + (ANSI_BRIGHTPURPLE + "[1]" + ANSI_RESET + " ") +
                (ANSI_BRIGHTWHITE + "[" + Mark.PLAYER_TWO.getStringRepresentation() +
                        "]" + ANSI_RESET + " ") + (ANSI_BRIGHTPURPLE + "[3]" +
                ANSI_RESET + " ") + "\n" + (ANSI_BRIGHTPURPLE + "[4]" + ANSI_RESET + " ") +
                (ANSI_BRIGHTPURPLE + "[5]" + ANSI_RESET + " ") + (ANSI_BRIGHTPURPLE + "[6]" +
                ANSI_RESET + " ") + "\n" + (ANSI_BRIGHTPURPLE + "[7]" + ANSI_RESET + " ") +
                (ANSI_BRIGHTPURPLE + "[8]" + ANSI_RESET + " ") + (ANSI_BRIGHTPURPLE + "[9]"
                + ANSI_RESET + " " + "\n"), ioHelper.output());
    }

    @Test
    public void displayGrid_fourSize() {
        setUp_withGridSize(4);
        consoleUI.displayGrid(grid);

        Assert.assertEquals("\n" + (ANSI_BRIGHTPURPLE + "[1]" + ANSI_RESET + " ") +
                (ANSI_BRIGHTPURPLE + "[2]" + ANSI_RESET + " ") + (ANSI_BRIGHTPURPLE + "[3]" +
                ANSI_RESET + " ") + (ANSI_BRIGHTPURPLE + "[4]" + ANSI_RESET + " ") + "\n" +
                (ANSI_BRIGHTPURPLE + "[5]" + ANSI_RESET + " ") + (ANSI_BRIGHTPURPLE + "[6]" +
                ANSI_RESET + " ") + (ANSI_BRIGHTPURPLE + "[7]" + ANSI_RESET + " ") +
                (ANSI_BRIGHTPURPLE + "[8]" + ANSI_RESET + " ")  + "\n" + (ANSI_BRIGHTPURPLE + "[9]" + ANSI_RESET + " ")
                + (ANSI_BRIGHTPURPLE + "[10]" + ANSI_RESET) + (ANSI_BRIGHTPURPLE + "[11]" + ANSI_RESET)
                + (ANSI_BRIGHTPURPLE + "[12]" + ANSI_RESET) + "\n" + (ANSI_BRIGHTPURPLE + "[13]" + ANSI_RESET)
                + (ANSI_BRIGHTPURPLE + "[14]" + ANSI_RESET) + (ANSI_BRIGHTPURPLE + "[15]" + ANSI_RESET)
                + (ANSI_BRIGHTPURPLE + "[16]" + ANSI_RESET + "\n"), ioHelper.output());
    }

    @Test
    public void clearScreen_onMac() {
        setUp_withGridSize(3);
        consoleUI.clearScreen();

        Assert.assertEquals("\033[H\033[2J", ioHelper.output());
    }
}


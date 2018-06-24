package Core.Players;

import Console.ConsoleUI;
import Console.IOHelper;
import Core.Grid;
import Core.Mark;
import org.junit.Test;

import java.util.ArrayList;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class PlayerHumanTest {

    @Test
    public void makeMove_ValidAttemptAtSquare1() {
        Grid grid = new Grid();
        new IOHelper("1");
        ConsoleUI consoleUI = new ConsoleUI(IOHelper.in, IOHelper.print, 1);
        Player playerOne = new PlayerHuman("Player One", Mark.PLAYERONEMARK, consoleUI);
        ArrayList<Mark> squaresResult = new ArrayList<>(
                asList(Mark.PLAYERONEMARK, Mark.UNMARKEDSQUARE, Mark.UNMARKEDSQUARE,
                        Mark.UNMARKEDSQUARE, Mark.UNMARKEDSQUARE, Mark.UNMARKEDSQUARE,
                        Mark.UNMARKEDSQUARE, Mark.UNMARKEDSQUARE, Mark.UNMARKEDSQUARE));

        playerOne.makeMove(grid);

        assertEquals(squaresResult, grid.getSquares());
    }

    @Test
    public void makeMove_ValidAttemptAtSquare2() {
        Grid grid = new Grid();
        new IOHelper("2");
        ConsoleUI consoleUI = new ConsoleUI(IOHelper.in, IOHelper.print, 1);
        Player playerOne = new PlayerHuman("Player One", Mark.PLAYERONEMARK, consoleUI);
        ArrayList<Mark> squaresResult = new ArrayList<>(
                asList(Mark.UNMARKEDSQUARE, Mark.PLAYERONEMARK, Mark.UNMARKEDSQUARE,
                        Mark.UNMARKEDSQUARE, Mark.UNMARKEDSQUARE, Mark.UNMARKEDSQUARE,
                        Mark.UNMARKEDSQUARE, Mark.UNMARKEDSQUARE, Mark.UNMARKEDSQUARE));

        playerOne.makeMove(grid);

        assertEquals(squaresResult, grid.getSquares());
    }

    @Test
    public void makeMove_InvalidAttemptThenAtSquare1() {
        Grid grid = new Grid();
        new IOHelper("asdf\n1");
        ConsoleUI consoleUI = new ConsoleUI(IOHelper.in, IOHelper.print, 1);
        Player playerOne = new PlayerHuman("Player One", Mark.PLAYERONEMARK, consoleUI);
        ArrayList<Mark> squaresResult = new ArrayList<>(
                asList(Mark.PLAYERONEMARK, Mark.UNMARKEDSQUARE, Mark.UNMARKEDSQUARE,
                        Mark.UNMARKEDSQUARE, Mark.UNMARKEDSQUARE, Mark.UNMARKEDSQUARE,
                        Mark.UNMARKEDSQUARE, Mark.UNMARKEDSQUARE, Mark.UNMARKEDSQUARE));

        playerOne.makeMove(grid);

        assertEquals(squaresResult, grid.getSquares());
    }
}
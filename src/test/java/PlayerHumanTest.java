import Console.ConsoleUI;
import Core.Grid;
import Core.Mark;
import Core.Players.Player;
import Core.Players.PlayerHuman;
import org.junit.Test;

import java.util.ArrayList;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class PlayerHumanTest {

    @Test
    public void makeMove_ValidAttemptAtSquare1() {
        Grid grid = new Grid();
        IOHelper ioHelper = new IOHelper("1");
        ConsoleUI consoleUI = new ConsoleUI(IOHelper.in, IOHelper.print, 1);
        Player playerOne = new PlayerHuman("Player One", Mark.playerOneMark, consoleUI);
        ArrayList<Mark> squaresResult = new ArrayList<>(
                asList(Mark.playerOneMark, Mark.unmarkedSquare, Mark.unmarkedSquare,
                        Mark.unmarkedSquare, Mark.unmarkedSquare, Mark.unmarkedSquare,
                        Mark.unmarkedSquare, Mark.unmarkedSquare, Mark.unmarkedSquare));

        playerOne.makeMove(grid);

        assertEquals(squaresResult, grid.getSquares());
    }

    @Test
    public void makeMove_ValidAttemptAtSquare2() {
        Grid grid = new Grid();
        IOHelper ioHelper = new IOHelper("2");
        ConsoleUI consoleUI = new ConsoleUI(IOHelper.in, IOHelper.print, 1);
        Player playerOne = new PlayerHuman("Player One", Mark.playerOneMark, consoleUI);
        ArrayList<Mark> squaresResult = new ArrayList<>(
                asList(Mark.unmarkedSquare, Mark.playerOneMark, Mark.unmarkedSquare,
                        Mark.unmarkedSquare, Mark.unmarkedSquare, Mark.unmarkedSquare,
                        Mark.unmarkedSquare, Mark.unmarkedSquare, Mark.unmarkedSquare));

        playerOne.makeMove(grid);

        assertEquals(squaresResult, grid.getSquares());
    }

    @Test
    public void makeMove_InvalidAttemptThenAtSquare1() {
        Grid grid = new Grid();
        IOHelper ioHelper = new IOHelper("asdf\n1");
        ConsoleUI consoleUI = new ConsoleUI(IOHelper.in, IOHelper.print, 1);
        Player playerOne = new PlayerHuman("Player One", Mark.playerOneMark, consoleUI);
        ArrayList<Mark> squaresResult = new ArrayList<>(
                asList(Mark.playerOneMark, Mark.unmarkedSquare, Mark.unmarkedSquare,
                        Mark.unmarkedSquare, Mark.unmarkedSquare, Mark.unmarkedSquare,
                        Mark.unmarkedSquare, Mark.unmarkedSquare, Mark.unmarkedSquare));

        playerOne.makeMove(grid);

        assertEquals(squaresResult, grid.getSquares());
    }
}
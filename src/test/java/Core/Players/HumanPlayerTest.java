package Core.Players;

import Console.ConsoleUI;
import Console.IOHelper;
import Core.UserInterfaces.Communicator;
import Core.Board.Grid;
import Core.Board.Mark;
import Core.UserInterfaces.UI;
import org.junit.Test;

import static org.junit.Assert.*;

public class HumanPlayerTest {

    @Test
    public void makeMove_ValidAttemptAtGridPoint0() {
        Grid grid = new Grid();
        IOHelper ioHelper = new IOHelper("1");
        UI ui = new ConsoleUI(ioHelper.in, ioHelper.print, 1);
        Communicator communicator = new Communicator(ui);
        Player playerOne = new HumanPlayer(Mark.PLAYER_ONE, communicator);

        assertEquals(0, playerOne.getMove(grid));
    }

    @Test
    public void makeMove_ValidAttemptAtGridPoint1() {
        Grid grid = new Grid();
        IOHelper ioHelper = new IOHelper("2");
        UI ui = new ConsoleUI(ioHelper.in, ioHelper.print, 1);
        Communicator communicator = new Communicator(ui);
        Player playerOne = new HumanPlayer(Mark.PLAYER_ONE, communicator);

        assertEquals(1, playerOne.getMove(grid));
    }

    @Test
    public void makeMove_InvalidAttemptThenAtSquare1() {
        Grid grid = new Grid();
        IOHelper ioHelper = new IOHelper("asdf\n1");
        UI ui = new ConsoleUI(ioHelper.in, ioHelper.print, 1);
        Communicator communicator = new Communicator(ui);
        Player playerOne = new HumanPlayer(Mark.PLAYER_ONE, communicator);

        assertEquals(0, playerOne.getMove(grid));
    }
}
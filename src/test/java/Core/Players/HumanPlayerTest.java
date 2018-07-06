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

    private Player player;
    private Grid grid;

    private void setUpWithInput(String input) {
        grid = new Grid(3);
        IOHelper ioHelper = new IOHelper(input);
        UI ui = new ConsoleUI(ioHelper.in, ioHelper.print, 0);
        Communicator communicator = new Communicator(ui);
        player = new HumanPlayer(Mark.PLAYER_ONE, communicator);
    }

    @Test
    public void makeMove_ValidAttemptAtGridPoint0() {
        setUpWithInput("1");

        assertEquals(0, player.getMove(grid));
    }

    @Test
    public void makeMove_ValidAttemptAtGridPoint1() {
        setUpWithInput("2");

        assertEquals(1, player.getMove(grid));
    }

    @Test
    public void makeMove_InvalidAttemptThenAtSquare1() {
        setUpWithInput("asdf\n1");

        assertEquals(0, player.getMove(grid));
    }
}
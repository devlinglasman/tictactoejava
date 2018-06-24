package Core;

import Console.ConsoleUI;
import Core.Players.Player;
import Core.Players.PlayerComputer;
import org.junit.Test;

import java.util.ArrayList;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class GameTest {

    @Test
    public void runGame_oneMove() {
        UI ui = new ConsoleUI(System.in, System.out, 1);
        Communicator communicator = new Communicator(ui);
        Grid grid = new Grid();
        Player playerOne = new PlayerComputer("Player One", Mark.PLAYERONEMARK, Mark.PLAYERTWOMARK);
        Player playerTwo = new PlayerComputer("Player Two", Mark.PLAYERTWOMARK, Mark.PLAYERONEMARK);
        Game game = new Game(grid, playerOne, playerTwo, communicator);
        ArrayList<Mark> squaresResult = new ArrayList<>(
                asList(Mark.PLAYERONEMARK, Mark.PLAYERONEMARK, Mark.PLAYERONEMARK,
                        Mark.UNMARKEDSQUARE, Mark.UNMARKEDSQUARE, Mark.UNMARKEDSQUARE,
                        Mark.UNMARKEDSQUARE, Mark.UNMARKEDSQUARE, Mark.UNMARKEDSQUARE));

        grid.markSquare(0, Mark.PLAYERONEMARK);
        grid.markSquare(1, Mark.PLAYERONEMARK);
        game.runGame();

        assertEquals(squaresResult, grid.getSquares());
        assertEquals(playerOne, game.getActivePlayer());
    }
}
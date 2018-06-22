import Console.ConsoleUI;
import Core.Game;
import Core.Grid;
import Core.Mark;
import Core.Players.Player;
import Core.Players.PlayerComputer;
import Core.Players.PlayerHuman;
import Core.UI;
import org.junit.Test;

import java.util.ArrayList;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class GameTest {

    @Test
    public void runGame_oneMove() {
        UI ui = new ConsoleUI(System.in, System.out, 1);
        Grid grid = new Grid();
        Player playerOne = new PlayerComputer("Player One", Mark.playerOneMark, Mark.playerTwoMark);
        Player playerTwo = new PlayerComputer("Player Two", Mark.playerTwoMark, Mark.playerOneMark);
        Game game = new Game(grid, playerOne, playerTwo, ui);
        ArrayList<Mark> squaresResult = new ArrayList<>(
                asList(Mark.playerOneMark, Mark.playerOneMark, Mark.playerOneMark,
                        Mark.unmarkedSquare, Mark.unmarkedSquare, Mark.unmarkedSquare,
                        Mark.unmarkedSquare, Mark.unmarkedSquare, Mark.unmarkedSquare));

        grid.markSquare(0, Mark.playerOneMark);
        grid.markSquare(1, Mark.playerOneMark);
        game.runGame();

        assertEquals(squaresResult, grid.getSquares());
        assertEquals(playerOne, game.getActivePlayer());
    }
}
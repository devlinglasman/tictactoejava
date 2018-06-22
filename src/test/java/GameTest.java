import Console.ConsoleUI;
import Core.Game;
import Core.Grid;
import Core.Mark;
import Core.Players.Player;
import Core.Players.PlayerComputer;
import Core.Players.PlayerHuman;
import Core.UI;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    @Test
    public void runGame_oneMove() {
        UI ui = new ConsoleUI(System.in, System.out, 1);
        Grid grid = new Grid();
        Player playerOne = new PlayerComputer("Player One", Mark.playerOneMark, Mark.playerTwoMark);
        Player playerTwo = new PlayerComputer("Player Two", Mark.playerTwoMark, Mark.playerOneMark);
        Game game = new Game(grid, playerOne, playerTwo, ui);

        grid.markSquare(0, Mark.playerOneMark);
        grid.markSquare(1, Mark.playerOneMark);
        game.runGame();

        assertEquals(playerOne, game.getActivePlayer());
    }
}
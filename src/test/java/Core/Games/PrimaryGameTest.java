package Core.Games;

import Console.ConsoleUI;
import Core.Grid;
import Core.Mark;
import Core.Players.Player;
import Core.Players.ComputerPlayer;
import Core.UserInterfaces.Communicator;
import Core.UserInterfaces.UI;
import org.junit.Test;

import java.util.ArrayList;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class PrimaryGameTest {

    @Test
    public void runGame_oneMove() {
        GameRunner gameRunner = new GameRunner();
        UI ui = new ConsoleUI(System.in, System.out, 0);
        Communicator communicator = new Communicator(ui);
        Grid grid = new Grid();
        Player playerOne = new ComputerPlayer(Mark.PLAYER_ONE);
        Player playerTwo = new ComputerPlayer(Mark.PLAYER_TWO);
        PrimaryGame primaryGame = new PrimaryGame(grid, playerOne, playerTwo, communicator);
        ArrayList<Mark> squaresResult = new ArrayList<>(
                asList(Mark.PLAYER_ONE, Mark.PLAYER_ONE, Mark.PLAYER_ONE,
                        Mark.EMPTY, Mark.EMPTY, Mark.EMPTY,
                        Mark.EMPTY, Mark.EMPTY, Mark.EMPTY));

        grid.markSquare(0, Mark.PLAYER_ONE);
        grid.markSquare(1, Mark.PLAYER_ONE);

        gameRunner.runGame(primaryGame);

        assertEquals(squaresResult, grid.getSquares());
    }
}
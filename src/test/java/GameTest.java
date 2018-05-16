import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GameTest {

    @Test
    public void convertInputToSquareNumber() {
        Game game = new Game();

        assertEquals(0, game.convertInputToSquareNumber("1"));
    }

    @Test
    public void markSquareX() {
        Game game = new Game();

        game.markSquare(game.getPlayerOne(),game.getGrid(),0);

        assertEquals("X", game.getGrid().getSquares()[0]);
    }

    @Test
    public void markSquareO() {
        Game game = new Game();

        game.markSquare(game.getPlayerTwo(),game.getGrid(),0);

        assertEquals("O", game.getGrid().getSquares()[0]);
    }

    @Test
    public void isBoardFullYes() {
        Game game = new Game();

        for (int i = 0; i < game.getGrid().getSquares().length; i++) {
            game.markSquare(game.getPlayerOne(),game.getGrid(),i);
        }

        assertEquals(true, game.isBoardFull(game.getGrid()));
    }

    @Test
    public void isBoardFullNo() {
        Game game = new Game();

        assertEquals(false, game.isBoardFull(game.getGrid()));
    }

    @Test
    public void winningLineYes() {
        Game game = new Game();
        String[] row1 = {"X", "X", "X"};

        assertEquals(true, game.winningLine(row1));
    }

    @Test
    public void winningLineNo() {
        Game game = new Game();
        String[] row1 = {" ", "X", "X"};

        assertEquals(false, game.winningLine(row1));
    }

    @Test
    public void isGameWonYes() {
        Game game = new Game();

        for (int i = 0; i < 3; i++) {
            game.markSquare(game.getPlayerOne(),game.getGrid(),i);
        }

        assertEquals(true, game.isGameWon(game.getGrid()));
    }

    @Test
    public void isGameWonNo() {
        Game game = new Game();

        assertEquals(false, game.isGameWon(game.getGrid()));
    }

    @Test
    public void alternatePlayer1() {
        Game game = new Game();

        game.alternatePlayer();
        game.alternatePlayer();

        assertEquals(game.getPlayerOne(), game.getActivePlayer());
    }

    @Test
    public void alternatePlayer2() {
        Game game = new Game();

        game.alternatePlayer();

        assertEquals(game.getPlayerTwo(), game.getActivePlayer());
    }

}


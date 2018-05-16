import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    @Test
    public void convertInputToSquareNumberTest() {
        Game game = new Game();

        assertEquals(0,game.convertInputToSquareNumber("1"));
    }

    @Test
    public void setSquareToXTest() {
        Game game = new Game();

        game.setSquareToXMark(0);

        assertEquals("X",game.getSquares()[0]);
    }

    @Test
    public void setSquareToOTest() {
        Game game = new Game();

        game.setSquareToO(0);

        assertEquals("O",game.getSquares()[0]);
    }

    @Test
    public void isBoardFullYesTest() {
        Game game = new Game();

        for (int i = 0; i < game.getSquares().length; i++) {
           game.setSquareToXMark(i);
        }

        assertEquals(true, game.isBoardFull());
    }

    @Test
    public void isBoardFullNoTest() {
        Game game = new Game();

        assertEquals(false, game.isBoardFull());
    }
}


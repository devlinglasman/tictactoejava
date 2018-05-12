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

        game.setSquareToX(0);

        assertEquals("X",game.getSquares()[0]);
    }

    @Test
    public void isBoardFullYesTest() {
        Game game = new Game();

        for (int i = 0; i < game.getSquares().length; i++) {
           game.setSquareToX(i);
        }

        assertEquals(true, game.isBoardFull());
    }

    @Test
    public void isBoardFullNoTest() {
        Game game = new Game();

        assertEquals(false, game.isBoardFull());
    }
}


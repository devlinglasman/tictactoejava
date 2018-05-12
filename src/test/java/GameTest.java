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

//    @Test
//    public void isBoardFullTest() {
//        game game = new game();
//
//        for (string square : game.getsquares()) {
//           square
//        }
//
//        assertequals(true, game.isboardfull());
//    }
}


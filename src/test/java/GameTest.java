import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    @Test
    public void selectInputSquareTest() {
        Game game = new Game();
        assertEquals(game.getSquare1(),game.getSelectedSquare(1));
    }

    @Test
    public void convertInputTest() {
        Game game = new Game();
        game.convertInput("1");
        assertEquals(1,game.getUserInput());
    }

    @Test
    public void setSquareStatusTest() {
        Game game = new Game();

        game.setSquareStatus(game.getSelectedSquare(1));

        assertEquals(2,game.getSelectedSquare(1).getStatus());
    }
}


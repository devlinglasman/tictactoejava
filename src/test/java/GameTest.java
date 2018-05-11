import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    @Test
    public void selectInputSquareTest() {
        Game game = new Game();
        assertEquals(game.getSquare1(),game.selectInputSquare(1));
    }

    @Test
    public void convertInput() {
        Game game = new Game();
        game.convertInput("1");
        assertEquals(1,game.getUserInput());
    }
}


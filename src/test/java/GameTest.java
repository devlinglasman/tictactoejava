import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    @Test
    public void selectInputSquareTest() {
        Game game = new Game();
        assertEquals(game.getSquare1(),game.selectInputSquare(1));
    }
}


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoardSquareTest {

    @Test
    public void testStatus() {
        BoardSquare square = new BoardSquare();

        assertEquals(1,square.getStatus());
    }
}

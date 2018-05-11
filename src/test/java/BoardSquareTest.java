import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoardSquareTest {

    @Test
    public void testStatus() {
        BoardSquare square = new BoardSquare();

        assertEquals(1,square.getStatus());
    }

    @Test
    public void setSquareStatusTest() {
        BoardSquare square = new BoardSquare();
        square.setStatus(2);
        assertEquals(2,square.getStatus());
    }
}

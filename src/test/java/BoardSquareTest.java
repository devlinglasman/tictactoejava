import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoardSquareTest {

    @Test
    public void setSquareStatusTest() {
        BoardSquare square = new BoardSquare();
        square.setStatus(2);
        assertEquals(2,square.getStatus());
    }

    @Test
    public void retrieveStatusOutputTest1() {
        BoardSquare square = new BoardSquare();
        square.setStatus(1);
        assertEquals(" ",square.retrieveStatusOutput());

    }

    @Test
    public void retrieveStatusOutputTest2() {
        BoardSquare square = new BoardSquare();
        square.setStatus(2);
        assertEquals("X",square.retrieveStatusOutput());

    }
}

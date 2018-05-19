import org.junit.Test;

import static org.junit.Assert.*;

public class ValidatorTest {

    @Test
    public void inputIsNotValidYes() {
        Validator validator = new Validator();

        
        assertFalse(grid.moveIsNotLegal(0));
    }

}
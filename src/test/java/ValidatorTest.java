import org.junit.Test;

import static org.junit.Assert.*;

public class ValidatorTest {

    @Test
    public void inputIsNotValidNumberYes() {
        Validator validator = new Validator();

        assertTrue(validator.inputIsNotValidNumber("as"));
    }

    @Test
    public void inputIsNotValidNumberNo() {
        Validator validator = new Validator();

        assertFalse(validator.inputIsNotValidNumber("1"));
    }

    @Test
    public void inputIsNotWithinRangeNo() {
        Validator validator = new Validator();

        assertFalse(validator.inputIsNotWithinRange(1));
    }

    @Test
    public void inputIsNotWithinRangeYes1() {
        Validator validator = new Validator();

        assertTrue(validator.inputIsNotWithinRange(0));
    }

    @Test
    public void inputIsNotWithinRangeYes2() {
        Validator validator = new Validator();

        assertTrue(validator.inputIsNotWithinRange(10));
    }
}
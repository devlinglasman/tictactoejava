import org.junit.Test;

import static org.junit.Assert.*;

public class ValidatorTest {

    @Test
    public void inputNotValidGameChoiceTrue() {
        Validator validator = new Validator();

        assertTrue(validator.inputNotValidGameChoice("1.5"));
    }

    @Test
    public void inputNotValidGameChoiceFalse() {
        Validator validator = new Validator();

        assertFalse(validator.inputNotValidGameChoice("1"));
    }

    @Test
    public void inputNotValidGridNumberTrue() {
        Validator validator = new Validator();

        assertTrue(validator.inputNotValidGridNumber("3.4"));
    }

    @Test
    public void inputNotValidGridNumberFalse() {
        Validator validator = new Validator();

        assertFalse(validator.inputNotValidGridNumber("3"));
    }

    @Test
    public void inputNotCorrectFormatTrueNotNumber() {
        Validator validator = new Validator();

        assertTrue(validator.inputNotCorrectFormat("as"));
    }

    @Test
    public void inputNotCorrectFormatTrueNotInteger() {
        Validator validator = new Validator();

        assertTrue(validator.inputNotCorrectFormat("3.4"));
    }

    @Test
    public void inputNotCorrectFormatFalse() {
        Validator validator = new Validator();

        assertFalse(validator.inputNotCorrectFormat("1"));
    }

    @Test
    public void inputIsNotWithinRangeTrueTooLow() {
        Validator validator = new Validator();

        assertTrue(validator.inputIsNotWithinRange(0));
    }

    @Test
    public void inputIsNotWithinRangeTrueTooHigh() {
        Validator validator = new Validator();

        assertTrue(validator.inputIsNotWithinRange(10));
    }

    @Test
    public void inputIsNotWithinRangeFalse() {
        Validator validator = new Validator();

        assertFalse(validator.inputIsNotWithinRange(1));
    }
}
import Console.ValidatorConsoleInput;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidatorConsoleInputTest {

    @Test
    public void inputNotValidGameChoiceTrue() {
        ValidatorConsoleInput validatorConsoleInput = new ValidatorConsoleInput();

        assertTrue(validatorConsoleInput.inputNotValidGameChoice("1.5"));
    }

    @Test
    public void inputNotValidGameChoiceFalse() {
        ValidatorConsoleInput validatorConsoleInput = new ValidatorConsoleInput();

        assertFalse(validatorConsoleInput.inputNotValidGameChoice("1"));
    }

    @Test
    public void inputNotValidGridNumberTrue() {
        ValidatorConsoleInput validatorConsoleInput = new ValidatorConsoleInput();

        assertTrue(validatorConsoleInput.inputNotValidGridNumber("3.4"));
    }

    @Test
    public void inputNotValidGridNumberFalse() {
        ValidatorConsoleInput validatorConsoleInput = new ValidatorConsoleInput();

        assertFalse(validatorConsoleInput.inputNotValidGridNumber("3"));
    }

    @Test
    public void inputNotCorrectFormatTrueNotNumber() {
        ValidatorConsoleInput validatorConsoleInput = new ValidatorConsoleInput();

        assertTrue(validatorConsoleInput.inputNotCorrectFormat("as"));
    }

    @Test
    public void inputNotCorrectFormatTrueNotInteger() {
        ValidatorConsoleInput validatorConsoleInput = new ValidatorConsoleInput();

        assertTrue(validatorConsoleInput.inputNotCorrectFormat("3.4"));
    }

    @Test
    public void inputNotCorrectFormatFalse() {
        ValidatorConsoleInput validatorConsoleInput = new ValidatorConsoleInput();

        assertFalse(validatorConsoleInput.inputNotCorrectFormat("1"));
    }

    @Test
    public void inputIsNotWithinRangeTrueTooLow() {
        ValidatorConsoleInput validatorConsoleInput = new ValidatorConsoleInput();

        assertTrue(validatorConsoleInput.inputIsNotWithinRange(0));
    }

    @Test
    public void inputIsNotWithinRangeTrueTooHigh() {
        ValidatorConsoleInput validatorConsoleInput = new ValidatorConsoleInput();

        assertTrue(validatorConsoleInput.inputIsNotWithinRange(10));
    }

    @Test
    public void inputIsNotWithinRangeFalse() {
        ValidatorConsoleInput validatorConsoleInput = new ValidatorConsoleInput();

        assertFalse(validatorConsoleInput.inputIsNotWithinRange(1));
    }
}
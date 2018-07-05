package Core.UserInterfaces;

import Console.ConsoleUI;
import Console.IOHelper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CommunicatorTest {

    private Communicator communicator;

    private void setUpWithInput(String input) {
        IOHelper ioHelper = new IOHelper(input);
        UI ui = new ConsoleUI(ioHelper.in, ioHelper.print, 0);
        communicator = new Communicator(ui);
    }

    @Test
    public void getValidNumber_ValidAttempt1() {
        setUpWithInput("1");

        assertEquals(1, communicator.getValidNumber());
    }

    @Test
    public void getValidNumber_ValidAttempt2() {
        setUpWithInput("123098457");

        assertEquals(123098457, communicator.getValidNumber());
    }

    @Test
    public void getValidNumber_InvalidAttemptNotNumber() {
        setUpWithInput("asdf\n1");

        assertEquals(1, communicator.getValidNumber());
    }

    @Test
    public void getValidNumber_InvalidAttemptNotInteger() {
        setUpWithInput("1.1\n1");

        assertEquals(1, communicator.getValidNumber());
    }

    @Test
    public void findYesorNo_AnswerIsYes() {
        setUpWithInput("y");

        assertTrue(communicator.returnTrueIfYes());
    }

    @Test
    public void findYesorNo_AnswerIsNo() {
        setUpWithInput("n");

        assertFalse(communicator.returnTrueIfYes());
    }

    @Test
    public void findYesorNo_AnswerIsYesUppercase() {
        setUpWithInput("Y");

        assertTrue(communicator.returnTrueIfYes());
    }

    @Test
    public void findYesorNo_AnswerIsIncorrectThenYes() {
        setUpWithInput("ye\nY");

        assertTrue(communicator.returnTrueIfYes());
    }

    @Test
    public void findYesorNo_AnswerIsIncorrectThenYes2() {
        setUpWithInput(" \nY");

        assertTrue(communicator.returnTrueIfYes());
    }
}
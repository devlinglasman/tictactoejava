package Core.UserInterfaces;

import Console.ConsoleUI;
import Console.IOHelper;
import org.junit.Test;

import static org.junit.Assert.*;

public class CommunicatorTest {

    @Test
    public void getValidNumber_ValidAttempt1() {
        IOHelper ioHelper = new IOHelper("1");
        UI ui = new ConsoleUI(ioHelper.in, ioHelper.print, 1);
        Communicator communicator = new Communicator(ui);

        assertEquals(1, communicator.getValidNumber());
    }

    @Test
    public void getValidNumber_ValidAttempt2() {
        IOHelper ioHelper = new IOHelper("123098457");
        UI ui = new ConsoleUI(ioHelper.in, ioHelper.print, 1);
        Communicator communicator = new Communicator(ui);

        assertEquals(123098457, communicator.getValidNumber());
    }

    @Test
    public void getValidNumber_InvalidAttemptNotNumber() {
        IOHelper ioHelper = new IOHelper("asdf\n1");
        UI ui = new ConsoleUI(ioHelper.in, ioHelper.print, 1);
        Communicator communicator = new Communicator(ui);

        assertEquals(1, communicator.getValidNumber());
    }

    @Test
    public void getValidNumber_InvalidAttemptNotInteger() {
        IOHelper ioHelper = new IOHelper("1.1\n1");
        UI ui = new ConsoleUI(ioHelper.in, ioHelper.print, 1);
        Communicator communicator = new Communicator(ui);

        assertEquals(1, communicator.getValidNumber());
    }

    @Test
    public void findYesorNo_AnswerIsYes() {
        IOHelper ioHelper = new IOHelper("y");
        UI ui = new ConsoleUI(ioHelper.in, ioHelper.print, 1);
        Communicator communicator = new Communicator(ui);

        assertTrue(communicator.returnTrueIfYes());
    }

    @Test
    public void findYesorNo_AnswerIsNo() {
        IOHelper ioHelper = new IOHelper("n");
        UI ui = new ConsoleUI(ioHelper.in, ioHelper.print, 1);
        Communicator communicator = new Communicator(ui);

        assertFalse(communicator.returnTrueIfYes());
    }

    @Test
    public void findYesorNo_AnswerIsYesUppercase() {
        IOHelper ioHelper = new IOHelper("Y");
        UI ui = new ConsoleUI(ioHelper.in, ioHelper.print, 1);
        Communicator communicator = new Communicator(ui);

        assertTrue(communicator.returnTrueIfYes());
    }

    @Test
    public void findYesorNo_AnswerIsIncorrectThenYes() {
        IOHelper ioHelper = new IOHelper("ye\nY");
        UI ui = new ConsoleUI(ioHelper.in, ioHelper.print, 1);
        Communicator communicator = new Communicator(ui);

        assertTrue(communicator.returnTrueIfYes());
    }

    @Test
    public void findYesorNo_AnswerIsIncorrectThenYes2() {
        IOHelper ioHelper = new IOHelper(" \nY");
        UI ui = new ConsoleUI(ioHelper.in, ioHelper.print, 1);
        Communicator communicator = new Communicator(ui);

        assertTrue(communicator.returnTrueIfYes());
    }
}
package Core;

import Console.ConsoleUI;
import Console.IOHelper;
import org.junit.Test;

import static org.junit.Assert.*;

public class CommunicatorTest {

    @Test
    public void getValidNumber_ValidAttempt1() {
        new IOHelper("1");
        UI ui = new ConsoleUI(IOHelper.in, IOHelper.print, 1);
        Communicator communicator = new Communicator(ui);

        assertEquals(1, communicator.getValidNumber());
    }

    @Test
    public void getValidNumber_ValidAttempt2() {
        new IOHelper("123098457");
        UI ui = new ConsoleUI(IOHelper.in, IOHelper.print, 1);
        Communicator communicator = new Communicator(ui);

        assertEquals(123098457, communicator.getValidNumber());
    }

    @Test
    public void getValidNumber_InvalidAttemptNotNumber() {
        new IOHelper("asdf\n1");
        UI ui = new ConsoleUI(IOHelper.in, IOHelper.print, 1);
        Communicator communicator = new Communicator(ui);

        assertEquals(1, communicator.getValidNumber());
    }

    @Test
    public void getValidNumber_InvalidAttemptNotInteger() {
        new IOHelper("1.1\n1");
        UI ui = new ConsoleUI(IOHelper.in, IOHelper.print, 1);
        Communicator communicator = new Communicator(ui);

        assertEquals(1, communicator.getValidNumber());
    }
}
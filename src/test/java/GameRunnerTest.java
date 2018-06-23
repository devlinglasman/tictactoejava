import Console.ConsoleUI;
import Core.GameRunner;
import Core.UI;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameRunnerTest {

    @Test
    public void getValidGameModeChoice_Valid_1() {
        new IOHelper("1");
        UI ui = new ConsoleUI(IOHelper.in, IOHelper.print, 1);
        GameRunner gameRunner = new GameRunner(ui);

        assertEquals(1, gameRunner.getValidGameModeChoice());
    }

    @Test
    public void getValidGameModeChoice_Invalid_TooLow() {
        new IOHelper("0\n1");
        UI ui = new ConsoleUI(IOHelper.in, IOHelper.print, 1);
        GameRunner gameRunner = new GameRunner(ui);

        assertEquals(1, gameRunner.getValidGameModeChoice());
    }

    @Test
    public void getValidGameModeChoice_Invalid_TooHigh() {
        new IOHelper("15\n1");
        UI ui = new ConsoleUI(IOHelper.in, IOHelper.print, 1);
        GameRunner gameRunner = new GameRunner(ui);

        assertEquals(1, gameRunner.getValidGameModeChoice());
    }

    @Test
    public void getValidGameModeChoice_Invalid_NotNumber() {
        new IOHelper("asdf\n1");
        UI ui = new ConsoleUI(IOHelper.in, IOHelper.print, 1);
        GameRunner gameRunner = new GameRunner(ui);

        assertEquals(1, gameRunner.getValidGameModeChoice());
    }

}


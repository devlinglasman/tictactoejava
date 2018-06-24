package Core;

import Console.ConsoleUI;
import Console.IOHelper;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameModeSelectorTest {

    @Test
    public void getGameMode_humanvscomp() {
        new IOHelper("1");
        UI ui = new ConsoleUI(IOHelper.in, IOHelper.print, 1);
        Communicator communicator = new Communicator(ui);
        GameModeSelector gameModeSelector = new GameModeSelector(communicator);

        assertEquals(GameMode.HUMANVSCOMP, gameModeSelector.getGameMode());
    }

    @Test
    public void getGameMode_compvscomp() {
        new IOHelper("2");
        UI ui = new ConsoleUI(IOHelper.in, IOHelper.print, 1);
        Communicator communicator = new Communicator(ui);
        GameModeSelector gameModeSelector = new GameModeSelector(communicator);

        assertEquals(GameMode.COMPVSCOMP, gameModeSelector.getGameMode());
    }

    @Test
    public void getGameMode_humanvshuman() {
        new IOHelper("3");
        UI ui = new ConsoleUI(IOHelper.in, IOHelper.print, 1);
        Communicator communicator = new Communicator(ui);
        GameModeSelector gameModeSelector = new GameModeSelector(communicator);

        assertEquals(GameMode.HUMANVSHUMAN, gameModeSelector.getGameMode());
    }

    @Test
    public void getGameMode_Invalid_TooLow() {
        new IOHelper("0\n1");
        UI ui = new ConsoleUI(IOHelper.in, IOHelper.print, 1);
        Communicator communicator = new Communicator(ui);
        GameModeSelector gameModeSelector = new GameModeSelector(communicator);

        assertEquals(GameMode.HUMANVSCOMP, gameModeSelector.getGameMode());
    }

    @Test
    public void getGameMode_Invalid_TooHigh() {
        new IOHelper("15\n1");
        UI ui = new ConsoleUI(IOHelper.in, IOHelper.print, 1);
        Communicator communicator = new Communicator(ui);
        GameModeSelector gameModeSelector = new GameModeSelector(communicator);

        assertEquals(GameMode.HUMANVSCOMP, gameModeSelector.getGameMode());
    }

    @Test
    public void getGameMode_Invalid_NotNumber() {
        new IOHelper("asdf\n1");
        UI ui = new ConsoleUI(IOHelper.in, IOHelper.print, 1);
        Communicator communicator = new Communicator(ui);
        GameModeSelector gameModeSelector = new GameModeSelector(communicator);

        assertEquals(GameMode.HUMANVSCOMP, gameModeSelector.getGameMode());
    }

}


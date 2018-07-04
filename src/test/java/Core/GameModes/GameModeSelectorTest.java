package Core.GameModes;

import Console.ConsoleUI;
import Console.IOHelper;
import Core.UserInterfaces.Communicator;
import Core.UserInterfaces.UI;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameModeSelectorTest {

    @Test
    public void getGameMode_humanvscomp() {
        IOHelper ioHelper = new IOHelper("1");
        UI ui = new ConsoleUI(ioHelper.in, ioHelper.print, 1);
        Communicator communicator = new Communicator(ui);
        GameModeSelector gameModeSelector = new GameModeSelector(communicator);

        assertEquals(GameMode.HUMANVSCOMP, gameModeSelector.getMode());
    }

    @Test
    public void getGameMode_compvscomp() {
        IOHelper ioHelper = new IOHelper("2");
        UI ui = new ConsoleUI(ioHelper.in, ioHelper.print, 1);
        Communicator communicator = new Communicator(ui);
        GameModeSelector gameModeSelector = new GameModeSelector(communicator);

        assertEquals(GameMode.COMPVSCOMP, gameModeSelector.getMode());
    }

    @Test
    public void getGameMode_humanvshuman() {
        IOHelper ioHelper = new IOHelper("3");
        UI ui = new ConsoleUI(ioHelper.in, ioHelper.print, 1);
        Communicator communicator = new Communicator(ui);
        GameModeSelector gameModeSelector = new GameModeSelector(communicator);

        assertEquals(GameMode.HUMANVSHUMAN, gameModeSelector.getMode());
    }

    @Test
    public void getGameMode_Invalid_TooLow() {
        IOHelper ioHelper = new IOHelper("0\n1");
        UI ui = new ConsoleUI(ioHelper.in, ioHelper.print, 1);
        Communicator communicator = new Communicator(ui);
        GameModeSelector gameModeSelector = new GameModeSelector(communicator);

        assertEquals(GameMode.HUMANVSCOMP, gameModeSelector.getMode());
    }

    @Test
    public void getGameMode_Invalid_TooHigh() {
        IOHelper ioHelper = new IOHelper("15\n1");
        UI ui = new ConsoleUI(ioHelper.in, ioHelper.print, 1);
        Communicator communicator = new Communicator(ui);
        GameModeSelector gameModeSelector = new GameModeSelector(communicator);

        assertEquals(GameMode.HUMANVSCOMP, gameModeSelector.getMode());
    }

    @Test
    public void getGameMode_Invalid_NotNumber() {
        IOHelper ioHelper = new IOHelper("asdf\n1");
        UI ui = new ConsoleUI(ioHelper.in, ioHelper.print, 1);
        Communicator communicator = new Communicator(ui);
        GameModeSelector gameModeSelector = new GameModeSelector(communicator);

        assertEquals(GameMode.HUMANVSCOMP, gameModeSelector.getMode());
    }
}


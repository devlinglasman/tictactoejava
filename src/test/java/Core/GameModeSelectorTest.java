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

        assertEquals(GameMode.HUMANVSCOMP, gameModeSelector.getPrimaryGameMode());
    }

    @Test
    public void getGameMode_compvscomp() {
        new IOHelper("2");
        UI ui = new ConsoleUI(IOHelper.in, IOHelper.print, 1);
        Communicator communicator = new Communicator(ui);
        GameModeSelector gameModeSelector = new GameModeSelector(communicator);

        assertEquals(GameMode.COMPVSCOMP, gameModeSelector.getPrimaryGameMode());
    }

    @Test
    public void getGameMode_humanvshuman() {
        new IOHelper("3");
        UI ui = new ConsoleUI(IOHelper.in, IOHelper.print, 1);
        Communicator communicator = new Communicator(ui);
        GameModeSelector gameModeSelector = new GameModeSelector(communicator);

        assertEquals(GameMode.HUMANVSHUMAN, gameModeSelector.getPrimaryGameMode());
    }

    @Test
    public void getGameMode_Invalid_TooLow() {
        new IOHelper("0\n1");
        UI ui = new ConsoleUI(IOHelper.in, IOHelper.print, 1);
        Communicator communicator = new Communicator(ui);
        GameModeSelector gameModeSelector = new GameModeSelector(communicator);

        assertEquals(GameMode.HUMANVSCOMP, gameModeSelector.getPrimaryGameMode());
    }

    @Test
    public void getGameMode_Invalid_TooHigh() {
        new IOHelper("15\n1");
        UI ui = new ConsoleUI(IOHelper.in, IOHelper.print, 1);
        Communicator communicator = new Communicator(ui);
        GameModeSelector gameModeSelector = new GameModeSelector(communicator);

        assertEquals(GameMode.HUMANVSCOMP, gameModeSelector.getPrimaryGameMode());
    }

    @Test
    public void getGameMode_Invalid_NotNumber() {
        new IOHelper("asdf\n1");
        UI ui = new ConsoleUI(IOHelper.in, IOHelper.print, 1);
        Communicator communicator = new Communicator(ui);
        GameModeSelector gameModeSelector = new GameModeSelector(communicator);

        assertEquals(GameMode.HUMANVSCOMP, gameModeSelector.getPrimaryGameMode());
    }

    @Test
    public void askSecondaryOptions_rewatch() {
        new IOHelper("y");
        UI ui = new ConsoleUI(IOHelper.in, IOHelper.print, 1);
        Communicator communicator = new Communicator(ui);
        GameModeSelector gameModeSelector = new GameModeSelector(communicator);

        assertEquals(GameMode.SIMULATEDPLAY, gameModeSelector.getSecondaryGameMode());
    }

    @Test
    public void askSecondaryOptions_InvalidChoice_ThenRewatch() {
        new IOHelper("yes\ny");
        UI ui = new ConsoleUI(IOHelper.in, IOHelper.print, 1);
        Communicator communicator = new Communicator(ui);
        GameModeSelector gameModeSelector = new GameModeSelector(communicator);

        assertEquals(GameMode.SIMULATEDPLAY, gameModeSelector.getSecondaryGameMode());
    }

    @Test
    public void askSecondaryOptions_noRewatchSoHumanVsComp() {
        new IOHelper("N\n1");
        UI ui = new ConsoleUI(IOHelper.in, IOHelper.print, 1);
        Communicator communicator = new Communicator(ui);
        GameModeSelector gameModeSelector = new GameModeSelector(communicator);

        assertEquals(GameMode.HUMANVSCOMP, gameModeSelector.getSecondaryGameMode());
    }

}


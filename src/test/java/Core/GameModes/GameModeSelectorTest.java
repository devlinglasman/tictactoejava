package Core.GameModes;

import Console.ConsoleUI;
import Console.IOHelper;
import Core.UserInterfaces.Communicator;
import Core.UserInterfaces.UI;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameModeSelectorTest {

    private GameModeSelector gameModeSelector;

    private void setUpWithInput(String input) {
        IOHelper ioHelper = new IOHelper(input);
        UI ui = new ConsoleUI(ioHelper.in, ioHelper.print, 0);
        Communicator communicator = new Communicator(ui);
        gameModeSelector = new GameModeSelector(communicator);
    }

    @Test
    public void getGameMode_humanvscomp() {
        setUpWithInput("1");

        assertEquals(GameMode.HUMANVSCOMP, gameModeSelector.getMode());
    }

    @Test
    public void getGameMode_compvscomp() {
        setUpWithInput("2");

        assertEquals(GameMode.COMPVSCOMP, gameModeSelector.getMode());
    }

    @Test
    public void getGameMode_humanvshuman() {
        setUpWithInput("3");

        assertEquals(GameMode.HUMANVSHUMAN, gameModeSelector.getMode());
    }

    @Test
    public void getGameMode_Invalid_TooLow() {
        setUpWithInput("0\n1");

        assertEquals(GameMode.HUMANVSCOMP, gameModeSelector.getMode());
    }

    @Test
    public void getGameMode_Invalid_TooHigh() {
        setUpWithInput("15\n1");

        assertEquals(GameMode.HUMANVSCOMP, gameModeSelector.getMode());
    }

    @Test
    public void getGameMode_Invalid_NotNumber() {
        setUpWithInput("asdf\n1");

        assertEquals(GameMode.HUMANVSCOMP, gameModeSelector.getMode());
    }
}


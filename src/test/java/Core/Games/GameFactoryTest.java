package Core.Games;

import Console.ConsoleUI;
import Core.GameMode;
import Core.Players.Player;
import Core.Players.PlayerFactory;
import Core.UserInterfaces.Communicator;
import Core.UserInterfaces.UI;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertTrue;

public class GameFactoryTest {


    @Test
    public void buildGame() {
        UI ui = new ConsoleUI(System.in, System.out, 1);
        Communicator communicator = new Communicator(ui);
        GameFactory gameFactory = new GameFactory(communicator);

        Game game = gameFactory.buildGame(GameMode.HUMANVSCOMP, communicator, true);

        assertTrue(game != null);
    }
}

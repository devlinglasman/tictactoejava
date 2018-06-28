package Core.Games;

import Console.ConsoleUI;
import Core.GameMode;
import Core.Players.Player;
import Core.Players.PlayerComputer;
import Core.Players.PlayerFactory;
import Core.Players.PlayerHuman;
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
        PlayerFactory playerFactory = new PlayerFactory(communicator);
        ArrayList<Player> players = playerFactory.producePrimaryPlayers(GameMode.HUMANVSCOMP);
        GameFactory gameFactory = new GameFactory();

        Game game = gameFactory.buildGame(players.get(0), players.get(1), communicator);

        assertTrue(game != null);
    }
}

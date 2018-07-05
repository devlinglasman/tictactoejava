package Core.Games;

import Console.ConsoleUI;
import Core.FileManipulators.GameDataWriter;
import Core.GameModes.GameMode;
import Core.Players.PlayerFactory;
import Core.UserInterfaces.Communicator;
import Core.UserInterfaces.UI;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class GameFactoryTest {

    @Test
    public void buildGame() {
        UI ui = new ConsoleUI(System.in, System.out, 1);
        Communicator communicator = new Communicator(ui);
        PlayerFactory playerFactory = new PlayerFactory(communicator);
        String pathName = "src/test/resources/dummyData.txt";
        GameDataWriter gameDataWriter = new GameDataWriter(pathName);
        GameFactory gameFactory = new GameFactory(communicator, playerFactory);

        Game game = gameFactory.buildGame(GameMode.HUMANVSCOMP, pathName);

        assertTrue(game != null);
    }
}

package Core.Games;

import Console.ConsoleUI;
import Core.FileManipulators.GameDataWriter;
import Core.FileManipulators.GameFileAnalyser;
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
        GameFileAnalyser gameFileAnalyser = new GameFileAnalyser();
        GameDataWriter gameDataWriter = new GameDataWriter();
        GameFactory gameFactory = new GameFactory(communicator, playerFactory, gameFileAnalyser, gameDataWriter);

        Game game = gameFactory.buildGame(GameMode.HUMANVSCOMP);

        assertTrue(game != null);
    }
}

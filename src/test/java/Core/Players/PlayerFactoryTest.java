package Core.Players;

import Console.ConsoleUI;
import Core.GameMode;
import Core.UserInterfaces.Communicator;
import Core.UserInterfaces.UI;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class PlayerFactoryTest {

    @Test
    public void gameMode_humanVsComp() {
        UI ui = new ConsoleUI(System.in, System.out, 1);
        Communicator communicator = new Communicator(ui);
        PlayerFactory playerFactory = new PlayerFactory(communicator);

        ArrayList<Player> players = playerFactory.producePrimaryPlayers(GameMode.HUMANVSCOMP);

        assertTrue(players.get(0) instanceof PlayerHuman);
        assertTrue(players.get(1) instanceof PlayerComputer);
    }

    @Test
    public void gameMode_compVsComp() {
        UI ui = new ConsoleUI(System.in, System.out, 1);
        Communicator communicator = new Communicator(ui);
        PlayerFactory playerFactory = new PlayerFactory(communicator);

        ArrayList<Player> players = playerFactory.producePrimaryPlayers(GameMode.COMPVSCOMP);

        assertTrue(players.get(0) instanceof PlayerComputer);
        assertTrue(players.get(1) instanceof PlayerComputer);
    }

    @Test
    public void gameMode_humanVsHuman() {
        UI ui = new ConsoleUI(System.in, System.out, 1);
        Communicator communicator = new Communicator(ui);
        PlayerFactory playerFactory = new PlayerFactory(communicator);

        ArrayList<Player> players = playerFactory.producePrimaryPlayers(GameMode.HUMANVSHUMAN);

        assertTrue(players.get(0) instanceof PlayerHuman);
        assertTrue(players.get(1) instanceof PlayerHuman);
    }

    @Test
    public void gameMode_simulatedPlay() {
        UI ui = new ConsoleUI(System.in, System.out, 1);
        Communicator communicator = new Communicator(ui);
        PlayerFactory playerFactory = new PlayerFactory(communicator);
        File gameData = new File("src/test/resources/testFile1.txt");

        ArrayList<Player> players = playerFactory.produceSimulatedPlayers(gameData);

        assertTrue(players.get(0) instanceof PlayerSimulated);
        assertTrue(players.get(1) instanceof PlayerSimulated);
        assertEquals("Player One", players.get(0).getName());
        assertEquals("Player Two", players.get(1).getName());
    }
}

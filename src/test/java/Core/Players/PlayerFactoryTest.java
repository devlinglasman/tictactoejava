package Core.Players;

import Console.ConsoleUI;
import Core.GameModes.GameMode;
import Core.UserInterfaces.Communicator;
import Core.UserInterfaces.UI;
import Core.UserInterfaces.UIStub;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class PlayerFactoryTest {

    private PlayerFactory playerFactory;

    @Before
    public void setUp() {
        UI ui = new UIStub();
        Communicator communicator = new Communicator(ui);
        MovesGenerator movesGenerator = new MovesGenerator();
        playerFactory = new PlayerFactory(communicator, movesGenerator);
    }

    @Test
    public void gameMode_humanVsComp() {
        List<Player> players = playerFactory.buildPrimaryPlayers(GameMode.HUMANVSCOMP);

        assertTrue(players.get(0) instanceof HumanPlayer);
        assertTrue(players.get(1) instanceof ComputerPlayer);
        assertEquals("Player One", players.get(0).getName());
        assertEquals("Player Two", players.get(1).getName());
    }

    @Test
    public void gameMode_compVsComp() {
        List<Player> players = playerFactory.buildPrimaryPlayers(GameMode.COMPVSCOMP);

        assertTrue(players.get(0) instanceof ComputerPlayer);
        assertTrue(players.get(1) instanceof ComputerPlayer);
    }

    @Test
    public void gameMode_humanVsHuman() {
        List<Player> players = playerFactory.buildPrimaryPlayers(GameMode.HUMANVSHUMAN);

        assertTrue(players.get(0) instanceof HumanPlayer);
        assertTrue(players.get(1) instanceof HumanPlayer);
    }

    @Test
    public void gameMode_simulatedPlay() {
        List<String> allMoves = Arrays.asList("0","1","2","3","4","5");

        List<Player> players = playerFactory.buildSimulatedPlayers(allMoves);

        assertTrue(players.get(0) instanceof SimulatedPlayer);
        assertTrue(players.get(1) instanceof SimulatedPlayer);
    }
}

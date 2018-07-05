package Core.Players;

import Console.ConsoleUI;
import Core.GameModes.GameMode;
import Core.UserInterfaces.Communicator;
import Core.UserInterfaces.UI;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class PlayerFactoryTest {

    @Test
    public void gameMode_humanVsComp() {
        UI ui = new ConsoleUI(System.in, System.out, 1);
        Communicator communicator = new Communicator(ui);
        PlayerFactory playerFactory = new PlayerFactory(communicator);

        List<Player> players = playerFactory.buildPrimaryPlayers(GameMode.HUMANVSCOMP);

        assertTrue(players.get(0) instanceof HumanPlayer);
        assertTrue(players.get(1) instanceof ComputerPlayer);
        assertEquals("Player One", players.get(0).getName());
        assertEquals("Player Two", players.get(1).getName());
    }

    @Test
    public void gameMode_compVsComp() {
        UI ui = new ConsoleUI(System.in, System.out, 1);
        Communicator communicator = new Communicator(ui);
        PlayerFactory playerFactory = new PlayerFactory(communicator);

        List<Player> players = playerFactory.buildPrimaryPlayers(GameMode.COMPVSCOMP);

        assertTrue(players.get(0) instanceof ComputerPlayer);
        assertTrue(players.get(1) instanceof ComputerPlayer);
    }

    @Test
    public void gameMode_humanVsHuman() {
        UI ui = new ConsoleUI(System.in, System.out, 1);
        Communicator communicator = new Communicator(ui);
        PlayerFactory playerFactory = new PlayerFactory(communicator);

        List<Player> players = playerFactory.buildPrimaryPlayers(GameMode.HUMANVSHUMAN);

        assertTrue(players.get(0) instanceof HumanPlayer);
        assertTrue(players.get(1) instanceof HumanPlayer);
    }

    @Test
    public void gameMode_simulatedPlay() {
        UI ui = new ConsoleUI(System.in, System.out, 1);
        Communicator communicator = new Communicator(ui);
        PlayerFactory playerFactory = new PlayerFactory(communicator);
        ArrayList<Integer> playerOneMoves = new ArrayList<>(asList(1,3,5));
        ArrayList<Integer> playerTwoMoves = new ArrayList<>(asList(2,4,6));

        List<Player> players = playerFactory.buildSimulatedPlayers(playerOneMoves, playerTwoMoves);

        assertTrue(players.get(0) instanceof SimulatedPlayer);
        assertTrue(players.get(1) instanceof SimulatedPlayer);
    }
}

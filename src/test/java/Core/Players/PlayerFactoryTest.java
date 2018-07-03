package Core.Players;

import Console.ConsoleUI;
import Core.GameMode;
import Core.UserInterfaces.Communicator;
import Core.UserInterfaces.UI;
import org.junit.Test;

import java.io.File;
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

        List<Player> players = playerFactory.buildPlayers(GameMode.HUMANVSCOMP);

        assertTrue(players.get(0) instanceof PlayerHuman);
        assertTrue(players.get(1) instanceof PlayerComputer);
        assertEquals("Player One", players.get(0).getName());
        assertEquals("Player Two", players.get(1).getName());
    }

    @Test
    public void gameMode_compVsComp() {
        UI ui = new ConsoleUI(System.in, System.out, 1);
        Communicator communicator = new Communicator(ui);
        PlayerFactory playerFactory = new PlayerFactory(communicator);

        List<Player> players = playerFactory.buildPlayers(GameMode.COMPVSCOMP);

        assertTrue(players.get(0) instanceof PlayerComputer);
        assertTrue(players.get(1) instanceof PlayerComputer);
        assertEquals("Player One", players.get(0).getName());
        assertEquals("Player Two", players.get(1).getName());
    }

    @Test
    public void gameMode_humanVsHuman() {
        UI ui = new ConsoleUI(System.in, System.out, 1);
        Communicator communicator = new Communicator(ui);
        PlayerFactory playerFactory = new PlayerFactory(communicator);

        List<Player> players = playerFactory.buildPlayers(GameMode.HUMANVSHUMAN);

        assertTrue(players.get(0) instanceof PlayerHuman);
        assertTrue(players.get(1) instanceof PlayerHuman);
        assertEquals("Player One", players.get(0).getName());
        assertEquals("Player Two", players.get(1).getName());
    }

    @Test
    public void gameMode_simulatedPlay() {
        UI ui = new ConsoleUI(System.in, System.out, 1);
        Communicator communicator = new Communicator(ui);
        PlayerFactory playerFactory = new PlayerFactory(communicator);
        ArrayList<Integer> playerOneMoves = new ArrayList<>(asList(1,3,5));
        ArrayList<Integer> playerTwoMoves = new ArrayList<>(asList(2,4,6));

        List<Player> players = playerFactory.buildPlayers(playerOneMoves, playerTwoMoves);

        assertTrue(players.get(0) instanceof PlayerSimulated);
        assertTrue(players.get(1) instanceof PlayerSimulated);
        assertEquals("Player One", players.get(0).getName());
        assertEquals("Player Two", players.get(1).getName());
    }
}

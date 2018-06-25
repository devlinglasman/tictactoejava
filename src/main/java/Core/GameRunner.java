package Core;

import Core.Players.Player;
import Core.Players.PlayerFactory;

import java.io.File;
import java.util.ArrayList;

public class GameRunner {

    private Communicator communicator;
    private GameModeSelector gameModeSelector;
    private PlayerFactory playerFactory;
    private File gameData = new File("src/test/resources/testFile1.txt");
    private boolean primaryGame;

    public GameRunner(Communicator communicator) {
        this.communicator = communicator;
        gameModeSelector = new GameModeSelector(communicator);
        playerFactory = new PlayerFactory(communicator);
        primaryGame = true;
    }

    public void run() {
        GameMode gameMode;
        ArrayList<Player> players;
        if (primaryGame) {
           gameMode = gameModeSelector.getPrimaryGameMode();
           players = getPlayers(gameMode);
        } else {
            gameMode = gameModeSelector.getSecondaryGameMode();
            players = getPlayers(gameMode, gameData);
        }
        runGame(players);
    }

    private ArrayList<Player> getPlayers(GameMode gameMode) {
        return playerFactory.producePlayers(gameMode);
    }

    private ArrayList<Player> getPlayers(GameMode gameMode, File gameData) {
        return playerFactory.producePlayers(gameMode,gameData);
    }

    private void runGame(ArrayList<Player> players) {
        Grid grid = new Grid();
        Game game = new Game(grid, players.get(0), players.get(1), communicator);
        game.runGame();
    }
}

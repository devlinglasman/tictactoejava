package Core;

import Core.Players.Player;
import Core.Players.PlayerFactory;

import java.util.ArrayList;

public class GameRunner {

    private Communicator communicator;
    private GameModeSelector gameModeSelector;
    private PlayerFactory playerFactory;

    public GameRunner(Communicator communicator) {
        this.communicator = communicator;
        gameModeSelector = new GameModeSelector(communicator);
        playerFactory = new PlayerFactory(communicator);
    }

    public void run() {
        runPrimaryGame();
        runSecondaryOptions();
    }

    private void runPrimaryGame() {
        GameMode gameMode = gameModeSelector.getGameMode();
        ArrayList<Player> players = playerFactory.producePlayers(gameMode);
        Grid grid = new Grid();
        Game game = new Game(grid, players.get(0), players.get(1), communicator);
        game.runGame();
    }

    private void runSecondaryOptions() {
        gameModeSelector.askSecondaryOptions();
    }
}

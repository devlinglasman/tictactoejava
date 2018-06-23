package Core;

import Core.Players.Player;
import Core.Players.PlayerFactory;

import java.util.ArrayList;

public class GameRunner {

    private UI ui;
    private GameModeSelector gameModeSelector;
    private PlayerFactory playerFactory;

    public GameRunner(UI ui) {
        this.ui = ui;
        gameModeSelector = new GameModeSelector(ui);
        playerFactory = new PlayerFactory(ui);
    }

    public void run() {
        GameMode gameMode = gameModeSelector.getGameMode();
        ArrayList<Player> players = playerFactory.producePlayers(gameMode);
        Grid grid = new Grid();
        Game game = new Game(grid, players.get(0), players.get(1), ui);
        game.runGame();
    }
}

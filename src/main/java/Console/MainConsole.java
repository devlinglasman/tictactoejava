package Console;

import Core.*;
import Core.Players.Player;
import Core.Players.PlayerFactory;

import java.util.ArrayList;

public class MainConsole {

    public static void main(String[] args) {
        UI ui = new ConsoleUI(System.in, System.out, 1000);
        GameModeSelector gameModeSelector = new GameModeSelector(ui);
        GameMode gameMode = gameModeSelector.getGameMode();
        PlayerFactory playerFactory = new PlayerFactory(ui);
        ArrayList<Player> players = playerFactory.producePlayers(gameMode);
        Grid grid = new Grid();
        Game game = new Game(grid, players.get(0), players.get(1), ui);
        game.runGame();
    }
}
package Core.Games;

import Core.GameMode;
import Core.Grid;
import Core.Players.Player;
import Core.Players.PlayerFactory;
import Core.UserInterfaces.Communicator;

import java.util.ArrayList;

public class GameFactory {

    private PlayerFactory playerFactory;
    private Communicator communicator;

    public GameFactory(Communicator communicator) {
        this.communicator = communicator;
        playerFactory = new PlayerFactory(communicator);
    }

    public Game buildGame(GameMode gameMode, Communicator  communicator, boolean isRecordable) {
        ArrayList<Player> players = playerFactory.buildPlayers(gameMode);
        Grid grid = new Grid();
        Game primaryGame = new PrimaryGame(grid, players.get(0), players.get(1), communicator);
        return (isRecordable) ? new RecordableGame(primaryGame) : primaryGame;
    }
}

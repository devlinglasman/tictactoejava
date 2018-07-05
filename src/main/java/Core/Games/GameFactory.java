package Core.Games;

import Core.Board.Grid;
import Core.FileAccessor;
import Core.GameModes.GameMode;
import Core.Players.Player;
import Core.Players.PlayerFactory;
import Core.UserInterfaces.Communicator;

import java.io.File;
import java.util.List;

public class GameFactory {

    private Communicator communicator;
    private PlayerFactory playerFactory;
    private FileAccessor fileAccessor;
    private String pathName;

    public GameFactory(Communicator communicator, PlayerFactory playerFactory, FileAccessor fileAccessor, String pathName) {
        this.communicator = communicator;
        this.playerFactory = playerFactory;
        this.fileAccessor = fileAccessor;
        this.pathName = pathName;
    }

    public Game buildGame(GameMode gameMode) {
        List<Player> players;
        if (gameMode == GameMode.SIMULATEDPLAY) {
            players = buildSimulatedPlayers();
        } else {
            fileAccessor.overwriteFile(pathName);
            players = buildPrimaryPlayers(gameMode);
        }
        Grid grid = new Grid();
        Game primaryGame = new PrimaryGame(grid, players.get(0), players.get(1), communicator);
        return new RecordableGame(primaryGame, fileAccessor);
    }

    private List<Player> buildSimulatedPlayers() {
        List<String> allMoves = fileAccessor.performExtraction();
        return playerFactory.buildSimulatedPlayers(allMoves);
    }

    private List<Player> buildPrimaryPlayers(GameMode gameMode) {
        return playerFactory.buildPrimaryPlayers(gameMode);
    }
}

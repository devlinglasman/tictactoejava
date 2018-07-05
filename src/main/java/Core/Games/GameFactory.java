package Core.Games;

import Core.Board.Grid;
import Core.FileManipulators.FileAccessor;
import Core.GameModes.GameMode;
import Core.Players.Player;
import Core.Players.PlayerFactory;
import Core.UserInterfaces.Communicator;

import java.util.List;

public class GameFactory {

    private Communicator communicator;
    private PlayerFactory playerFactory;

    public GameFactory(Communicator communicator, PlayerFactory playerFactory) {
        this.communicator = communicator;
        this.playerFactory = playerFactory;
    }

    public Game buildGame(GameMode gameMode, String filePathName) {
        FileAccessor fileAccessor = new FileAccessor(filePathName);
        List<Player> players = buildPlayers(gameMode, fileAccessor);
        Grid grid = new Grid();
        Game primaryGame = new PrimaryGame(grid, players.get(0), players.get(1), communicator);
        return new RecordableGame(primaryGame, fileAccessor);
    }

    private List<Player> buildPlayers(GameMode gameMode, FileAccessor fileAccessor) {
        return (gameMode == GameMode.SIMULATEDPLAY) ? buildSimulatedPlayers(fileAccessor)
            : buildPrimaryPlayers(gameMode);
    }

    private List<Player> buildSimulatedPlayers(FileAccessor fileAccessor) {
        List<Integer> playerOneMoves = fileAccessor.generateMoves(0);
        List<Integer> playerTwoMoves = fileAccessor.generateMoves(1);
        return playerFactory.buildSimulatedPlayers(playerOneMoves, playerTwoMoves);
    }

    private List<Player> buildPrimaryPlayers(GameMode gameMode) {
        return playerFactory.buildPrimaryPlayers(gameMode);
    }

}

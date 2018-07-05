package Core.Games;

import Core.Board.Grid;
import Core.FileManipulators.GameDataWriter;
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
        GameDataWriter gameDataWriter = new GameDataWriter(filePathName);
        List<Player> players = buildPlayers(gameMode, gameDataWriter);
        Grid grid = new Grid();
        Game primaryGame = new PrimaryGame(grid, players.get(0), players.get(1), communicator);
        return new RecordableGame(primaryGame, gameDataWriter);
    }

    private List<Player> buildPlayers(GameMode gameMode, GameDataWriter gameDataWriter) {
        List<Player> players;
        if (gameMode == GameMode.SIMULATEDPLAY) {
            players = buildSimulatedPlayers(gameDataWriter);
        } else {
            players = buildPrimaryPlayers(gameMode);
        }
        return players;
    }

    private List<Player> buildSimulatedPlayers(GameDataWriter gameDataWriter) {
        return playerFactory.buildSimulatedPlayers(generateMoves(gameDataWriter, 0)
                , generateMoves(gameDataWriter, 1));
    }

    private List<Integer> generateMoves(GameDataWriter gameDataWriter, int playerPosition) {
        return gameDataWriter.generateMoves(playerPosition);
    }

    private List<Player> buildPrimaryPlayers(GameMode gameMode) {
        return playerFactory.buildPrimaryPlayers(gameMode);
    }

}

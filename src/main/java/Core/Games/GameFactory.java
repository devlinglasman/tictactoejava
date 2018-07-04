package Core.Games;

import Core.FileManipulators.GameDataWriter;
import Core.FileManipulators.GameFileAnalyser;
import Core.GameModes.GameMode;
import Core.Board.Grid;
import Core.Players.Player;
import Core.Players.PlayerFactory;
import Core.UserInterfaces.Communicator;

import java.util.List;

public class GameFactory {

    private Communicator communicator;
    private PlayerFactory playerFactory;
    private GameFileAnalyser gameFileAnalyser;
    private GameDataWriter gameDataWriter;

    public GameFactory(Communicator communicator, PlayerFactory playerFactory, GameFileAnalyser gameFileAnalyser, GameDataWriter gameDataWriter) {
        this.communicator = communicator;
        this.playerFactory = playerFactory;
        this.gameFileAnalyser = gameFileAnalyser;
        this.gameDataWriter = gameDataWriter;
    }

    public Game buildGame(GameMode gameMode) {
        List<Player> players = getPlayers(gameMode);
        Grid grid = new Grid();
        Game primaryGame = new PrimaryGame(grid, players.get(0), players.get(1), communicator);
        return new RecordableGame(primaryGame, gameDataWriter);
    }

    private List<Player> getPlayers(GameMode gameMode) {
        List<Player> players;
        if (gameMode == GameMode.SIMULATEDPLAY) {
            players = buildSimulatedPlayers();
        } else {
            players = buildPrimaryPlayers(gameMode);
        }
        return players;
    }

    private List<Player> buildSimulatedPlayers() {
        return playerFactory.buildSimulatedPlayers(generateMoves(0), generateMoves(1));
    }

    private List<Integer> generateMoves(int playerPosition) {
        return gameFileAnalyser.generateMovesFromFile(gameDataWriter.getGameData(),playerPosition);
    }

    private List<Player> buildPrimaryPlayers(GameMode gameMode) {
        return playerFactory.buildPrimaryPlayers(gameMode);
    }

}

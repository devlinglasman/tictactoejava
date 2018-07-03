package Core.Games;

import Core.FileManipulators.GameFileAnalyser;
import Core.GameMode;
import Core.Grid;
import Core.Players.Player;
import Core.Players.PlayerFactory;
import Core.UserInterfaces.Communicator;

import java.util.ArrayList;
import java.util.List;

public class GameFactory {

    private Communicator communicator;
    private PlayerFactory playerFactory;
    private GameFileAnalyser gameFileAnalyser;

    public GameFactory(Communicator communicator, PlayerFactory playerFactory, GameFileAnalyser gameFileAnalyser) {
        this.communicator = communicator;
        this.playerFactory = playerFactory;
        this.gameFileAnalyser = gameFileAnalyser;
    }

    public Game buildGame(GameMode gameMode) {
        List<Player> players;
        if (gameMode == GameMode.SIMULATEDPLAY) {
            players = buildSimulatedPlayers();
        } else {
            players = buildPrimaryPlayers(gameMode);
        }
        return buildGameWithPlayers(players);
    }

    private List<Player> buildSimulatedPlayers() {
        List<Integer> playerOneMoves = gameFileAnalyser.generateMovesFromFile(0);
        List<Integer> playerTwoMoves = gameFileAnalyser.generateMovesFromFile(1);
        return playerFactory.buildSimulatedPlayers(playerOneMoves, playerTwoMoves);
    }

    private List<Player> buildPrimaryPlayers(GameMode gameMode) {
        return playerFactory.buildPrimaryPlayers(gameMode);
    }

    private Game buildGameWithPlayers(List<Player> players) {
        Grid grid = new Grid();
        Game primaryGame = new PrimaryGame(grid, players.get(0), players.get(1), communicator);
        return new RecordableGame(primaryGame);
    }
}

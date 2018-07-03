package Core.Games;

import Core.FileManipulators.GameFileAnalyser;
import Core.GameMode;
import Core.Grid;
import Core.Players.Player;
import Core.Players.PlayerFactory;
import Core.UserInterfaces.Communicator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GameFactory {

    private PlayerFactory playerFactory;

    public GameFactory(Communicator communicator) {
        playerFactory = new PlayerFactory(communicator);
    }

    public Game buildGame(GameMode gameMode, Communicator  communicator, boolean isRecordable) {
        if (gameMode == GameMode.SIMULATEDPLAY) {
            return buildSimulatedGame(communicator, isRecordable);
        } else {
            List<Player> players = playerFactory.buildPlayers(gameMode);
            return buildGameWithPlayers(players, communicator, isRecordable);
        }
    }

    private Game buildSimulatedGame(Communicator communicator, boolean isRecordable) {
        GameFileAnalyser gameFileAnalyser = new GameFileAnalyser();
        ArrayList<Integer> playerOneMoves = gameFileAnalyser.generateMovesFromFile(0);
        ArrayList<Integer> playerTwoMoves = gameFileAnalyser.generateMovesFromFile(1);
        List<Player> players = playerFactory.buildPlayers(playerOneMoves, playerTwoMoves);
        return buildGameWithPlayers(players, communicator, isRecordable);
    }


    private Game buildGameWithPlayers(List<Player> players, Communicator communicator, boolean isRecordable) {
        Grid grid = new Grid();
        Game primaryGame = new PrimaryGame(grid, players.get(0), players.get(1), communicator);
        return (isRecordable) ? new RecordableGame(primaryGame) : primaryGame;
    }
}

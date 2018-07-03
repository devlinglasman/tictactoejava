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

    private Communicator communicator;
    private PlayerFactory playerFactory;
    private GameFileAnalyser gameFileAnalyser;

    public GameFactory(Communicator communicator, PlayerFactory playerFactory, GameFileAnalyser gameFileAnalyser) {
        this.communicator = communicator;
        this.playerFactory = playerFactory;
        this.gameFileAnalyser = gameFileAnalyser;
    }

    public Game buildGame(GameMode gameMode, boolean isRecordable) {
        if (gameMode == GameMode.SIMULATEDPLAY) {
            return buildSimulatedGame(isRecordable);
        } else {
            List<Player> players = playerFactory.buildPlayers(gameMode);
            return buildGameWithPlayers(players, isRecordable);
        }
    }

    private Game buildSimulatedGame(boolean isRecordable) {
        ArrayList<Integer> playerOneMoves = gameFileAnalyser.generateMovesFromFile(0);
        ArrayList<Integer> playerTwoMoves = gameFileAnalyser.generateMovesFromFile(1);
        List<Player> players = playerFactory.buildPlayers(playerOneMoves, playerTwoMoves);
        return buildGameWithPlayers(players, isRecordable);
    }


    private Game buildGameWithPlayers(List<Player> players, boolean isRecordable) {
        Grid grid = new Grid();
        Game primaryGame = new PrimaryGame(grid, players.get(0), players.get(1), communicator);
        return (isRecordable) ? new RecordableGame(primaryGame) : primaryGame;
    }
}

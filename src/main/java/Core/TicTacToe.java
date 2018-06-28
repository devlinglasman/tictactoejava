package Core;

import Core.FileManipulators.GameDataWriter;
import Core.Games.Game;
import Core.Games.GameFactory;
import Core.Players.Player;
import Core.Players.PlayerFactory;
import Core.UserInterfaces.Communicator;

import java.io.File;
import java.util.ArrayList;

public class TicTacToe {

    private Communicator communicator;
    private GameFactory gameFactory;
    private GameModeSelector gameModeSelector;
    private PlayerFactory playerFactory;
    private boolean programTerminated;
    private GameDataWriter gameDataWriter;

    public TicTacToe(Communicator communicator) {
        this.communicator = communicator;
        gameFactory = new GameFactory();
        gameModeSelector = new GameModeSelector(communicator);
        playerFactory = new PlayerFactory(communicator);
        programTerminated = false;
        gameDataWriter = new GameDataWriter();
    }

    public void run() {
        runGame();
    }

    private void runGame() {
        GameMode gameMode = gameModeSelector.getPrimaryGameMode();
        ArrayList<Player> players = getPlayers(gameMode);
        Game game = gameFactory.buildGame(players.get(0), players.get(1), communicator);
        game.runGame();
    }

//    private void runSimulatedGame(File gameData) {
//        ArrayList<Player> players = getPlayers(gameData);
//    }

    private ArrayList<Player> getPlayers(GameMode gameMode) {
        return playerFactory.buildPlayers(gameMode);
    }

//    private ArrayList<Player> getPlayers(File gameData) {
//        return playerFactory.buildPlayers(gameData);
//    }
}

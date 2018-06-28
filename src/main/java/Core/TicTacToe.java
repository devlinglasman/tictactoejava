package Core;

import Core.FileManipulators.GameDataWriter;
import Core.Games.Game;
import Core.Games.GameFactory;
import Core.Players.Player;
import Core.Players.PlayerFactory;
import Core.UserInterfaces.Communicator;

import java.util.ArrayList;

public class TicTacToe {

    private Communicator communicator;
    private GameFactory gameFactory;
    private GameModeSelector gameModeSelector;
    private PlayerFactory playerFactory;
    private boolean programTerminated;
    private GameDataWriter gameDataWriter;
    private boolean isRecording;

    public TicTacToe(Communicator communicator) {
        this.communicator = communicator;
        gameFactory = new GameFactory();
        gameModeSelector = new GameModeSelector(communicator);
        playerFactory = new PlayerFactory(communicator);
        programTerminated = false;
        gameDataWriter = new GameDataWriter();
        isRecording = true;
    }

    public void run() {
        runGame();
    }

    private void runGame() {
        GameMode gameMode = gameModeSelector.getPrimaryGameMode();
        ArrayList<Player> players = getPlayers(gameMode);
        Game game = gameFactory.buildGame(players.get(0), players.get(1), communicator, isRecording);
        game.runGame();
    }

    private ArrayList<Player> getPlayers(GameMode gameMode) {
        return playerFactory.buildPlayers(gameMode);
    }
}

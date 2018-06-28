package Core;

import Core.FileManipulators.GameDataWriter;
import Core.Games.Game;
import Core.Games.GameFactory;
import Core.Games.GameRunner;
import Core.Players.Player;
import Core.Players.PlayerFactory;
import Core.UserInterfaces.Communicator;

import java.util.ArrayList;

public class TicTacToe {

    private Communicator communicator;
    private GameRunner gameRunner;
    private GameFactory gameFactory;
    private GameModeSelector gameModeSelector;
    private PlayerFactory playerFactory;
    private boolean programTerminated;
    private GameDataWriter gameDataWriter;
    private boolean isRecording;

    public TicTacToe(Communicator communicator) {
        this.communicator = communicator;
        gameRunner = new GameRunner();
        gameFactory = new GameFactory(communicator);
        gameModeSelector = new GameModeSelector(communicator);
        programTerminated = false;
        gameDataWriter = new GameDataWriter();
        isRecording = true;
    }

    public void run() {
        runGame();
    }

    private void runGame() {
        GameMode gameMode = gameModeSelector.getPrimaryGameMode();
        Game game = gameFactory.buildGame(gameMode, communicator, isRecording);
        gameRunner.runGame(game);
    }
}

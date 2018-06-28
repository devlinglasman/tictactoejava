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
    private boolean isRecording;

    public TicTacToe(Communicator communicator) {
        this.communicator = communicator;
        gameRunner = new GameRunner();
        gameFactory = new GameFactory(communicator);
        gameModeSelector = new GameModeSelector(communicator);
        isRecording = true;
    }

    public void run() {
        GameMode gameMode;
        if (rewatch()) {
            gameMode = GameMode.SIMULATEDPLAY;
        } else {
            gameMode = getMode();
        }
        runGame(gameMode);
    }

    private boolean rewatch() {
        return false;
    }

    private GameMode getMode() {
        return gameModeSelector.getPrimaryGameMode();
    }

    private void runGame(GameMode gameMode) {
        Game game = gameFactory.buildGame(gameMode, communicator, isRecording);
        gameRunner.runGame(game);
    }
}

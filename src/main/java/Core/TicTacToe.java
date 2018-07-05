package Core;

import Core.GameModes.GameMode;
import Core.GameModes.GameModeSelector;
import Core.Games.Game;
import Core.Games.GameFactory;
import Core.UserInterfaces.Communicator;

public class TicTacToe {

    private Communicator communicator;
    private GameRunner gameRunner;
    private GameFactory gameFactory;
    private GameModeSelector gameModeSelector;
    private String filePathName;

    public TicTacToe(Communicator communicator, GameRunner gameRunner, GameFactory gameFactory, GameModeSelector gameModeSelector, String filePathName) {
        this.communicator = communicator;
        this.gameRunner = gameRunner;
        this.gameFactory = gameFactory;
        this.gameModeSelector = gameModeSelector;
        this.filePathName = filePathName;
    }

    public void run() {
        GameMode gameMode = getMode();
        runGame(gameMode);
        if (findIfPlayAnotherGame()) {
            run();
        } else {
            communicator.announceProgramOver();
        }
    }

    private boolean findIfPlayAnotherGame() {
        return communicator.findPlayAgainResponse();
    }

    private GameMode getMode() {
        return gameModeSelector.getMode();
    }

    private void runGame(GameMode gameMode) {
        Game game = gameFactory.buildGame(gameMode, filePathName);
        gameRunner.runGame(game);
        while (rewatch()) {
            Game rewatchGame = gameFactory.buildGame(GameMode.SIMULATEDPLAY, filePathName);
            gameRunner.runGame(rewatchGame);
        }
    }

    private boolean rewatch() {
        return communicator.findRewatchResponse();
    }
}

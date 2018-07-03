package Core;

import Core.FileManipulators.GameFileAnalyser;
import Core.Games.Game;
import Core.Games.GameFactory;
import Core.Games.GameRunner;
import Core.UserInterfaces.Communicator;

public class TicTacToe {

    private Communicator communicator;
    private GameRunner gameRunner;
    private GameFactory gameFactory;
    private GameModeSelector gameModeSelector;
    private boolean isRecording;

    public TicTacToe(Communicator communicator, GameRunner gameRunner, GameFactory gameFactory, GameModeSelector gameModeSelector) {
        this.communicator = communicator;
        this.gameRunner = gameRunner;
        this.gameFactory = gameFactory;
        this.gameModeSelector = gameModeSelector;
        isRecording = true;
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
        communicator.askIfPlayAgain();
        return communicator.returnTrueIfYes();
    }

    private GameMode getMode() {
        return gameModeSelector.getMode();
    }

    private void runGame(GameMode gameMode) {
        Game game = gameFactory.buildGame(gameMode, isRecording);
        gameRunner.runGame(game);
        while (rewatch()) {
            Game rewatchGame = gameFactory.buildGame(GameMode.SIMULATEDPLAY, isRecording);
            gameRunner.runGame(rewatchGame);
        }
    }

    private boolean rewatch() {
        communicator.askRewatch();
        return communicator.returnTrueIfYes();
    }
}

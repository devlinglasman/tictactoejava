package Core;

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

    public TicTacToe(Communicator communicator) {
        this.communicator = communicator;
        gameRunner = new GameRunner();
        gameFactory = new GameFactory(communicator);
        gameModeSelector = new GameModeSelector(communicator);
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
        Game game = gameFactory.buildGame(gameMode, communicator, isRecording);
        gameRunner.runGame(game);
        while (rewatch()) {
            Game rewatchGame = gameFactory.buildGame(GameMode.SIMULATEDPLAY, communicator, isRecording);
            gameRunner.runGame(rewatchGame);
        }
    }

    private boolean rewatch() {
        communicator.askRewatch();
        return communicator.returnTrueIfYes();
    }
}

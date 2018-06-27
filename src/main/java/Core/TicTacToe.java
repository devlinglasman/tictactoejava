package Core;

import Core.FileManipulators.GameDataWriter;
import Core.Games.Game;
import Core.Games.GameRecordable;
import Core.Games.PrimaryGame;
import Core.Players.Player;
import Core.Players.PlayerFactory;
import Core.UserInterfaces.Communicator;

import java.io.File;
import java.util.ArrayList;

public class TicTacToe {

    private Communicator communicator;
    private GameModeSelector gameModeSelector;
    private PlayerFactory playerFactory;
    private boolean programTerminated;
    private GameDataWriter gameDataWriter;

    public TicTacToe(Communicator communicator) {
        this.communicator = communicator;
        gameModeSelector = new GameModeSelector(communicator);
        playerFactory = new PlayerFactory(communicator);
        programTerminated = false;
        gameDataWriter = new GameDataWriter();
    }

    public void run() {
        runPrimaryGame();
        while (!programTerminated) {
            String rewatchOrReplay = findIfPlayerWishesToRewatchOrReplay();
            switch (rewatchOrReplay) {
                case "rewatch":
                    runSimulatedGame(gameDataWriter.getGameData());
                    break;
                case "replay":
                    runPrimaryGame();
                    break;
                default:
                    programTerminated = true;
                    communicator.announceProgramOver();
            }
        }
    }

    private void runPrimaryGame() {
        GameMode gameMode = gameModeSelector.getPrimaryGameMode();
        ArrayList<Player> players = getPlayers(gameMode);
        runGame(players);
    }

    private void runSimulatedGame(File gameData) {
        ArrayList<Player> players = getPlayers(gameData);
        runGame(players);
    }

    private void runGame(ArrayList<Player> players) {
        Grid grid = new Grid();
        PrimaryGame primaryGame = new PrimaryGame(grid, players.get(0), players.get(1), communicator);
        Game game = new GameRecordable(primaryGame, gameDataWriter);
        gameDataWriter.createFile();
        gameDataWriter.writeGameValue(players.get(0).getName());
        gameDataWriter.writeGameValue(players.get(1).getName());
        game.runGame();
    }

    private ArrayList<Player> getPlayers(GameMode gameMode) {
        return playerFactory.producePrimaryPlayers(gameMode);
    }

    private ArrayList<Player> getPlayers(File gameData) {
        return playerFactory.produceSimulatedPlayers(gameData);
    }

    private String findIfPlayerWishesToRewatchOrReplay() {
        String rewatchOrReplay;
        if (findIfPlayerWishesToRewatch()) {
            rewatchOrReplay = "rewatch";
        } else if (findIfPlayerWishesToReplay()) {
            rewatchOrReplay = "replay";
        } else {
            rewatchOrReplay = "none";
        }
        return rewatchOrReplay;
    }

    private boolean findIfPlayerWishesToRewatch() {
        communicator.askRewatch();
        String yesOrNoAnswer = communicator.findYesorNoAnswer();
        return yesOrNoAnswer.equals("y");
    }

    private boolean findIfPlayerWishesToReplay() {
        communicator.askReplay();
        String yesOrNoAnswer = communicator.findYesorNoAnswer();
        return yesOrNoAnswer.equals("y");
    }
}

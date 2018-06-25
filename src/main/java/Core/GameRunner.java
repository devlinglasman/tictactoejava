package Core;

import Core.Players.Player;
import Core.Players.PlayerFactory;

import java.io.File;
import java.util.ArrayList;

public class GameRunner {

    private Communicator communicator;
    private GameModeSelector gameModeSelector;
    private PlayerFactory playerFactory;
    private File gameData = null;
    private boolean programTerminated;

    public GameRunner(Communicator communicator) {
        this.communicator = communicator;
        gameModeSelector = new GameModeSelector(communicator);
        playerFactory = new PlayerFactory(communicator);
        programTerminated = false;
    }

    public void run() {
        ArrayList<Player> players;
        runPrimaryGame();
        while (!programTerminated) {
            String rewatchOrReplay = findIfPlayerWishesToRewatchOrReplay();
            switch (rewatchOrReplay) {
                case "rewatch":
                    players = getPlayers(GameMode.SIMULATEDPLAY, gameData);
                    runGame(players);
                    break;
                case "replay":
                    runPrimaryGame();
                    break;
                default:
                    programTerminated = true;
                    communicator.announceProgramOver();
                    break;
            }
        }
    }

    private void runPrimaryGame() {
        GameMode gameMode = gameModeSelector.getPrimaryGameMode();
        ArrayList<Player> players = getPlayers(gameMode);
        runGame(players);
    }

    private void runGame(ArrayList<Player> players) {
        Grid grid = new Grid();
        Game game = new Game(grid, players.get(0), players.get(1), communicator);
        game.runGame();
    }

    private ArrayList<Player> getPlayers(GameMode gameMode) {
        return playerFactory.producePlayers(gameMode);
    }

    private ArrayList<Player> getPlayers(GameMode gameMode, File gameData) {
        return playerFactory.producePlayers(gameMode, gameData);
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

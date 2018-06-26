package Core.Games;

import Core.UserInterfaces.Communicator;
import Core.Grid;
import Core.Players.Player;

public abstract class GameDecorator implements Game {

    private Game primaryGame;

    public GameDecorator(Game primaryGame) {
        this.primaryGame = primaryGame;
    }

    public Game getPrimaryGame() {
        return primaryGame;
    }

    @Override
    public void runGame() {
        primaryGame.runGame();
    }

    @Override
    public Player getActivePlayer() {
        return primaryGame.getActivePlayer();
    }

    @Override
    public void alternatePlayer() {
        primaryGame.alternatePlayer();
    }

    @Override
    public boolean gameOngoing() {
        return primaryGame.gameOngoing();
    }

    @Override
    public void announceResult() {
        primaryGame.announceResult();
    }

    @Override
    public Grid getGrid() {
        return primaryGame.getGrid();
    }

    @Override
    public Communicator getCommunicator() {
        return primaryGame.getCommunicator();
    }
}

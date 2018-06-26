package Core.Games;

import Core.UserInterfaces.Communicator;
import Core.Grid;
import Core.Players.Player;

public interface Game {

    void runGame();

    Player getActivePlayer();

    void alternatePlayer();

    boolean gameOngoing();

    void announceResult();

    Communicator getCommunicator();

    Grid getGrid();
}

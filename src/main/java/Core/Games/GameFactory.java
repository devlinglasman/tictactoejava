package Core.Games;

import Core.Grid;
import Core.Players.Player;
import Core.UserInterfaces.Communicator;

public class GameFactory {

    public Game buildGame(Player playerOne, Player playerTwo, Communicator  communicator) {
        Grid grid = new Grid();
        return new PrimaryGame(grid, playerOne, playerTwo, communicator);
    }
}

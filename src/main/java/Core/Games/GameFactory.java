package Core.Games;

import Core.Grid;
import Core.Players.Player;
import Core.UserInterfaces.Communicator;

public class GameFactory {

    public Game buildGame(Player playerOne, Player playerTwo, Communicator  communicator, boolean isRecordable) {
        Grid grid = new Grid();
        Game primaryGame = new PrimaryGame(grid, playerOne, playerTwo, communicator);
        return (isRecordable) ? new RecordableGame(primaryGame) : primaryGame;
    }
}

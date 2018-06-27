package Core.Games;

import Core.FileManipulators.GameDataWriter;
import Core.Grid;
import Core.Players.Player;
import Core.UserInterfaces.Communicator;

public class GameRecordable {

    private PrimaryGame primaryGame;
    private GameDataWriter gameDataWriter;

    public GameRecordable(PrimaryGame primaryGame, GameDataWriter gameDataWriter) {
        this.primaryGame = primaryGame;
        this.gameDataWriter = gameDataWriter;
    }

    public void makeMove() {

    }
}

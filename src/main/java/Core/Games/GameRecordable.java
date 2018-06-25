package Core.Games;

import Core.FileManipulators.GameDataWriter;

public class GameRecordable extends GameDecorator {

    private GameDataWriter gameDataWriter;

    public GameRecordable(Game primaryGame, GameDataWriter gameDataWriter) {
        super(primaryGame);
        this.gameDataWriter = gameDataWriter;
    }

    @Override
    public void runGame() {
        getCommunicator().displayGrid(getGrid().getSquares());
        while (gameOngoing()) {
            getActivePlayer().makeMove(getGrid());
            String move = getActivePlayer().getPreviousMove().toString();
            gameDataWriter.writeGameValue(move);
            getCommunicator().presentMove(getActivePlayer(), getGrid());
            alternatePlayer();
        }
        announceResult();
    }
}

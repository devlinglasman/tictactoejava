package Core.Games;

public class GameRecordable extends GameDecorator {

    private Game primaryGame;

    public GameRecordable(Game primaryGame) {
        super(primaryGame);
    }

    @Override
    public void runGame() {
        primaryGame.getCommunicator().displayGrid(primaryGame.getGrid().getSquares());
        while (gameOngoing()) {
            primaryGame.getActivePlayer().makeMove(primaryGame.getGrid());
            primaryGame.getCommunicator().presentMove(primaryGame.getActivePlayer(), primaryGame.getGrid());
            alternatePlayer();
        }
        announceResult();
    }
}

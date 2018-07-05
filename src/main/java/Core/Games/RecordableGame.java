package Core.Games;

import Core.FileAccessor;

public class RecordableGame implements Game {

    private Game primaryGame;
    private FileAccessor fileAccessor;

    public RecordableGame(Game primaryGame, FileAccessor fileAccessor) {
        this.primaryGame = primaryGame;
        this.fileAccessor = fileAccessor;
    }

    @Override
    public boolean gameOngoing() {
        return primaryGame.gameOngoing();
    }

    @Override
    public void playNextMove() {
        primaryGame.playNextMove();
        convertAndWriteMove(getLastMove());
    }

    @Override
    public void announceResult() {
        primaryGame.announceResult();
    }

    @Override
    public Integer getLastMove() {
        return primaryGame.getLastMove();
    }

    private void convertAndWriteMove(Integer move) {
        fileAccessor.writeGameValue(Integer.toString(move));
    }

}

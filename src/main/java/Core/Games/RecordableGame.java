package Core.Games;

import Core.FileManipulators.GameDataWriter;

public class RecordableGame implements Game {

    private Game primaryGame;
    private GameDataWriter gameDataWriter;

    public RecordableGame(Game primaryGame, GameDataWriter gameDataWriter) {
        this.primaryGame = primaryGame;
        this.gameDataWriter = gameDataWriter;
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
        gameDataWriter.writeGameValue(Integer.toString(move));
    }

}

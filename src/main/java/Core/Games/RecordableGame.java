package Core.Games;

import Core.FileManipulators.GameDataWriter;

public class RecordableGame implements Game {

    private Game primaryGame;
    private GameDataWriter gameDataWriter;

    public RecordableGame(Game primaryGame) {
        this.primaryGame = primaryGame;
        gameDataWriter = new GameDataWriter();
        gameDataWriter.createFile();
    }

    @Override
    public void displayGrid() {
        primaryGame.displayGrid();
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
    public void markGrid(Integer move) {
        primaryGame.markGrid(move);
    }

    public void convertAndWriteMove(Integer move) {
        gameDataWriter.writeGameValue(Integer.toString(move));
    }

    public void announceResult() {
        primaryGame.announceResult();
    }

    public Integer getLastMove() {
        return primaryGame.getLastMove();
    }
}

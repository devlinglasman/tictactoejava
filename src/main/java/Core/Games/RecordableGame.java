package Core.Games;

import Core.FileManipulators.GameDataWriter;

public class RecordableGame implements Game {

    private Game primaryGame;
    private GameDataWriter gameDataWriter;

    public RecordableGame(Game primaryGame) {
        this.primaryGame = primaryGame;
        gameDataWriter = new GameDataWriter();
    }

    public void displayGrid() {
        primaryGame.displayGrid();
    }

    public boolean gameOngoing() {
        return primaryGame.gameOngoing();
    }

    public void nextMove() {
        primaryGame.generateMove();
        convertAndWriteMove(primaryGame.getLastMove());
    }

    @Override
    public int generateMove() {
        return primaryGame.generateMove();
    }

    @Override
    public void markGrid(int move) {
        primaryGame.markGrid(move);
    }

    public void convertAndWriteMove(Integer move) {
        gameDataWriter.writeGameValue(Integer.toString(move));
    }

    public void announceResult() {
        primaryGame.announceResult();
    }

    public int getLastMove() {
        return primaryGame.getLastMove();
    }
}

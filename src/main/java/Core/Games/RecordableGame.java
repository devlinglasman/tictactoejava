package Core.Games;

import Core.FileManipulators.GameDataWriter;

public class RecordableGame implements Game {

    private Game primaryGame;
    private GameDataWriter gameDataWriter;

    public RecordableGame(Game primaryGame) {
        this.primaryGame = primaryGame;
        gameDataWriter = new GameDataWriter();
    }

    @Override
    public void runGame() {
        primaryGame.runGame();
    }

    public void makeMove() {
        int move = generateMove();
        markGrid(move);
        convertAndWriteMove(move);
    }

    @Override
    public int generateMove() {
        return primaryGame.generateMove();
    }

    @Override
    public void markGrid(int move) {
        primaryGame.markGrid(move);
    }

    public void convertAndWriteMove(int move) {
        gameDataWriter.writeGameValue(Integer.toString(move));
    }
}

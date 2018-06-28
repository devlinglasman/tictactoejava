package Core.Games;

import Core.FileManipulators.GameDataWriter;

public class GameRecordable implements Game {

    private PrimaryGame primaryGame;
    private GameDataWriter gameDataWriter;

    public GameRecordable(PrimaryGame primaryGame, GameDataWriter gameDataWriter) {
        this.primaryGame = primaryGame;
        this.gameDataWriter = gameDataWriter;
    }

    public void runGame() {
        primaryGame.runGame();
    }

    public void makeMove() {
        int move = primaryGame.generateMove();
        primaryGame.markGrid(move);
        convertAndWriteMove(move);
    }

    public void convertAndWriteMove(int move) {
        gameDataWriter.writeGameValue(Integer.toString(move));
    }
}

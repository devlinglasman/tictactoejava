package Core.Games;

import Core.FileManipulators.GameDataWriter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RecordableGameTest {

    @Test
    public void playNextMove() {
        PrimaryGameDouble primaryGameDouble = new PrimaryGameDouble();
        GameDataWriter gameDataWriter = new GameDataWriter("src/test/resources/dummyDataRGame.txt");
        RecordableGame recordableGame = new RecordableGame(primaryGameDouble, gameDataWriter);
        List<Integer> expectedMove = new ArrayList<>();
        expectedMove.add(0);

        recordableGame.playNextMove();

        assertEquals(gameDataWriter.generateMoves(0), expectedMove);
    }
}
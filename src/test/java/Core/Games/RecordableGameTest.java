package Core.Games;

import Core.FileManipulators.FileAccessor;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RecordableGameTest {

    @Test
    public void playNextMove() {
        PrimaryGameDouble primaryGameDouble = new PrimaryGameDouble();
        FileAccessor fileAccessor = new FileAccessor("src/test/resources/dummyDataRGame.txt");
        RecordableGame recordableGame = new RecordableGame(primaryGameDouble, fileAccessor);
        List<Integer> expectedMove = new ArrayList<>();
        expectedMove.add(0);

        recordableGame.playNextMove();

        assertEquals(fileAccessor.generateMoves(0), expectedMove);
    }
}
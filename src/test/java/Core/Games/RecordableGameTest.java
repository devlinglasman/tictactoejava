package Core.Games;

import Core.FileAccessor;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RecordableGameTest {

    @Test
    public void playNextMove() {
        PrimaryGameDouble primaryGameDouble = new PrimaryGameDouble();
        String pathName = "src/test/resources/dummyDataRGame.txt";
        FileAccessor fileAccessor = new FileAccessor(pathName);
        RecordableGame recordableGame = new RecordableGame(primaryGameDouble, fileAccessor);
        List<String> expectedMove = Collections.singletonList("0");

        recordableGame.playNextMove();

        assertEquals(fileAccessor.performExtraction(), expectedMove);
    }
}
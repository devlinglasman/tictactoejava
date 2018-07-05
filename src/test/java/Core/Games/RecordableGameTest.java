package Core.Games;

import Core.FileAccessor;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class RecordableGameTest {

    @Test
    public void playNextMove() {
        PrimaryGameDouble primaryGameDouble = new PrimaryGameDouble();
        String pathName = "src/test/resources/dummyDataRGame.txt";
        FileAccessor fileAccessor = new FileAccessor(pathName);
        RecordableGame recordableGame = new RecordableGame(primaryGameDouble, fileAccessor);
        List<String> expectedMove = Arrays.asList("0");

        recordableGame.playNextMove();

        assertEquals(fileAccessor.performExtraction(pathName), expectedMove);
    }
}
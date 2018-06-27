package Core.FileManipulatorsTests;

import Core.FileManipulators.GameDataReader;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class GameDataReaderTest {

    @Test
    public void convertFileToList() {
        GameDataReader gameDataReader = new GameDataReader();

        File testFile1 = new File("src/test/resources/testFile1.txt");

        ArrayList<String> expectedGameData = new ArrayList<>(
                asList("1", "2", "3",
                        "4","5","6","7","8","9"));

        assertEquals(expectedGameData, gameDataReader.extractData(testFile1));
    }
}

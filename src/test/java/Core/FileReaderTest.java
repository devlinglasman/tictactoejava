package Core;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class FileReaderTest {

    @Test
    public void convertFileToList() {
        GameDataReader gameDataReader = new GameDataReader();

        File testFile1 = new File("src/test/resources/testFile1.txt");

        ArrayList<String> expectedGameData = new ArrayList<>(
                asList("Player One", "Player Two", "1", "2", "3",
                        "4","5","6","7","8","9"));

        assertEquals(expectedGameData, gameDataReader.extractData(testFile1));
    }
}

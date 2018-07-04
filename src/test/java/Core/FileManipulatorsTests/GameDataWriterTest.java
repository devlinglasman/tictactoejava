package Core.FileManipulatorsTests;

import Core.FileManipulators.GameDataWriter;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class GameDataWriterTest {

    @Test
    public void writeValues() {
        FileReaderHelper fileReaderHelper = new FileReaderHelper();
        GameDataWriter gameDataWriter = new GameDataWriter();
        List<String> expectedGameData = new ArrayList<>(
                asList("9","8"));

        gameDataWriter.createFile("src/test/resources/dummyData.txt");
        gameDataWriter.writeGameValue("9");
        gameDataWriter.writeGameValue("8");

        List<String> actualGameData = fileReaderHelper.extractData(gameDataWriter.getGameData());

        assertEquals(expectedGameData, actualGameData);
    }

    @Test
    public void createFile_OverwriteItWithNewData() {
        FileReaderHelper fileReaderHelper = new FileReaderHelper();
        GameDataWriter gameDataWriter = new GameDataWriter();
        List<String> expectedGameData = new ArrayList<>(
                asList("0","1"));

        gameDataWriter.createFile("src/test/resources/dummyData2.txt");
        gameDataWriter.writeGameValue("Incorrect data.");
        gameDataWriter.createFile("src/test/resources/dummyData2.txt");
        gameDataWriter.writeGameValue("0");
        gameDataWriter.writeGameValue("1");

        List<String> actualGameData = fileReaderHelper.extractData(gameDataWriter.getGameData());

        assertEquals(expectedGameData, actualGameData);
    }
}

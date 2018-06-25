package FileManipulatorsTests;

import Core.FileManipulators.GameDataReader;
import Core.FileManipulators.GameDataWriter;
import org.junit.Test;

import java.util.ArrayList;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class GameDataWriterTest {

    @Test
    public void writeToFile_One() {
        GameDataReader gameDataReader = new GameDataReader();
        GameDataWriter gameDataWriter = new GameDataWriter();
        ArrayList<String> expectedGameData = new ArrayList<>(
                asList("Player One"));

        gameDataWriter.writeGameValue("Player One");
        ArrayList<String> actualGameData = gameDataReader.extractData(gameDataWriter.getGameData());

        assertEquals(expectedGameData, actualGameData);
    }

    @Test
    public void writeToFile_Two() {
        GameDataReader gameDataReader = new GameDataReader();
        GameDataWriter gameDataWriter = new GameDataWriter();
        ArrayList<String> expectedGameData = new ArrayList<>(
                asList("Player One", "Player Two", "0"));

        gameDataWriter.writeGameValue("Player One");
        gameDataWriter.writeGameValue("Player Two");
        gameDataWriter.writeGameValue("0");
        ArrayList<String> actualGameData = gameDataReader.extractData(gameDataWriter.getGameData());

        assertEquals(expectedGameData, actualGameData);
    }
}

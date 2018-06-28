package Core.FileManipulatorsTests;

import Core.FileManipulators.GameFileAnalyser;
import Core.FileManipulators.GameDataWriter;
import org.junit.Test;

import java.util.ArrayList;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class GameDataWriterTest {

    @Test
    public void createFile_OverwriteItWithNewData() {
        GameFileAnalyser gameFileAnalyser = new GameFileAnalyser();
        GameDataWriter gameDataWriter = new GameDataWriter();
        ArrayList<String> expectedGameData = new ArrayList<>(
                asList("Player One"));

        gameDataWriter.createFile();
        gameDataWriter.writeGameValue("Incorrect data.");
        gameDataWriter.createFile();
        gameDataWriter.writeGameValue("Player One");
        ArrayList<String> actualGameData = gameFileAnalyser.extractData(gameDataWriter.getGameData());

        assertEquals(expectedGameData, actualGameData);
    }

    @Test
    public void writeToFile_CheckItAcceptsMultipleData() {
        GameFileAnalyser gameFileAnalyser = new GameFileAnalyser();
        GameDataWriter gameDataWriter = new GameDataWriter();
        ArrayList<String> expectedGameData = new ArrayList<>(
                asList("Player One", "Player Two", "0"));

        gameDataWriter.createFile();
        gameDataWriter.writeGameValue("Player One");
        gameDataWriter.writeGameValue("Player Two");
        gameDataWriter.writeGameValue("0");
        ArrayList<String> actualGameData = gameFileAnalyser.extractData(gameDataWriter.getGameData());

        assertEquals(expectedGameData, actualGameData);
    }
}

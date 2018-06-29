package Core.FileManipulatorsTests;

import Core.FileManipulators.GameDataWriter;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class GameDataWriterTest {

    public ArrayList<String> extractData(File file) {
        ArrayList<String> gameData = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                gameData.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gameData;
    }

    @Test
    public void createFile_OverwriteItWithNewData() {
        GameDataWriter gameDataWriter = new GameDataWriter();
        ArrayList<String> expectedGameData = new ArrayList<>(
                asList("0","1"));

        gameDataWriter.createFile();
        gameDataWriter.writeGameValue("Incorrect data.");
        gameDataWriter.createFile();
        gameDataWriter.writeGameValue("0");
        gameDataWriter.writeGameValue("1");

        ArrayList<String> actualGameData = extractData(gameDataWriter.getGameData());

        assertEquals(expectedGameData, actualGameData);
    }
}

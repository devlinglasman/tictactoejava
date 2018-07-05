package Core.FileManipulatorsTests;

import Core.FileManipulators.GameDataWriter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class GameDataWriterTest {

    @Test
    public void writeAndExtractMoves1() {
        GameDataWriter gameDataWriter = new GameDataWriter();
        List<Integer> expectedGameData = new ArrayList<>(
                asList(9,7));

        gameDataWriter.createFile("src/test/resources/dummyData.txt");
        gameDataWriter.writeGameValue("9");
        gameDataWriter.writeGameValue("8");
        gameDataWriter.writeGameValue("7");

        List<Integer> actualGameData = gameDataWriter.generateMoves(0);

        assertEquals(expectedGameData, actualGameData);
    }

    @Test
    public void writeAndExtractMoves_afterOverwrite() {
        GameDataWriter gameDataWriter = new GameDataWriter();
        List<Integer> expectedGameData = new ArrayList<>(
                asList(8,6));

        gameDataWriter.createFile("src/test/resources/dummyData.txt");
        gameDataWriter.writeGameValue("Incorrect Values");
        gameDataWriter.createFile("src/test/resources/dummyData.txt");
        gameDataWriter.writeGameValue("9");
        gameDataWriter.writeGameValue("8");
        gameDataWriter.writeGameValue("7");
        gameDataWriter.writeGameValue("6");

        List<Integer> actualGameData = gameDataWriter.generateMoves(1);

        assertEquals(expectedGameData, actualGameData);
    }
}

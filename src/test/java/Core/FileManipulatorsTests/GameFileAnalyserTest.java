package Core.FileManipulatorsTests;

import Core.FileManipulators.GameFileAnalyser;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class GameFileAnalyserTest {

    @Test
    public void generatePlies_playerOne() {
        GameFileAnalyser gameFileAnalyser = new GameFileAnalyser();
        File testFile1 = new File("src/test/resources/testFile1.txt");

        ArrayList<Integer> expectedGameData = new ArrayList<>(
                asList(1,3,5,7,9));

        assertEquals(expectedGameData, gameFileAnalyser.generateMovesFromFile(testFile1, 0));
    }

    @Test
    public void generatePlies_playerTwo() {
        GameFileAnalyser gameFileAnalyser = new GameFileAnalyser();
        File testFile1 = new File("src/test/resources/testFile1.txt");

        ArrayList<Integer> expectedGameData = new ArrayList<>(
                asList(2,4,6,8));

        assertEquals(expectedGameData, gameFileAnalyser.generateMovesFromFile(testFile1, 1));
    }
}

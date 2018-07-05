package Core.FileManipulatorsTests;

import Core.FileManipulators.FileAccessor;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class FileAccessorTest {

    @Test
    public void writeAndExtractMoves1() {
        FileAccessor fileAccessor = new FileAccessor("src/test/resources/dummyData.txt");
        List<Integer> expectedGameData = new ArrayList<>(
                asList(9,7));

        fileAccessor.writeGameValue("9");
        fileAccessor.writeGameValue("8");
        fileAccessor.writeGameValue("7");

        List<Integer> actualGameData = fileAccessor.generateMoves(0);

        assertEquals(expectedGameData, actualGameData);
    }

    @Test
    public void writeAndExtractMoves_afterOverwrite() {
        FileAccessor fileAccessor = new FileAccessor("src/test/resources/dummyData.txt");
        List<Integer> expectedGameData = new ArrayList<>(
                asList(8,6));

        fileAccessor.writeGameValue("9");
        fileAccessor.writeGameValue("8");
        fileAccessor.writeGameValue("7");
        fileAccessor.writeGameValue("6");

        List<Integer> actualGameData = fileAccessor.generateMoves(1);

        assertEquals(expectedGameData, actualGameData);
    }
}

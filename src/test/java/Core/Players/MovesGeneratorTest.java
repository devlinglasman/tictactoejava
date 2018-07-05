package Core.Players;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MovesGeneratorTest {

    private MovesGenerator movesGenerator;
    private List<String> allGameMoves;

    @Before
    public void setUp() {
        movesGenerator = new MovesGenerator();
        allGameMoves = Arrays.asList("0","1","2","3","4","5","6","7","8","9");
    }

    @Test
    public void generatePlies_playerOne() {
        List<Integer> expectedGameData = Arrays.asList(0,2,4,6,8);

        assertEquals(expectedGameData, movesGenerator.generateMoves(allGameMoves, 0));
    }

    @Test
    public void generatePlies_playerTwo() {
        List<Integer> expectedGameData = Arrays.asList(1,3,5,7,9);

        assertEquals(expectedGameData, movesGenerator.generateMoves(allGameMoves, 1));
    }
}

import Console.ConsoleUI;
import Core.GameRunner;
import Core.Grid;
import Core.Mark;
import Core.Players.Player;
import Core.Players.PlayerHuman;
import Core.UI;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class GameRunnerTest {

    @Test
    public void gameModeChoiceNotValid_False() {
        UI ui = new ConsoleUI(System.in, System.out, 1);
        GameRunner gameRunner = new GameRunner(ui);

        assertFalse(gameRunner.gameModeChoiceNotValid(1));
    }

    @Test
    public void gameModeChoiceNotValid_True_0() {
        UI ui = new ConsoleUI(System.in, System.out, 1);
        GameRunner gameRunner = new GameRunner(ui);

        assertTrue(gameRunner.gameModeChoiceNotValid(0));
    }

    @Test
    public void gameModeChoiceNotValid_True_15() {
        UI ui = new ConsoleUI(System.in, System.out, 1);
        GameRunner gameRunner = new GameRunner(ui);

        assertTrue(gameRunner.gameModeChoiceNotValid(15));
    }

//    @Test
//    public void getValidGameModeChoice_True() {
//        UI ui = new ConsoleUI(System.in, System.out, 1);
//        GameRunner gameRunner = new GameRunner(ui);
//
//        assertTrue(gameRunner.getValidGameModeChoice());
//    }

}

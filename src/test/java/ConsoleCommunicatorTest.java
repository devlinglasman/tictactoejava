import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ConsoleCommunicatorTest {

    @Test
    public void displayGrid() {
        GameLogic gamerunner = new GameLogic();
        IOHelper ioHelper = new IOHelper("");
        ConsoleCommunicator consoleCommunicator = new ConsoleCommunicator(ioHelper.in, ioHelper.print,gamerunner);
        ArrayList<String> squares = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
           squares.add(" ");
        }

        consoleCommunicator.displayGrid(squares);
        assertEquals("[ ][ ][ ]\n[ ][ ][ ]\n[ ][ ][ ]\n", ioHelper.output());
    }

    @Test
    public void displayGrid2() {
        GameLogic gamerunner = new GameLogic();
        IOHelper ioHelper = new IOHelper("");
        ConsoleCommunicator consoleCommunicator = new ConsoleCommunicator(ioHelper.in, ioHelper.print,gamerunner);
        ArrayList<String> squares = new ArrayList<>();
        squares.add("X");
        for (int i = 0; i < 8; i++) {
            squares.add(" ");
        }

        consoleCommunicator.displayGrid(squares);

        assertEquals("[X][ ][ ]\n[ ][ ][ ]\n[ ][ ][ ]\n", ioHelper.output());
    }

    @Test
    public void askInputPlayerOne() {
        GameLogic gamerunner = new GameLogic();
        IOHelper ioHelper = new IOHelper("");
        ConsoleCommunicator consoleCommunicator = new ConsoleCommunicator(ioHelper.in, ioHelper.print,gamerunner);

        consoleCommunicator.askInput(Player.PLAYERONE);
        assertEquals("\nHi Player One! Please select a square from 1-9\n", ioHelper.output());
    }

    @Test
    public void askInputPlayerTwo() {
        GameLogic gamerunner = new GameLogic();
        IOHelper ioHelper = new IOHelper("");
        ConsoleCommunicator consoleCommunicator = new ConsoleCommunicator(ioHelper.in, ioHelper.print,gamerunner);

        consoleCommunicator.askInput(Player.PLAYERTWO);
        assertEquals("\nHi Player Two! Please select a square from 1-9\n", ioHelper.output());
    }

    @Test
    public void askGameMode() {
        GameLogic gamerunner = new GameLogic();
        IOHelper ioHelper = new IOHelper("");
        ConsoleCommunicator consoleCommunicator = new ConsoleCommunicator(ioHelper.in, ioHelper.print,gamerunner);

        consoleCommunicator.askGameMode();
        assertEquals("\nHi! please enter '1' to " +
                "play against the computer or '2' to play human-vs-human.\n", ioHelper.output());
    }

    @Test
    public void announceWinner1() {
        GameLogic gamerunner = new GameLogic();
        IOHelper ioHelper = new IOHelper("");
        ConsoleCommunicator consoleCommunicator = new ConsoleCommunicator(ioHelper.in, ioHelper.print,gamerunner);

        consoleCommunicator.announceWinner(Player.PLAYERONE);

        assertEquals("Congratulations Player One - You're the winner!\n", ioHelper.output());
    }

    @Test
    public void announceWinner2() {
        GameLogic gamerunner = new GameLogic();
        IOHelper ioHelper = new IOHelper("");
        ConsoleCommunicator consoleCommunicator = new ConsoleCommunicator(ioHelper.in, ioHelper.print,gamerunner);

        consoleCommunicator.announceWinner(Player.PLAYERTWO);

        assertEquals("Congratulations Player Two - You're the winner!\n", ioHelper.output());
    }

    @Test
    public void computerTakesTurn() {
        GameLogic gamerunner = new GameLogic();
        IOHelper ioHelper = new IOHelper("");
        ConsoleCommunicator consoleCommunicator = new ConsoleCommunicator(ioHelper.in, ioHelper.print,gamerunner);

        consoleCommunicator.announceComputerTurn();

        assertEquals("\nComputer takes turn...\n", ioHelper.output());
    }
}

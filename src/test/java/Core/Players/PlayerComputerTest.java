package Core.Players;

import Console.ConsoleIO;
import Core.GameRunner;
import Core.Grid;
import Core.Mark;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerComputerTest {


    @Test
    public void minimaxTest1() {
        Grid grid = new Grid();
        ConsoleIO consoleIO = new ConsoleIO(System.in, System.out);
        Player playerOne = new PlayerHuman("Player One", Mark.playerOneMark, consoleIO);
        Player playerTwo = new PlayerComputer("Computer", Mark.playerTwoMark);
        GameRunner gameRunner = new GameRunner(grid, playerOne, playerTwo, consoleIO);

        gameRunner.getGrid().setASquare(0, playerTwo.getMark());
        gameRunner.getGrid().setASquare(1, playerOne.getMark());
        gameRunner.getGrid().setASquare(2, playerTwo.getMark());
        gameRunner.getGrid().setASquare(3, playerTwo.getMark());
        gameRunner.getGrid().setASquare(4, playerTwo.getMark());
        gameRunner.getGrid().setASquare(5, playerOne.getMark());
        gameRunner.getGrid().setASquare(6, playerOne.getMark());

        gameRunner.alternatePlayer();

        assertEquals(8, playerTwo.getInput(gameRunner.getGrid()));
    }

    @Test
    public void minimaxTest2() {
        Grid grid = new Grid();
        ConsoleIO consoleIO = new ConsoleIO(System.in, System.out);
        Player playerOne = new PlayerHuman("Player One", Mark.playerOneMark, consoleIO);
        Player playerTwo = new PlayerComputer("Computer", Mark.playerTwoMark);
        GameRunner gameRunner = new GameRunner(grid, playerOne, playerTwo, consoleIO);

        gameRunner.getGrid().setASquare(0, playerTwo.getMark());
        gameRunner.getGrid().setASquare(1, playerOne.getMark());
        gameRunner.getGrid().setASquare(2, playerTwo.getMark());
        gameRunner.getGrid().setASquare(5, playerOne.getMark());
        gameRunner.getGrid().setASquare(6, playerOne.getMark());
        gameRunner.getGrid().setASquare(7, playerTwo.getMark());
        gameRunner.getGrid().setASquare(8, playerTwo.getMark());

        gameRunner.alternatePlayer();

        assertEquals(4, playerTwo.getInput(gameRunner.getGrid()));
    }

    @Test
    public void minimaxTest3() {
        Grid grid = new Grid();
        ConsoleIO consoleIO = new ConsoleIO(System.in, System.out);
        Player playerOne = new PlayerHuman("Player One", Mark.playerOneMark, consoleIO);
        Player playerTwo = new PlayerComputer("Computer", Mark.playerTwoMark);
        GameRunner gameRunner = new GameRunner(grid, playerOne, playerTwo, consoleIO);

        gameRunner.getGrid().setASquare(0, playerTwo.getMark());
        gameRunner.getGrid().setASquare(2, playerOne.getMark());
        gameRunner.getGrid().setASquare(3, playerOne.getMark());
        gameRunner.getGrid().setASquare(6, playerOne.getMark());
        gameRunner.getGrid().setASquare(7, playerTwo.getMark());
        gameRunner.getGrid().setASquare(8, playerTwo.getMark());

        gameRunner.alternatePlayer();

        assertEquals(4, playerTwo.getInput(gameRunner.getGrid()));
    }
}
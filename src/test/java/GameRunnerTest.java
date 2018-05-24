//import Console.ConsoleIO;
//import Core.GameRunner;
//import Core.Grid;
//import Core.Mark;
//import Core.Players.Player;
//import Core.Players.PlayerComputer;
//import Core.Players.PlayerHuman;
//import org.junit.Test;
//
//public class GameRunnerTest {
//
//    @Test
//    public void minimaxTest1() {
//        Grid grid = new Grid();
//        ConsoleIO consoleIO = new ConsoleIO(System.in, System.out);
//        Player playerOne = new PlayerHuman("Player One", Mark.playerOneMark, consoleIO);
//        Player playerTwo = new PlayerComputer("Computer", Mark.playerTwoMark);
//        GameRunner game = new GameRunner(grid, playerOne, playerTwo, consoleIO);
//
//        grid.setASquare(0, playerOne.getMark());
//        grid.setASquare(2, playerTwo.getMark());
//        grid.setASquare(3, playerTwo.getMark());
//        grid.setASquare(6, playerOne.getMark());
//        grid.setASquare(7, playerOne.getMark());
//        grid.setASquare(8, playerOne.getMark());
//
//        game.alternatePlayer();
//
//        assertEquals(4, );
//    }
//
//    @Test
//    public void alternatePlayerOne() {
//        Grid grid = new Grid();
//        ValidatorConsoleInput validatorConsoleInput = new ValidatorConsoleInput();
//        ConsoleIO consoleIO = new ConsoleIO(System.in, System.out);
//        GameRunner game = new GameRunner(grid, validatorConsoleInput, consoleIO);
//
//        game.alternatePlayer();
//        game.alternatePlayer();
//
//        assertEquals(game.getPlayerOne(), game.getActivePlayer());
//    }
//
//    @Test
//    public void alternatePlayerPlayerTwo() {
//        Grid grid = new Grid();
//        ValidatorConsoleInput validatorConsoleInput = new ValidatorConsoleInput();
//        ConsoleIO consoleIO = new ConsoleIO(System.in, System.out);
//        GameRunner game = new GameRunner(grid, validatorConsoleInput, consoleIO);
//
//        game.alternatePlayer();
//
//        assertEquals(game.getPlayerOne(), game.getActivePlayer());
//    }
//}
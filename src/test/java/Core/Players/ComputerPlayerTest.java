package Core.Players;

import Core.Board.Grid;
import Core.Board.Mark;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ComputerPlayerTest {


    @Test
    public void minimaxTest1() {
        Grid grid = new Grid();
        Player computer = new ComputerPlayer( Mark.PLAYER_TWO);

//         Grid state:
//         O X O
//         O O X
//         X 8 9

//         Player 'O' optimum move is at 9:
//         O X O
//         O O X
//         X 8 O

        grid.markSquare(0, Mark.PLAYER_TWO);
        grid.markSquare(1, Mark.PLAYER_ONE);
        grid.markSquare(2, Mark.PLAYER_TWO);
        grid.markSquare(3, Mark.PLAYER_TWO);
        grid.markSquare(4, Mark.PLAYER_TWO);
        grid.markSquare(5, Mark.PLAYER_ONE);
        grid.markSquare(6, Mark.PLAYER_ONE);

        assertEquals(8, computer.getMove(grid));
    }

    @Test
    public void minimaxTest2() {
        Grid grid = new Grid();
        Player computer = new ComputerPlayer(Mark.PLAYER_TWO);

//         Grid state:
//         O X O
//         4 5 X
//         X O O

//         Player 'O' optimum move is at 5:
//         O X O
//         4 O X
//         X O O

        grid.markSquare(0, Mark.PLAYER_TWO);
        grid.markSquare(1, Mark.PLAYER_ONE);
        grid.markSquare(2, Mark.PLAYER_TWO);
        grid.markSquare(5, Mark.PLAYER_ONE);
        grid.markSquare(6, Mark.PLAYER_ONE);
        grid.markSquare(7, Mark.PLAYER_TWO);
        grid.markSquare(8, Mark.PLAYER_TWO);

        assertEquals(4, computer.getMove(grid));
    }

    @Test
    public void minimaxTest3() {
        Grid grid = new Grid();
        Player computer = new ComputerPlayer(Mark.PLAYER_TWO);

//         Grid state:
//         O 2 X
//         X 5 6
//         X O O

//         Player 'O' optimum move is at 5:
//         O 2 X
//         X O 6
//         X O O

        grid.markSquare(0, Mark.PLAYER_TWO);
        grid.markSquare(2, Mark.PLAYER_ONE);
        grid.markSquare(3, Mark.PLAYER_ONE);
        grid.markSquare(6, Mark.PLAYER_ONE);
        grid.markSquare(7, Mark.PLAYER_TWO);
        grid.markSquare(8, Mark.PLAYER_TWO);

        assertEquals(4, computer.getMove(grid));
    }

    @Test
    public void minimaxTest4() {
        Grid grid = new Grid();
        Player computer = new ComputerPlayer(Mark.PLAYER_TWO);

//         Grid state:
//         X X 3
//         4 X 6
//         O 8 O

//         Player 'O' optimum move:
//         X X 3
//         4 X 6
//         O O O

        grid.markSquare(0, Mark.PLAYER_ONE);
        grid.markSquare(1, Mark.PLAYER_ONE);
        grid.markSquare(4, Mark.PLAYER_ONE);
        grid.markSquare(6, Mark.PLAYER_TWO);
        grid.markSquare(8, Mark.PLAYER_TWO);

        assertEquals(7, computer.getMove(grid));
    }

    @Test
    public void minimaxTest5() {
        Grid grid = new Grid();
        Player computer = new ComputerPlayer(Mark.PLAYER_TWO);

//         Grid state:
//         X 2 O
//         O 5 6
//         O X X

//         Player 'O' optimum move is at 5:
//         X 2 O
//         O O 6
//         O X X

        grid.markSquare(0, Mark.PLAYER_ONE);
        grid.markSquare(2, Mark.PLAYER_TWO);
        grid.markSquare(3, Mark.PLAYER_TWO);
        grid.markSquare(6, Mark.PLAYER_TWO);
        grid.markSquare(7, Mark.PLAYER_ONE);
        grid.markSquare(8, Mark.PLAYER_ONE);

        assertEquals(4, computer.getMove(grid));
    }

    @Test
    public void minimaxTest6WithDepth() {
        Grid grid = new Grid();
        Player computer = new ComputerPlayer(Mark.PLAYER_TWO);

//         Grid state:
//         1 X 3
//         4 5 X
//         O O X

//         Player 'O' optimum move is at 3:
//         1 X O
//         4 5 X
//         O O X

        grid.markSquare(1, Mark.PLAYER_ONE);
        grid.markSquare(5, Mark.PLAYER_ONE);
        grid.markSquare(6, Mark.PLAYER_TWO);
        grid.markSquare(7, Mark.PLAYER_TWO);
        grid.markSquare(8, Mark.PLAYER_ONE);

        assertEquals(2, computer.getMove(grid));
    }

    @Test
    public void minimaxTest7WithDepthWithSwitchedMarks() {
        Grid grid = new Grid();
        Player computer = new ComputerPlayer(Mark.PLAYER_ONE);

//         Grid state:
//         O O X
//         4 X 6
//         7 8 9

//         Player 'X' optimum move is at 7:
//         O O X
//         4 X 6
//         X 8 9

        grid.markSquare(0, Mark.PLAYER_ONE);
        grid.markSquare(1, Mark.PLAYER_ONE);
        grid.markSquare(2, Mark.PLAYER_TWO);
        grid.markSquare(4, Mark.PLAYER_TWO);

        assertEquals(6, computer.getMove(grid));
    }
}
package Core.Players;

import Core.Grid;
import Core.Mark;
import Core.Minimax;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinimaxTest {


    @Test
    public void minimaxTest1() {
        Grid grid = new Grid();
        Minimax minimax = new Minimax(Mark.playerTwoMark, grid);

//         O X O
//         O O X
//         X _ _

        grid.markSquare(0, Mark.playerTwoMark);
        grid.markSquare(1, Mark.playerOneMark);
        grid.markSquare(2, Mark.playerTwoMark);
        grid.markSquare(3, Mark.playerTwoMark);
        grid.markSquare(4, Mark.playerTwoMark);
        grid.markSquare(5, Mark.playerOneMark);
        grid.markSquare(6, Mark.playerOneMark);

        assertEquals(8, minimax.findSquareChoice(grid, Mark.playerTwoMark, 0));
    }

    @Test
    public void minimaxTest2() {
        Grid grid = new Grid();
        Minimax minimax = new Minimax(Mark.playerTwoMark, grid);

//         O X O
//         _ _ X
//         X O O

        grid.markSquare(0, Mark.playerTwoMark);
        grid.markSquare(1, Mark.playerOneMark);
        grid.markSquare(2, Mark.playerTwoMark);
        grid.markSquare(5, Mark.playerOneMark);
        grid.markSquare(6, Mark.playerOneMark);
        grid.markSquare(7, Mark.playerTwoMark);
        grid.markSquare(8, Mark.playerTwoMark);

        assertEquals(4, minimax.findSquareChoice(grid, Mark.playerTwoMark, 0));
    }

    @Test
    public void minimaxTest3() {
        Grid grid = new Grid();
        Minimax minimax = new Minimax(Mark.playerTwoMark, grid);

//         O _ X
//         X _ _
//         X O O

        grid.markSquare(0, Mark.playerTwoMark);
        grid.markSquare(2, Mark.playerOneMark);
        grid.markSquare(3, Mark.playerOneMark);
        grid.markSquare(6, Mark.playerOneMark);
        grid.markSquare(7, Mark.playerTwoMark);
        grid.markSquare(8, Mark.playerTwoMark);

        assertEquals(4, minimax.findSquareChoice(grid, Mark.playerTwoMark, 0));
    }

    @Test
    public void minimaxTest4() {
        Grid grid = new Grid();
        Minimax minimax = new Minimax(Mark.playerTwoMark, grid);

//         X X _
//         _ X _
//         O _ O

        grid.markSquare(0, Mark.playerOneMark);
        grid.markSquare(1, Mark.playerOneMark);
        grid.markSquare(4, Mark.playerOneMark);
        grid.markSquare(6, Mark.playerTwoMark);
        grid.markSquare(8, Mark.playerTwoMark);

        assertEquals(7, minimax.findSquareChoice(grid, Mark.playerTwoMark, 0));
    }

    @Test
    public void minimaxTest5() {
        Grid grid = new Grid();
        Minimax minimax = new Minimax(Mark.playerTwoMark, grid);

//         X _ O
//         O _ _
//         O X X

        grid.markSquare(0, Mark.playerOneMark);
        grid.markSquare(2, Mark.playerTwoMark);
        grid.markSquare(3, Mark.playerTwoMark);
        grid.markSquare(6, Mark.playerTwoMark);
        grid.markSquare(7, Mark.playerOneMark);
        grid.markSquare(8, Mark.playerOneMark);

        assertEquals(4, minimax.findSquareChoice(grid, Mark.playerTwoMark, 0));
    }

    @Test
    public void minimaxTest6WithDepth() {
        Grid grid = new Grid();
        Minimax minimax = new Minimax(Mark.playerTwoMark, grid);

//         _ X _
//         _ _ X
//         O O X

        grid.markSquare(1, Mark.playerOneMark);
        grid.markSquare(5, Mark.playerOneMark);
        grid.markSquare(6, Mark.playerTwoMark);
        grid.markSquare(7, Mark.playerTwoMark);
        grid.markSquare(8, Mark.playerOneMark);

        assertEquals(2, minimax.findSquareChoice(grid, Mark.playerTwoMark, 0));
    }
}
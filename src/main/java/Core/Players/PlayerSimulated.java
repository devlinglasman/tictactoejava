package Core.Players;

import Core.Grid;
import Core.Mark;

import java.io.File;
import java.util.ArrayList;

public class PlayerSimulated extends Player {

    private ArrayList<Integer> moves;
    private int movesCounter = 0;

    public PlayerSimulated(String name, Mark mark, ArrayList<Integer> moves) {
       super(name, mark);
       this.moves = moves;
    }

    @Override
    public void makeMove(Grid grid) {
        grid.markSquare(moves.get(movesCounter), getMark());
        movesCounter++;
    }
}

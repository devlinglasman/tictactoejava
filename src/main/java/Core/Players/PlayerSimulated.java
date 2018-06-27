package Core.Players;

import Core.Grid;
import Core.Mark;

import java.util.ArrayList;

public class PlayerSimulated extends Player {

    private ArrayList<Integer> moves;
    private int movesCounter = 0;
    private Integer previousMove;

    public PlayerSimulated(String name, Mark mark, ArrayList<Integer> moves) {
       super(name, mark);
       this.moves = moves;
       previousMove = null;
    }

    @Override
    public void makeMove(Grid grid) {
        grid.markSquare(moves.get(movesCounter), getMark());
        previousMove = moves.get(movesCounter);
        movesCounter++;
    }

    @Override
    public Integer getPreviousMove() {
        return previousMove;
    }
}

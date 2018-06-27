package Core.Players;

import Core.Grid;
import Core.Mark;

import java.util.ArrayList;

public class PlayerSimulated extends Player {

    private ArrayList<Integer> moves;
    private int movesCounter = 0;

    public PlayerSimulated(Mark mark, ArrayList<Integer> moves) {
       super(mark);
       this.moves = moves;
    }

    @Override
    public int getMove(Grid grid) {
        int move = moves.get(movesCounter);
        movesCounter++;
        return move;
    }
}

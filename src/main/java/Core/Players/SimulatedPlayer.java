package Core.Players;

import Core.Grid;
import Core.Mark;

import java.util.List;

public class SimulatedPlayer extends Player {

    private List<Integer> moves;
    private int movesCounter = 0;

    public SimulatedPlayer(Mark mark, List<Integer> moves) {
       super(mark);
       this.moves = moves;
    }

    @Override
    public int getMove(Grid grid) {
        int move = retrieveCurrentMove();
        advanceCounterPosition();
        return move;
    }

    private int retrieveCurrentMove() {
        return moves.get(movesCounter);
    }

    private void advanceCounterPosition() {
        movesCounter++;
    }
}

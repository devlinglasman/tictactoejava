package Core.Players;

import Core.Grid;
import Core.Mark;
import Core.Minimax;

public class PlayerComputer extends Player {

    private Mark opponentMark;

    public PlayerComputer(String name, Mark mark, Mark opponentMark) {
        super(name, mark);
        this.opponentMark = opponentMark;
    }

    @Override
    public int getInput(Grid grid) {
       Minimax minimax = new Minimax(grid, getMark(), opponentMark);
        return minimax.maximise(grid, getMark(), 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}

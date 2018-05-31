package Core.Players;

import Core.Grid;
import Core.Mark;
import Core.Minimax;

public class PlayerComputer extends Player {

    public PlayerComputer(String name, Mark mark) {
        super(name, mark);
    }

    @Override
    public int getInput(Grid grid) {
       Minimax minimax = new Minimax(getMark(), grid);
        return minimax.findSquareChoice(grid, getMark(), 0);
    }
}

package Core.Players;

import Core.Grid;
import Core.Mark;

import java.util.Random;

public class PlayerComputer extends Player {

    public PlayerComputer(String name, Mark mark) {
        super(name, mark);
    }

    @Override
    public int getInput(Grid grid) {
        Random rand = new Random();
        int input = rand.nextInt(8);
        boolean inputIllegalMove = moveIllegal(grid, input);
        while (inputIllegalMove) {
            input = rand.nextInt(8);
            inputIllegalMove = moveIllegal(grid, input);
        }
        return input;
    }

    public boolean moveIllegal(Grid grid, int input) {
        return grid.moveNotLegal(input);
    }

    @Override
    public boolean isHumanPlayer() {
        return false;
    }
}

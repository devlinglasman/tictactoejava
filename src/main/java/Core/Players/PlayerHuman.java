package Core.Players;

import Console.ConsoleIO;
import Core.Grid;
import Core.Mark;

public class PlayerHuman extends Player {

    private ConsoleIO consoleIO;

    public PlayerHuman(String name, Mark mark, ConsoleIO consoleIO) {
        super(name,mark);
        this.consoleIO = consoleIO;
    }

    @Override
    public int getInput(Grid grid) {
        int input = getValidNumberInput();
        input--;
        boolean inputIllegalMove = moveIllegal(grid, input);
        while (inputIllegalMove) {
            consoleIO.announceInputInvalid(getName());
            input = getValidNumberInput();
            input--;
            inputIllegalMove = moveIllegal(grid, input);
        }
        return input;
    }

    public int getValidNumberInput() {
        consoleIO.askForSquareChoice(getName());
        return consoleIO.requestValidSquareChoice(getName());
    }

    public boolean moveIllegal(Grid grid, int input) {
        return grid.moveNotLegal(input);
    }

    @Override
    public boolean isHuman() {
       return true;
    }
}

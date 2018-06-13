package Core.Players;

import Core.Grid;
import Core.Mark;
import Core.UI;

public class PlayerHuman extends Player {

    private UI ui;

    public PlayerHuman(String name, Mark mark, UI ui) {
        super(name,mark);
        this.ui = ui;
    }

    @Override
    public void makeMove(Grid grid) {
        int input = getValidNumberInput();
        input--;
        boolean inputIllegalMove = moveIllegal(grid, input);
        while (inputIllegalMove) {
            ui.announceSquareChoiceInvalid(this);
            input = getValidNumberInput();
            input--;
            inputIllegalMove = moveIllegal(grid, input);
        }
        grid.markSquare(input, getMark());
    }

    private int getValidNumberInput() {
        ui.askSquareChoice(this);
        return ui.getValidNumber(this);
    }

    private boolean moveIllegal(Grid grid, int input) {
        return grid.moveNotLegal(input);
    }
}

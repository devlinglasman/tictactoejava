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
        boolean inputIllegalMove = grid.moveNotLegal(input);
        while (inputIllegalMove) {
            ui.announceSquareChoiceInvalid(this);
            input = getValidNumberInput();
            input--;
            inputIllegalMove = grid.moveNotLegal(input);
        }
        grid.markSquare(input, getMark());
    }

    private int getValidNumberInput() {
        ui.askSquareChoice(this);
        return ui.getValidNumber(this);
    }
}

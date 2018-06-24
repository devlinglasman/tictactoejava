package Core.Players;

import Core.Communicator;
import Core.Grid;
import Core.Mark;

public class PlayerHuman extends Player {

    private Communicator communicator;

    public PlayerHuman(String name, Mark mark, Communicator communicator) {
        super(name,mark);
        this.communicator = communicator;
    }

    @Override
    public void makeMove(Grid grid) {
        int input = getValidNumberInput();
        input--;
        boolean inputIllegalMove = grid.moveNotLegal(input);
        while (inputIllegalMove) {
            communicator.announceSquareChoiceInvalid(this);
            input = getValidNumberInput();
            input--;
            inputIllegalMove = grid.moveNotLegal(input);
        }
        grid.markSquare(input, getMark());
    }

    private int getValidNumberInput() {
        communicator.askSquareChoice(this);
        return communicator.getValidNumber();
    }
}

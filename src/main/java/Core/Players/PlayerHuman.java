package Core.Players;

import Core.UserInterfaces.Communicator;
import Core.Grid;
import Core.Mark;

public class PlayerHuman extends Player {

    private Communicator communicator;

    public PlayerHuman(Mark mark, Communicator communicator) {
        super(mark);
        this.communicator = communicator;
    }

    @Override
    public int getMove(Grid grid) {
        int input = getValidNumberInput();
        input--;
        boolean inputIllegalMove = grid.moveNotLegal(input);
        while (inputIllegalMove) {
            communicator.announceSquareChoiceInvalid(this);
            input = getValidNumberInput();
            input--;
            inputIllegalMove = grid.moveNotLegal(input);
        }
        return input;
    }

    private int getValidNumberInput() {
        communicator.askSquareChoice(this);
        return communicator.getValidNumber();
    }
}

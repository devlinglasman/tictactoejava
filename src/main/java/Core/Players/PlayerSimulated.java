package Core.Players;

import Console.GameMovesReader;
import Core.Grid;
import Core.Mark;

import java.util.ArrayList;

public class PlayerSimulated extends Player {

    private ArrayList<Integer> movesList;
    private int movesListCounter;

    public PlayerSimulated(String name, Mark mark, ArrayList<Integer> movesList) {
        super(name, mark);
        this.movesList = movesList;
        movesListCounter = 0;
    }

    @Override
    public int getInput(Grid grid) {
        return nextChoice();
    }

    private int nextChoice() {
        int move = movesList.get(movesListCounter);
        movesListCounter++;
        return move;
    }

}

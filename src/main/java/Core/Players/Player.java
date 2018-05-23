package Core.Players;

import Core.Grid;
import Core.Mark;

public abstract class Player {

    private String name;
    private Mark mark;
    private Grid grid;

    public Player(String name, Mark mark) {
        this.name = name;
        this.mark = mark;
    }

    public abstract int getInput(Grid grid);

    public abstract boolean isHumanPlayer();

    public String getName() {
        return name;
    }

    public Mark getMark() {
        return mark;
    }
}

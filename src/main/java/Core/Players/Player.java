package Core.Players;

import Core.Grid;
import Core.Mark;

public abstract class Player {

    private String name;
    private Mark mark;

    public Player(Mark mark) {
        this.mark = mark;
        name = generateName();
    }

    public abstract void makeMove(Grid grid);

    private String generateName() {
        return (mark == Mark.PLAYERONEMARK) ? "Player One" : "Player Two";
    }

    public String getName() {
        return name;
    }

    public Mark getMark() {
        return mark;
    }

    public abstract Integer getPreviousMove();
}

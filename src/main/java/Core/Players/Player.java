package Core.Players;

import Core.Board.Grid;
import Core.Board.Mark;

public abstract class Player {

    private String name;
    private Mark mark;

    public Player(Mark mark) {
        this.mark = mark;
        name = generateName();
    }

    public abstract int getMove(Grid grid);

    private String generateName() {
        return (mark == Mark.PLAYER_ONE) ? "Player One" : "Player Two";
    }

    public String getName() {
        return name;
    }

    public Mark getMark() {
        return mark;
    }
}

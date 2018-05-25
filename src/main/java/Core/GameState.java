package Core;

public class GameState {

    private Grid grid;

    public GameState(Grid grid) {
        this.grid = grid;
    }

    public boolean isGameOver() {
        return grid.isFull() || grid.winningLineExistsInGrid();
    }

    public boolean isGameTied() {
        if (isGameOver()) return grid.winningLineExistsInGrid();
        else return false;
    }

    public Grid getGrid() {
        return grid;
    }
}

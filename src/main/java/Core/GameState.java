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
        return !grid.winningLineExistsInGrid();
    }

    public Grid getGrid() {
        return grid;
    }
}

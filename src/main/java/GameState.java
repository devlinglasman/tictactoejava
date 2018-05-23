import java.util.ArrayList;

public class GameState {

    Grid grid;
    Player activePlayer;
    Player opponent;

    public GameState(Grid grid, Player activePlayer, Player opponent) {
        this.grid = grid;
        this.activePlayer = activePlayer;
        this.opponent = opponent;
    }

    public boolean gameOver() {
        return grid.isFull() || grid.winningLineExistsInGrid(activePlayer);
    }

    public Grid getGrid() {
        return grid;
    }

    public Player getActivePlayer() {
        return activePlayer;
    }

    public Player getOpponent() {
        return opponent;
    }
}

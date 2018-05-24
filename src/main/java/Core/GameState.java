package Core;

public class GameState {

    private Grid grid;
    private Mark activePlayerMark;

    public GameState(Grid grid, Mark activePlayerMark) {
        this.grid = grid;
        this.activePlayerMark = activePlayerMark;
    }

    public Grid getGrid() {
        return grid;
    }

    public Mark getActivePlayerMark() {
        return activePlayerMark;
    }

    public Mark getOpponentMark() {
        if (activePlayerMark == Mark.playerOneMark) return Mark.playerTwoMark;
        else return Mark.playerOneMark;
    }
}

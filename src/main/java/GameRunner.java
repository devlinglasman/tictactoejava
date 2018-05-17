public class GameRunner {

    private Player activePlayer = Player.PLAYERONE;
    private Grid grid = new Grid();
    private MovesEvaluator movesEvaluator = new MovesEvaluator();

    public int convertInputToSquareNumber(String input) {
        return Integer.parseInt(input) - 1;
    }

    public boolean gameOngoing() {
        return !movesEvaluator.gameIsOver(grid);
    }

    public boolean isGameWon() {
        return movesEvaluator.isGameWon(grid);
    }

    public void alternatePlayer() {
        if (getActivePlayer() == Player.PLAYERONE) activePlayer = Player.PLAYERTWO;
        else activePlayer = Player.PLAYERONE;
    }

    public Grid getGrid() {
        return grid;
    }

    public Player getActivePlayer() {
        return activePlayer;
    }

}

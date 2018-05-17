public class GameRunner {

    private Player activePlayer = Player.PLAYERTWO;
    private Grid grid = new Grid();
    private MovesEvaluator movesEvaluator = new MovesEvaluator();

    public boolean gameOngoing() {
        return !movesEvaluator.gameIsOver(grid);
    }
//        else {
//            while (!movesEvaluator.isGridFull()) {
//                cli.displayGrid(movesEvaluator.getSquares());
//                cli.askInput(movesEvaluator.getPlayerOne());
//                String input = cli.takeInput();
//                int squareNumber = movesEvaluator.convertInputToSquareNumber(input);
//                movesEvaluator.setSquareMark(squareNumber, "X");
//                if (squareNumber + 1 < movesEvaluator.getSquares().length) movesEvaluator.setSquareMark(squareNumber + 1, "O");
//            }
//            cli.displayGrid(movesEvaluator.getSquares());
//        }


    public int convertInputToSquareNumber(String input) {
        return Integer.parseInt(input) - 1;
    }

    public boolean isGameWon() {
        return movesEvaluator.isGameWon(grid);
    }

    public Player getActivePlayer() {
        return activePlayer;
    }

    public void alternatePlayer() {
        if (getActivePlayer() == Player.PLAYERONE) activePlayer = Player.PLAYERTWO;
        else activePlayer = Player.PLAYERONE;
    }

    public Grid getGrid() {
        return grid;
    }

    public MovesEvaluator getMovesEvaluator() {
        return movesEvaluator;
    }

}

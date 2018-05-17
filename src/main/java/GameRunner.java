public class GameRunner {

    private Player activePlayer = Player.PLAYERONE;
    private Grid grid = new Grid();
    private MovesEvaluator movesEvaluator = new MovesEvaluator();
    private Cli cli = new Cli(System.in, System.out);

    public void runGame() {
        cli.askGameMode();
        String choice = cli.takeInput();

        if (choice.equals("1")) {
            while (!movesEvaluator.gameIsOver(grid)) {
                runTurn(activePlayer);
                alternatePlayer();
            }
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
    }


    public void runTurn(Player activePlayer) {
        cli.displayGrid(grid.getSquares());
        String input = cli.askAndTakeInput(activePlayer);
        int squareNumber = convertInputToSquareNumber(input);
        grid.markSquare(squareNumber,activePlayer.getMark());
        isGameWon(activePlayer);
    }

    public int convertInputToSquareNumber(String input) {
        return Integer.parseInt(input) - 1;
    }

    public void isGameWon(Player activePlayer) {
        if (movesEvaluator.isGameWon(grid)) {
            cli.announceWinner(activePlayer);
            cli.displayGrid(grid.getSquares());
        }
    }

    public Player getActivePlayer() {
        return activePlayer;
    }

    public void alternatePlayer() {
        if (getActivePlayer() == Player.PLAYERONE) activePlayer = Player.PLAYERTWO;
        else activePlayer = Player.PLAYERONE;
    }

}

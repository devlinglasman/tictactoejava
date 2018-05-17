public class GameRunner {

    private Game game;
    private Cli cli = new Cli(System.in, System.out);

    public GameRunner(Game game) {
        this.game = game;
    }

    public void runGame() {
        cli.askGameMode();
        String choice = cli.takeInput();

        if (choice.equals("1")) {
            while (gameOngoing()) {
                runTurn(game.getActivePlayer());
                game.alternatePlayer();
            }
        }
//        else {
//            while (!game.isGridFull()) {
//                cli.displayGrid(game.getSquares());
//                cli.askInput(game.getPlayerOne());
//                String input = cli.takeInput();
//                int squareNumber = game.convertInputToSquareNumber(input);
//                game.setSquareMark(squareNumber, "X");
//                if (squareNumber + 1 < game.getSquares().length) game.setSquareMark(squareNumber + 1, "O");
//            }
//            cli.displayGrid(game.getSquares());
//        }
    }

    public boolean gameOngoing() {
        return !game.isGridFull(game.getGrid()) && !game.isGameWon(game.getGrid());
    }

    public void runTurn(Player activePlayer) {
        cli.displayGrid(game.getGrid().getSquares());
        String input = cli.askAndTakeInput(activePlayer);
        int squareNumber = game.convertInputToSquareNumber(input);
        game.markSquare(activePlayer, game.getGrid(), squareNumber);
        runGameWonIfWon(activePlayer);
    }

    public void runGameWonIfWon(Player activePlayer) {
        if (game.isGameWon(game.getGrid())) {
            cli.announceWinner(activePlayer);
            cli.displayGrid(game.getGrid().getSquares());
        }
    }
}

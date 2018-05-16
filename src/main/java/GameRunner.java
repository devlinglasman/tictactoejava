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
        } else {
            while (!game.isBoardFull()) {
                cli.displayBoard(game.getSquares());
                cli.askInput(game.getPlayerOne());
                String input = cli.takeInput();
                int squareNumber = game.convertInputToSquareNumber(input);
                game.setSquareMark(squareNumber, "X");
                if (squareNumber + 1 < game.getSquares().length) game.setSquareMark(squareNumber + 1, "O");
            }
            cli.displayBoard(game.getSquares());
        }
    }

    public boolean gameOngoing() {
        return !game.isBoardFull() && !game.isGameWon(game.getPossibleWinLines());
    }

    public void runTurn(Player activePlayer) {
        cli.displayBoard(game.getSquares());
        String input = cli.askAndTakeInput(activePlayer);
        int squareNumber = game.convertInputToSquareNumber(input);
        game.markSquare(activePlayer, squareNumber);
        runGameWonIfWon(activePlayer);
    }

    public void runGameWonIfWon(Player activePlayer) {
        if (game.isGameWon(game.getPossibleWinLines())) {
            cli.announceWinner(activePlayer);
            cli.displayBoard(game.getSquares());
        }
    }
}

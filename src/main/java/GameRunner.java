public class GameRunner {

    private Game game;
    private Cli cli = new Cli(System.in, System.out);

    public GameRunner(Game game) {
        this.game = game;
    }

    public void runGame() {
        cli.askGameType();
        String choice = cli.takeInput();

        if (choice.equals("1")) {
            int counter = 1;
            while (gameOngoing()) {
                runTurn(findActivePlayer(counter));
                counter = nextCounter(counter);
            }
        } else {
            while (!game.isBoardFull()) {
                cli.displayBoard(game.getSquares());
                cli.askInput(1);
                String input = cli.takeInput();
                int squareNumber = game.convertInputToSquareNumber(input);
                game.setSquareMark(squareNumber,"X");
                if (squareNumber + 1 < game.getSquares().length) game.setSquareMark(squareNumber + 1,"O");
            }
            cli.displayBoard(game.getSquares());
        }
    }

    public int nextCounter(int counter) {
        counter = counter % 2;
        counter++;
        return counter;
    }

    public boolean gameOngoing() {
        return !game.isBoardFull() && !game.isGameWon(game.getPossibleWinLines());
    }

    public int findActivePlayer(int counter) {
        int activePlayer;
        if (counter == 1) {
            activePlayer = 1;
        } else {
            activePlayer = 2;
        }
        return activePlayer;
    }

    public void runTurn(int activePlayer) {
        cli.displayBoard(game.getSquares());
        String input = cli.askAndTakeInput(activePlayer);
        int squareNumber = game.convertInputToSquareNumber(input);
        game.markSquare(activePlayer, squareNumber);
        runGameWonIfWon(activePlayer);
    }

    public void runGameWonIfWon(int activePlayer) {
        if (game.isGameWon(game.getPossibleWinLines())) {
            cli.gameWon(activePlayer);
            cli.displayBoard(game.getSquares());
        }
    }
}

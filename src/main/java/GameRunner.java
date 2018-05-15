public class GameRunner {

    private Game game;
    private Cli cli;

    public GameRunner(Cli cli, Game game) {
        this.cli = cli;
        this.game = game;
    }

    public void runGame() {
        cli.askGameType();
        String choice = cli.takeInput();

        if (choice.equals("1")) {
            int counter = 1;
            while (gameOnGoing()) {
                runTurn(findActivePlayer(counter));
                counter = counter % 2;
                counter++;
            }

        } else {
            while (!game.isBoardFull()) {
                cli.displayBoard(game.getSquares());
                cli.askInput(1);
                String input = cli.takeInput();
                int squareNumber = game.convertInputToSquareNumber(input);
                game.setSquareToXMark(squareNumber);
                if (squareNumber + 1 < game.getSquares().length) game.setSquareToO(squareNumber + 1);
            }
            cli.displayBoard(game.getSquares());
        }
    }
    public boolean gameOnGoing() {
        return !game.isBoardFull() && !game.isGameWon(game.getLines());
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
        cli.askInput(activePlayer);
        String input = cli.takeInput();
        int squareNumber = game.convertInputToSquareNumber(input);
        if (activePlayer == 1) {
            game.setSquareToX(squareNumber);
        } else {
            game.setSquareToO(squareNumber);
        }
        if (game.isGameWon(game.getLines())) {
            cli.gameWon(activePlayer);
            cli.displayBoard(game.getSquares());
        }
    }
}

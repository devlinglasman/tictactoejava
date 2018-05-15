public class GameRunner {

    private Game game = new Game();
    private Cli cli = new Cli(System.in, System.out, game);

    public void runGame() {
        cli.askGameType();
        String choice = cli.takeInput();

        if (choice.equals("1")) {
            int counter = 1;
            int activePlayer = 1;
            while (!game.isBoardFull() && !game.isGameWon(game.getLines())) {
                if (counter == 1) {
                    activePlayer = 1;
                } else {
                    activePlayer = 2;
                }
                runTurn(activePlayer);
                counter = counter % 2;
                counter++;
            }
        } else {
            while (!game.isBoardFull()) {
                cli.displayBoard();
                cli.askInput(1);
                String input = cli.takeInput();
                int squareNumber = game.convertInputToSquareNumber(input);
                game.setSquareToXMark(squareNumber);
                if (squareNumber + 1 < game.getSquares().length) game.setSquareToO(squareNumber + 1);
            }
            cli.showBoard();
        }
    }

    public void runTurn(int activePlayer) {
        cli.displayBoard();
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
            cli.displayBoard();
        }
    }
}

public class GameRunner {

    private Game game = new Game();
    private Cli cli = new Cli(System.in, System.out, game);

    public void runGame() {
        cli.askGameType();
        String choice = cli.takeInput();

        if (choice.equals("1")) {
            while (!game.isBoardFull()) {

                cli.displayBoard();
                cli.askInput(1);
                String input = cli.takeInput();
                int squareNumber = game.convertInputToSquareNumber(input);
                game.setSquareToX(squareNumber);
                if (game.isGameWon(game.getLines())) {
                    cli.gameWon(1);
                }

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
}

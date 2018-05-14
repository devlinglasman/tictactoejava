public class GameRunner {

    private Game game = new Game();
    private Cli cli = new Cli(System.in, System.out, game);

    public void runGame() {
        while (!game.isBoardFull()) {
            cli.displayBoard();
            cli.askInput();
            String input = cli.takeInput();
            int squareNumber = game.convertInputToSquareNumber(input);
            game.setSquareToX(squareNumber);
            if (squareNumber + 1 < game.getSquares().length) game.setSquareToO(squareNumber + 1);
        }
        cli.displayBoard();
    }
}

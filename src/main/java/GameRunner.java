public class GameRunner {

    private Game game = new Game();
    private Cli cli = new Cli(System.in,System.out, game);

    public void runGame() {
        cli.displayBoard();
        cli.askInput();
        String input = cli.takeInput();
        int squareNumber = game.convertInputToSquareNumber(input);
        game.setSquareToX(squareNumber);
        cli.displayBoard();
    }
}

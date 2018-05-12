public class GameRunner {

    private Game game = new Game();
    private Cli cli = new Cli(System.in,System.out, game);

    public void runGame() {
        cli.displayBoard();
        cli.askInput();
        String input = cli.takeInput();
        int convertedInput = game.convertInputToSquareNumber(input);
        game.setSquareToX(convertedInput);
        cli.displayBoard();
    }
}

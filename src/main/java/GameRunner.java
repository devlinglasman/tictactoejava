public class GameRunner {

    private Game game = new Game();
    private Cli cli = new Cli(System.in, System.out, game);

    public void runGame() {
        cli.askGameType();
        String choice = cli.takeInput();

        if (choice.equals("1")) {
            System.out.println("Human");
        } else {
            while (!game.isBoardFull()) {
                cli.showBoard();
                cli.askForInput();
                String input = cli.takeInput();
                int squareNumber = game.convertInputToSquareNumber(input);
                game.setSquareToXMark(squareNumber);
                if (squareNumber + 1 < game.getSquares().length) game.setSquareToO(squareNumber + 1);
            }
            cli.showBoard();
        }
    }
}

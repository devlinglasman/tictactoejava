public class Main {

    public static void main(String[] args) {
        Game b = new Game();
        Cli cli = new Cli(System.in,System.out, b);

        cli.displayBoard();
        cli.askInput();
        cli.takeInput();
    }
}

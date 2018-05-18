public class Main {

    public static void main(String[] args) {
        GameLogic gamerunner = new GameLogic();
        Cli cli = new Cli(System.in,System.out,gamerunner);
        cli.chooseGame();
    }
}

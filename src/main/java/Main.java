public class Main {

    public static void main(String[] args) {
        GameRunner gamerunner = new GameRunner();
        Cli cli = new Cli(System.in,System.out,gamerunner);
        cli.runHumanGame();
    }
}

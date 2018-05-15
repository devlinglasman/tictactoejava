import java.io.PrintStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        Cli cli = new Cli(System.in,System.out);
        GameRunner gamerunner = new GameRunner(cli, game);
        gamerunner.runGame();
    }
}

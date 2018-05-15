import java.io.PrintStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        GameRunner gamerunner = new GameRunner(game);
        gamerunner.runGame();
    }
}

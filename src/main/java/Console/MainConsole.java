package Console;

import Core.GameRunner;
import Core.UI;

public class MainConsole {

    public static void main(String[] args) {
        UI ui = new ConsoleUI(System.in, System.out, 1000);
        GameRunner gameRunner = new GameRunner(ui);
        gameRunner.run();
    }
}
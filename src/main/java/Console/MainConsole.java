package Console;

import Core.GameRunner;
import Console.ConsoleUI;

public class MainConsole {

    public static void main(String[] args) {
        ConsoleUI consoleUI = new ConsoleUI(System.in, System.out, 1000);
        GameRunner gameRunner = new GameRunner(consoleUI);
        gameRunner.run();
    }
}
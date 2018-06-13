import Console.ConsoleGameRunner;
import Console.ConsoleUI;

public class Main {

    public static void main(String[] args) {
        ConsoleUI consoleUI = new ConsoleUI(System.in, System.out);
        ConsoleGameRunner consoleGameRunner = new ConsoleGameRunner(consoleUI);
        consoleGameRunner.run();
    }
}
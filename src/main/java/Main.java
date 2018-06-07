import Console.ConsoleGameRunner;
import Console.ConsoleIO;

public class Main {

    public static void main(String[] args) {
        ConsoleIO consoleIO = new ConsoleIO(System.in, System.out);
        ConsoleGameRunner consoleGameRunner = new ConsoleGameRunner(consoleIO);
        consoleGameRunner.run();
    }
}
import Console.ConsoleIO;
import Core.ConsoleGameRunner;

public class MainConsole {

    public static void main(String[] args) {
        ConsoleIO consoleIO = new ConsoleIO(System.in, System.out);
        ConsoleGameRunner consoleGameRunner = new ConsoleGameRunner(consoleIO);
        consoleGameRunner.run();
    }
}

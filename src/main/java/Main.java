import Console.ConsoleGameRunner;
import Console.ConsoleIO;
import Console.GameMovesReader;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        ConsoleIO consoleIO = new ConsoleIO(System.in, System.out);
        ConsoleGameRunner consoleGameRunner = new ConsoleGameRunner(consoleIO);
        consoleGameRunner.run();

    }
}
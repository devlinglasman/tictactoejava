public class Main {

    public static void main(String[] args) {
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(System.in, System.out);
        ConsoleGameRunner consoleGameRunner = new ConsoleGameRunner(consoleDisplay);

        consoleGameRunner.run();
    }
}

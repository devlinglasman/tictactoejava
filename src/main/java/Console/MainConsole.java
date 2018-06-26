package Console;

import Core.GameRunner;
import Core.UserInterfaces.Communicator;
import Core.UserInterfaces.UI;

public class MainConsole {

    public static void main(String[] args) {
        UI ui = new ConsoleUI(System.in, System.out, 1000);
        Communicator communicator = new Communicator(ui);
        GameRunner gameRunner = new GameRunner(communicator);
        gameRunner.run();
    }
}
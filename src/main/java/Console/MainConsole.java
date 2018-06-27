package Console;

import Core.TicTacToe;
import Core.UserInterfaces.Communicator;
import Core.UserInterfaces.UI;

public class MainConsole {

    public static void main(String[] args) {
        UI ui = new ConsoleUI(System.in, System.out, 1000);
        Communicator communicator = new Communicator(ui);
        TicTacToe ticTacToe = new TicTacToe(communicator);
        ticTacToe.run();
    }
}
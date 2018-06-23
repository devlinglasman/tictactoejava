package Console;

import Core.*;
import Core.Players.Player;
import Core.Players.PlayerFactory;

import java.util.ArrayList;

public class MainConsole {

    public static void main(String[] args) {
        UI ui = new ConsoleUI(System.in, System.out, 1000);
        GameRunner gameRunner = new GameRunner(ui);
        gameRunner.run();
    }
}
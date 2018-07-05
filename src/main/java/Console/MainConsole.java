package Console;

import Core.FileAccessor;
import Core.GameModes.GameModeSelector;
import Core.Games.GameFactory;
import Core.GameRunner;
import Core.Players.MovesGenerator;
import Core.Players.PlayerFactory;
import Core.TicTacToe;
import Core.UserInterfaces.Communicator;
import Core.UserInterfaces.UI;

public class MainConsole {

    public static void main(String[] args) {
        UI ui = new ConsoleUI(System.in, System.out, 0);
        Communicator communicator = new Communicator(ui);
        MovesGenerator movesGenerator = new MovesGenerator();
        PlayerFactory playerFactory = new PlayerFactory(communicator, movesGenerator);
        String filePathName = "src/main/resources/gameData.txt";
        FileAccessor fileAccessor = new FileAccessor(filePathName);
        GameFactory gameFactory = new GameFactory(communicator, playerFactory, fileAccessor, filePathName);
        GameRunner gameRunner = new GameRunner();
        GameModeSelector gameModeSelector = new GameModeSelector(communicator);
        TicTacToe ticTacToe = new TicTacToe(communicator, gameRunner, gameFactory, gameModeSelector);
        ticTacToe.run();
    }
}
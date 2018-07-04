package Console;

import Core.FileManipulators.GameDataWriter;
import Core.FileManipulators.GameFileAnalyser;
import Core.GameModes.GameModeSelector;
import Core.Games.GameFactory;
import Core.GameRunner;
import Core.Players.PlayerFactory;
import Core.TicTacToe;
import Core.UserInterfaces.Communicator;
import Core.UserInterfaces.UI;

public class MainConsole {

    public static void main(String[] args) {
        UI ui = new ConsoleUI(System.in, System.out, 1000);
        Communicator communicator = new Communicator(ui);
        PlayerFactory playerFactory = new PlayerFactory(communicator);
        GameFileAnalyser gameFileAnalyser = new GameFileAnalyser();
        GameDataWriter gameDataWriter = new GameDataWriter();
        GameFactory gameFactory = new GameFactory(communicator, playerFactory, gameFileAnalyser, gameDataWriter);
        GameRunner gameRunner = new GameRunner();
        GameModeSelector gameModeSelector = new GameModeSelector(communicator);
        TicTacToe ticTacToe = new TicTacToe(communicator, gameRunner, gameFactory, gameModeSelector);
        ticTacToe.run();
    }
}
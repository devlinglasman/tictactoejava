package Core;

import Core.Players.Player;
import Core.Players.PlayerFactory;

import java.util.ArrayList;
import java.util.Arrays;

public class GameRunner {

    private Grid grid;
    private UI ui;
    private PlayerFactory playerFactory;

    public GameRunner(UI ui) {
        this.ui = ui;
        grid = new Grid();
        playerFactory = new PlayerFactory(ui);
    }

//    public void run() {
//        int gameChoice = getValidGameModeChoice();
//        ArrayList<Player> players = playerFactory.producePlayers(gameChoice);
//        Game game = new Game();
//    }

    public int getValidGameModeChoice() {
        ui.askGameMode();
        int gameModeChoice = ui.getValidNumber();
        boolean gameChoiceIllegal = gameModeChoiceNotValid(gameModeChoice);
        while (gameChoiceIllegal) {
            ui.announceGameModeChoiceInvalid();
            gameModeChoice = ui.getValidNumber();
            gameChoiceIllegal = gameModeChoiceNotValid(gameModeChoice);
        }
        return gameModeChoice;
    }

    private boolean gameModeChoiceNotValid(int gameModeChoice) {
        return Arrays.stream(GameMode.values())
                .noneMatch(gameMode -> gameMode.getModeNumber() == gameModeChoice);
    }

}

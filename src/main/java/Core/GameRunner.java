package Core;

import Core.Players.Player;
import Core.Players.PlayerComputer;
import Core.Players.PlayerHuman;

import java.util.ArrayList;
import java.util.Arrays;

public class GameRunner {

    private Grid grid;
    private UI ui;

    public GameRunner(UI ui) {
        this.ui = ui;
        grid = new Grid();
    }



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

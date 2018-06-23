package Core;

import java.util.Arrays;

public class GameModeSelector {

    private UI ui;

    public GameModeSelector(UI ui) {
        this.ui = ui;
    }

    public GameMode getGameMode() {
        int gameModeNumber = getValidGameModeChoiceNumber();
        return GameMode.findGameModeUsingNumber(gameModeNumber);
    }

    private int getValidGameModeChoiceNumber() {
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

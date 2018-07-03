package Core.GameModes;

import Core.GameModes.GameMode;
import Core.UserInterfaces.Communicator;

import java.util.Arrays;

public class GameModeSelector {

    private Communicator communicator;

    public GameModeSelector(Communicator communicator) {
        this.communicator = communicator;
    }

    public GameMode getMode() {
        int gameModeNumber = getValidGameModeChoiceNumber();
        return GameMode.findGameModeUsingNumber(gameModeNumber);
    }

    private int getValidGameModeChoiceNumber() {
        communicator.askGameMode();
        int gameModeChoice = communicator.getValidNumber();

        while (choiceNotValid(gameModeChoice)) {
            communicator.announceGameModeChoiceInvalid();
            gameModeChoice = communicator.getValidNumber();
        }
        return gameModeChoice;
    }

    private boolean choiceNotValid(int gameModeChoice) {
        return Arrays.stream(GameMode.values())
                .noneMatch(gameMode -> gameMode.getModeNumber() == gameModeChoice);
    }
}

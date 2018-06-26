package Core;

import Core.UserInterfaces.Communicator;

import java.util.Arrays;

public class GameModeSelector {

    private Communicator communicator;

    public GameModeSelector(Communicator communicator) {
        this.communicator = communicator;
    }

    public GameMode getPrimaryGameMode() {
        int gameModeNumber = getValidGameModeChoiceNumber();
        return GameMode.findGameModeUsingNumber(gameModeNumber);
    }

    private int getValidGameModeChoiceNumber() {
        communicator.askGameMode();
        int gameModeChoice = communicator.getValidNumber();
        boolean gameChoiceIllegal = gameModeChoiceNotValid(gameModeChoice);
        while (gameChoiceIllegal) {
            communicator.announceGameModeChoiceInvalid();
            gameModeChoice = communicator.getValidNumber();
            gameChoiceIllegal = gameModeChoiceNotValid(gameModeChoice);
        }
        return gameModeChoice;
    }

    private boolean gameModeChoiceNotValid(int gameModeChoice) {
        return Arrays.stream(GameMode.values())
                .noneMatch(gameMode -> gameMode.getModeNumber() == gameModeChoice);
    }
}

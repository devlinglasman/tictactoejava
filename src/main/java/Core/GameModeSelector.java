package Core;

import Core.UserInterfaces.Communicator;

import java.util.Arrays;

public class GameModeSelector {

    private Communicator communicator;
    private boolean firstGame;

    public GameModeSelector(Communicator communicator) {
        this.communicator = communicator;
        firstGame = true;
    }

    public GameMode getMode() {
        if (firstGame) {
            firstGame = false;
            return getPrimaryGameMode();
        } else {
            return getSecondaryGameMode();
        }
    }

    public GameMode getPrimaryGameMode() {
        int gameModeNumber = getValidGameModeChoiceNumber();
        return GameMode.findGameModeUsingNumber(gameModeNumber);
    }

    private GameMode getSecondaryGameMode() {
        return rewatch() ? GameMode.SIMULATEDPLAY
                : getPrimaryGameMode();
    }

    private boolean rewatch() {
        communicator.askRewatch();
        return communicator.askIfYes();
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

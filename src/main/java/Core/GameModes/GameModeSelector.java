package Core.GameModes;

import Core.UserInterfaces.Communicator;

public class GameModeSelector {

    private Communicator communicator;

    public GameModeSelector(Communicator communicator) {
        this.communicator = communicator;
    }

    public GameMode getMode() {
        return GameMode.findGameModeUsingNumber(getGameModeChoice());
    }

    private int getGameModeChoice() {
        int gameModeChoice = communicator.findGameModeChoice();
        while (invalid(gameModeChoice)) {
            communicator.announceGameModeChoiceInvalid();
            gameModeChoice = communicator.findGameModeChoice();
        }
        return gameModeChoice;
    }

    private boolean invalid(int gameModeChoice) {
        boolean illegalChoice = true;
        for (GameMode gameMode : GameMode.values()) {
            if (gameMode.getModeNumber() == gameModeChoice) {
                illegalChoice = false;
                break;
            }
        }
        if (gameModeChoice == GameMode.SIMULATEDPLAY.getModeNumber()) {
            illegalChoice = true;
        }
        return illegalChoice;
    }
}

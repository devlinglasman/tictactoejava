package Core.GameModes;

import Core.UserInterfaces.Communicator;

import java.util.Arrays;

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
            gameModeChoice = communicator.findGameModeChoice();
        }
        return gameModeChoice;
    }

    private boolean invalid(int gameModeChoice) {
        return Arrays.stream(GameMode.values())
                .noneMatch(gameMode -> gameMode.getModeNumber() == gameModeChoice);
    }
}

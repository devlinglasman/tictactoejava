package Core;

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

    public GameMode getSecondaryGameMode() {
        String rewatchDecision = getRewatchDecision();
        return rewatchDecision.equals("y") ? GameMode.SIMULATEDPLAY : getPrimaryGameMode();
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

    private String getRewatchDecision() {
        communicator.askRewatch();
        return communicator.findYesorNoAnswer();
    }

}

package Core.GameModes;

public enum GameMode {

    HUMANVSCOMP(1),
    COMPVSCOMP(2),
    HUMANVSHUMAN(3),
    SIMULATEDPLAY(4);

    private int modeNumber;

    GameMode(int modeNumber) {
        this.modeNumber = modeNumber;
    }

    public int getModeNumber() {
        return modeNumber;
    }

    public static GameMode findGameModeUsingNumber(int gameModeChoice) {
        for (GameMode gameMode : GameMode.values()) {
            if (gameModeChoice == gameMode.getModeNumber()) {
                return gameMode;
            }
        }
        throw new IllegalArgumentException(String.valueOf(gameModeChoice));
    }

}

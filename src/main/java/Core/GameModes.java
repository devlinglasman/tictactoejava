package Core;

public enum GameModes {

    HUMANVSCOMP(1),
    COMPVSCOMP(2),
    HUMANVSHUMAN(3),
    SIMULATEDPLAY(4);

    private int modeNumber;

    GameModes(int modeNumber) {
        this.modeNumber = modeNumber;
    }

    public int getModeNumber() {
        return modeNumber;
    }
}

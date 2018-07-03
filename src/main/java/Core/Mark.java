package Core;

public enum Mark {

    EMPTY(" "),
    PLAYER_ONE("X"),
    PLAYER_TWO("O");

    private String stringRepresentation;

    Mark(String stringRepresentation) {
        this.stringRepresentation = stringRepresentation;
    }

    public String getStringRepresentation() {
        return stringRepresentation;
    }
}

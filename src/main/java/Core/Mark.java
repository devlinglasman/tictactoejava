package Core;

public enum Mark {

    UNMARKEDSQUARE(" "),
    PLAYERONEMARK("X"),
    PLAYERTWOMARK("O");

    private String stringRepresentation;

    Mark(String stringRepresentation) {
        this.stringRepresentation = stringRepresentation;
    }

    public String getStringRepresentation() {
        return stringRepresentation;
    }
}

public enum Mark {

    unmarkedSquare(" "),
    playerOneMark("X"),
    playerTwoMark("O");

    private String stringRepresentation;

    Mark(String stringRepresentation) {
        this.stringRepresentation = stringRepresentation;
    }

    public String getStringRepresentation() {
        return stringRepresentation;
    }
}

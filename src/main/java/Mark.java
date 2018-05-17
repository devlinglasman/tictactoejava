public enum Mark {

    unmarkedSquare(" "),
    playerOneMarkedSquare("X"),
    playerTwoMarkedSquare("O");

    private String stringRepresentation;

    Mark(String stringRepresentation) {
        this.stringRepresentation = stringRepresentation;
    }

    public String getStringRepresentation() {
        return stringRepresentation;
    }
}

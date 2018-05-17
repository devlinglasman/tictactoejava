public enum Player {

    PLAYERONE("Player One", Mark.playerOneMarkedSquare),
    PLAYERTWO("Player Two", Mark.playerTwoMarkedSquare);

    private final String name;
    private final Mark mark;

    Player(String name, Mark mark) {
        this.name = name;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public Mark getMark() {
        return mark;
    }
}

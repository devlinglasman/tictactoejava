public enum Player {

    PLAYERONE("Player One"),
    PLAYERTWO("Player Two");

    private final String name;

    private Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public abstract class Player {

    private String name;
    private Mark mark;

    public Player(String name, Mark mark) {
        this.name = name;
        this.mark = mark;
    }

    public abstract String getInput();

    public abstract boolean isHumanPlayer();

    public String getName() {
        return name;
    }

    public Mark getMark() {
        return mark;
    }
}

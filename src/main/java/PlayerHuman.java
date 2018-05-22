public class PlayerHuman {

    private String name;
    private Mark mark;

    public PlayerHuman(String name, Mark mark) {
        this.name = name;
        this.mark = mark;
    }

    public String askForMove(ConsoleDisplay consoleDisplay) {
        consoleDisplay.askForSquareChoice(name);
        return consoleDisplay.takeInput();
    }

    public String getName() {
        return name;
    }

    public Mark getMark() {
        return mark;
    }
}

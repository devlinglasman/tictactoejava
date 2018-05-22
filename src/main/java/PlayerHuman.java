public class PlayerHuman extends Player {

    private ConsoleDisplay consoleDisplay;

    public PlayerHuman(String name, Mark mark, ConsoleDisplay consoleDisplay) {
        super(name,mark);
        this.consoleDisplay = consoleDisplay;
    }

    @Override
    public String getInput() {
        consoleDisplay.askForSquareChoice(getName());
        return consoleDisplay.takeInput();
    }
}

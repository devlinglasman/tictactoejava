public class PlayerHuman extends Player {

    private ConsoleDisplay consoleDisplay;

    public PlayerHuman(String name, Mark mark, ConsoleDisplay consoleDisplay) {
        super(name,mark);
        this.consoleDisplay = consoleDisplay;
    }

    public String getHumanInput() {
        consoleDisplay.askForSquareChoice(getName());
        return consoleDisplay.takeInput();
    }

    @Override
    public boolean isHumanPlayer() {
       return true;
    }
}

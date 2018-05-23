public class PlayerComputer extends Player {

    public PlayerComputer(String name, Mark mark) {
        super(name, mark);
    }

    public int getComputerInput(Minimax minimax) {
        minimax.minimaxCalculation(minimax.getInitialGameState());
    }

    @Override
    public boolean isHumanPlayer() {
        return false;
    }
}

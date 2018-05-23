import java.util.Random;

public class PlayerComputer extends Player {

    public PlayerComputer(String name, Mark mark) {
        super(name, mark);
    }

    @Override
    public String getInput() {
        Random rand = new Random();
        int input = rand.nextInt(8);
        return Integer.toString(input);
    }

    @Override
    public boolean isHumanPlayer() {
        return false;
    }
}

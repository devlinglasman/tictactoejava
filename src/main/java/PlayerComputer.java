import java.util.Random;

public class PlayerComputer {

    private String name;
    private Mark mark;

    public PlayerComputer(String name, Mark mark) {
        this.name = name;
        this.mark = mark;
    }

    public int generateComputerInput() {
        Random rand = new Random();
        return rand.nextInt(8);
    }

    public String getName() {
        return name;
    }

    public Mark getMark() {
        return mark;
    }
}

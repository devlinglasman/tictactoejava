package Core.Games;

public interface Game {

    void runGame();

    int generateMove();

    void markGrid(int move);
}

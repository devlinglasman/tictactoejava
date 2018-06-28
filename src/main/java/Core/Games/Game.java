package Core.Games;

public interface Game {

    void displayGrid();

    boolean gameOngoing();

    void nextMove();

    int generateMove();

    void markGrid(int move);

    void announceResult();

    int getLastMove();
}

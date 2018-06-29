package Core.Games;

public interface Game {

    void displayGrid();

    boolean gameOngoing();

    void playNextMove();

    Integer generateMove();

    void markGrid(Integer move);

    void announceResult();

    Integer getLastMove();
}

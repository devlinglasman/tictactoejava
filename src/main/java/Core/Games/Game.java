package Core.Games;

public interface Game {

    boolean gameOngoing();

    void playNextMove();

    void announceResult();

    Integer getLastMove();
}

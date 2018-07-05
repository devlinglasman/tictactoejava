package Core.Games;

public class PrimaryGameDouble implements Game {

    @Override
    public boolean gameOngoing() {
        return false;
    }

    @Override
    public void playNextMove() {
    }

    @Override
    public void announceResult() {
    }

    @Override
    public Integer getLastMove() {
        return 0;
    }
}

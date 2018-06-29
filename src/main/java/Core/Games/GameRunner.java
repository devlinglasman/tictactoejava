package Core.Games;

public class GameRunner {

    public void runGame(Game game) {
        game.displayGrid();
        playPlies(game);
        game.announceResult();
    }

    public void playPlies(Game game) {
        while (game.gameOngoing()) {
            game.playNextMove();
        }
    }

}

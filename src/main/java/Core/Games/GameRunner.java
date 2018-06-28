package Core.Games;

public class GameRunner {

    public void runGame(Game game) {
        game.displayGrid();
        continuePlies(game);
        game.announceResult();
    }

    public void continuePlies(Game game) {
        while (game.gameOngoing()) {
            game.playNextMove();
        }
    }

}

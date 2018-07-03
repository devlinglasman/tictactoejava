package Core;

import Core.Games.Game;

public class GameRunner {

    public void runGame(Game game) {
        playPlies(game);
        game.announceResult();
    }

    public void playPlies(Game game) {
        while (game.gameOngoing()) {
            game.playNextMove();
        }
    }

}

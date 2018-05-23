import java.util.ArrayList;

public class Minimax {

    private GameState initialGameState;

    public Minimax(GameState initialGameState) {
        this.initialGameState = initialGameState;
    }

    public int score(GameState gameState) {
        if (gameState.getGrid().winningLineExistsInGrid(initialGameState.activePlayer)) return 10;
        else if (gameState.getGrid().winningLineExistsInGrid(initialGameState.opponent)) return -10;
        else return 0;
    }

    public Integer minimaxCalculation(GameState currentGameState) {
        Integer score = score(currentGameState);
        if (currentGameState.gameOver()) return score;

        else {
            ArrayList<Integer> scores = new ArrayList<>();
            ArrayList<Integer> theseEmptySquares = currentGameState.getGrid().emptySquareIndices();

            for (Integer emptySquareIndex : theseEmptySquares) {
                GameState nextGameState = new GameState(currentGameState.getGrid(), currentGameState.getOpponent(), currentGameState.getActivePlayer());
                nextGameState.getGrid().setASquare(emptySquareIndex, nextGameState.getActivePlayer());
                Integer minimaxScore = minimaxCalculation(nextGameState);
                scores.add(minimaxScore);
            }

            if (currentGameState.getActivePlayer() == initialGameState.getActivePlayer()) {
                Integer maxScoreIndex = 0;

                for (int i = 0; i < scores.size(); i++) {
                    Integer newScoreIndex = scores.get(i);
                    if ((newScoreIndex > scores.get(maxScoreIndex))) {
                        maxScoreIndex = i;
                    }
                }
                return scores.get(maxScoreIndex);
            } else {
                Integer minScoreIndex = 0;

                for (int i = 0; i < scores.size(); i++) {
                    Integer newScoreIndex = scores.get(i);
                    if ((newScoreIndex < scores.get(minScoreIndex))) {
                        minScoreIndex = i;
                    }
                }
                return scores.get(minScoreIndex);
            }

        }
    }

    public GameState getInitialGameState() {
        return initialGameState;
    }
}



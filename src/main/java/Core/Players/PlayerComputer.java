package Core.Players;

import Core.GameState;
import Core.Grid;
import Core.Mark;

import java.util.ArrayList;

public class PlayerComputer extends Player {

    public PlayerComputer(String name, Mark mark) {
        super(name, mark);
    }

    @Override
    public int getInput(Grid grid) {
        GameState initialGameState = new GameState(grid, getMark());
        return emptySquareChoice(initialGameState);
    }

    public Integer emptySquareChoice(GameState gameState) {
        ArrayList<Integer> scores = new ArrayList<>();
        ArrayList<Integer> theseEmptySquares = gameState.getGrid().emptySquareIndices();

        for (Integer emptySquare : theseEmptySquares) {
            gameState.getGrid().setASquare(emptySquare, gameState.getActivePlayerMark());
            Integer minimaxScore = minimaxCalculator(gameState);
            scores.add(minimaxScore);
        }

        Integer maxScoreIndex = 0;
        for (int i = 0; i < scores.size(); i++) {
            Integer newScoreIndex = scores.get(i);
            if ((newScoreIndex > scores.get(maxScoreIndex))) {
                maxScoreIndex = i;
            }
        }

        return theseEmptySquares.get(maxScoreIndex);
    }

    public int score(GameState gameState) {
        if (gameState.getGrid().winningLineExistsInGrid()) {
            if (gameState.getGrid().reportWinningMark() == gameState.getActivePlayerMark()) return 10;
            else return -10;
        } else return 0;
    }

    public Integer minimaxCalculator(GameState gameState) {
        Integer score = score(gameState);
        if (!gameState.getGrid().gameOngoing()) return score;

        else {
            ArrayList<Integer> scores = new ArrayList<>();
            ArrayList<Integer> theseEmptySquares = gameState.getGrid().emptySquareIndices();

            for (Integer emptySquareIndex : theseEmptySquares) {
                GameState nextGameState = new GameState(gameState.getGrid(), gameState.getOpponentMark());
                nextGameState.getGrid().setASquare(emptySquareIndex, nextGameState.getActivePlayerMark());
                Integer minimaxScore = minimaxCalculator(nextGameState);
                scores.add(minimaxScore);
            }

            if (gameState.getActivePlayerMark() == getMark()) {
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

    @Override
    public boolean isHumanPlayer() {
        return false;
    }
}

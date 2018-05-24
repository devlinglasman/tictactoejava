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
        Grid gridClone = new Grid();
        gridClone.setSquares(grid.copySquares());
        GameState initialGameState = new GameState(gridClone, getMark());
        return emptySquareChoice(initialGameState);
    }

    public Integer emptySquareChoice(GameState gameState) {
        ArrayList<Integer> scores = new ArrayList<>();
        ArrayList<Integer> theseEmptySquares = gameState.getGrid().emptySquareIndices();

        for (Integer emptySquare : theseEmptySquares) {
            Grid gridClone = new Grid();
            gridClone.setSquares(gameState.getGrid().copySquares());
            GameState nextGameState = new GameState(gridClone, gameState.getOpponentMark());
            nextGameState.getGrid().setASquare(emptySquare, getMark());
            Integer minimaxScore = minimaxCalculator(nextGameState);
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
            if (gameState.getGrid().reportWinningMark() == getMark()) return 10;
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
                Grid gridClone = new Grid();
                gridClone.setSquares(gameState.getGrid().copySquares());
                GameState nextGameState = new GameState(gridClone, gameState.getOpponentMark());
                nextGameState.getGrid().setASquare(emptySquareIndex, gameState.getActivePlayerMark());
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

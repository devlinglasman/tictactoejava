package Core;

import java.util.ArrayList;

public class Minimax {

    private Mark minimaxPlayerMark;
    private Grid firstGrid;

    public Minimax(Mark minimaxPlayerMark, Grid firstGrid) {
        this.minimaxPlayerMark = minimaxPlayerMark;
        this.firstGrid = firstGrid;
    }

    public int findSquareChoice(Grid grid, Mark optimisingPlayerMark) {

        ArrayList<Integer> emptyGridSquares = grid.emptySquareIndices();
        ArrayList<Integer> scores = new ArrayList<>();

        emptyGridSquares
                .stream()
                .map(emptySquare -> emulateGrid(grid, emptySquare, optimisingPlayerMark))
                .forEach(emulatedGrid ->
                {
                    Integer emulatedGridScore = findGridScore(emulatedGrid, optimisingPlayerMark);
                    scores.add(emulatedGridScore);
                });

        Integer relevantIndex;
        if (grid != firstGrid) {
            if (optimisingPlayerMark == minimaxPlayerMark) {
                relevantIndex = findMaxIndex(scores);
            } else {
                relevantIndex = findMinIndex(scores);
            }
            return scores.get(relevantIndex);
        } else {
            relevantIndex = findMaxIndex(scores);
            return emptyGridSquares.get(relevantIndex);
        }
    }

    private Integer findGridScore(Grid grid, Mark optimisingPlayerMark) {
        if (grid.isGameOver()) {
            return scoreForTerminalGameState(grid);
        } else {
            Mark oppositeOptimiserMark = makeOppositeOptimisingMark(optimisingPlayerMark);
            return findSquareChoice(grid, oppositeOptimiserMark);
        }
    }

    private int findMaxIndex(ArrayList<Integer> scores) {
        Integer maxScore = null;
        Integer maxIndex = 0;
        for (int i = 0; i < scores.size(); i++) {
            Integer currentScore = scores.get(i);
            if (maxScore == null || currentScore >= maxScore) {
                maxScore = currentScore;
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    private int findMinIndex(ArrayList<Integer> scores) {
        Integer minScore = null;
        Integer minIndex = 0;
        for (int i = 0; i < scores.size(); i++) {
            Integer currentScore = scores.get(i);
            if (minScore == null || currentScore <= minScore) {
                minScore = currentScore;
                minIndex = i;
            }
        }
        return minIndex;
    }

    private int scoreForTerminalGameState(Grid grid) {
        if (grid.winningLineExistsInGrid()) {
            if (grid.reportWinningMark() == minimaxPlayerMark) return 1;
            else return -1;
        } else return 0;
    }

    private Grid emulateGrid(Grid grid, Integer emptySquare, Mark mark) {
        Grid gridClone = grid.duplicate();
        gridClone.markSquare(emptySquare, mark);
        return gridClone;
    }

    private Mark makeOppositeOptimisingMark(Mark currentOptimisingPlayerMark) {
        Mark oppositeOptimisingMark;
        if (currentOptimisingPlayerMark == minimaxPlayerMark) oppositeOptimisingMark = Mark.playerOneMark;
        else oppositeOptimisingMark = minimaxPlayerMark;
        return oppositeOptimisingMark;
    }
}

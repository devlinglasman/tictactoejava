package Core;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.IntStream;

public class Minimax {

    private Grid firstGrid;
    private Mark minimaxPlayerMark;
    private Mark nonMinimaxPlayerMark;

    public Minimax(Grid firstGrid, Mark minimaxPlayerMark, Mark nonMinimaxPlayerMark) {
        this.firstGrid = firstGrid;
        this.minimaxPlayerMark = minimaxPlayerMark;
        this.nonMinimaxPlayerMark = nonMinimaxPlayerMark;
    }

    public int findSquareChoice(Grid grid, Mark optimisingPlayerMark, Integer depth) {

        ArrayList<Integer> emptyGridSquares = grid.emptySquareIndices();
        ArrayList<Integer> scores = new ArrayList<>();

        for (Integer emptySquare : emptyGridSquares) {
            Grid emulatedGrid = emulateGrid(grid, emptySquare, optimisingPlayerMark);
            Integer emulatedGridScore;
            if (emulatedGrid.isGameOver()) {
                emulatedGridScore = scoreForTerminalGameState(emulatedGrid, depth);
            } else {
                depth++;
                Mark oppositeOptimiserMark = makeOppositeOptimisingMark(optimisingPlayerMark);
                emulatedGridScore = findSquareChoice(emulatedGrid, oppositeOptimiserMark, depth);
            }
            scores.add(emulatedGridScore);
        }

        if (grid != firstGrid) {
            if (optimisingPlayerMark == minimaxPlayerMark) {
                Integer maxScore = scores.get(0);
                for (Integer score: scores) {
                   if (score > maxScore) maxScore = score;
                }
                return maxScore;
            } else {
                Integer minScore = scores.get(0);
                for (Integer score: scores) {
                    if (score < minScore) minScore = score;
                }
                return minScore;
            }
        } else {
            Integer relevantIndex = findMaxIndex(scores);
            return emptyGridSquares.get(relevantIndex);
        }
    }

    private Grid emulateGrid(Grid grid, Integer emptySquare, Mark mark) {
        Grid gridClone = grid.duplicate();
        gridClone.markSquare(emptySquare, mark);
        return gridClone;
    }

    private int scoreForTerminalGameState(Grid grid, Integer depth) {
        if (grid.winningLineExistsInGrid()) {
            if (grid.reportWinningMark() == minimaxPlayerMark) return 100 - depth;
            else return depth - 100;
        } else return 0;
    }

    private Mark makeOppositeOptimisingMark(Mark currentOptimisingPlayerMark) {
        Mark oppositeOptimisingMark;
        if (currentOptimisingPlayerMark == minimaxPlayerMark) oppositeOptimisingMark = nonMinimaxPlayerMark;
        else oppositeOptimisingMark = minimaxPlayerMark;
        return oppositeOptimisingMark;
    }

    private int findMaxIndex(ArrayList<Integer> scores) {
        return IntStream.range(0, scores.size()).boxed()
                .max(Comparator.comparingInt(scores::get))
                .get();
    }
}

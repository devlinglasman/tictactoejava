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

        emptyGridSquares
                .stream()
                .map(emptySquare -> emulateGrid(grid, emptySquare, optimisingPlayerMark))
                .forEach(emulatedGrid ->
                {
                    Integer emulatedGridScore = findGridScore(emulatedGrid, optimisingPlayerMark, depth);
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

    private Grid emulateGrid(Grid grid, Integer emptySquare, Mark mark) {
        Grid gridClone = grid.duplicate();
        gridClone.markSquare(emptySquare, mark);
        return gridClone;
    }

    private Integer findGridScore(Grid grid, Mark optimisingPlayerMark, Integer depth) {
        if (grid.isGameOver()) {
            return scoreForTerminalGameState(grid, depth);
        } else {
            depth++;
            Mark oppositeOptimiserMark = makeOppositeOptimisingMark(optimisingPlayerMark);
            return findSquareChoice(grid, oppositeOptimiserMark, depth);
        }
    }

    private int scoreForTerminalGameState(Grid grid, Integer depth) {
        if (grid.winningLineExistsInGrid()) {
            if (grid.reportWinningMark() == minimaxPlayerMark) return 10 - depth;
            else return depth - 10;
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

    private int findMinIndex(ArrayList<Integer> scores) {
        return IntStream.range(0, scores.size()).boxed()
                .min(Comparator.comparingInt(scores::get))
                .get();
    }
}

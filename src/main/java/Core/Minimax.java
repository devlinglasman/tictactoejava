package Core;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.IntStream;

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

    private Grid emulateGrid(Grid grid, Integer emptySquare, Mark mark) {
        Grid gridClone = grid.duplicate();
        gridClone.markSquare(emptySquare, mark);
        return gridClone;
    }

    private Integer findGridScore(Grid grid, Mark optimisingPlayerMark) {
        if (grid.isGameOver()) {
            return scoreForTerminalGameState(grid);
        } else {
            Mark oppositeOptimiserMark = makeOppositeOptimisingMark(optimisingPlayerMark);
            return findSquareChoice(grid, oppositeOptimiserMark);
        }
    }

    private Mark makeOppositeOptimisingMark(Mark currentOptimisingPlayerMark) {
        Mark oppositeOptimisingMark;
        if (currentOptimisingPlayerMark == minimaxPlayerMark) oppositeOptimisingMark = Mark.playerOneMark;
        else oppositeOptimisingMark = minimaxPlayerMark;
        return oppositeOptimisingMark;
    }

    private int scoreForTerminalGameState(Grid grid) {
        if (grid.winningLineExistsInGrid()) {
            if (grid.reportWinningMark() == minimaxPlayerMark) return 1;
            else return -1;
        } else return 0;
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

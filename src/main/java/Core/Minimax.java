package Core;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.IntStream;

public class Minimax {

    private Grid firstGrid;
    private Mark maximisingPlayerMark;
    private Mark minimisingPlayerMark;

    public Minimax(Grid firstGrid, Mark maximisingPlayerMark, Mark minimisingPlayerMark) {
        this.firstGrid = firstGrid;
        this.maximisingPlayerMark = maximisingPlayerMark;
        this.minimisingPlayerMark = minimisingPlayerMark;
    }

    public int minimax() {
        return maximise(firstGrid, maximisingPlayerMark, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private int maximise(Grid grid, Mark maximisingPlayerMark, Integer depth, Integer alpha, Integer beta) {

        ArrayList<Integer> emptyGridSquares = grid.emptySquareIndices();
        ArrayList<Integer> scores = new ArrayList<>();
        Integer newAlpha = alpha;

        for (Integer emptySquare : emptyGridSquares) {
            Grid emulatedGrid = emulateGrid(grid, emptySquare, maximisingPlayerMark);
            if (emulatedGrid.isGameOver()) {
                Integer emulatedGridScore = scoreForTerminalGameState(emulatedGrid, depth);
                newAlpha = Math.max(newAlpha, emulatedGridScore);
            } else {
                newAlpha = Math.max(newAlpha, minimise(emulatedGrid, oppositeOptimisingMark(maximisingPlayerMark), depth + 1, newAlpha, beta));
            }
            if (grid == firstGrid) scores.add(newAlpha);
            else if (newAlpha >= beta) {
                break;
            }
        }
        if (grid == firstGrid) {
            Integer relevantIndex = findMaxIndex(scores);
            return emptyGridSquares.get(relevantIndex);
        } else {
            return newAlpha;
        }
    }

    private Integer minimise(Grid grid, Mark optimisingPlayerMark, Integer depth, Integer alpha, Integer beta) {

        ArrayList<Integer> emptyGridSquares = grid.emptySquareIndices();
        Integer newBeta = beta;

        for (Integer emptySquare : emptyGridSquares) {
            Grid emulatedGrid = emulateGrid(grid, emptySquare, optimisingPlayerMark);
            if (emulatedGrid.isGameOver()) {
                Integer emulatedGridScore = scoreForTerminalGameState(emulatedGrid, depth);
                newBeta = Math.min(newBeta, emulatedGridScore);
            } else {
                newBeta = Math.min(newBeta, maximise(emulatedGrid, oppositeOptimisingMark(optimisingPlayerMark), depth + 1, alpha, newBeta));
            }
            if (alpha >= newBeta) break;
        }
        return newBeta;
    }

    private Grid emulateGrid(Grid grid, Integer emptySquare, Mark mark) {
        Grid gridClone = grid.duplicate();
        gridClone.markSquare(emptySquare, mark);
        return gridClone;
    }

    private int scoreForTerminalGameState(Grid grid, Integer depth) {
        if (grid.winningLineExistsInGrid()) {
            if (grid.reportWinningMark() == this.maximisingPlayerMark) return 1000 - depth;
            else return depth - 1000;
        } else return 0;
    }

    private Mark oppositeOptimisingMark(Mark currentOptimisingPlayerMark) {
        Mark oppositeOptimisingMark;
        if (currentOptimisingPlayerMark == this.maximisingPlayerMark) oppositeOptimisingMark = this.minimisingPlayerMark;
        else oppositeOptimisingMark = this.maximisingPlayerMark;
        return oppositeOptimisingMark;
    }

    private int findMaxIndex(ArrayList<Integer> scores) {
        return IntStream.range(0, scores.size()).boxed()
                .max(Comparator.comparingInt(scores::get))
                .get();
    }
}

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

    public int findGridChoice() {
        ArrayList<Integer> emptyGridSquares = firstGrid.emptySquareIndices();
        ArrayList<Integer> scores = new ArrayList<>();

        for (Integer emptySquare : emptyGridSquares) {
            Grid emulatedGrid = emulateGrid(firstGrid, emptySquare, maximisingPlayerMark);
            Integer score = minimax(emulatedGrid, minimisingPlayerMark, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
            scores.add(score);
        }

        Integer maxScoreIndex = findMaxIndex(scores);
        return emptyGridSquares.get(maxScoreIndex);
    }

    private int minimax(Grid grid, Mark optimisingPlayerMark, Integer depth, Integer alpha, Integer beta) {

        if (grid.isGameOver()) {
            return scoreForTerminalGameState(grid, depth);
        } else {
            Integer bestVal;
            if (isMaximisingPlayer(optimisingPlayerMark)) bestVal = Integer.MIN_VALUE;
            else bestVal = Integer.MAX_VALUE;

            ArrayList<Integer> emptyGridSquares = grid.emptySquareIndices();
            for (Integer emptySquare : emptyGridSquares) {
                Grid emulatedGrid = emulateGrid(grid, emptySquare, optimisingPlayerMark);
                Integer value = minimax(emulatedGrid, oppositeOptimisingMark(optimisingPlayerMark), depth + 1, alpha, beta);
                if (isMaximisingPlayer(optimisingPlayerMark)) {
                    bestVal = Math.max(bestVal, value);
                    alpha = Math.max(alpha, bestVal);
                } else {
                    bestVal = Math.min(bestVal, value);
                    beta = Math.min(beta, bestVal);
                }
                if (beta <= alpha) break;
            }
            return bestVal;
        }
    }

    private boolean isMaximisingPlayer(Mark optimisingPlayerMark) {
        return optimisingPlayerMark == maximisingPlayerMark;
    }

    private Grid emulateGrid(Grid grid, Integer emptySquare, Mark mark) {
        Grid gridClone = grid.duplicate();
        gridClone.markSquare(emptySquare, mark);
        return gridClone;
    }

    private int scoreForTerminalGameState(Grid grid, Integer depth) {
        if (grid.winningLineExistsInGrid()) {
            if (grid.reportWinningMark() == maximisingPlayerMark) return 1000 - depth;
            else return depth - 1000;
        } else return 0;
    }

    private Mark oppositeOptimisingMark(Mark currentOptimisingPlayerMark) {
        Mark oppositeOptimisingMark;
        if (currentOptimisingPlayerMark == maximisingPlayerMark)
            oppositeOptimisingMark = minimisingPlayerMark;
        else oppositeOptimisingMark = maximisingPlayerMark;
        return oppositeOptimisingMark;
    }

    private int findMaxIndex(ArrayList<Integer> scores) {
        return IntStream.range(0, scores.size()).boxed()
                .max(Comparator.comparingInt(scores::get))
                .get();
    }
}

package Core;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.IntStream;

public class Minimax {

    private Grid firstGrid;
    private Mark maximisingPlayer;
    private Mark minimisingPlayer;

    public Minimax(Grid firstGrid, Mark maximisingPlayer, Mark minimisingPlayer) {
        this.firstGrid = firstGrid;
        this.maximisingPlayer = maximisingPlayer;
        this.minimisingPlayer = minimisingPlayer;
    }

    public int findBestMove() {
        ArrayList<Integer> emptyGridSquares = firstGrid.emptySquareIndices();
        ArrayList<Integer> scores = new ArrayList<>();

        for (Integer emptySquare : emptyGridSquares) {
            Grid emulatedGrid = playMove(firstGrid, emptySquare, maximisingPlayer);
            Integer score = minimax(emulatedGrid, minimisingPlayer, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
            scores.add(score);
        }

        Integer maxScoreIndex = findMaxIndex(scores);
        return emptyGridSquares.get(maxScoreIndex);
    }

    private int minimax(Grid grid, Mark optimisingPlayer, Integer depth, Integer alpha, Integer beta) {

        if (grid.isGameOver()) {
            return scoreForTerminalGameState(grid, depth);
        } else {
            Integer bestVal;
            if (isMaximisingPlayer(optimisingPlayer)) bestVal = Integer.MIN_VALUE;
            else bestVal = Integer.MAX_VALUE;

            ArrayList<Integer> emptyGridSquares = grid.emptySquareIndices();
            for (Integer emptySquare : emptyGridSquares) {
                Grid emulatedGrid = playMove(grid, emptySquare, optimisingPlayer);
                Integer value = minimax(emulatedGrid, oppositeOptimising(optimisingPlayer), depth + 1, alpha, beta);
                if (isMaximisingPlayer(optimisingPlayer)) {
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

    private boolean isMaximisingPlayer(Mark optimisingPlayer) {
        return optimisingPlayer == maximisingPlayer;
    }

    private Grid playMove(Grid grid, Integer emptySquare, Mark mark) {
        Grid gridClone = grid.duplicate();
        gridClone.markSquare(emptySquare, mark);
        return gridClone;
    }

    private int scoreForTerminalGameState(Grid grid, Integer depth) {
        if (grid.winningLineExistsInGrid()) {
            if (grid.reportWinningMark() == maximisingPlayer) return 1000 - depth;
            else return depth - 1000;
        } else return 0;
    }

    private Mark oppositeOptimising(Mark currentOptimisingPlayer) {
        Mark oppositeOptimising;
        if (currentOptimisingPlayer == maximisingPlayer)
            oppositeOptimising = minimisingPlayer;
        else oppositeOptimising = maximisingPlayer;
        return oppositeOptimising;
    }

    private int findMaxIndex(ArrayList<Integer> scores) {
        return IntStream.range(0, scores.size()).boxed()
                .max(Comparator.comparingInt(scores::get))
                .get();
    }
}

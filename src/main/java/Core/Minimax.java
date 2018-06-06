package Core;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.Map.*;

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
        HashMap<Integer, Integer> scores = buildScores();
        return scores.entrySet().stream().max(Entry.comparingByValue()).get().getKey();
    }

    private HashMap<Integer, Integer> buildScores() {
        ArrayList<Integer> emptyGridSquares = firstGrid.emptySquareIndices();
        HashMap<Integer, Integer> scores = new HashMap<>();

        for (Integer emptySquare : emptyGridSquares) {
            Integer score = getScore(firstGrid, emptySquare, maximisingPlayer, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
            scores.put(emptySquare, score);
        }

        return scores;
    }

    private Integer getScore(Grid grid, Integer emptySquare, Mark optimisingPlayer, Integer depth, Integer alpha, Integer beta) {
        Grid emulatedGrid = playMove(grid, emptySquare, optimisingPlayer);
        return minimax(emulatedGrid, oppositeOptimising(optimisingPlayer), depth, alpha, beta);
    }

    private int minimax(Grid grid, Mark optimisingPlayer, Integer depth, Integer alpha, Integer beta) {

        if (grid.isGameOver()) {
            return scoreForTerminalGameState(grid, depth);
        } else {
            Integer bestVal = isMaximisingPlayer(optimisingPlayer) ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            ArrayList<Integer> emptyGridSquares = grid.emptySquareIndices();
            for (Integer emptySquare : emptyGridSquares) {
                Integer value = getScore(grid, emptySquare, optimisingPlayer, depth + 1, alpha, beta);
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
}

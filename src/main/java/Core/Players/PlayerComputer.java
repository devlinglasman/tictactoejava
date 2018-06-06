package Core.Players;

import Core.Grid;
import Core.Mark;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PlayerComputer extends Player {

    private Mark opponentMark;

    public PlayerComputer(String name, Mark mark, Mark opponentMark) {
        super(name, mark);
        this.opponentMark = opponentMark;
    }

    @Override
    public int getInput(Grid grid) {
        return findBestMove(grid);
    }

    private int findBestMove(Grid grid) {
        HashMap<Integer, Integer> scores = buildScores(grid);
        return scores.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
    }

    private HashMap<Integer, Integer> buildScores(Grid grid) {
        ArrayList<Integer> emptyGridSquares = grid.emptySquareIndices();
        HashMap<Integer, Integer> scores = new HashMap<>();

        for (Integer emptySquare : emptyGridSquares) {
            Integer score = getScore(grid, emptySquare, getMark(), 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
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
        return optimisingPlayer == getMark();
    }

    private Grid playMove(Grid grid, Integer emptySquare, Mark mark) {
        Grid gridClone = grid.duplicate();
        gridClone.markSquare(emptySquare, mark);
        return gridClone;
    }

    private int scoreForTerminalGameState(Grid grid, Integer depth) {
        if (grid.winningLineExistsInGrid()) {
            if (grid.reportWinningMark() == getMark()) return 1000 - depth;
            else return depth - 1000;
        } else return 0;
    }

    private Mark oppositeOptimising(Mark currentOptimisingPlayer) {
        if (currentOptimisingPlayer == getMark()) return opponentMark;
        return getMark();
    }
}

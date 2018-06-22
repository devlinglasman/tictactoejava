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
    public void makeMove(Grid grid) {
        int input = findBestMove(grid);
        grid.markSquare(input, getMark());
    }

    private int findBestMove(Grid grid) {
        HashMap<Integer, Integer> scores = buildScores(grid);
        return scores.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .get().getKey();
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

        return grid.isFull() || grid.winningLineExistsInGrid() ?
                scoreForTerminalGameState(grid, depth) :
                findBestScore(grid, optimisingPlayer, depth, alpha, beta);
    }

    private Integer findBestScore(Grid grid, Mark optimisingPlayer, Integer depth, Integer alpha, Integer beta) {

        Integer bestScore = isMaximisingPlayer(optimisingPlayer) ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        ArrayList<Integer> emptyGridSquares = grid.emptySquareIndices();

        for (Integer emptySquare : emptyGridSquares) {

            Integer score = getScore(grid, emptySquare, optimisingPlayer, depth + 1, alpha, beta);

            if (isMaximisingPlayer(optimisingPlayer)) {
                bestScore = Math.max(bestScore, score);
                alpha = Math.max(alpha, bestScore);
            } else {
                bestScore = Math.min(bestScore, score);
                beta = Math.min(beta, bestScore);
            }
            if (beta <= alpha) break;
        }
        return bestScore;
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
            return grid.reportWinningMark() == getMark() ?
                    grid.getSquares().size() - depth :
                    depth - grid.getSquares().size();
        } else {
            return 0;
        }
    }

    private Mark oppositeOptimising(Mark currentOptimisingPlayer) {
        return currentOptimisingPlayer == getMark() ? opponentMark : getMark();
    }
}

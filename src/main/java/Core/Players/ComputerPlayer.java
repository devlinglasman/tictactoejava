package Core.Players;

import Core.Board.Grid;
import Core.Board.Mark;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComputerPlayer extends Player {

    private Mark opponentMark;

    public ComputerPlayer(Mark mark) {
        super(mark);
        opponentMark = findOpponentMark();
    }

    @Override
    public int getMove(Grid grid) {
        return findBestMove(grid);
    }

    private Mark findOpponentMark(){
        return (getMark() == Mark.PLAYER_ONE) ? Mark.PLAYER_TWO : Mark.PLAYER_ONE;
    }

    private int findBestMove(Grid grid) {
        HashMap<Integer, Integer> scores = buildScores(grid);
        return scores.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .get().getKey();
    }

    private HashMap<Integer, Integer> buildScores(Grid grid) {
        List<Integer> emptyGridSquares = grid.emptySquareIndices();
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

        return grid.isFull() || grid.winningLineExists() ?
                scoreForTerminalGameState(grid, depth) :
                findBestScore(grid, optimisingPlayer, depth, alpha, beta);
    }

    private Integer findBestScore(Grid grid, Mark optimisingPlayer, Integer depth, Integer alpha, Integer beta) {

        Integer bestScore = isMaximisingPlayer(optimisingPlayer) ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        List<Integer> emptyGridSquares = grid.emptySquareIndices();

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
        if (grid.winningLineExists()) {
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

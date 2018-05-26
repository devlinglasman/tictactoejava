package Core;

import java.util.ArrayList;

public class Minimax {

    private Mark minimaxPlayerMark;

    public Minimax(Mark minimaxPlayerMark) {
        this.minimaxPlayerMark = minimaxPlayerMark;
    }

    public int returnScoreForTerminalGameState(Grid grid) {
        if (grid.winningLineExistsInGrid()) {
            if (grid.reportWinningMark() == minimaxPlayerMark) return 1;
            else return -1;
        } else return 0;
    }

    public int findGameStateScore(Grid grid, Mark optimisingPlayerMark) {

        ArrayList<Integer> emptyGridSquares = grid.emptySquareIndices();
        ArrayList<Integer> scores = new ArrayList<>();

        for (Integer emptySquare : emptyGridSquares) {
            Grid gridClone = grid.duplicate();
            gridClone.markSquare(emptySquare, optimisingPlayerMark);
            if (gridClone.isGameOver()) {
                Integer scoreForEmulate = returnScoreForTerminalGameState(gridClone);
                scores.add(scoreForEmulate);
            } else {
                Mark temporaryOptimisingPlayer;
                if (optimisingPlayerMark == minimaxPlayerMark) temporaryOptimisingPlayer = Mark.playerOneMark;
                else temporaryOptimisingPlayer = minimaxPlayerMark;
                Integer gameScore = findGameStateScore(gridClone, temporaryOptimisingPlayer);
                scores.add(gameScore);
            }
        }
        if (optimisingPlayerMark == minimaxPlayerMark) {
            Integer maxIndex = findMaxIndex(scores);
            return scores.get(maxIndex);
        } else {
            Integer minIndex = findMinIndex(scores);
            return scores.get(minIndex);
        }
    }

    public int findMaxIndex(ArrayList<Integer> scores) {
        Integer score = -2;
        Integer maxIndex = 0;
        for (int i = 0; i < scores.size(); i++) {
            if (scores.get(i) > score) {
                maxIndex = i;
                score = scores.get(i);
            }
        }
        return maxIndex;
    }

    public int findMinIndex(ArrayList<Integer> scores) {
        Integer score = 2;
        Integer minIndex = 0;
        for (int i = 0; i < scores.size(); i++) {
            if (scores.get(i) < score) {
                minIndex = i;
                score = scores.get(i);
            }
        }
        return minIndex;
    }
}

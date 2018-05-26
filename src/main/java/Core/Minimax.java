package Core;

import java.util.ArrayList;

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

        for (Integer emptySquare : emptyGridSquares) {
            Grid emulatedGrid = emulateGrid(grid, emptySquare, optimisingPlayerMark);
            if (emulatedGrid.isGameOver()) {
                Integer scoreForEmulate = returnScoreForTerminalGameState(emulatedGrid);
                scores.add(scoreForEmulate);
            } else {
                Mark oppositeOptimiserMark = makeOppositeOptimisingMark(optimisingPlayerMark);
                Integer gameScore = findSquareChoice(emulatedGrid, oppositeOptimiserMark);
                scores.add(gameScore);
            }
        }

        if (grid == firstGrid) {
            Integer maxIndex;
            maxIndex = findMaxIndex(scores);
            return emptyGridSquares.get(maxIndex);
        } else {
            if (optimisingPlayerMark == minimaxPlayerMark) {
                Integer maxIndex = findMaxIndex(scores);
                return scores.get(maxIndex);
            } else {
                Integer minIndex = findMinIndex(scores);
                return scores.get(minIndex);
            }
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

    private int returnScoreForTerminalGameState(Grid grid) {
        if (grid.winningLineExistsInGrid()) {
            if (grid.reportWinningMark() == minimaxPlayerMark) return 1;
            else return -1;
        } else return 0;
    }

    private Grid emulateGrid(Grid grid, Integer emptySquare, Mark mark) {
        Grid gridClone = grid.duplicate();
        gridClone.markSquare(emptySquare, mark);
        return gridClone;
    }

    private Mark makeOppositeOptimisingMark(Mark currentOptimisingPlayerMark) {
        Mark oppositeOptimisingMark;
        if (currentOptimisingPlayerMark == minimaxPlayerMark) oppositeOptimisingMark = Mark.playerOneMark;
        else oppositeOptimisingMark = minimaxPlayerMark;
        return oppositeOptimisingMark;
    }
}

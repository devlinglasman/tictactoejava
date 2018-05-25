package Core.Players;

import Core.GameState;
import Core.Grid;
import Core.Mark;

import java.util.ArrayList;

public class PlayerComputer extends Player {

    public PlayerComputer(String name, Mark mark) {
        super(name, mark);
    }

    @Override
    public int getInput(Grid grid) {
        ArrayList<Integer> emptyGridSquares = grid.emptySquareIndices();
        ArrayList<Integer> scores = new ArrayList<>();

        for (Integer emptySquare : emptyGridSquares) {
            Grid gridClone = new Grid();
            gridClone.setSquares(grid.copySquares());
            GameState emulatedGameState = new GameState(gridClone);
            emulatedGameState.getGrid().setASquare(emptySquare, getMark());
//            If it's in terminal state:
            if (emulatedGameState.isGameOver()) {
                Integer scoreForEmulate = returnScoreForTerminalGameState(emulatedGameState);
                scores.add(scoreForEmulate);
            } else {
//                Switch optimising Player and call minimax.
                Integer gameScore = findGameStateScore(emulatedGameState, Mark.playerOneMark);
                scores.add(gameScore);
            }
        }
        Integer maxIndex = findMaxIndex(scores);
        return emptyGridSquares.get(maxIndex);
    }

    public int returnScoreForTerminalGameState(GameState gameState) {
        if (gameState.isGameTied()) return 0;
        else if (gameState.getGrid().reportWinningMark() == getMark()) return 1;
        else return -1;
    }

    public int findGameStateScore(GameState gameState, Mark optimisingPlayerMark) {

        ArrayList<Integer> emptyGridSquares = gameState.getGrid().emptySquareIndices();
        ArrayList<Integer> scores = new ArrayList<>();

        for (Integer emptySquare : emptyGridSquares) {
            Grid gridClone = new Grid();
            gridClone.setSquares(gameState.getGrid().copySquares());
            GameState emulatedGameState = new GameState(gridClone);
            emulatedGameState.getGrid().setASquare(emptySquare, optimisingPlayerMark);
//            If it's in terminal state:
            if (emulatedGameState.isGameOver()) {
                Integer scoreForEmulate = returnScoreForTerminalGameState(emulatedGameState);
                scores.add(scoreForEmulate);
            } else {
//                Switch optimising Player and call minimax.
                Mark temporaryOptimisingPlayer;
                if (optimisingPlayerMark == getMark()) temporaryOptimisingPlayer = Mark.playerOneMark;
                else temporaryOptimisingPlayer = getMark();
                Integer gameScore = findGameStateScore(emulatedGameState, temporaryOptimisingPlayer);
                scores.add(gameScore);
            }
        }
//        If player looking at the emulated gameStates is currently the maximising player (computer)...:
        if (optimisingPlayerMark == getMark()) {
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

    @Override
    public boolean isHumanPlayer() {
        return false;
    }
}

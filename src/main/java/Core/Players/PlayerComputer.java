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
        Grid gridClone = new Grid();
        gridClone.setSquares(grid.copySquares());

        GameState gameState = new GameState(gridClone);
        return moveChoice(gameState, getMark());
    }

    public int returnScoreForTerminalGameState(GameState gameState) {
        if (gameState.isGameTied()) return 0;
        else if (gameState.getGrid().reportWinningMark() == getMark()) return 1;
        else return -1;
    }

    public int moveChoice(GameState gameState, Mark optimisingPlayerMark) {

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
//                Switch activePlayer
                if (optimisingPlayerMark == getMark()) optimisingPlayerMark = Mark.playerOneMark;
                else optimisingPlayerMark = getMark();
                return moveChoice(emulatedGameState, optimisingPlayerMark);
            }
        }
//        If player looking at the emulated gameStates is currently the maximising player (computer)...:
        if (optimisingPlayerMark == getMark()) {
            Integer maxIndex = findMaxIndex(scores);
            return emptyGridSquares.get(maxIndex);
        } else {
            Integer minIndex = findMinIndex(scores);
            return emptyGridSquares.get(minIndex);
        }

    }

    public int findMaxIndex(ArrayList<Integer> scores) {
        Integer maxIndex = 0;
        for (Integer score : scores) {
            if (score > maxIndex) {
                maxIndex = score;
            }
        }
        return maxIndex;
    }

    public int findMinIndex(ArrayList<Integer> scores) {
        Integer minIndex = 0;
        for (Integer score : scores) {
            if (score > minIndex) {
                minIndex = score;
            }
        }
        return minIndex;
    }

    @Override
    public boolean isHumanPlayer() {
        return false;
    }
}

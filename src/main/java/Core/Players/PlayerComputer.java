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

        GameState gameState = new GameState(gridClone, getMark());
        return moveChoice(gameState);
    }

    public int returnScoreForTerminalGameState(GameState gameState) {
        if (gameState.isGameTied()) return 0;
        else if (gameState.getGrid().reportWinningMark() == getMark()) return 1;
        else return -1;
    }

    public int moveChoice(GameState gameState) {

        ArrayList<Integer> emptyGridSquares = gameState.getGrid().emptySquareIndices();
       ArrayList<Integer> scores = new ArrayList<>();

        for (Integer emptySquare : emptyGridSquares) {
            Grid gridClone = new Grid();
            gridClone.setSquares(gameState.getGrid().copySquares());

            GameState emulatedGameState = new GameState(gridClone, getMark());
//            If it's in terminal state:
            Integer scoreForEmulate = returnScoreForTerminalGameState(emulatedGameState);
            scores.add(scoreForEmulate);
        }
//        If playing looking at the emulated gameStates is currently the maximising player (computer) then:
        Integer maxIndex = findMaxIndex(scores);
        return emptyGridSquares.get(maxIndex);
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

    @Override
    public boolean isHumanPlayer() {
        return false;
    }
}

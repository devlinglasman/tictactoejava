package Core.Players;

import Core.Grid;
import Core.Mark;
import Core.Minimax;

import java.util.ArrayList;

public class PlayerComputer extends Player {

    private Minimax minimax;

    public PlayerComputer(String name, Mark mark) {
        super(name, mark);
        minimax = new Minimax(getMark());
    }

    @Override
    public int getInput(Grid grid) {
        ArrayList<Integer> emptyGridSquares = grid.emptySquareIndices();
        ArrayList<Integer> scores = new ArrayList<>();

        for (Integer emptySquare : emptyGridSquares) {
            Grid gridClone = grid.duplicate();
            gridClone.markSquare(emptySquare, getMark());
            if (gridClone.isGameOver()) {
                Integer scoreForEmulate = minimax.returnScoreForTerminalGameState(gridClone);
                scores.add(scoreForEmulate);
            } else {
                Integer gameScore = minimax.findGameStateScore(gridClone, Mark.playerOneMark);
                scores.add(gameScore);
            }
        }
        Integer maxIndex = minimax.findMaxIndex(scores);
        return emptyGridSquares.get(maxIndex);
    }

    @Override
    public boolean isHuman() {
        return false;
    }
}

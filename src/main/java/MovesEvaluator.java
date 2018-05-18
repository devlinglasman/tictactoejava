import java.util.ArrayList;
import java.util.Arrays;

public class MovesEvaluator {

    public boolean isLegalMove(Grid grid, int squareNumber) {
        if (grid.getSquares().get(squareNumber).equals(" ")) return true;
        else return false;
    }

    public boolean gameIsOver(Grid grid){
        return isGridFull(grid) || isGameWon(grid);
    }

    public boolean isGridFull(Grid grid) {
        return grid.isGridFull();
    }

    public boolean isGameWon(Grid grid) {
        for (ArrayList<String> line : grid.getPossibleWinLines()) {
            if (winningLine(line)) return true;
        }
        return false;
    }

    public boolean winningLine(ArrayList<String> line) {
        if (line.contains(Mark.unmarkedSquare.getStringRepresentation())) return false;
        String first = line.get(0);
        for (String s : line) {
            if (!s.equals(first)) return false;
        }
        return true;
    }

}

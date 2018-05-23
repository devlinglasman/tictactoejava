package Core;

import Core.Players.Player;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.*;

public class Grid {

    private ArrayList<Mark> squares = createGrid();

    public ArrayList<Mark> createGrid() {
        List<Mark> result = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            result.add(Mark.unmarkedSquare);
        }
        return (ArrayList<Mark>) result;
    }

    public void markSquare(int squareNumber, Mark mark) {
        squares.set(squareNumber, mark);
    }

    public boolean moveNotLegal(int squareNumber) {
        return squares.get(squareNumber) != Mark.unmarkedSquare;
    }

    public boolean isFull() {
        for (Mark m : squares) {
            if (m.equals(Mark.unmarkedSquare)) return false;
        }
        return true;
    }

    public Mark reportWinningMark() {
        for (ArrayList<Mark> line : possibleWinLines()) if (lineIsWinner(line)) {
            return line.get(0);
        }
        return Mark.unmarkedSquare;
    }

    public boolean winningLineExistsInGrid() {
        for (ArrayList<Mark> line : possibleWinLines()) if (lineIsWinner(line)) return true;
        return false;
    }

    public boolean lineIsWinner(ArrayList<Mark> line) {
        if (line.contains(Mark.unmarkedSquare)) return false;
        Mark firstMark = squares.get(0);
        for (Mark m : line) {
            if (m != firstMark) return false;
        }
        return true;
    }

    public List<ArrayList<Mark>> possibleWinLines() {
        return asList(
                group3Squares(0, 1, 2),
                group3Squares(3, 4, 5),
                group3Squares(6, 7, 8),
                group3Squares(0, 3, 6),
                group3Squares(1, 4, 7),
                group3Squares(2, 5, 8),
                group3Squares(0, 4, 8),
                group3Squares(2, 4, 6)
        );
    }

    public ArrayList<Mark> group3Squares(int a, int b, int c) {
        List<Mark> result = new ArrayList<>();
        result.add(squares.get(a));
        result.add(squares.get(b));
        result.add(squares.get(c));
        return (ArrayList<Mark>) result;
    }

    public ArrayList<Integer> emptySquareIndices() {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < squares.size(); i++) {
            if (squares.get(i) == Mark.unmarkedSquare) result.add(i);
        }
        return result;
    }

    public void setASquare(Integer index, Player player) {
        squares.set(index, player.getMark());
    }

    public ArrayList<Mark> getSquares() {
        return squares;
    }

    public void setSquares(ArrayList<Mark> squares) {
        this.squares = squares;
    }
}

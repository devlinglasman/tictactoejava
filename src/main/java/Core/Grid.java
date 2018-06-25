package Core;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Arrays.asList;

public class Grid {

    private ArrayList<Mark> squares;

    public Grid() {
        squares = createGrid();
    }

    public void markSquare(int squareNumber, Mark mark) {
        squares.set(squareNumber, mark);
    }

    public boolean moveNotLegal(int squareChoice) {
         return choiceOutOfRange(squareChoice) || choiceAlreadyMarked(squareChoice);
    }

    public boolean isFull() {
        return squares.stream().noneMatch(m -> m.equals(Mark.UNMARKEDSQUARE));
    }

    public Mark reportWinningMark() {
        for (ArrayList<Mark> line : possibleWinLines()) if (lineIsWinner(line)) {
            return line.get(0);
        }
        return Mark.UNMARKEDSQUARE;
    }

    public boolean winningLineExistsInGrid() {
        return possibleWinLines().stream().anyMatch(this::lineIsWinner);
    }

    public Grid duplicate() {
        Grid gridDuplicate = new Grid();
        ArrayList<Mark> copiedSquares = new ArrayList<>(squares);
        gridDuplicate.setSquares(copiedSquares);
        return gridDuplicate;
    }

    public ArrayList<Integer> emptySquareIndices() {
        return IntStream.range(0, squares.size()).filter(i -> squares.get(i) == Mark.UNMARKEDSQUARE)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Mark> getSquares() {
        return squares;
    }

    private boolean lineIsWinner(ArrayList<Mark> line) {
        return lineDoesNotContainUnmarkedSquare(line) && lineContainsAllIdenticalMarks(line);
    }

    private boolean lineDoesNotContainUnmarkedSquare(ArrayList<Mark> line) {
        return !line.contains(Mark.UNMARKEDSQUARE);
    }

    private boolean lineContainsAllIdenticalMarks(ArrayList<Mark> line) {
        Mark firstMark = line.get(0);
        return line.stream().noneMatch(m -> m != firstMark);
    }

    private List<ArrayList<Mark>> possibleWinLines() {
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

    private ArrayList<Mark> group3Squares(int a, int b, int c) {
        List<Mark> result = new ArrayList<>();
        result.add(squares.get(a));
        result.add(squares.get(b));
        result.add(squares.get(c));
        return (ArrayList<Mark>) result;
    }

    private void setSquares(ArrayList<Mark> squares) {
        this.squares = squares;
    }

    private ArrayList<Mark> createGrid() {
        List<Mark> result = IntStream.range(0, 9)
                .mapToObj(i -> Mark.UNMARKEDSQUARE)
                .collect(Collectors.toList());
        return (ArrayList<Mark>) result;
    }

    private boolean choiceOutOfRange(int squareChoice) {
        return squareChoice < 0 || squareChoice >= squares.size();
    }

    private boolean choiceAlreadyMarked(int squareChoice) {
        return squares.get(squareChoice) != Mark.UNMARKEDSQUARE;
    }

}

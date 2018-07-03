package Core;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Arrays.asList;

public class Grid {

    private List<Mark> squares;

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
        return squares.stream().noneMatch(m -> m.equals(Mark.EMPTY));
    }

    public Mark reportWinningMark() {
        for (List<Mark> line : possibleWinLines()) if (lineIsWinner(line)) {
            return line.get(0);
        }
        return Mark.EMPTY;
    }

    public boolean winningLineExistsInGrid() {
        return possibleWinLines().stream().anyMatch(this::lineIsWinner);
    }

    public Grid duplicate() {
        Grid gridDuplicate = new Grid();
        List<Mark> copiedSquares = new ArrayList<>(squares);
        gridDuplicate.setSquares(copiedSquares);
        return gridDuplicate;
    }

    public List<Integer> emptySquareIndices() {
        return IntStream.range(0, squares.size()).filter(i -> squares.get(i) == Mark.EMPTY)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<Mark> getSquares() {
        return squares;
    }

    private boolean lineIsWinner(List<Mark> line) {
        return lineDoesNotContainUnmarkedSquare(line) && lineContainsAllIdenticalMarks(line);
    }

    private boolean lineDoesNotContainUnmarkedSquare(List<Mark> line) {
        return !line.contains(Mark.EMPTY);
    }

    private boolean lineContainsAllIdenticalMarks(List<Mark> line) {
        Mark firstMark = line.get(0);
        return line.stream().noneMatch(m -> m != firstMark);
    }

    private List<List<Mark>> possibleWinLines() {
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

    private List<Mark> group3Squares(int a, int b, int c) {
        List<Mark> result = new ArrayList<>();
        result.add(squares.get(a));
        result.add(squares.get(b));
        result.add(squares.get(c));
        return result;
    }

    private void setSquares(List<Mark> squares) {
        this.squares = squares;
    }

    private List<Mark> createGrid() {
        List<Mark> result = IntStream.range(0, 9)
                .mapToObj(i -> Mark.EMPTY)
                .collect(Collectors.toList());
        return result;
    }

    private boolean choiceOutOfRange(int squareChoice) {
        return squareChoice < 0 || squareChoice >= squares.size();
    }

    private boolean choiceAlreadyMarked(int squareChoice) {
        return squares.get(squareChoice) != Mark.EMPTY;
    }

}

package Core.Board;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;

public class Grid {

    private List<Mark> squares;

    public Integer getGridSize() {
        return gridSize;
    }

    public Integer getGridMaxSquares() {
        return gridMaxSquares;
    }

    private Integer gridSize;
    private Integer gridMaxSquares;

    public Grid(Integer gridSize) {
        this.gridSize = gridSize;
        gridMaxSquares = gridSize * gridSize;
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
        for (List<Mark> line : possibleWinLines())
            if (lineIsWinner(line)) {
                return line.get(0);
            }
        return Mark.EMPTY;
    }

    public boolean winningLineExistsInGrid() {
        return possibleWinLines().stream().anyMatch(this::lineIsWinner);
    }

    public Grid duplicate() {
        Grid gridDuplicate = new Grid(gridSize);
        List<Mark> copiedSquares = new ArrayList<>(squares);
        gridDuplicate.setSquares(copiedSquares);
        return gridDuplicate;
    }

    public List<Integer> emptySquareIndices() {
        return IntStream.range(0, squares.size())
                .filter(i -> squares.get(i) == Mark.EMPTY)
                .boxed()
                .collect(toCollection(ArrayList::new));
    }

    public List<Mark> getSquares() {
        return squares;
    }

    private boolean lineIsWinner(List<Mark> line) {
        return lineDoesNotContainUnmarkedSquare(line)
                && lineContainsAllIdenticalMarks(line);
    }

    private boolean lineDoesNotContainUnmarkedSquare(List<Mark> line) {
        return !line.contains(Mark.EMPTY);
    }

    private boolean lineContainsAllIdenticalMarks(List<Mark> line) {
        Mark firstMark = line.get(0);
        return line.stream().noneMatch(m -> m != firstMark);
    }

    private List<List<Mark>> possibleWinLines() {
        List<List<Mark>> result = new ArrayList<>();
        for (int i = 0; i < gridSize; i++) {
            result.add(buildRow(i));
            result.add(buildCol(i));
        }
        result.add(topLeftDiag());
        result.add(topRightDiag());
        return result;
    }

    private List<Mark> topRightDiag() {
        List<Mark> result = new ArrayList<>();
        for (int i = 0; i < gridSize; i++) {
            i++;
            Integer winSquare = (i * gridSize) - i;
            result.add(squares.get(winSquare));
        }
        return result;
    }

    private List<Mark> topLeftDiag() {
        return IntStream.range(0, gridSize)
                .mapToObj(i -> (i * gridSize) + i)
                .map(winSquare -> squares.get(winSquare))
                .collect(Collectors.toList());
    }

    private List<Mark> buildCol(int position) {
        List<Mark> result = new ArrayList<>();
        for (int i = position; i < gridMaxSquares; i += gridSize) {
            result.add(squares.get(i));
        }
        return result;
    }

    private List<Mark> buildRow(int position) {
        return IntStream.range(position, gridSize * (position + 1))
                .mapToObj(i -> squares.get(i))
                .collect(Collectors.toList());
    }

    private void setSquares(List<Mark> squares) {
        this.squares = squares;
    }

    private List<Mark> createGrid() {
        return IntStream.range(0, (gridMaxSquares))
                .mapToObj(i -> Mark.EMPTY)
                .collect(toList());
    }

    private boolean choiceOutOfRange(int squareChoice) {
        return squareChoice < 0 || squareChoice >= squares.size();
    }

    private boolean choiceAlreadyMarked(int squareChoice) {
        return squares.get(squareChoice) != Mark.EMPTY;
    }

}

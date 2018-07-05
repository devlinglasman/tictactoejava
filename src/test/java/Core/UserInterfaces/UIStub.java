package Core.UserInterfaces;

import Core.Board.Mark;

import java.util.List;

public class UIStub implements UI {
    @Override
    public String getInput() {
        return null;
    }

    @Override
    public void presentMessage(String message) {
    }

    @Override
    public void displayGrid(List<Mark> gridSquares) {
    }

    @Override
    public void clearScreen() {
    }

    @Override
    public void pause() {
    }
}

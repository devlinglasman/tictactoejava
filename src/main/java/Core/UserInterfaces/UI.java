package Core.UserInterfaces;

import Core.Mark;

import java.util.List;

public interface UI {

    String getInput();

    void presentMessage(String message);

    void displayGrid(List<Mark> gridSquares);

    void clearScreen();

    void pause();

}

package Core.UserInterfaces;

import Core.Mark;

import java.util.ArrayList;

public interface UI {

    String getInput();

    void presentMessage(String message);

    void displayGrid(ArrayList<Mark> gridSquares);

    void clearScreen();

    void pause();

}

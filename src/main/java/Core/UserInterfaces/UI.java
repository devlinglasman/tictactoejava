package Core.UserInterfaces;

import Core.Board.Grid;
import Core.Board.Mark;

import java.util.List;

public interface UI {

    String getInput();

    void presentMessage(String message);

    void displayGrid(Grid grid);

    void clearScreen();

    void pause();

}

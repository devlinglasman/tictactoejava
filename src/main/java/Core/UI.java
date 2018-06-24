package Core;

import Core.Players.Player;

import java.util.ArrayList;

public interface UI {

    String getInput();

    int getValidNumber();

    void presentMessage(String message);

    void displayGrid(ArrayList<Mark> gridSquares);

    void presentMove(Player player, Grid grid);

}

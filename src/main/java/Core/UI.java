package Core;

import Core.Players.Player;

import java.util.ArrayList;

public interface UI {

    String getInput();

    int getValidNumber();

    void askGameMode();

    void announceGameModeChoiceInvalid();

    void displayGrid(ArrayList<Mark> gridSquares);

    void presentMove(Player player, Grid grid);

    void askSquareChoice(Player player);

    void announceSquareChoiceInvalid(Player player);

    void announceTie();

    void announceWinner(Player player);
}

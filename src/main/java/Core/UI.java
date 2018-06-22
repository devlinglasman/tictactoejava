package Core;

import Core.Players.Player;

import java.util.ArrayList;
import java.util.List;

public interface UI {

    String getInput();

    String findGameMode();

    int getValidNumber(Player player);

    void askGameMode();

    void announceGameModeChoiceInvalid();

    void displayGrid(ArrayList<Mark> gridSquares);

    void presentMove(Player player, Grid grid);

    void askSquareChoice(Player player);

    void announceSquareChoiceInvalid(Player player);

    void announceTie();

    void announceWinner(Player player);
}

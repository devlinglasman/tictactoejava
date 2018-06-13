package Core;

import Core.Players.Player;

import java.util.ArrayList;
import java.util.List;

public interface UI {

    String getInput();

    int getValidNumber(Player player);

    void askGameMode();

    void announceGameModeChoiceInvalid();

    void displayGrid(ArrayList<Mark> gridSquares);

    void announceSquareChoice(Player player);

    void askSquareChoice(Player player);

    void announceSquareChoiceInvalid(Player player);

    void announceTie();

    void announceWinner(Player player);
}

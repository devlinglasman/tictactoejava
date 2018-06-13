package Core;

import java.util.ArrayList;
import java.util.List;

public interface UI {

    String getInput();

    int getValidSquareChoice(String playerName);

    void askGameMode();

    void announceGameModeChoiceInvalid();

    void displayGrid(ArrayList<Mark> gridSquares);

    void announceSquareChoice(String playerName);

    void askSquareChoice(String playerName);

    void announceSquareChoiceInvalid(String playerName);

    void announceTie();

    void announceWinner(String playerName);
}

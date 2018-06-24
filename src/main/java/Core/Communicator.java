package Core;

import Core.Players.Player;

import java.util.ArrayList;

public class Communicator {

    private UI ui;

    public Communicator(UI ui) {
        this.ui = ui;
    }

    public String getInput() {
        return ui.getInput();
    }

    public int getValidNumber() {
        return ui.getValidNumber();
    }

    public void askGameMode() {
        ui.presentMessage(Message.askGameMode);
    }

    public void announceGameModeChoiceInvalid() {
        ui.presentMessage(Message.announceGameModeChoiceInvalid);
    }

    public void displayGrid(ArrayList<Mark> gridSquares) {
        ui.displayGrid(gridSquares);
    }

    public void presentMove(Player player, Grid grid) {
        ui.presentMove(player, grid);
    }

    public void askSquareChoice(Player player) {
        ui.presentMessage(Message.askSquareChoice(player));
    }

    public void announceSquareChoiceInvalid(Player player) {
        ui.presentMessage(Message.announceSquareChoiceInvalid(player));
    }

    public void announceTie() {
        ui.presentMessage(Message.announceTie);
    }

    public void announceWinner(Player player) {
        ui.presentMessage(Message.announceWinner(player));
    }
}
